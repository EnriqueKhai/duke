public class ToDo extends Task {

	public ToDo (String description) {
		super(description);
	}

	@Override
	public String getStatus() {
		return "[T]" + super.getStatus();
	}
}
