package task8_22;

import java.io.FileReader;
import java.io.IOException;

public class TextHandler {
	private final int SIZE = 100000;
	private char[] javaCode;
	private String cleanedJavaCode;

	public TextHandler() {
		this.javaCode = new char[SIZE];
		this.cleanedJavaCode = "";
	}

	public void readFromFile() throws IOException {
		FileReader fileReader = new FileReader("D:\\sourceJavaFile.java");
		fileReader.read(this.javaCode);
		fileReader.close();
	}

	public String getCleanedJavaCode() {
		for (int i = 0; i < this.javaCode.length; i++) {
			this.cleanedJavaCode += this.javaCode[i];
		}
		return this.cleanedJavaCode.replaceAll("(//[^\\p{Cntrl}]*)|(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)", "");
	}

}
