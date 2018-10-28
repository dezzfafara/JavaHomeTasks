package task_13;

public class Button {

	private String name;
	private String action;

	public Button() {

	}

	public Button(String name, String action) {
		this.name = name;
		this.action = action;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Name: " + name + "; Action: " + action;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Button)) {
			return false;
		}

		Button button = (Button) obj;
		if (this.name.compareTo(button.name) == 0) {
			return (this.action.compareTo(button.action) == 0) ? true : false;
		} else {
			return false;
		}
	}

}
