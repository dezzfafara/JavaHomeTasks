package task_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dropdown {

	private List<String> options;
	private boolean isSelected;
	private String name;

	public Dropdown() {
		options = new ArrayList<String>();
	}

	public Dropdown(String name, boolean isSelected, String... options) {
		this();
		this.name = name;
		this.isSelected = isSelected;
		this.options = Arrays.asList(options).stream().collect(Collectors.toList());

	}

	@Override
	public String toString() {
		return "Name: " + name + "; Is Selected: " + isSelected + "\nOPTIONS:\n"
				+ options.stream().collect(Collectors.joining("\n"));
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Dropdown)) {
			return false;
		}

		Dropdown dropdown = (Dropdown) obj;
		if (this.name.compareTo(dropdown.name) == 0) {
			return (this.isSelected == dropdown.isSelected) ? this.options.equals(dropdown.options) : false;
		} else {
			return false;
		}

	}

}
