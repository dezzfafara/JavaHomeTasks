package reg_exp;

public class PatternsHandler {
	private final static int SIZE = 16;

	private String[] myPatterns = new String[SIZE];

	public PatternsHandler() {
		myPatterns[0] = "([^a-zA-Z]*[a-zA-Z]{4}[^a-zA-Z]*)|";
		myPatterns[1] = "([^a-zA-Z]*[a-zA-Z]{3}[^a-zA-Z]+[a-zA-Z]{1}[^a-zA-Z]*)|";
		myPatterns[2] = "([^a-zA-Z]*[a-zA-Z]{2}[^a-zA-Z]+[a-zA-Z]{2}[^a-zA-Z]*)|";
		myPatterns[3] = "([^a-zA-Z]*[a-zA-Z]{1}[^a-zA-Z]+[a-zA-Z]{3}[^a-zA-Z]*)|";
		myPatterns[4] = "([^a-zA-Z]*[a-zA-Z]{1}[^a-zA-Z]+[a-zA-Z]{1}[^a-zA-Z]+[a-zA-Z]{2}[^a-zA-Z]*)|";
		myPatterns[5] = "([^a-zA-Z]*[a-zA-Z]{1}[^a-zA-Z]+[a-zA-Z]{1}[^a-zA-Z]+[a-zA-Z]{1}[^a-zA-Z]+[a-zA-z]{1}[^a-zA-Z]*|)";
		myPatterns[6] = "([^a-zA-Z]*[a-zA-Z]{3}[^a-zA-Z]*)|";
		myPatterns[7] = "([^a-zA-Z]*[a-zA-Z]{1}[^a-zA-Z]+[a-zA-Z]{1}[^a-zA-Z]+[a-zA-Z]{1}[^a-zA-Z]*)|";
		myPatterns[8] = "([^a-zA-Z]*[a-zA-Z]{2}[^a-zA-Z]+[a-zA-Z]{1}[^a-zA-Z]*)|";
		myPatterns[9] = "([^a-zA-Z]*[a-zA-Z]{1}[^a-zA-Z]+[a-zA-Z]{2}[^a-zA-Z]*)|";
		myPatterns[10] = "([^a-zA-Z]*[a-zA-Z]{2}[^a-zA-Z]*)|";
		myPatterns[11] = "([^a-zA-Z]*[a-zA-Z]{1}[^a-zA-Z]+[a-zA-Z]{1}[^a-zA-Z]*)|";
		myPatterns[12] = "([^a-zA-Z]*[a-zA-Z]{1}[^a-zA-Z]*)|";
		myPatterns[13] = "([^a-zA-Z]*)|";
		myPatterns[14] = "([^a-zA-Z]*[a-zA-Z]{1}[^a-zA-Z]+[a-zA-Z]{2}[^a-zA-Z]+[a-zA-Z]{1}[^a-zA-Z]*)|";
		myPatterns[15] = "([^a-zA-Z]*[a-zA-Z]{2}[^a-zA-Z]+[a-zA-Z]{1}[^a-zA-Z]+[a-zA-Z]{1}[^a-zA-Z]*)";
	}

	public String[] getMyPatterns() {
		return myPatterns;
	}

}
