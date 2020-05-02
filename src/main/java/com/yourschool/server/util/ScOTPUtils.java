package com.yourschool.server.util;

import java.util.concurrent.ThreadLocalRandom;

public class ScOTPUtils {

	public static int generateOTP() {
		int randomNum = ThreadLocalRandom.current().nextInt(1000, 9999);
		return randomNum;
	}
}
