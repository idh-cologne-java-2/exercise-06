/**
 * @author UntoadtedToast
 *
 */

package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {

	public Stack<Integer> lStack = new Stack<Integer>();
	public Stack<Integer> mStack = new Stack<Integer>();
	public Stack<Integer> rStack = new Stack<Integer>();

	public Hanoi() {
		// Implemented
		for (int i = 9; i > 0; i--) {
			lStack.push(i);
		}
	}

	public Stack<Integer> getStack (char label) {
		
		 if ('l' == label) {
			 return lStack;
		 }
		 if ('m' == label) {
			 return mStack;
		 }
		 if ('r' == label) {
			 return rStack;
		 }
		 else {
			 return null;
		 }
	}
	
	private void movePiece(char from, char to) {
		// Implemented
		
		Stack<Integer> fromStack = getStack(from);
		Stack<Integer> toStack = getStack(to);
		
		if(fromStack.empty()) {
			System.out.println("This stick has no pieces");
			return;
		}
		if(toStack.empty()){
			toStack.push(fromStack.pop());
			return;
		}
			
		if(toStack.peek() > fromStack.peek()) {
			
			toStack.push(fromStack.pop());
			
		}else {
			System.out.println("Ha! Nice try. This is not possible.");
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
		// Implemented
		return new Iterator<Integer>(){
			Stack<Integer> ls = lStack;
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
			Stack<Integer> ms = mStack;
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
			Stack<Integer> rs = rStack;
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
		while (iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n m|");
		iter = this.getMiddleDescendingIterator();
		while (iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n r|");
		iter = this.getRightDescendingIterator();
		while (iter.hasNext()) {
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
