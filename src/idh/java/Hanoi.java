package idh.java;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Hanoi {
	Deque<Integer> l = new LinkedList<Integer>();
	Deque<Integer> m = new LinkedList<Integer>();
	Deque<Integer> r = new LinkedList<Integer>();

	public Hanoi() {
		
for (int i = 10; i > 0; i--){
	l.add(i);
	
}
	}
	private void movePiece(char from, char to) {
		
		Integer pieceNumber = null;
		
		switch(from) {
		
		case 'l' : pieceNumber = l.pop(); break;
		case 'm' : pieceNumber = m.pop(); break; 
		case 'r' : pieceNumber= r.pop(); break; 
		}
		
		switch(to) {
		case 'l' : l.add(pieceNumber); break;
		case 'm' : m.add(pieceNumber); break;
		case 'r' : r.add(pieceNumber); break;
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
		// TODO: Implement
		return m.iterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
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
