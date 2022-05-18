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

	int i;
	
	public Hanoi() {
		for(i = 9;i > 0; i--) 
			l.push(i);
	}
	
	private void movePiece(char from, char to) {
		if (from == 'l' && to == 'm') {
			m.push(l.pop());
		} else if (from == 'l' && to == 'r'){
			r.push(l.pop());
		} else if (from == 'm' && to == 'r'){
			r.push(m.pop());
		} else if (from == 'm' && to == 'l'){
			l.push(m.pop());
		} else if (from == 'r' && to == 'l'){
			m.push(r.pop());
		} else if (from == 'r' && to == 'm'){
			l.push(r.pop());
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
		@Override
		public boolean hasNext() {
			//ToDo
		}

		@Override
		public String next() {
			//ToDo
		}
		return null;
	}
	

	private Iterator<Integer> getMiddleDescendingIterator() {
		@Override
		public boolean hasNext() {
			//ToDo
		}

		@Override
		public String next() {
			//ToDO
		}
		return null;

	}
	private Iterator<Integer> getRightDescendingIterator() {
		@Override
		public boolean hasNext() {
			//ToDo
		}

		@Override
		public String next() {
			//ToDo
		}
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
