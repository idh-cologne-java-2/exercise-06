package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	
	
	Stack<Integer> towerL = new Stack<Integer>();
	Stack<Integer> towerM = new Stack<Integer>();
	Stack<Integer> towerR = new Stack<Integer>();

	
	public Hanoi() {
		ArrayList<Integer> p = new ArrayList<Integer>(9);
		p.add(9);
		p.add(8);
		p.add(7);
		p.add(6);
		p.add(5);
		p.add(4);
		p.add(3);
		p.add(2);
		p.add(1);
	}
	
		
	private void movePiece(int n, char from, char to) {
		if (n == 1) {
			System.out.println("Move piece 1 from" + from + "to" + to);
			}
		movePiece(n-1, from, to);
		System.out.println("Move piece" + n + "from" + from + "to" + to);
		
	
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
	
	
	private void movePiece(char source, char target) {
		// TODO Auto-generated method stub
		
	}


	private Iterator<Integer> getLeftDescendingIterator() {
		return new Iterator<Integer>() {
			Stack<Integer> tL = towerL;
			int n = 0;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return tL.size() > n;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				int i = tL.get(n);;
				n++;
				return i;
			}
			
		};

	}

	
	private Iterator<Integer> getMiddleDescendingIterator() {
		return new Iterator<Integer>() {
			Stack<Integer> tM = towerM;
			int n = 0;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return tM.size() > n;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				int i = tM.get(n);
				n++;
				return i;
			}
			
		};

	}
	
	private Iterator<Integer> getRightDescendingIterator() {
		return new Iterator<Integer>() {
			Stack<Integer> tR = towerR;
			int n = 0;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return tR.size() > n;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				int i = tR.get(n);;
				n++;
				return i;
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

