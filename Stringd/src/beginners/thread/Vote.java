package beginners.thread;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Vote {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		TreeMap<String, Integer> candiMap = new TreeMap<>();

		System.out.println("Enter number of cadidate");
		int nextInt = sc.nextInt();

		for (int i = 0; i < nextInt; i++) {
			System.out.println("Enter candidate names");
			String next = sc.next();
			candiMap.put(next, 0);
			System.out.println();
		}

		System.out.println("Shall We Start Voting");
		System.out.println("No of votee");
		int noOfVotee = sc.nextInt();

		for (int i = 0; i < noOfVotee; i++) {
			System.out.println("Cadidate name :");
			String next = sc.next();
			vote(next, candiMap);
		}

		result(candiMap);

		sc.close();
	}

	private static void vote(String candi, TreeMap<String, Integer> candiMap) {

		candiMap.put(candi, candiMap.get(candi) + 1);
	}

	private static void result(TreeMap<String, Integer> candiMap) {

		List<Entry<String, Integer>> listOfEntries = new java.util.ArrayList<>(candiMap.entrySet());

		Collections.sort(listOfEntries, (e1, e2) -> {
			Integer v1 = e1.getValue();
			Integer v2 = e2.getValue();
			return v1.compareTo(v2);
		});

		System.out.println(listOfEntries.get(listOfEntries.size() - 1).getKey() + " Win the Vote with count of "
				+ listOfEntries.get(listOfEntries.size() - 1).getValue());
	}

}
