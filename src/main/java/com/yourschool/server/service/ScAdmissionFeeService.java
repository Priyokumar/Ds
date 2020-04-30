package com.yourschool.server.service;

import java.math.BigInteger;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.dto.ApiMessage;
import com.yourschool.server.dto.ApiUtil;
import com.yourschool.server.dto.admissionFee.Admission;
import com.yourschool.server.dto.admissionFee.AdmissionFeeResponse;
import com.yourschool.server.dto.admissionFee.AdmissionFeesResponse;
import com.yourschool.server.dto.admissionFee.AdmissionMonthly;
import com.yourschool.server.dto.admissionFee.Fee;
import com.yourschool.server.dto.admissionFee.FeesResponse;
import com.yourschool.server.dto.admissionFee.StudentBasicDetail;
import com.yourschool.server.dto.error.InternalServerException;
import com.yourschool.server.dto.error.NotFoundException;
import com.yourschool.server.entity.admissionfee.ScAdmission;
import com.yourschool.server.entity.admissionfee.ScFee;
import com.yourschool.server.entity.maintenance.ScMaintenanceAdmissionFee;
import com.yourschool.server.entity.student.ScStudent;
import com.yourschool.server.service.common.CommonService;
import com.yourschool.server.util.ScDateUtil;
import com.yourschool.server.util.ScUtil;
import com.yourschool.server.vo.AdmissionStatuses;
import com.yourschool.server.vo.ApiMessageType;
import com.yourschool.server.vo.FeeStatus;
import com.yourschool.server.vo.FieldType;
import com.yourschool.server.vo.Filter;
import com.yourschool.server.vo.Operator;
import com.yourschool.server.vo.RefType;

@Service
public class ScAdmissionFeeService {

	@Autowired
	private CommonService commonService;

	@Autowired
	private ScMaintAdmissionFeeService maintAdmissionFeeService;

	@PersistenceContext
	private EntityManager em;

	public AdmissionFeesResponse findAllAdmissionFee(Map<String, String> allParams) {

		List<Filter> filters = null;
		if (allParams != null && !allParams.isEmpty()) {

			filters = new ArrayList<Filter>();

			for (Entry<String, String> entry : allParams.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				filters.add(new Filter(key, Operator.EQUAL, FieldType.STRING, value));
			}
		}

		AdmissionFeesResponse res = new AdmissionFeesResponse();

		List<ScAdmission> admissions = null;
		if (!ScUtil.isAllPresent(filters))
			admissions = commonService.findAll(ScAdmission.class);
		else
			admissions = commonService.find(filters, ScAdmission.class);

		List<Admission> dtoadmissions = new ArrayList<>();
		admissions.forEach(admission -> {
			Admission dtoAdmission = setAdmissionToDto(admission);
			dtoadmissions.add(dtoAdmission);
		});

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoadmissions);
		return res;
	}

	public AdmissionFeeResponse findAdmissionFee(Long id) {

		AdmissionFeeResponse res = new AdmissionFeeResponse();

		ScAdmission admission = commonService.findById(id, ScAdmission.class);

		if (!ScUtil.isAllPresent(admission))
			throw new NotFoundException("No student can be found !");

		Admission admissionDto = setAdmissionToDto(admission);

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(admissionDto);

		return res;
	}

	public ActionResponse createOrUpdateAdmissionFee(Admission admissionDto, Long id) {

		ActionResponse res = new ActionResponse();
		ScAdmission admission = new ScAdmission();

		Long studentId = admissionDto.getStudent().getId();
		String academicYear = admissionDto.getAcademicYear();
		String standard = admissionDto.getStandard();

		if (ScUtil.isAllPresent(id)) {
			admission = commonService.findById(id, ScAdmission.class);
		} else {
			List<Filter> filters = new ArrayList<>();
			filters.add(new Filter("student", Operator.EQUAL, FieldType.NUMBER, studentId));
			filters.add(new Filter("academicYear", Operator.EQUAL, FieldType.STRING, academicYear));
			// filters.add(new Filter("standard", Operator.EQUAL, FieldType.STRING, standard));
			ScAdmission existingAdmission = commonService.findOne(filters, ScAdmission.class);

			if (ScUtil.isAllPresent(existingAdmission)) {

				ApiMessage apiMessage = new ApiMessage(true, 500, "Student is already admitted for the academic year - " + academicYear, "Internal server error");
				res.setApiMessage(apiMessage);
				return res;
			}
		}

		if (!ScUtil.isAllPresent(admission))
			throw new NotFoundException("No Admission can be found !");

		admission.setAcademicYear(academicYear);
		admission.setAdmissionAmount(admissionDto.getAdmissionAmount());
		admission.setAdmissionDate(ScDateUtil.now());
		admission.setDueAmount(admissionDto.getDueAmount());
		admission.setPaidAmount(admissionDto.getPaidAmount());
		admission.setPromiseToPayDate(ScDateUtil.stringToDate(admissionDto.getPromiseToPayDate()));
		admission.setStandard(standard);

		StudentBasicDetail studentDto = admissionDto.getStudent();

		if (!ScUtil.isAllPresent(studentDto) || !ScUtil.isAllPresent(studentDto.getId()))
			throw new InternalServerException(
					ApiMessageType.INSUFFICIENT_DATA + " Student information cannot be found");

		ScStudent student = commonService.findById(studentId, ScStudent.class);
		if (!ScUtil.isAllPresent(student))
			throw new NotFoundException("No Student can be found !");
		
		if(!ScUtil.isAllPresent(id)) {
			admission.setAdmissionRefNo(ScUtil.getGeneratedNumber("ADM"));
			admission.setStatus(AdmissionStatuses.ADMITTED);
		} else {
			admission.setStatus(admissionDto.getStatus());	
		}
		
		student.setStandard(admissionDto.getStandard());
		admission.setStudent(student);

		if (!ScUtil.isAllPresent(id)) {
			List<ScFee> fees = generateFees(admissionDto.getStandard(), academicYear, true);
			admission.setFees(fees);
		}

		commonService.save(admission);
		String message = "";
		if (ScUtil.isAllPresent(id)) {

			message = "Successfully updated the admission";
			res.setApiMessage(ApiUtil.okMessage(message));

		} else {

			message = "Successfully created an admission";
			res.setApiMessage(ApiUtil.createdMessage(message));
			res.setActionMessage(message);
		}
		return res;
	}
	
	public ActionResponse  payFee(Long feeId) {
		ActionResponse res = new ActionResponse();
		
		ScFee fee = commonService.findById(feeId, ScFee.class);
		fee.setActdateOfPayment(ScDateUtil.now());
		fee.setStatus(FeeStatus.PAID);
		commonService.save(fee);
		
		return 	res;
	}
	
	public ActionResponse deleteAdmissionFee(Long id) {

		ActionResponse res = new ActionResponse();

		ScAdmission admission = commonService.findById(id, ScAdmission.class);

		if (!ScUtil.isAllPresent(admission))
			throw new NotFoundException("No admission can be found !");

		commonService.delete(admission);

		res.setActionMessage("Admission has been deleted successfully");
		res.setApiMessage(ApiUtil.okMessage("Admission has been deleted successfully"));
		return res;
	}

	private Admission setAdmissionToDto(ScAdmission admission) {

		Admission dtoAdmission = new Admission();

		dtoAdmission.setAcademicYear(admission.getAcademicYear());
		dtoAdmission.setAdmissionAmount(admission.getAdmissionAmount());
		dtoAdmission.setAdmissionDate(ScDateUtil.dateToString(admission.getAdmissionDate()));
		dtoAdmission.setAdmissionRefNo(admission.getAdmissionRefNo());
		dtoAdmission.setStatus(admission.getStatus());
		dtoAdmission.setDueAmount(admission.getDueAmount());
		dtoAdmission.setId(admission.getId());
		dtoAdmission.setPaidAmount(admission.getPaidAmount());
		dtoAdmission.setPromiseToPayDate(ScDateUtil.dateToString(admission.getPromiseToPayDate()));
		dtoAdmission.setStandard(admission.getStandard());

		ScStudent student = admission.getStudent();
		if (ScUtil.isAllPresent(student)) {

			StudentBasicDetail studBasicDetail = new StudentBasicDetail();

			studBasicDetail.setRegistrationDate(ScDateUtil.dateToString(student.getRegistrationDate()));
			studBasicDetail.setRegistrationNo(student.getRegistrationNo());
			studBasicDetail.setStatus(student.getStatus());
			studBasicDetail.setFirstName(student.getFirstName());
			studBasicDetail.setId(student.getId());
			studBasicDetail.setLastName(student.getLastName());
			studBasicDetail.setMiddleName(student.getMiddleName());
			studBasicDetail.setRollNo(student.getRollNo());
			studBasicDetail.setStandard(student.getStandard());
			dtoAdmission.setStudent(studBasicDetail);
		}

		List<ScFee> fees = admission.getFees();
		if (ScUtil.isAllPresent(fees)) {

			List<Fee> dtoFees = new ArrayList<>();

			fees.forEach(fee -> {
				Fee dtoFee = new Fee();
				dtoFee.setActdateOfPayment(ScDateUtil.dateToString(fee.getActdateOfPayment()));
				dtoFee.setAmount(fee.getAmount());
				dtoFee.setExptdateOfPayment(ScDateUtil.dateToString(fee.getExptdateOfPayment()));
				dtoFee.setFeeRefNo(fee.getFeeRefNo());
				dtoFee.setId(fee.getId());
				dtoFee.setMonthOf(fee.getMonthOf());
				dtoFee.setStatus(fee.getStatus());
				dtoFees.add(dtoFee);
			});
			dtoAdmission.setFees(dtoFees);
		}
		return dtoAdmission;
	}

	public List<ScFee> generateFees(String standard, String year, boolean ref) {

		Double feeAmount = 0.0;

		ScMaintenanceAdmissionFee maintAdmissionFeeByStandard = maintAdmissionFeeService
				.getMaintAdmissionFeeByStandard(standard, year);
		if (ScUtil.isAllPresent(maintAdmissionFeeByStandard))
			feeAmount = maintAdmissionFeeByStandard.getFeeAmount();

		List<ScFee> fees = new ArrayList<>();
		Month[] months = Month.values();

		for (int i = 0; i < 12; i++) {

			ScFee fee = new ScFee();

			fee.setAmount(feeAmount);

			if (ref == true)
				fee.setFeeRefNo(ScUtil.getGeneratedNumber(RefType.FEE));

			String date = "01";
			int monthInt = months[i].getValue();
			String month = "";
			if (monthInt < 10)
				month += "0" + monthInt;
			else
				month += monthInt;

			date = month + "/" + date + "/" + year;

			fee.setExptdateOfPayment(ScDateUtil.stringToDate(date));
			fee.setMonthOf(months[i].name());
			fee.setStatus(FeeStatus.NOT_PAID);

			fees.add(fee);
		}
		return fees;
	}

	public FeesResponse findFeesByStandard(String standard, String year) {

		FeesResponse res = new FeesResponse();

		List<ScFee> fees = generateFees(standard, year, false);
		if (!ScUtil.isAllPresent(fees))
			throw new NotFoundException("No fee can be found !");

		List<Fee> dtoFees = new ArrayList<>();
		fees.forEach(fee -> {
			Fee dtoFee = setFeeToDto(fee);
			dtoFees.add(dtoFee);
		});

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoFees);
		return res;
	}

	private Fee setFeeToDto(ScFee fee) {

		Fee dtoFee = new Fee();
		dtoFee.setActdateOfPayment(ScDateUtil.dateToString(fee.getActdateOfPayment()));
		dtoFee.setAmount(fee.getAmount());
		dtoFee.setExptdateOfPayment(ScDateUtil.dateToString(fee.getExptdateOfPayment()));
		dtoFee.setFeeRefNo(fee.getFeeRefNo());
		dtoFee.setId(fee.getId());
		dtoFee.setMonthOf(fee.getMonthOf());
		dtoFee.setStatus(fee.getStatus());

		return dtoFee;
	}

	public List<AdmissionMonthly> getAdmissionDashboardData(int year) {

		List<AdmissionMonthly> admisionsMonthly = new ArrayList<>();

		try {
			for (int i = 1; i <= 12; i++) {

				Query q = em.createNativeQuery(
						"SELECT COUNT(*) FROM sc_admission WHERE  EXTRACT(MONTH FROM admission_date) = " + i
								+ " AND  EXTRACT(YEAR FROM admission_date) = " + year);
				BigInteger count = (BigInteger) q.getSingleResult();
				int cou = count.intValue();

				admisionsMonthly.add(new AdmissionMonthly(ScDateUtil.getMonth(i), cou));

			}
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}

		return admisionsMonthly;

	}
}
