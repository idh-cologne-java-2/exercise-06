package idh.java;

public class IllegalMoveException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalMoveException() {
		System.err.println("You cannot execute this move.");
	}
}
