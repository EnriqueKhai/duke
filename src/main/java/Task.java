/**
 *This class is the basis of all Tasks that can be represented for the user.
 */
public class Task {

	/**
	 *'Description' refers to the name of the Task as defined by the user.
	 */
	protected String description;

	/**
	 *'isDone' represents whether or not this Task has been completed; by default a Task is incomplete until the user has marked it otherwise.
	 */
	protected boolean isDone;

        /**
         *'taskID' represents the number associated with a particular task. It can be used to keep track of existing tasks.
         */
        protected int taskID;

	/**
	 *The constructor for the Task class.
	 *@param description refers to the name of this Task.
	 */
	//constructor
	public Task(String description) {
		this.description = description;
		this.isDone = false;
	}

	/**
	 *This function gets and returns the status of this Task, that is whether this Task is 'done', its description etc...
	 @return a string describing this Task's status
	 */
	public String getStatus() {
		return ("[" + (isDone ? "\u2713" : "\u2718") + "] " + description); //return tick or X symbols
	}

	/**
	 *This method allows the user to mark a previously added Task as completed, a status that can be reflected by the application.
	 */
	public void markAsDone() {
		this.isDone = true;
	}
}
