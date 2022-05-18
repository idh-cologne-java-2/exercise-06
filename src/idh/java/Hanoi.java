package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	
	// Stacks
	Stack<Integer> leftStack = new Stack<Integer>();
	Stack<Integer> middleStack = new Stack<Integer>();
	Stack<Integer> rightStack = new Stack<Integer>();

	public Hanoi() {
		// TODO: Implement
		// Implementierung mit for-Schleife
		for (int i = 0; i < 9; i++) {
			leftStack.push(i);
		}
		
		// Implementierung
		leftStack.add(1);
		leftStack.add(2);
		leftStack.add(3);
		leftStack.add(4);
		leftStack.add(5);
		leftStack.add(6);
		leftStack.add(7);
		leftStack.add(8);
		leftStack.add(9);
	
	}
	
	private void movePiece(char from, char to) {
		// TODO: Implement
		Stack<Integer> sourceStack = new Stack<Integer>();
		Stack<Integer> targetStack = new Stack<Integer>();
		
		switch (from) {
		case 'l': sourceStack = leftStack;
		case 'm': sourceStack = middleStack;
		case 'r': sourceStack = rightStack;
		break;
		}
		
		switch (to) {
		case 'l': targetStack = leftStack;
		case 'm': targetStack = middleStack;
		case 'r': targetStack = rightStack;
		break;
		}
		
		if(sourceStack.empty()) {
		System.out.println("Stack is empty.");
		}
		
		if(targetStack.isEmpty()|| sourceStack.peek() < targetStack.peek()) {
		targetStack.push(sourceStack.pop());
		return;
		}
		
		if(sourceStack.peek() > targetStack.peek()) {
		System.out.println("Not valid");
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
		return null;

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement
		return null;

	}
	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
		return null;
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
