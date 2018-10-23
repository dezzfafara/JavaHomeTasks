package text_handler;

import java.util.Scanner;

abstract class InputMethodsContainer {

	private Scanner input;

	InputMethodsContainer() {
		input = new Scanner(System.in);
	}

	void closeInput() {
		input.close();
	}

	Scanner getInput() {
		return input;
	}

	abstract void keyboardInputHandler();

}
