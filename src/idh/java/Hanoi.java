package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	Stack<Integer> left = new Stack();
	Stack<Integer> middle = new Stack();
	Stack<Integer> right = new Stack();

	public Hanoi() {
		// TODO: Implement
		for (int i = 9; i > 0; i--) {
			left.push(i);
		}

	}

	private void movePiece(char from, char to) {
		// TODO: Implement
		int item;
		int elementToMove;

//		Operation from left to
		if (from == 'l') { // check, which stack the item will be removed from
			elementToMove = left.peek(); // get Element that should be removed

			if (left.empty()) {
				System.out.println("Sorry, stack is empty.");

			} else if (!left.empty()) {
				// ...middle
				if (to == 'm') { // check, where it should be moved to
					if (middle.empty() || middle.peek() > elementToMove) { // check, if move is possible, that is, if
																			// element that is moved to
						// the stack is smaller than top element
						item = left.pop(); // remove item from left stack and ...
						middle.push(item); // ..insert item onto the top of the middle stack.
					} else
						System.out.println("Sorry, but " + middle.peek() + " is smaller than " + elementToMove
								+ ". \nYou can only stack numbers on top of bigger numbers.");
				}

				// ...right
				if (to == 'r') {
					if (right.empty() || right.peek() > elementToMove) { // check, if move is possible, that is, if
																			// element
																			// that is moved
						// to the stack is smaller than top element
						item = left.pop(); // remove item from left stack and ...
						right.push(item); // ..insert item onto the top of the right stack.
					} else
						System.out.println("Sorry, but " + right.peek() + " is smaller than " + elementToMove
								+ ". \nYou can only stack numbers on top of bigger numbers.");
				}

			}
		}

//		Operation from middle to...
		if (from == 'm') {
			if (middle.empty()) {
				System.out.println("Sorry, stack is empty.");
			} else if (!middle.empty()) {
				elementToMove = middle.peek();

				// ...left
				if (to == 'l') {
					if (left.empty() || left.peek() > elementToMove) {

						item = middle.pop(); // remove item from middle stack
						left.push(item); // ..insert item onto the top of the left stack.
					} else
						System.out.println("Sorry, but " + middle.peek() + " is smaller than " + elementToMove
								+ ". \nYou can only stack numbers on top of bigger numbers.");
				}
				// ...right
				if (to == 'r') {
					if (right.empty() || right.peek() > elementToMove) { // check, if move is possible, that is, if
																			// element
																			// that is moved
						// to the stack is smaller than top element
						item = middle.pop(); // remove item from middle stack and ...
						right.push(item); // ..insert item onto the top of the right stack.
					} else
						System.out.println("Sorry, but " + right.peek() + " is smaller than " + elementToMove
								+ ". \nYou can only stack numbers on top of bigger numbers.");
				}
			}
		}

		// Operation from right stack to...
		if (from == 'r') {
			if (right.empty())
				System.out.println("Sorry, stack is empty.");
			if (!right.empty()) {

				elementToMove = right.peek();

				// ...middle stack
				if (to == 'm') { // check, where it should be moved to
					if (middle.empty() || middle.peek() > elementToMove) { // check, if move is possible, that is, if
																			// element that is moved to
						// the stack is smaller than top element
						item = right.pop(); // remove item from left stack and ...
						middle.push(item); // ..insert item onto the top of the middle stack.
					} else
						System.out.println("Sorry, but " + middle.peek() + " is smaller than " + elementToMove
								+ ". \nYou can only stack numbers on top of bigger numbers.");
				}
				// ...right
				if (to == 'r') {
					if (right.empty() || right.peek() > elementToMove) { // check, if move is possible, that is, if
																			// element
																			// that is moved
						// to the stack is smaller than top element
						item = middle.pop(); // remove item from middle stack and ...
						right.push(item); // ..insert item onto the top of the right stack.
					} else
						System.out.println("Sorry, but " + right.peek() + " is smaller than " + elementToMove
								+ ". \nYou can only stack numbers on top of bigger numbers.");
				}
			}
		}

	}

	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println(this);
				System.out.print("Enter source and target stick (will move top piece):");
				String s = br.readLine();
				if (s.matches("^([lmr])([lmr])$")) {
					char source = s.charAt(0);
					char target = s.charAt(1);
					movePiece(source, target);
				}
				if(s.matches("exit")) {
					break;
				}
			} catch (Exception e) {
				System.out.println("Try again, something's not right.");
				e.printStackTrace();
			}
		}
	}

	private Iterator<Integer> getLeftDescendingIterator() {
		// TODO: Implement

		return left.iterator();

	}

	private Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement
		return middle.iterator();

	}

	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
		return right.iterator();
	}

	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("  |\n l|");
		Iterator<Integer> iter;
		iter = this.getLeftDescendingIterator();
		while (iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n m|");
		iter = this.getMiddleDescendingIterator();
		while (iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n r|");
		iter = this.getRightDescendingIterator();
		while (iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |");
		return b.toString();
	}

	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
		hanoi.run();
	}

}
