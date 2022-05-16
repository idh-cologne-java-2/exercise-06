package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	
	private Stack<Integer> leftStack = new Stack<Integer>();
	private Stack<Integer> middleStack = new Stack<Integer>();
	private Stack<Integer> rightStack = new Stack<Integer>();
	

	public Stack<Integer> getStackByIdentifier(char stackID) {
		switch (stackID) {
		case 'l':
			return leftStack;
		case 'm':
			return middleStack;
		case 'r':
			return rightStack;
		default:
			return null;
		}
	}

	public Hanoi() {
		for (int i = 1; i < 10; i++) {
			this.leftStack.push(10-i);
		}
	}
	
	private void movePiece(char from, char to) throws EmptyStackException, IllegalMoveException {
		if (this.getStackByIdentifier(from).empty()) throw new EmptyStackException();
		if (this.getStackByIdentifier(to).empty()) {
			this.getStackByIdentifier(to).push(this.getStackByIdentifier(from).pop());
			return;
		}
		if (this.getStackByIdentifier(from).peek() > this.getStackByIdentifier(to).peek()) {
			throw new IllegalMoveException();
		}
		this.getStackByIdentifier(to).push(this.getStackByIdentifier(from).pop());
		return;
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
		return new DescendingIterator(this,'l');
	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return new DescendingIterator(this,'m');
	}
	private Iterator<Integer> getRightDescendingIterator() {
		return new DescendingIterator(this,'r');
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
