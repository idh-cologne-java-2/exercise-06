package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {

	Stack<Integer> leftStack = new Stack<>();
	Stack<Integer> middleStack = new Stack<>();
	Stack<Integer> rightStack = new Stack<>();
	public Hanoi() {
		leftStack.push(9);
		leftStack.push(8);
		leftStack.push(7);
		leftStack.push(6);
		leftStack.push(5);
		leftStack.push(4);
		leftStack.push(3);
		leftStack.push(2);
		leftStack.push(1);

	}
	
	private void movePiece(char from, char to) {
		Stack<Integer> source;
		Stack<Integer> target;

		switch (from) {
			case 'l' -> source = leftStack;
			case 'm' -> source = middleStack;
			case 'r' -> source = rightStack;
			default -> throw new RuntimeException();
		}

		switch (to) {
			case 'l' -> target = leftStack;
			case 'm' -> target = middleStack;
			case 'r' -> target = rightStack;
			default -> throw new RuntimeException();
		}

		if (!source.empty() && source.peek() < target.peek()){

			//auf target die oberste Scheibe von source legen
			target.push(source.pop());
		}
		else if (source.empty() && source.peek() > target.peek()){
			System.out.println("Diese Aktion ist nicht möglich, versuche es erneut");
		}
	}
	
	public void run(){
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
		return leftStack.iterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return middleStack.iterator();


	}
	private Iterator<Integer> getRightDescendingIterator() {
	return rightStack.iterator();

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
	
	public static void main(String[] args){
		Hanoi hanoi = new Hanoi();
		hanoi.run();
	}

}
