package idh.java;

import java.util.Iterator;
import java.util.Stack;

public class DescendingIterator implements Iterator<Integer> {
	
	private Stack<Integer> stack;
	private int currentIndex;

	public DescendingIterator(Hanoi hanoi, char stackID) {
		this.stack = hanoi.getStackByIdentifier(stackID);
		this.currentIndex = 0;
	}

	@Override
	public boolean hasNext() {
		if (this.currentIndex >= this.stack.size()) {
			return false;
		}
		return !this.stack.get(currentIndex).equals(null);
	}

	@Override
	public Integer next() {
		return this.stack.get(currentIndex++);
	}

}
