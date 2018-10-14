package task8_4;

public class StringConnector {
	private StringBuilder stringToInsertInto;

	public StringConnector() {
		this.stringToInsertInto = new StringBuilder();
	}

	public void setStringToInsertInto(String stringToInsertInto) {
		this.stringToInsertInto.append(stringToInsertInto);
	}

	public StringBuilder getStringToInsertInto() {
		return stringToInsertInto;
	}

	public void insertIntoString(int index, String valueToInsert) {
		this.stringToInsertInto.insert(index, valueToInsert);
	}

	public boolean positionChecker(int index) {
		return (index <= this.stringToInsertInto.length()) ? true : false;
	}

}
