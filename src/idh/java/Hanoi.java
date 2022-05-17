package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	Stack <Integer> stackl = new Stack<Integer>();
	Stack <Integer> stackm = new Stack<Integer>();
	Stack <Integer> stackr = new Stack<Integer>();
	ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
	
	public Hanoi() {
		for (int i = 9; i > 0; i--) {
			stackl.add(i);
		}
		stacks.add(stackl);
		stacks.add(stackm);
		stacks.add(stackr);
			
	}
	
	private void movePiece(char from, char to) {
		int i = 0;
		int j = 0;
		switch (from) {
		case 'l':
		   i = 0;
		  break;
		case 'm':
		   i = 1;
		  break;
		case 'r':
		  i = 2;
		  break;
		}
		switch (to) {
		case 'l':
		  j = 0;
		  break;
		case 'm':
		  j = 1;
		  break;
		case 'r':
		  j = 2;
	      break;
		}	
	if (stacks.get(j).isEmpty() || (stacks.get(j).peek() > stacks.get(i).peek())) {
		stacks.get(j).push(stacks.get(i).pop()); 
	}
	else {
	System.out.println("Against the rules!");	
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
				if (stackl.isEmpty() && stackm.isEmpty()) {
					System.out.println("You have won!");
					break;
				}
			} catch (Exception e) {
				System.out.println("Try again, something's not right.");
				e.printStackTrace();
			} 
		}
	}
	
	private Iterator<Integer> getLeftDescendingIterator() {
		return new Iterator<Integer>() {
			int i = 0;
			@Override
			public boolean hasNext() {
				return  i < stacks.get(0).size();
			}

			@Override
			public Integer next() {
			return stacks.get(0).get(i++);
			}
			
		};

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return new Iterator<Integer>() {
			int i = 0;
			@Override
			public boolean hasNext() {
				return  i < stacks.get(1).size();
			}

			@Override
			public Integer next() {
			return stacks.get(1).get(i++);
			}
			
		};

	}
	private Iterator<Integer> getRightDescendingIterator() {
		return new Iterator<Integer>() {
			int i = 0;
			@Override
			public boolean hasNext() {
				return  i < stacks.get(2).size();
			}

			@Override
			public Integer next() {
			return stacks.get(2).get(i++);
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
