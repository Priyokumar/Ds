package com.yourschool.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.dto.ApiUtil;
import com.yourschool.server.dto.error.NotFoundException;
import com.yourschool.server.dto.maintenance.Standard;
import com.yourschool.server.dto.maintenance.StandardResponse;
import com.yourschool.server.dto.maintenance.StandardSection;
import com.yourschool.server.dto.maintenance.StandardsResponse;
import com.yourschool.server.entity.maintenance.ScStandard;
import com.yourschool.server.entity.maintenance.ScStandardSection;
import com.yourschool.server.service.common.CommonService;
import com.yourschool.server.util.ScUtil;

@Service
public class ScStandardService {

	@Autowired
	private CommonService commonService;

	public StandardsResponse findAllStandard() {

		StandardsResponse res = new StandardsResponse();

		List<ScStandard> standards = commonService.findAll(ScStandard.class);
		if (!ScUtil.isAllPresent(standards))
			throw new NotFoundException("No standards can be found !");

		List<Standard> dtoStandards = new ArrayList<>();
		standards.forEach(standard -> {
			Standard dtoStandard = setStandardDto(standard);
			dtoStandards.add(dtoStandard);
		});

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoStandards);
		return res;
	}

	private Standard setStandardDto(ScStandard standard) {

		Standard dtoStandard = new Standard();

		dtoStandard.setId(standard.getId());
		dtoStandard.setName(standard.getName());
		dtoStandard.setDescription(standard.getDescription());

		if (ScUtil.isAllPresent(standard.getSections())) {

			List<StandardSection> dtoSections = new ArrayList<StandardSection>();

			standard.getSections().forEach(section -> {

				StandardSection dtoSection = new StandardSection();
				dtoSection.setDescription(section.getDescription());
				dtoSection.setId(section.getId());
				dtoSection.setName(section.getName());
				dtoSections.add(dtoSection);
			});
			dtoStandard.setSections(dtoSections);
		}

		return dtoStandard;
	}

	public StandardResponse findStandard(Long id) {

		StandardResponse res = new StandardResponse();

		ScStandard standard = commonService.findById(id, ScStandard.class);

		if (!ScUtil.isAllPresent(standard))
			throw new NotFoundException("No standard can be found !");

		Standard standardDto = setStandardDto(standard);
		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(standardDto);

		return res;
	}

	public ActionResponse createOrUpdateStandard(Standard dtoStandard, Long id) {

		ActionResponse res = new ActionResponse();

		ScStandard standard = setDtoToStandard(dtoStandard, id);

		commonService.save(standard);

		String message = "";
		if (ScUtil.isAllPresent(id)) {
			message = "Successfully staff data";
			res.setApiMessage(ApiUtil.okMessage(message));
		} else {
			message = "Successfully created an staff";
			res.setApiMessage(ApiUtil.createdMessage(message));
			res.setActionMessage(message);
		}

		return res;
	}

	private ScStandard setDtoToStandard(Standard standardDto, Long id) {

		ScStandard standard = new ScStandard();

		if (ScUtil.isAllPresent(id))
			standard = commonService.findById(id, ScStandard.class);

		if (!ScUtil.isAllPresent(standard))
			throw new NotFoundException("No standard can be found !");

		standard.setDescription(standardDto.getDescription());
		standard.setName(standardDto.getName());

		if (ScUtil.isAllPresent(standardDto.getSections())) {

			if (ScUtil.isAllPresent(standard.getSections())) {
				standard.getSections().clear();
			} else {
				standard.setSections(new ArrayList<ScStandardSection>());
			}

			for (StandardSection sectionDto : standardDto.getSections()) {
				ScStandardSection section = new ScStandardSection();
				section.setDescription(sectionDto.getDescription());
				section.setName(sectionDto.getName());
				section.setStandard(standard);
			}
		}
		return standard;
	}

	public ActionResponse deleteStandard(Long id) {

		ActionResponse res = new ActionResponse();

		ScStandard standard = commonService.findById(id, ScStandard.class);

		if (!ScUtil.isAllPresent(standard))
			throw new NotFoundException("No standard can be found !");

		commonService.delete(standard);

		res.setActionMessage("Standard has been deleted successfully");
		res.setApiMessage(ApiUtil.okMessage("Standard has been deleted successfully"));
		return res;
	}

}
