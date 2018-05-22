package ds;

import java.util.ArrayList;
import java.util.Arrays;

public class Reporty {

	public static void main(String[] args) {

		ArrayList<Plan> plans = constructData();
		ArrayList<Crop> crops = new ArrayList<>();
		ArrayList<Variety> varieties = new ArrayList<>();

		plans.forEach(plan -> {
			crops.addAll(plan.crop);
		});

		crops.forEach(crop -> {
			varieties.addAll(crop.varieties);
		});

		System.out.println("Before-----------");
		varieties.forEach(varity -> {
			System.out.println("Name : " + varity.name + " || Quantity : " + varity.quantity + "\n");
		});

		ArrayList<Variety> distinctVarieties = new ArrayList<>();

		for (int i = 0; i < varieties.size(); i++) {

			if (!checkFromPool(varieties, distinctVarieties, i)) {

				Variety variety = varieties.get(i);
				Integer quantity = variety.quantity;

				for (int j = i + 1; j < varieties.size(); j++) {
					if (variety.name.equals(varieties.get(j).name))
						quantity += varieties.get(j).quantity;
				}

				variety.quantity = quantity;
				distinctVarieties.add(variety);
			}
		}

		System.out.println("After-----------");
		distinctVarieties.forEach(varity -> {
			System.out.println("Name : " + varity.name + " || Quantity : " + varity.quantity + "\n");
		});

	}

	private static Boolean checkFromPool(ArrayList<Variety> varieties, ArrayList<Variety> distinctVarieties, int i) {

		for (Variety distinctVariety : distinctVarieties) {
			if (distinctVariety.name.equals(varieties.get(i).name))
				return true;
		}
		return false;
	}

	private static ArrayList<Plan> constructData() {
		ArrayList<Variety> varietiesc1 = new ArrayList<>(
				Arrays.asList(new Variety("V1", 1), new Variety("V2", 1), new Variety("V3", 1), new Variety("V4", 1)));
		Crop cropp1 = new Crop(varietiesc1);

		ArrayList<Variety> varietiesc2 = new ArrayList<>(
				Arrays.asList(new Variety("V1", 1), new Variety("V2", 1), new Variety("V3", 1), new Variety("V4", 1)));
		Crop cropp2 = new Crop(varietiesc2);

		ArrayList<Variety> varietiesc3 = new ArrayList<>(Arrays.asList(new Variety("V1", 1), new Variety("V2", 1),
				new Variety("V3", 1), new Variety("V4", 1), new Variety("V5", 1)));
		Crop cropp3 = new Crop(varietiesc3);

		Plan p1 = new Plan(new ArrayList<>(Arrays.asList(cropp1)));

		Plan p2 = new Plan(new ArrayList<>(Arrays.asList(cropp1, cropp2, cropp3)));

		return new ArrayList<>(Arrays.asList(p1, p2));
	}
}

class Plan {

	ArrayList<Crop> crop;

	public Plan(ArrayList<Crop> crop) {
		this.crop = crop;
	}
}

class Crop {
	ArrayList<Variety> varieties;

	public Crop(ArrayList<Variety> varieties) {
		this.varieties = varieties;
	}

}

class Variety {
	String name;
	Integer quantity;

	public Variety(String name, Integer quantity) {
		this.name = name;
		this.quantity = quantity;
	}

}