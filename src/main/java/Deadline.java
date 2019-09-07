/**
 *The Deadline class is a subset of the Task class.
 */
public class Deadline extends Task {

	/**
	 *This attribute 'by' refers to the deadline of this 'Deadline' Task.
	 */
	protected String by;

	/**
	 *The 'Deadline' Task constructor.
	 *@param description refers to the name of this 'Deadline' Task.
	 *@param by refers to the deadline of this 'Deadline' Task.
	 */
	public Deadline (String description, String by) {
		super(description);
		this.by = by;
	}

	/**
	 *This function gets and returns the status of this 'Deadline' Task, that is whether this Task is 'done' or of type 'Deadline', 'Event', 'Todo' etc...
	 @return a string describing this Task's status
	 */
	@Override
	public String getStatus() {
		return "[D]" + super.getStatus() + " (by: " + by + ")";
	}
}
