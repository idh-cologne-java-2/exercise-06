package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

public class Hanoi {

	public Hanoi() {
		// TODO: Implement
		Queue<Integer> left = new LinkedList<Integer>();
		left.add(1);
		left.add(2);
		/*
		left.add("3");
		left.add("4");
		left.add("5");
		left.add("6");
		left.add("7");
		left.add("8");
		left.add("9");
		*/

//the first stack on the left to begin the game with
		Queue<String> middle = new LinkedList<String>();
		Queue<String> right = new LinkedList<String>();
//the other two stacks for the game


	}


	
	private void movePiece(char from, char to) {

	middle.add();
		// TODO: Implement

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
		Iterator<Integer> itLeft = new left.iterator();

		return null;

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement

		Iterator<Integer> itMiddle = new middle.iterator();
		return null;

	}
	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
		iterator<Integer> itRight = new right.iterator();
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
