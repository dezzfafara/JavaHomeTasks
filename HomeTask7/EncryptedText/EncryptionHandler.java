package encryption;

public class EncryptionHandler {
	private String originalTextContainer;
	private char[][] symbolsContainer;
	private char[][] turnedSymbolsContainer;
	private int sizeOfCharArray;

	public EncryptionHandler() {
		this.originalTextContainer = "";
	}

	public EncryptionHandler(String valueToEncrypt) {
		this.originalTextContainer = valueToEncrypt;
		this.sizeOfCharArray = (int) Math.ceil((Math.sqrt(valueToEncrypt.length())));
		this.symbolsContainer = new char[this.sizeOfCharArray][this.sizeOfCharArray];
		this.turnedSymbolsContainer = new char[this.sizeOfCharArray][this.sizeOfCharArray];
	}

	public void matrixInitializer() {
		int count = 0;
		for (int i = 0; i < this.sizeOfCharArray; i++) {
			for (int j = 0; j < this.sizeOfCharArray; j++) {
				symbolsContainer[i][j] = this.originalTextContainer.charAt(count);
				count++;
			}
		}
	}

	public void turnedMatrixInitializer() {
		for (int i = 0; i < this.sizeOfCharArray; i++) {
			for (int j = 0; j < this.sizeOfCharArray; j++) {
				this.turnedSymbolsContainer[i][j] = this.symbolsContainer[this.sizeOfCharArray - j - 1][i];
			}
		}
	}

	public void swapColumns() {
		char tempSymbol = ' ';
		for (int i = 0; i < (int) Math.ceil(this.sizeOfCharArray / 2); i++) {
			for (int j = 0; j < this.sizeOfCharArray; j++) {
				tempSymbol = this.turnedSymbolsContainer[i][j];
				this.turnedSymbolsContainer[i][j] = this.turnedSymbolsContainer[this.sizeOfCharArray - 1 - i][j];
				this.turnedSymbolsContainer[this.sizeOfCharArray - 1 - i][j] = tempSymbol;
			}
		}
	}

	public void swapRows() {
		char tempSymbol = ' ';
		for (int i = 0; i < this.sizeOfCharArray; i++) {
			for (int j = 0; j < this.sizeOfCharArray - 1; j += 2) {
				tempSymbol = this.turnedSymbolsContainer[i][j];
				this.turnedSymbolsContainer[i][j] = this.turnedSymbolsContainer[i][j + 1];
				this.turnedSymbolsContainer[i][j + 1] = tempSymbol;
			}
		}
	}

	public String getEncryptedText() {
		String encryptedText = "";

		int edge = (this.sizeOfCharArray % 2 != 0) ? this.sizeOfCharArray / 2 + 1 : this.sizeOfCharArray / 2;
		for (int i = 1; i <= edge; i++) {
			for (int j = i - 1; j < this.sizeOfCharArray - i + 1; j++) {
				encryptedText += this.turnedSymbolsContainer[i - 1][j];
			}
			for (int j = i; j < this.sizeOfCharArray - i + 1; j++) {
				encryptedText += this.turnedSymbolsContainer[j][this.sizeOfCharArray - i];
			}
			for (int j = this.sizeOfCharArray - i - 1; j >= i - 1; j--) {
				encryptedText += this.turnedSymbolsContainer[this.sizeOfCharArray - i][j];
			}
			for (int j = this.sizeOfCharArray - i - 1; j >= i; j--) {
				encryptedText += this.turnedSymbolsContainer[j][i - 1];
			}
		}

		return encryptedText;
	}
}
