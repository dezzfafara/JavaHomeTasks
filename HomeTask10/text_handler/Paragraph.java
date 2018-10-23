package text_handler;

class Paragraph {

	private static String[] arrayOfParagraphs;

	private static Paragraph paragraph;

	private Paragraph(int quantityOfParagraphs) {
		arrayOfParagraphs = new String[quantityOfParagraphs];
	}

	static Paragraph getPrivateObjectOfParagraph(int quantityOfParagraphs) {
		if (paragraph == null) {
			paragraph = new Paragraph(quantityOfParagraphs);
		}
		return paragraph;
	}

	String getParagraph(int index) {
		return arrayOfParagraphs[index];
	}

	static int getQuantityOfParagraphs() {
		return arrayOfParagraphs.length;
	}

	void setParagraph(int index, String paragraph) {
		arrayOfParagraphs[index] = paragraph;
	}

	void stringToArray(String stringToSplit) {
		arrayOfParagraphs = stringToSplit.split("[\\r\\n\\t]");
	}

}
