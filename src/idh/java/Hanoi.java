package idh.java;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hanoi {
	Stack<Integer> l = new Stack<Integer>();
	Stack<Integer> m = new Stack<Integer>();
	Stack<Integer> r = new Stack <Integer>(); 
	
 // we need 3 stacks that are storing the int data 

	public Hanoi() {
		l.add(9);
		l.add(8);
		l.add(7);
		l.add(6);
		l.add(4);
		l.add(3);
		l.add(2);
		l.add(1);
//todo
	}
	
	private void movePiece(char from, char to) {
		if(from == 'l' && to == 'm') {
			if(!m.empty() && m.peek() < l.peek()) {
				System.out.print("ne bro mach nicht diesen immer klein auf groß");
			}else {
				m.push(l.pop());
			}
		} 
		
		if(from == 'l' && to == 'r') {
			if(!r.empty() && r.peek() < l.peek()) {
				System.out.print("ne bro mach nicht diesen immer klein auf groß");
			}else {
				r.push(l.pop());
			}
		}
		
		if(from == 'm' && to == 'l') {
			if(!l.empty() && l.peek() < m.peek()) {
				System.out.print("ne bro mach nicht diesen immer klein auf groß");
			}else {
				l.push(m.pop());
			}
		}
		
		if(from == 'm' && to == 'r') {
			if(!r.empty() && r.peek() < m.peek()) {
				System.out.print("ne bro mach nicht diesen immer klein auf groß");
			}else {
				r.push(m.pop());
			}
		}
		if(from == 'r' && to == 'm') {
			if(!m.empty() && m.peek() < r.peek()) {
				System.out.print("ne bro mach nicht diesen immer klein auf groß");
			}else {
				m.push(r.pop());
			}
		}
		if(from == 'r' && to == 'l') {
			if(!r.empty() && m.peek() < r.peek()) {
				System.out.print("ne bro mach nicht diesen immer klein auf groß");
			}else {
				l.push(r.pop());
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
				break;
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
