public class Event extends Task {
	
	protected String at;

	public Event (String description, String at) {
		super(description);
		this.at = at;
	}

	@Override
	public String getStatus() {
		return "[E]" + super.getStatus() + " (at: " + at + ")";
	}
}
