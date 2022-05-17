package idh.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Document implements Iterable<String> {
	String documentText;

	public static Document readFromFile(File f) throws IOException {
		FileReader fileReader = new FileReader(f);
		int ch;
		StringBuilder b = new StringBuilder();
		while( (ch = fileReader.read()) != -1 ) {
			b.append((char) ch);
		}
		fileReader.close();
		Document doc = new Document();
		doc.documentText = b.toString();
		
		return doc;
	}
	
	public String getDocumentText() {
		return documentText;
	}

	public void setDocumentText(String documentText) {
		this.documentText = documentText;
	}
	
	public static final void main(String[] args) throws IOException {
		Document d = Document.readFromFile(new File("data/dracula.txt"));
		int i = 0;
		for (String token : d) {
			System.out.println(i++ + ": " + token + " ");
			if (i > 100)
				break;
		}
	}

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			StringTokenizer tokenizer = new StringTokenizer(documentText);
			
			@Override
			public boolean hasNext() {
				return tokenizer.hasMoreTokens();
			}

			@Override
			public String next() {
				return tokenizer.nextToken();
			}
			
		};
	}




	public class MyLinkedList<T> implements LinkedList<T> {

		/**
		 * We only need to store the very first element of our list,
		 * because it will now whether there is a next element.
		 */
		ListElement first;


		@Override
		public int size() {
			// TODO Implement!
			return 0;
		}

		@Override
		public boolean isEmpty() {
			return first == null;
		}

		@Override
		public boolean contains(Object o) {
			// TODO Implement!
			return false;
		}

		@Override
		public Iterator<T> iterator() {
			return new Iterator<T>() {
				ListElement next = first;

				@Override
				public boolean hasNext() {
					return next != null;
				}

				@Override
				public T next() {
					T ret = next.value;
					next = next.next;
					return ret;
				}

			};
		}

		@Override
		public Object[] toArray() {
			// TODO Implement!
			return null;
		}

		@Override
		public <E> E[] toArray(E[] a) {
			if (a.length < size()) {
				a = (E[]) new Object[size()];
			}
			int i = 0;
			for (T t : this) {
				a[i++] = (E) t;
			}
			return a;
		}

		@Override
		public boolean add(T e) {
			ListElement newListElement = new ListElement(e);
			if (first == null)
				first = newListElement;
			else
				last().next = newListElement;
			return true;
		}

		@Override
		public boolean remove(Object o) {
			// TODO: Implement
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			for (Object o : c)
				if (! contains(o))
					return false;
			return true;
		}

		@Override
		public boolean addAll(Collection<? extends T> c) {
			for (T t : c)
				this.add(t);
			return true;
		}

		@Override
		public boolean addAll(int index, Collection<? extends T> c) {
			// TODO Implement!
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			boolean r = true;
			for (Object o : c)
				r = r || this.remove(o);
			return r;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void clear() {
			first = null;
		}

		@Override
		public T get(int index) {
			return getElement(index).value;
		}

		@Override
		public T set(int index, T element) {
			// TODO: Implement
			return null;
		}

		@Override
		public void add(int index, T element) {
			// TODO: Implement
		}

		@Override
		public T remove(int index) {
			// TODO: Implement
			return null;
		}

		@Override
		public int indexOf(Object o) {
			// TODO: Implement
			return 0;
		}

		@Override
		public int lastIndexOf(Object o) {
			// TODO: Implement
			return 0;
		}

		@Override
		public ListIterator<T> listIterator() {
			return new ListIterator<T>() {

				ListElement previous = null;
				ListElement next = first;
				int index;

				@Override
				public boolean hasNext() {
					return next != null;
				}

				@Override
				public T next() {
					previous = next;
					T ret = next.value;
					next = next.next;
					index++;
					return ret;
				}

				@Override
				public boolean hasPrevious() {
					return false;
				}

				@Override
				public T previous() {
					throw new UnsupportedOperationException();
				}

				@Override
				public int nextIndex() {
					return index+1;
				}

				@Override
				public int previousIndex() {
					return index-1;
				}

				@Override
				public void remove() {
					previous.next = next.next;
				}

				@Override
				public void set(T e) {
					next.value = e;
				}

				@Override
				public void add(T e) {
					throw new UnsupportedOperationException();
				}

			};
		}

		@Override
		public ListIterator<T> listIterator(int index) {
			throw new UnsupportedOperationException();
		}

		@Override
		public List<T> subList(int fromIndex, int toIndex) {
			throw new UnsupportedOperationException();
		}

		private class ListElement {
			T value;
			ListElement next;

			ListElement(T value) {
				this.value = value;
			}
		}

		/**
		 * Internal method that iterates over the list, returning the last element (i.e., the one whose next field is null)
		 * @return
		 */
		private ListElement last() {
			if (first == null)
				return null;
			ListElement current = first;

			while(current.next != null) {
				current = current.next;
			}
			return current;
		}

		/**
		 * Internal method to get the list element (not the value) of the list at the specified index position.
		 * @param index
		 * @return
		 */
		private ListElement getElement(int index) {
			if (isEmpty())
				return null;
			ListElement current = first;
			while(current != null) {
				if (index == 0)
					return current;
				index--;
				current = current.next;
			}
			return null;
		}

		public static void main(String[] args) {
			MyLinkedList<String> ll = new MyLinkedList<String>();
			ll.add("Hallo");
			ll.add("Welt");
			ll.get(0);
			for (String s : ll) {
				System.out.println(s);
			}
		}
	}


}
