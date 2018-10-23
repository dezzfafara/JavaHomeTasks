package text_handler;

public class LettersReplacer {

	InputHandler inputHandler = new InputHandler();
	Word word = new Word();
	Sentence sentence = new Sentence();

	public void replaceLettersInText() {
		inputHandler.keyboardInputHandler();

		Paragraph paragraph = Paragraph.getPrivateObjectOfParagraph(Paragraph.getQuantityOfParagraphs());

		paragraphsToSentences(paragraph);

		sentence.stringToArrayOfWords();

		word.keyboardInputHandler();

		updateWordsInSentences();

		sentence.modifyStringOfParagraphs();

		paragraph.stringToArray(sentence.getStringOfParagraphs());

		printModifiedText(paragraph);

	}

	private void printModifiedText(Paragraph paragraph) {
		System.out.println("MODIFIED TEXT:");
		for (int i = 0; i < Paragraph.getQuantityOfParagraphs(); i++) {
			System.out.println(paragraph.getParagraph(i));
		}
	}

	private void paragraphsToSentences(Paragraph paragraph) {

		for (int i = 0; i < Paragraph.getQuantityOfParagraphs(); i++) {
			sentence.handleTextElement(paragraph.getParagraph(i));
		}
	}

	private void updateWordsInSentences() {
		int i = 0;
		for (String tempWord : sentence.getArrayOfWords()) {
			word.handleTextElement(tempWord);
			sentence.setWord(i, word.getTempWord().toString());
			i++;
		}
	}

}
