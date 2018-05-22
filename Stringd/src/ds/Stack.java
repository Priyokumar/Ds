package ds;

public class Stack {

	private String[] arr;
	private int pushIndex;
	private int popIndex;
	private int length;

	public Stack(int size) {
		arr = new String[size];
		length = arr.length;
		pushIndex = arr.length - 1;
		popIndex = 0;
	}

	public Stack push(String val) {
		if (checkForPush())
			arr[pushIndex] = val;
		else
			throw new RuntimeException("No place to push data");
		return this;
	}

	public Stack pop() {
		if (checkForPop())
			arr[popIndex] = null;
		else
			throw new RuntimeException("Nothing to pop");
		return this;
	}

	public String peek() {

		Integer initIndex = checkForVals();
		if (initIndex != null) {
			return arr[initIndex];
		} else {
			throw new RuntimeException("No data, So no peek..");
		}
	}

	public String[] values() {

		Integer initIndex = checkForVals();
		String[] newData = new String[0];
		if (initIndex != null) {

			int size = length - initIndex;
			newData = new String[size];
			for (int i = initIndex, j = 0; i < length; i++, j++) {
				newData[j] = arr[i];
			}
			return newData;
		} else
			return newData;
	}

	private boolean checkForPush() {

		for (int i = length - 1; i >= 0; i--) {
			if (arr[i] == null) {
				pushIndex = i;
				return true;
			}
		}
		return false;
	}

	private boolean checkForPop() {

		for (int i = 0; i < length; i++) {
			if (arr[i] != null) {
				popIndex = i;
				return true;
			}
		}
		return false;
	}

	private Integer checkForVals() {

		Integer initIndex = null;
		for (int i = 0; i < length; i++) {
			if (arr[i] != null) {
				popIndex = i;

				if (initIndex == null)
					initIndex = i;
				return initIndex;
			}
		}
		return initIndex;
	}

}
