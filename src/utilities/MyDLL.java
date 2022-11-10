package utilities;

import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E> {
	private int size;
	private Node head;
	private Node one = null;

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = null;
		size = 0;

	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {

		Node node = new Node();
		Node prevNode = new Node();
		for (int i=0; i<size;i++) {
			
			if (i==index) {
				node.setPrev(prevNode.getPrev());
			}
		}
		return false;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		Node temp1 = head;
		Node temp2 = null;
		if (index == 0) {
			head = head.getNext();
		} else if (index > size) {
			throw new IndexOutOfBoundsException(
					"The position [ " + index + " ] is greater than the current size " + size + ".");
		} else {

			for (int i = 0; i < index - 1; i++) {
				temp1 = temp1.getNext();
			}
			temp2 = temp1.getNext();
			temp1.setNext(temp2.getNext());
			size--;
		}
		return (E) temp2;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		Node node = head;
		while (node != null) {
			node = node.getNext();

			if (node.equals(toRemove)) {
				Node node2 = node;
				node.setNext(node2.getNext());
				size--;
			} else {
				return null;
			}
		}
		return (E) node;// check this
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		Node node = head;
		while (node != null) {
			node = node.getNext();

			if (node.getData().equals(toFind)) {
				return true;
			} else {
				node = node.getNext();
			}
		}
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new myNewIterator();
	}

	public class myNewIterator implements Iterator {
		private int pos;
		private int size;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return pos < size;
		}

		@Override
		public Object next() throws NoSuchElementException {
			if (pos >= size) {
				throw new NoSuchElementException();
			}
//			E toReturn = array[pos++]; not sure if we need to have an array here???
			return null;
		}

	}

}
