package exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Exam {

	public static void main(String[] args) {

		HashMap<String, String> check = check();

		if (check.keySet().contains("0"))
			System.out.println(check.get("0"));
		else if (check.keySet().contains("1"))
			System.out.println(check.get("1"));

	}

	private static HashMap<String, String> check() {

		String real = "flipkart";
		char[] reaArr = real.toCharArray();
		String val = "f?ip*t";

		HashMap<String, String> result = new HashMap<>();

		boolean hyCon = val.contains("-");
		boolean qCon = val.contains("?");
		boolean asCon = val.contains("*");

		HashMap<String, List<Integer>> rule = new HashMap<>();
		char[] charArray = val.toCharArray();

		if (hyCon) {
			result.put("0", "0(- operator cause no output)");
			return result;
		}

		if (qCon) {

			List<Integer> qList = new ArrayList<>();
			for (int i = 0; i < charArray.length; i++) {

				if (charArray[i] == '?')
					qList.add(i);
			}
			rule.put("Q", qList);
		}

		if (asCon) {

			List<Integer> aList = new ArrayList<>();
			for (int i = 0; i < charArray.length; i++) {
				if (charArray[i] == '*')
					aList.add(i);
			}
			rule.put("A", aList);
		}

		boolean err = false;

		if (rule.containsKey("Q")) {

			List<Integer> list = rule.get("Q");

			for (Integer i : list) {
				char bckwrd = charArray[i + 1];
				int indexOf2 = real.indexOf(bckwrd);

				if (indexOf2 - i > 2) {
					result.put("0", "0( ? placeholder more than 2 character)");
					err = true;
				} else {

					String oo = "";
					for (int o = 0; o < indexOf2; o++) {
						oo += reaArr[0];
					}
					result.put("1", "1( ? matches " + oo + ")");
				}
			}
		}

		if (err) {
			return result;
		}

		if (rule.containsKey("A")) {

			List<Integer> list = rule.get("A");

			for (Integer i : list) {

				char bckwrd = charArray[i + 1];
				int indexOf2 = real.indexOf(bckwrd);

				if (indexOf2 - i <= 2) {

					result.put("0", "0( ? placeholder less than 2 character)");
					err = true;
					err = true;
				} else {
					String oo = "";
					for (int o = 0; o < indexOf2; o++) {
						oo += reaArr[0];
					}

					result.put("1", "1( ? matches " + oo + ")");
				}
			}
		}

		if (err) {
			return result;
		}

		return result;
	}

}
