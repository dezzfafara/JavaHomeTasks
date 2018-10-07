package task1_7;

public class Task1_7 {
	public static void main(String[] args) {
		int i = 14;
		short s = 114;
		long l = 55669988L;
		double d = 5589.635d;
		float f = 78.36f;
		char c = 'r';
		boolean isTrue = true;
		int result1 = i + s;
		double result2 = l - d;
		double result3 = f * d;
		boolean result4 = (l > d) ? true : false;
		boolean result5 = (f < i) ? true : false;
		boolean result6;
		boolean result7;

		if (c != s) {
			result6 = true;
		} else {
			result6 = false;
		}

		if (f == s) {
			result7 = true;
		} else {
			result7 = false;
		}
		System.out.print("PRINT: " + i + " " + s + " " + l + " " + d + " " + f + " " + c + " " + isTrue + " " + result1
				+ " " + result2 + " " + result3 + " " + result4 + " " + result5 + " " + result6 + " " + result7 + "\n");

		System.out.println("PRINTLN: " + i + " " + s + " " + l + " " + d + " " + f + " " + c + " " + isTrue + " "
				+ result1 + " " + result2 + " " + result3 + " " + result4 + " " + result5 + " " + result6 + " "
				+ result7);
		
		System.out.println("PRINTF:");
		System.out.printf("i = %+d\n", i);
		System.out.printf("s = %10d\n", s);
		System.out.printf("l = %,d\n", l);
		System.out.printf("d = %.5f\n", d);
		System.out.printf("f = %.1f\n", f);
		System.out.printf("result2 = %015.5f\n", result2);
		System.out.printf("result3 = %,.5f\n", result3);

	}

}
