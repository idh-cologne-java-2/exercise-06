package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	Stack<Integer> l = new Stack<Integer>();
	Stack<Integer> m = new Stack<Integer>();
	Stack<Integer> r = new Stack<Integer>();

	public Hanoi() {
		int i = 9;
		while (l.peek() != 1) {
			l.push(i--);
		}
	}
	
	private void movePiece(char from, char to) {
		if(from == 'l') {
			if(to == 'l') {
				System.out.println("Try again, something's not right.");
			}
			else if(to == 'm') {
				if(l.peek() < m.peek()) {
					m.push(l.peek());
					l.pop();
				}
				else {
					System.out.println("Try again, something's not right.");
				}
			}
			else if(to == 'r') {
				if(l.peek() < r.peek()) {
					r.push(l.peek());
					l.pop();
				}
				else {
					System.out.println("Try again, something's not right.");
				}	
			}
		}
		else if(from == 'm') {
			if(to == 'l') {
				if(m.peek() < l.peek()) {
					l.push(m.peek());
					m.pop();
				}
				else {
					System.out.println("Try again, something's not right.");
				}				
			}
			if(to == 'm') {
				System.out.println("Try again, something's not right.");
			}
			if(to == 'r') {
				if(m.peek() < r.peek()) {
					r.push(m.peek());
					m.pop();
				}
				else {
					System.out.println("Try again, something's not right.");
				}
			}
			
		}
		else if(from == 'r') {
			if(to == 'l') {
				if(r.peek() < l.peek()) {
					l.push(r.peek());
					r.pop();
				}
				else {
					System.out.println("Try again, something's not right.");
				}				
			}
			else if(to == 'm') {
				if(r.peek() < m.peek()) {
					m.push(r.peek());
					r.pop();
				}
				else {
					System.out.println("Try again, something's not right.");
				}				
			}
			else if(to == 'r') {
				System.out.println("Try again, something's not right.");				
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
		return l.iterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return m.iterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		return r.iterator();
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
