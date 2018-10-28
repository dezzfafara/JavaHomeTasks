package task_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

public class Page {

	private final static String DELIMITER = "======================================";

	private float id;
	private String title;

	private ArrayList<Button> listOfButtons;
	private LinkedList<Field> listOfFields;
	private HashSet<Label> setOfLabels;
	private HashMap<Integer, Dropdown> mapOfDropdowns;
	private TreeSet<Form> treeOfForms;

	public Page() {
		this.listOfButtons = new ArrayList<Button>();
		this.listOfFields = new LinkedList<Field>();
		this.setOfLabels = new HashSet<Label>();
		this.mapOfDropdowns = new HashMap<Integer, Dropdown>();
		this.treeOfForms = new TreeSet<Form>(new SortFormById());
	}

	public float getId() {
		return this.id;
	}

	public void setId(float id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void addButton(Button button) {
		listOfButtons.add(button);
	}

	public void removeButton(Button button) {
		listOfButtons.remove(button);
	}

	public void removeAllSimilarButtons(Button button) {
		Iterator<Button> iter = listOfButtons.iterator();
		Button tempButton = null;
		while (iter.hasNext()) {
			tempButton = iter.next();
			if (tempButton.equals(button)) {
				iter.remove();
			}
		}
	}

	public void replaceButton(Button oldButton, Button newButton) {
		if (listOfButtons.indexOf(oldButton) != -1) {
			listOfButtons.set(listOfButtons.indexOf(oldButton), newButton);
		}
	}

	public void replaceAllSimilarButtons(Button oldButton, Button newButton) {
		if (listOfButtons.indexOf(oldButton) != -1) {
			for (int i = 0; i < listOfButtons.size(); i++) {

				if (listOfButtons.get(i).equals(oldButton)) {
					listOfButtons.set(i, newButton);
				}
			}
		}
	}

	public void printButtons() {
		listOfButtons.stream().forEach(button -> System.out.println(button.toString()));
		System.out.println(DELIMITER);
	}

	public void addField(Field field) {
		listOfFields.add(field);
	}

	public void removeField(Field field) {
		listOfFields.remove(field);
	}

	public void removeAllSimilarFields(Field field) {
		Iterator<Field> iter = listOfFields.iterator();
		Field tempField = null;
		while (iter.hasNext()) {
			tempField = iter.next();
			if (tempField.equals(field)) {
				iter.remove();
			}
		}
	}

	public void replaceField(Field oldField, Field newFeild) {
		if (listOfFields.indexOf(oldField) != -1) {
			listOfFields.set(listOfFields.indexOf(oldField), newFeild);
		}
	}

	public void replaceAllSimilarFields(Field oldField, Field newFeild) {
		if (listOfFields.indexOf(oldField) != -1) {
			for (int i = 0; i < listOfFields.size(); i++) {
				if (listOfFields.get(i).equals(oldField)) {
					listOfFields.set(i, newFeild);
				}
			}
		}
	}

	public void printFields() {
		listOfFields.stream().forEach(field -> System.out.println(field.toString()));
		System.out.println(DELIMITER);
	}

	public void addLabel(Label label) {
		setOfLabels.add(label);
	}

	public void removeLabel(Label label) {
		setOfLabels.remove(label);
	}

	public void replaceLabel(Label oldLabel, Label newLabel) {
		removeLabel(oldLabel);
		addLabel(newLabel);
	}

	public void printLabels() {
		setOfLabels.stream().forEach(label -> System.out.println(label.toString()));
		System.out.println(DELIMITER);
	}

	public void addDropdwon(Integer key, Dropdown dropdown) {
		mapOfDropdowns.put(key, dropdown);
	}

	private Integer getKey(Dropdown dropdown) {
		Integer key = null;
		for (Map.Entry<Integer, Dropdown> entry : mapOfDropdowns.entrySet()) {
			if (dropdown.equals(entry.getValue())) {
				key = (Integer) entry.getKey();
				break;
			}
		}
		return key;
	}

	public void removeDropdown(Dropdown dropdown) {
		mapOfDropdowns.remove(getKey(dropdown));

	}

	public void replaceDropdown(Dropdown oldDropdown, Dropdown newDropdown) {
		mapOfDropdowns.replace(getKey(oldDropdown), newDropdown);

	}

	public void printDropdowns() {
		for (Map.Entry<Integer, Dropdown> entry : mapOfDropdowns.entrySet()) {
			System.out.println("KEY: " + entry.getKey() + "; VALUE:\n" + entry.getValue().toString() + "\n");
		}
		System.out.println(DELIMITER);
	}

	public void bubbleSortByName() {
		Button tempButtonObject = null;
		for (int i = 0; i < listOfButtons.size(); i++) {
			for (int j = 0; j < listOfButtons.size() - 1; j++) {
				if ((listOfButtons.get(j).getName().compareTo(listOfButtons.get(j + 1).getName())) > 0) {
					tempButtonObject = listOfButtons.get(j);
					listOfButtons.set(j, listOfButtons.get(j + 1));
					listOfButtons.set(j + 1, tempButtonObject);
				}
			}
		}
	}

	public void addForm(Form form) {
		treeOfForms.add(form);
	}

	public void removeForm(Form form) {
		treeOfForms.remove(form);
	}

	public void replaceForm(Form oldForm, Form newForm) {
		removeForm(oldForm);
		addForm(newForm);
	}

	public void printAllForms() {
		treeOfForms.stream().forEach(form -> System.out.println(form.toString()));
		System.out.println(DELIMITER);
	}

}
