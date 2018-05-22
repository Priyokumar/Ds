package trick;

public class UserInput {

	public static void main(String[] args) {
		TextInput input = new NumericInput();
		input.add('1');
		input.add('a');
		input.add('0');
		
		System.out.println(input.getValue());
	}
}

class TextInput {
	String ok = "";

	public void add(char c) {
		ok += c;
	}
	
	public String getValue() {
		return ok;
	}
	
	public UserInput Yes() {
		return null;
	}
}

class NumericInput extends TextInput {
	String ok = "";

	public void add(char c) {

		if (isNumeric(c)) {
			ok += String.valueOf(c);
		}
	}
	
	public UserInput Yes() {
		return null;
	}
	
	public String getValue() {
		return ok + "";
	}

	private boolean isNumeric(char c) {
		boolean isNumeric = false;
		switch (c) {

		case '0':
			isNumeric = true;
			break;
		case '1':
			isNumeric = true;
			break;
		case '2':
			isNumeric = true;
			break;
		case '3':
			isNumeric = true;
			break;
		case '4':
			isNumeric = true;
			break;
		case '5':
			isNumeric = true;
			break;

		case '6':
			isNumeric = true;
			break;
		case '7':
			isNumeric = true;
			break;

		case '8':
			isNumeric = true;
			break;

		case '9':
			isNumeric = true;
			break;

		default:
			break;
		}
		return isNumeric;
	}
}
