package reg_exp;

public class PatternConcatenator {
	private String patternContainer;

	private PatternsHandler patternsHandler;

	public PatternConcatenator() {
		patternContainer = "";
		patternsHandler = new PatternsHandler();
		this.patternConcatenator(patternsHandler.getMyPatterns());
	}

	private void patternConcatenator(String[] patternArray) {
		for (String patternArrayElement : patternArray) {
			patternContainer += patternArrayElement;
		}
	}

	public String getPatternContainer() {
		return patternContainer;
	}

}
