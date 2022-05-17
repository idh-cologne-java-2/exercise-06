package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	//Arraylist<Integer> a = new ArrayList<Integer>(9);
	Stack<Integer> stackL = new Stack<>();
	Stack<Integer> stackM = new Stack<>();
	Stack<Integer> stackR = new Stack<>();

	public Hanoi() {
		stackL.push(9);
		stackL.push(8);
		stackL.push(7);
		stackL.push(6);
		stackL.push(5);
		stackL.push(4);
		stackL.push(3);
		stackL.push(2);
		stackL.push(1);
		
	}
	
	private void movePiece(char from, char to) {
		Stack<Integer> source = null;
		Stack<Integer> target = null;
		
		switch(from) {
		case 'l': source = stackL;
		case 'm': source = stackM;
		case 'r': source = stackR;
		}
		
		switch(to) {
		case 'l': target = stackL;
		case 'm': target = stackM;
		case 'r': target = stackR;
		}
		
		if(source.empty()) {
			System.out.println("empty");
			return;
		}
		
		if(target.isEmpty() || source.peek()< target.peek()) {
			target.push(source.pop());
			return;
		}
		
		if(source.peek() > target.peek()) {
			System.out.println("it doesn't work");
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
	
		
		return stackL.iterator();
		

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
	
       return stackM.iterator();
	}
	private Iterator<Integer> getRightDescendingIterator() {
	
	
	return stackR.iterator();
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
