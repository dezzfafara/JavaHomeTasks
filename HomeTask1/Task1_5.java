package task1_5;

import java.util.Random;

public class Task1_5 {
	public static void main(String[] args) {
		Random generator = new Random();
		int myRand = generator.nextInt(10000);
		System.out.println("Random number is : " + myRand);
	}

}
