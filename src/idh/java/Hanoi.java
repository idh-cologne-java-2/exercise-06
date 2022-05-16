package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	
	
	Stack<Integer> leftTower = new Stack<Integer>();
	Stack<Integer> middleTower = new Stack<Integer>();
	Stack<Integer> rightTower = new Stack<Integer>();
	
	public Stack<Integer> getStack(char id){
		switch(id) {
		case 'l': return leftTower;
		case 'm': return middleTower;
		case 'r': return rightTower;
		default: return null;
		}
	}

	
	public Hanoi() {
		
		for(int i = 1; i < 10; i++) {
			leftTower.push(i);
		}
	}
	
		
	private void movePiece(char from, char to) throws EmptyStackException, Exception {
		
		if(this.getStack(from).empty()) throw new EmptyStackException();
		if (this.getStack(to).empty()) {
			this.getStack(to).push(this.getStack(from).pop());
			System.out.println("Moved piece from " + from + " to " + to + ".");
			return;
		}
		if (this.getStack(from).peek() > this.getStack(to).peek()) {
			throw new Exception();
		}
		this.getStack(to).push(this.getStack(from).pop());
		System.out.println("Moved piece from " + from + " to " + to + ".");
		return;
		
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
		
		return new Iterator<Integer>() {
			Stack<Integer> lT = leftTower;
			int i = 0;

			@Override
			public boolean hasNext() {
				return lT.size() > i;
			}

			@Override
			public Integer next() {
				int n = lT.get(i);;
				i++;
				return n;
			}
			
		};

	}

	
	private Iterator<Integer> getMiddleDescendingIterator() {
		
		return new Iterator<Integer>() {
			Stack<Integer> mT = middleTower;
			int i = 0;

			@Override
			public boolean hasNext() {
				return mT.size() > i;
			}

			@Override
			public Integer next() {
				int n = mT.get(i);;
				i++;
				return n;
			}
			
		};

	}
	
	private Iterator<Integer> getRightDescendingIterator() {
		
		return new Iterator<Integer>() {
			Stack<Integer> rT = rightTower;
			int i = 0;

			@Override
			public boolean hasNext() {
				return rT.size() > i;
			}

			@Override
			public Integer next() {
				int n = rT.get(i);;
				i++;
				return n;
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