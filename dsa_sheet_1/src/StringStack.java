/** A stack abstract data type that contains Strings. */
public class StringStack {

	final int capacity;
	int top;
	int size;
	String[] stack;
	/**
	* Constructor for creating a new StringStack with a certain capacity.
	* @param capacity the maximum number of strings the stack can hold
	*/
	public StringStack(int capacity) {
		this.capacity = capacity;
		this.top = -1;
		this.size = 0;
		if (capacity != 0) {
			stack = new String[this.capacity];
		}
	}

	/**
	* Puts the given String on top of the stack (if there is enough space).
	* @param s the String to add to the top of the stack
	* @return false if there was not enough space in the stack to add the string;
	*         otherwise true
	*/
	public boolean push(String s) {
		int testLocation = top+1;
		if (testLocation != capacity){
			stack[testLocation] = s;
			size++;
			top = testLocation;
			return true;
		}
		return false;
	}

	/**
	* Removes the String on top of the stack from the stack and returns it.
	* @return the String on top of the stack, or null if the stack is empty.
	*/
	public String pop() {

		if (top != -1){
			String collect = stack[top];
			stack[top] = null;
			top--;
			size--;
			return collect;
		}
		return null;
	}

	/**
	* Returns the number of Strings in the stack.
	* @return the number of Strings in the stack
	*/
	public int count() {
		return size;
	}
}