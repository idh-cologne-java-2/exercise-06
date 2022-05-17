package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	
	Stack<Integer> links = new Stack<Integer>();
	Stack<Integer> mitte = new Stack<Integer>();
	Stack<Integer> rechts = new Stack<Integer>();

	public Hanoi() {
		links.push(9);
		links.push(8);
		links.push(7);
		links.push(6);
		links.push(5);
		links.push(4);
		links.push(3);
		links.push(2);
		links.push(1);
	}
	
	private void movePiece(char from, char to) {
		
		int fromwert = 0;
		int towert = 0;
		
		try {
			if(from == 'l') {fromwert = links.peek();}
			if(from == 'm') {fromwert = mitte.peek();}
			if(from == 'r') {fromwert = rechts.peek();}
		}catch(EmptyStackException e) {
			System.out.println("The tower is empty. Try another one");
			return;
		}
		
		try {
			if(to == 'l') {towert = links.peek();}
			if(to == 'm') {towert = mitte.peek();}
			if(to == 'r') {towert = rechts.peek();}
		}catch(EmptyStackException e) {
			if(to == 'l') {links.add(fromwert);}
			if(to == 'm') {mitte.add(fromwert);}
			if(to == 'r') {rechts.add(fromwert);}
			if(from == 'l') {links.pop();}
			if(from == 'm') {mitte.pop();}
			if(from == 'r') {rechts.pop();}
			return;
		}
		
		if(fromwert < towert) {
			if(from == 'l') {links.pop();}
			if(from == 'm') {mitte.pop();}
			if(from == 'r') {rechts.pop();}
			if(to == 'l') {links.add(fromwert);}
			if(to == 'm') {mitte.add(fromwert);}
			if(to == 'r') {rechts.add(fromwert);}
		} else {
			System.out.println("Sorry, this does not work. You cannot put a greater number on a smaller one.");
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
				System.out.println("Try again, something is not right.");
				e.printStackTrace();
			} 
		}
	}
	
	private Iterator<Integer> getLeftDescendingIterator() {
		return links.iterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return mitte.iterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		return rechts.iterator();
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
