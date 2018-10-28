package task_13;

public class Field {

	private long id;
	private String value;

	public Field() {

	}

	public Field(long id, String value) {
		this.id = id;
		this.value = value;
	}

	@Override
	public String toString() {
		return "ID: " + id + "; Value: " + value;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Field)) {
			return false;
		}

		Field field = (Field) obj;

		if (this.id == field.id) {
			return (this.value.compareTo(field.value) == 0) ? true : false;
		} else {
			return false;
		}
	}

}
