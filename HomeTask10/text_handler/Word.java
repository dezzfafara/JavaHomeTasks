package text_handler;

class Word extends InputMethodsContainer implements ITextElementHandler {

	private final static String LETTERS_PATTERN = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String TO_REPLACE_MESSAGE = " to replace: ";
	private StringBuilder tempWord;
	private int indexToReplace;
	private char symbolToReplace;

	Word() {
		super();
		tempWord = new StringBuilder();
	}

	private void setIndexToReplace(int indexToReplace) {
		this.indexToReplace = indexToReplace;
	}

	private void setSymbolToReplace(char symbolToReplace) {
		this.symbolToReplace = symbolToReplace;
	}

	private boolean isLetter(char symbolToVerify) {
		for (int i = 0; i < LETTERS_PATTERN.length(); i++) {
			if (symbolToVerify == LETTERS_PATTERN.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	StringBuilder getTempWord() {
		return this.tempWord;
	}

	@Override
	void keyboardInputHandler() {
		System.out.println("Position" + TO_REPLACE_MESSAGE);
		setIndexToReplace(Integer.parseInt(getInput().nextLine()) - 1);
		System.out.println("Symbol" + TO_REPLACE_MESSAGE);
		setSymbolToReplace(getInput().nextLine().charAt(0));
		closeInput();

	}

	@Override
	public void handleTextElement(String tempTextElement) {
		tempWord.setLength(0);
		tempWord.append(tempTextElement);
		if (tempTextElement.length() > indexToReplace) {
			{
				if (isLetter(tempTextElement.charAt(indexToReplace))) {
					tempWord.setCharAt(indexToReplace, symbolToReplace);
				}
			}

		}
	}

}
