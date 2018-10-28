package task_13;

public class Form {

	private long id;
	private String name;

	public Form() {

	}

	public Form(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ID: " + id + "; Name: " + name;
	}

}
