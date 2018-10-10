package encryption;

public class EncryptedText {

	public static void main(String[] args) {
		EncryptionHandler encryptionHandler = new EncryptionHandler(
				"Once upon a time there was a poor miller. He lived in a small house, together with three sons. Miller worked at the mill.");

		encryptionHandler.matrixInitializer();

		encryptionHandler.turnedMatrixInitializer();

		encryptionHandler.swapColumns();

		encryptionHandler.swapRows();

		System.out.print("Encrypted text:\n" + encryptionHandler.getEncryptedText());

	}

}
