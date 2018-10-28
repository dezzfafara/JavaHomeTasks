package task_13;

public class Task13 {

	public static void main(String[] args) {
		Page page1 = new Page();
		Page page2 = new Page();

		Button button1 = new Button("Button_1", "Accept");
		Button button2 = new Button("Button_2", "Decline");
		Button button3 = new Button("Button_3", "Send");
		Button button4 = new Button("Button_4", "Delete");

		Field field1 = new Field(111, "Field_1");
		Field field2 = new Field(222, "Field_2");
		Field field3 = new Field(333, "Field_3");
		Field field4 = new Field(444, "Field_4");

		Label label1 = new Label("Label_1");
		Label label2 = new Label("Label_2");
		Label label3 = new Label("Label_3");
		Label label4 = new Label("Label_4");

		Dropdown dropdown1 = new Dropdown("Dropdown_1", false, "A", "B", "C");
		Dropdown dropdown2 = new Dropdown("Dropdown_2", false, "C", "D", "E", "F");
		Dropdown dropdown3 = new Dropdown("Dropdown_3", true, "XXX", "ZZZ", "YYY");
		Dropdown dropdown4 = new Dropdown("Dropdown_4", false, "XX", "YY", "ZZ");

		page1.addButton(button1);
		page1.addButton(button2);
		page1.addButton(button1);
		page1.addButton(button3);
		page1.addButton(button1);
		page1.printButtons();

		page1.replaceButton(button1, button4);
		page1.printButtons();

		page1.replaceAllSimilarButtons(button1, button4);
		page1.printButtons();

		page1.removeButton(button2);
		page1.printButtons();

		page1.removeAllSimilarButtons(button4);
		page1.printButtons();

		page1.addField(field1);
		page1.addField(field2);
		page1.addField(field1);
		page1.addField(field3);
		page1.addField(field1);
		page1.printFields();

		page1.replaceField(field1, field4);
		page1.printFields();

		page1.replaceAllSimilarFields(field1, field4);
		page1.printFields();

		page1.removeField(field2);
		page1.printFields();

		page1.removeAllSimilarFields(field4);
		page1.printFields();

		page1.addLabel(label1);
		page1.addLabel(label2);
		page1.addLabel(label3);
		page1.printLabels();

		page1.removeLabel(label2);
		page1.printLabels();

		page1.replaceLabel(label3, label4);
		page1.printLabels();

		page1.addDropdwon(1, dropdown1);
		page1.addDropdwon(2, dropdown2);
		page1.addDropdwon(4, dropdown4);
		page1.printDropdowns();

		page1.removeDropdown(dropdown1);
		page1.printDropdowns();

		page1.replaceDropdown(dropdown4, dropdown3);
		page1.printDropdowns();

		page2.addButton(button4);
		page2.addButton(button2);
		page2.addButton(button1);
		page2.addButton(button3);
		page2.printButtons();

		// Bubble sort
		page2.bubbleSortByName();

		System.out.println("SORTED BUTTONS:");
		page2.printButtons();

		// TreeSet
		Form form1 = new Form(111, "Form_1");
		Form form2 = new Form(222, "Form_2");
		Form form3 = new Form(333, "Form_3");
		Form form4 = new Form(444, "Form_4");

		page1.addForm(form1);
		page1.addForm(form3);
		page1.addForm(form2);
		page1.printAllForms();

		page1.removeForm(form1);
		page1.printAllForms();

		page1.replaceForm(form2, form4);
		page1.printAllForms();
	}

}
