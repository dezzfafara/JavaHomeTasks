package task1_2;

public class Task1_2 {
	public static void main(String[] args) {
		for (int i = args.length - 1; i >= 0; i--) {
			System.out.println("Argument " + (i + 1) + " = " + args[i]);
		}
	}

}
