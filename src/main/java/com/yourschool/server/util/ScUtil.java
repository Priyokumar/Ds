package com.yourschool.server.util;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.yourschool.server.dto.employee.RecordAudit;
import com.yourschool.server.dto.user.User;
import com.yourschool.server.entity.employee.ScRecordAudit;
import com.yourschool.server.entity.user.ScUser;


public class ScUtil {

	public static boolean isAllPresent(Object... objects) {

		if (objects == null || objects.length <= 0)
			return false;

		for (int i = 0; i < objects.length; i++) {

			Object obj = objects[i];

			if (obj == null)
				return false;
			else {

				if (obj instanceof String)
					return !((String) obj).isEmpty();
				else if (obj instanceof List || obj instanceof Map || obj instanceof Set)
					return !((Collection<?>) obj).isEmpty();
			}
		}

		return true;
	}

	public static String getGeneratedNumber(String prefix) {

		LocalDateTime now = LocalDateTime.now();
		int month = now.getMonth().getValue();
		int year = now.getYear();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		Random rand = new Random();
		int rndNo = rand.nextInt(100) + 1;

		prefix += year + "" + month + "" + hour + "" + minute + "" + second + "" + rndNo;

		return prefix;

	}

	public static ScRecordAudit recordAudit(ScUser user, Long id) {

		if (ScUtil.isAllPresent(user))
			return null;
		ScRecordAudit recordAudit = new ScRecordAudit();

		if (ScUtil.isAllPresent(id)) {
			recordAudit.setUpdatedBy(user);
			recordAudit.setUpdatedDate(ScDateUtil.now());
		} else {
			recordAudit.setCreatedBy(user);
			recordAudit.setCreatedDate(ScDateUtil.now());
			recordAudit.setUpdatedBy(user);
			recordAudit.setUpdatedDate(ScDateUtil.now());
		}

		return recordAudit;
	}

	public static RecordAudit recordAuditToDto(ScRecordAudit recordAudit) {

		RecordAudit dtoRecordAudit = new RecordAudit();

		dtoRecordAudit.setCreatedBy(userToDto(recordAudit.getCreatedBy()));
		dtoRecordAudit.setCreatedDate(ScDateUtil.dateToString(recordAudit.getCreatedDate()));
		dtoRecordAudit.setUpdatedBy(userToDto(recordAudit.getUpdatedBy()));
		dtoRecordAudit.setUpdatedDate(ScDateUtil.dateToString(recordAudit.getUpdatedDate()));

		return dtoRecordAudit;

	}

	private static User userToDto(ScUser user) {

		if (ScUtil.isAllPresent(user))
			return null;

		User dtoUser = new User();
		dtoUser.setId(user.getId());
		dtoUser.setFirstName(user.getFirstName());
		dtoUser.setLastName(user.getLastName());
		dtoUser.setUserName(user.getUserName());

		return dtoUser;
	}
}
