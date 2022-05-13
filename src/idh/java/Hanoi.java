package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {

	
	Stack<Integer> l = new Stack<Integer>();
	Stack<Integer> m = new Stack<Integer>();
	Stack<Integer> r = new Stack<Integer>();
	
	public Hanoi() {
		l.push(9);
		l.push(8);
		l.push(7);
		l.push(6);
		l.push(5);
		l.push(4);
		l.push(3);
		l.push(2);
		l.push(1);
	}
	
	private void movePiece(char from, char to) {
		int chosen = 0;
		int upperItem;
		if(from == 'l') {
			if(l.empty()) {
				System.out.println("There is no piece on the stack");
			}
			else {
				chosen = l.pop();
			}
			
		}
		else if(from == 'm') {
			if(m.empty()) {
				System.out.println("There is no piece on the stack");
			}
			else {
				chosen = m.pop();
			}
		}
		else {
			if(r.empty()) {
				System.out.println("There is no piece on the stack");
			}
			else {
				chosen = r.pop();
			}
		}
		if(chosen != 0) {
			if(to == 'l') {
				if(l.empty()) {
					upperItem = 100;
				}
				else {
					upperItem = l.peek();
				}
				if(upperItem > chosen) {
					l.push(chosen);
				}
				else {
					System.out.println("Can't put a bigger piece on a smaller one");
					if(from == 'l') {
						l.push(chosen);
					}
					else if(from == 'm') {
						m.push(chosen);
					}
					else {
						r.push(chosen);
					}
				}
			}
			else if(to == 'm') {
				if(m.empty()) {
					upperItem = 100;
				}
				else {
					upperItem = m.peek();
				}
				if(upperItem > chosen) {
					m.push(chosen);
				}
				else {
					System.out.println("Can't put a bigger piece on a smaller one");
					if(from == 'l') {
						l.push(chosen);
					}
					else if(from == 'm') {
						m.push(chosen);
					}
					else {
						r.push(chosen);
					}
				}
			}
			else {
				if(r.empty()) {
					upperItem = 100;
				}
				else {
					upperItem = r.peek();
				}
				if(upperItem > chosen) {
					r.push(chosen);
				}
				else {
					System.out.println("Can't put a bigger piece on a smaller one");
					if(from == 'l') {
						l.push(chosen);
					}
					else if(from == 'm') {
						m.push(chosen);
					}
					else {
						r.push(chosen);
					}
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
		Iterator<Integer> iteratorl = l.iterator() ;
		return iteratorl;

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		Iterator<Integer> iteratorm = m.iterator() ;
		return iteratorm;

	}
	private Iterator<Integer> getRightDescendingIterator() {
		Iterator<Integer> iteratorr = r.iterator() ;
		return iteratorr;
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
