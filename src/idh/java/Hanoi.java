package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	
	Stack<Integer> lStack = new Stack<Integer>();
	Stack<Integer> mStack = new Stack<Integer>();
	Stack<Integer> rStack = new Stack<Integer>();

	public Hanoi() {
		
		lStack.add(9);
		lStack.add(8);
		lStack.add(7);
		lStack.add(6);
		lStack.add(5);
		lStack.add(4);
		lStack.add(3);
		lStack.add(2);
		lStack.add(1);
		
	}
	
	private void movePiece(char from, char to) {
		
		int fromwert = 0;
		int towert = 0;
		
		try {
			if(from == 'l') {fromwert = lStack.peek();}
			if(from == 'm') {fromwert = mStack.peek();}
			if(from == 'r') {fromwert = rStack.peek();}
		}catch(EmptyStackException e) {
			System.out.println("The tower is empty. Try another one");
			return;
		}
		
		try {
			if(to == 'l') {towert = lStack.peek();}
			if(to == 'm') {towert = mStack.peek();}
			if(to == 'r') {towert = rStack.peek();}
		}catch(EmptyStackException e) {
			if(to == 'l') {lStack.add(fromwert);}
			if(to == 'm') {mStack.add(fromwert);}
			if(to == 'r') {rStack.add(fromwert);}
			if(from == 'l') {lStack.pop();}
			if(from == 'm') {mStack.pop();}
			if(from == 'r') {rStack.pop();}
			return;
		}
		
		if(fromwert < towert) {
			if(from == 'l') {lStack.pop();}
			if(from == 'm') {mStack.pop();}
			if(from == 'r') {rStack.pop();}
			if(to == 'l') {lStack.add(fromwert);}
			if(to == 'm') {mStack.add(fromwert);}
			if(to == 'r') {rStack.add(fromwert);}
		} else {
			System.out.println("Sorry, this dosent work. You cant put a greater number on a smaller one.");
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
		return new DescendingIterator(lStack);

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return new DescendingIterator(mStack);

	}
	private Iterator<Integer> getRightDescendingIterator() {
		return new DescendingIterator(rStack);
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
