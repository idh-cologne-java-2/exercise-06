package idh.java;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

public class DescendingIterator implements Iterator<Integer> {
	
	Stack<Integer> neuerStack;
	int n =0;
	
	

	public DescendingIterator(Stack<Integer> neuerStack) {
		super();
		this.neuerStack = neuerStack;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return neuerStack.size() > n;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		int i = neuerStack.get(n);;
		n++;
		return i;
	}
	

}
