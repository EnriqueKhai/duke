/**
 *The ToDo class is a subset of the Task class.
 */
public class ToDo extends Task {

	/**
	 *The 'ToDo' Task constructor.
	 *@param description refers to the name of this Event' Task.
	 */
	public ToDo (String description) {
		super(description);
	}

	/**
	 *This function gets and returns the status of this 'ToDo' Task, that is whether this Task is 'done' or of type 'Deadline', 'Event', 'Todo' etc...
	 @return a string describing this Task's status
	 */
	@Override
	public String getStatus() {
		return "[T]" + super.getStatus();
	}
}
