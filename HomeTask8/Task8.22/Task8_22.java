package task8_22;

import java.io.IOException;

public class Task8_22 {

	public static void main(String[] args) throws IOException {
		TextHandler textHandler = new TextHandler();
		textHandler.readFromFile();
		System.out.println("Cleaned Java code:\n=============================\n" + textHandler.getCleanedJavaCode());

	}

}
