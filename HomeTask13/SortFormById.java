package task_13;

import java.util.Comparator;

public class SortFormById implements Comparator<Form> {

	@Override
	public int compare(Form f1, Form f2) {
		return (int) ((f1.getId() - f2.getId() == 0) ? 0
				: (f1.getId() - f2.getId()) / Math.abs(f1.getId() - f2.getId()));
	}

}
