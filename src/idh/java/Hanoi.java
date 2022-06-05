package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Deque;

public class Hanoi {
	
	Deque<Integer> l = new LinkedList<Integer>();
	Deque<Integer> m = new LinkedList<Integer>();
	Deque<Integer> r = new LinkedList<Integer>();

	public Hanoi() {
		for (int i = 1; i < 10; i++) {
			l.addLast(i);
		}
	}
	
	private void movePiece(char from, char to) {
		int i = 0;
		switch(from) {
			case 'l': i = l.poll(); break;
			case 'm': i = m.poll(); break;
			case 'r': i = r.poll(); break;
		}
		switch(to) {
			case 'l': l.addFirst(i); break;
			case 'm': m.addFirst(i); break;
			case 'r': r.addFirst(i); break;
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
		return l.descendingIterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return m.descendingIterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		return r.descendingIterator();
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
