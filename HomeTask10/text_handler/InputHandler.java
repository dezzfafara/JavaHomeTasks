package text_handler;

class InputHandler extends InputMethodsContainer {

	private final static String ENTER_MESSAGE = "Enter ";

	InputHandler() {
		super();
	}

	void keyboardInputHandler() {

		System.out.println(ENTER_MESSAGE + "size of text (in paragraphs): ");
		Paragraph paragraph = Paragraph.getPrivateObjectOfParagraph(Integer.parseInt(getInput().nextLine()));
		int i = 0;
		while (i < Paragraph.getQuantityOfParagraphs()) {
			System.out.println(ENTER_MESSAGE + (i + 1) + " paragraph:");
			paragraph.setParagraph(i, (getInput().nextLine() + "\n"));
			i++;
		}

	}

}
