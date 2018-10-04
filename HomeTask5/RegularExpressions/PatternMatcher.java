package reg_exp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
	private PatternConcatenator patternConcatenator = new PatternConcatenator();

	public boolean matchPattern(String stringToVerify) {

		return this.patternCompiler(patternConcatenator.getPatternContainer(), stringToVerify);
	}

	public boolean matchPattern(int exactLengthOfString, String stringToVerify) {

		return this.patternCompiler("^.{" + exactLengthOfString + "}$", stringToVerify);
	}

	private boolean patternCompiler(String patternTemplate, String stringToVerify) {

		Pattern pattern = Pattern.compile(patternTemplate);
		Matcher matcher = pattern.matcher(stringToVerify);
		return matcher.matches();

	}
}
