package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	
	Stack<Integer> turmL = new Stack<Integer>();
	Stack<Integer> turmM = new Stack<Integer>();
	Stack<Integer> turmR = new Stack<Integer>();

	public Hanoi(int[] numbers) {
		// TODO: Implement
		for(int i : numbers) {
			turmL.add(i);
		}
		//turmM.add(0);
		//turmR.add(0);
	}
	
	private void movePiece(char from, char to) {
		// TODO: Implement
		int take = 0;
		if(from == 'l') {take=turmL.lastElement(); turmL.pop();}
		if(from == 'm') {take=turmM.lastElement(); turmM.pop();}
		if(from == 'r') {take=turmR.lastElement(); turmR.pop();}
		if(to == 'l') {  turmL.addElement(take);}
		if(to == 'm') {  turmM.addElement(take);}
		if(to == 'r') {  turmR.addElement(take);}
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
		// TODO: Implement
		return new Iterator<Integer>() {
			Stack<Integer> nL = turmL;
			int n = 0;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return nL.size() > n;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				int i = nL.get(n);;
				n++;
				return i;
			}
			
		};

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement
		return new Iterator<Integer>() {
			Stack<Integer> nL = turmM;
			int n = 0;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return nL.size() > n;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				int i = nL.get(n);
				n++;
				return i;
			}
			
		};

	}
	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
		return new Iterator<Integer>() {
			Stack<Integer> nL = turmR;
			int n = 0;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return nL.size() > n;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				int i = nL.get(n);;
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
		
		int[] n = {1,5,2};
		Hanoi hanoi = new Hanoi(n);
		hanoi.run();
	}

}
