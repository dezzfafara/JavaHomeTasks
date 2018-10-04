package reg_exp;

public class MyRegularExpressions {

	public static void main(String[] args) {
		PatternMatcher patternMatcher = new PatternMatcher();

		// Invocation of method which verifies that string has no more than 4 any
		// letters (I tried to verify all combinations of letters' location)
		System.out.println((patternMatcher.matchPattern("a 33.BC : q--")) ? "MATCHES" : "DOESN'T MATCH");

		// Invocation of method which verifies that string consists of N any symbols (in
		// our task N == 4)
		System.out.println((patternMatcher.matchPattern(4, "1 $G")) ? "MATCHES" : "DOESN'T MATCH");

	}
}