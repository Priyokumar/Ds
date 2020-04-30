package com.yourschool.server.vo;

import java.io.File;
import java.time.LocalDate;

public class Test {

	static String uploadPath = System.getProperty("user.dir") + File.separator + "upload";

	public static void main(String[] args) {

		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int monthValue = today.getMonthValue();
		int dayOfMonth = today.getDayOfMonth();
		
		String datePath = File.separator + year +File.separator + monthValue + File.separator + dayOfMonth ;

		String fullPath = uploadPath + datePath;

		File file = new File(fullPath);

		if (!file.exists())
			file.mkdirs();

	}

}
