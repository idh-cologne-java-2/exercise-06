package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	// Implemented
	public Stack<Integer> l = new Stack<Integer>();
 	public Stack<Integer> m = new Stack<Integer>();
 	public Stack<Integer> r = new Stack<Integer>();

	public Hanoi() {
	
		for (int i = 9; i > 0; i--) {
			l.push(i);
		}
	}
	
	public Stack<Integer> getStack(char label) {

 		switch(label) {

 			case 'l':
 				return l;

 			case 'm':
 				return m;

 			case 'r':
 				return r;

 			default:
 				return null;
 		}
	}
	
	
	private void movePiece(char from, char to) {
		// Implemented
		Stack<Integer> fromStack = getStack(from);
 		Stack<Integer> toStack = getStack(to);

 		if(fromStack.empty()) {
 			System.out.println("There are no disks on this tower.");
 			return;
 		}
 		if(toStack.empty()){
 			toStack.push(fromStack.pop());
 			return;
 		}

 		if(toStack.peek() > fromStack.peek()) {

 			toStack.push(fromStack.pop());

 		}else {
 			System.out.println("You can not move this disk.");
 		}
	}
	
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println(this);
				System.out.print("Enter source and target tower (will move top disk):");
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
		// Implemented
		
		
		return new Iterator<Integer>(){
 			Stack<Integer> ls = l;
 			int i = 0;

 			@Override
 			public boolean hasNext() {
 				return ls.size() > i;
 			}

 			@Override
 			public Integer next() {
 				int helpInt = ls.get(i);
 				i++;
 				return helpInt;
 			}

 		};

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		// Implemented
		
		return new Iterator<Integer>(){
 			Stack<Integer> ms = m;
 			int i = 0;

 			@Override
 			public boolean hasNext() {
 				return ms.size() > i;
 			}

 			@Override
 			public Integer next() {
 				int helpInt = ms.get(i);
 				i++;
 				return helpInt;
 			}

 		};

	}
	private Iterator<Integer> getRightDescendingIterator() {
		// Implemented
		
		return new Iterator<Integer>(){
 			Stack<Integer> rs = r;
 			int i = 0;

 			@Override
 			public boolean hasNext() {
 				return rs.size() > i;
 			}

 			@Override
 			public Integer next() {
 				int helpInt = rs.get(i);
 				i++;
 				return helpInt;
 			}

 		};
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
