/**
 *The Event class is a subset of the Task class.
 */
public class Event extends Task {
	
	/**
	 *This attribute 'at' refers to the time of this 'Event' Task.
	 */
	protected String at;

	/**
	 *The 'Event' Task constructor.
	 *@param description refers to the name of this Event' Task.
	 *@param by refers to the time of this 'Event' Task.
	 */
	public Event (String description, String at) {
		super(description);
		this.at = at;
	}

	/**
	 *This function gets and returns the status of this 'Event' Task, that is whether this Task is 'done' or of type 'Deadline', 'Event', 'Todo' etc...
	 @return a string describing this Task's status
	 */
	@Override
	public String getStatus() {
		return "[E]" + super.getStatus() + " (at: " + at + ")";
	}
}
