package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	Stack <Integer> stackl = new Stack<Integer>();
	Stack <Integer> stackm = new Stack<Integer>();
	Stack <Integer> stackr = new Stack<Integer>();

	public Hanoi() {
		for (int i = 9; i > 0; i--) {
				stackl.push(i);
		}
		
	}
	
	private void movePiece(char from, char to) {
		int item;
		int elementToMove;
		
		// from left stack to
		if (from == 'l') {
			elementToMove = stackl.peek();
			
			if(stackl.empty()) {
				System.out.println("stack is empty");
				
			} else if (!stackl.empty()) {
				
				// middle
				if (to == 'm') {
					if (stackm.empty() || stackm.peek() > elementToMove) {
						
						item = stackl.pop();
						stackm.push(item);
					} else
						System.out.println(stackm.peek() + " is smaller than " + elementToMove + "\nstack not possible");
				}
				// right
				if (to == 'r') {
					if (stackr.empty() || stackr.peek() > elementToMove) {
						item = stackl.pop();
						stackr.push(item);
					}else
						System.out.println(stackr.peek() + " is smaller than " + elementToMove + "\nstack not possible");
				}
			}
				
		}
		
		// from middle to
		if(from == 'm') {
			if(stackm.empty()) {
				System.out.println("stack is empty");
			}else if (!stackm.empty()) {
				elementToMove = stackm.peek();
				
				// left
				if (to == 'l') {
					if(stackl.empty() || stackl.peek() > elementToMove) {
						
						item = stackm.pop();
						stackl.push(item);
					} else
						System.out.println(stackm.peek() + " is smaller than " + elementToMove + "\nstack is not possible");
				}
				
				// right
				if (to == 'r') {
					if (stackr.empty() || stackr.peek() > elementToMove) {
						
						item = stackm.pop();
						stackr.push(item);
						
					} else
						System.out.println(stackr.peek() + " is smaller than " + elementToMove + " \nstack is not possible");
				}
			}
			
		}
		// from right stack to
		if (from == 'r') {
			if(stackr.empty())
				System.out.println("stack is empty");
			if(!stackr.empty()) {
				
				elementToMove = stackr.peek();
				
				// middle stack
				if(to == 'm') {
					if (stackm.empty() || stackm.peek() > elementToMove) {
						
						item = stackr.pop();
						stackm.push(item);
					}else
						System.out.println(stackm.peek() + " is smaller than " + elementToMove + "\nstack is not possible");
				}
				
			// right
				if (to == 'r') {
					if (stackr.empty() || stackr.peek() > elementToMove) {
						
						item = stackm.pop();
						stackr.push(item);
					}else
						System.out.println(stackr.peek() + " is maller than " + elementToMove + " \nstack is not possible");
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
			} catch (Exception e) {
				System.out.println("Try again, something's not right.");
				e.printStackTrace();
			} 
		}
	}
	
	private Iterator<Integer> getLeftDescendingIterator() {
		// TODO: Implement
		return stackl.iterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement
		return stackm.iterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
		return stackr.iterator();
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("  |\n l|");
		Iterator<Integer> iter;
		iter = this.getLeftDescendingIterator();
		while(iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n m|");
		iter = this.getMiddleDescendingIterator();
		while(iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n r|");
		iter = this.getRightDescendingIterator();
		while(iter.hasNext()) {
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
