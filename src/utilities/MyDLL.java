package utilities;

import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E> {
	private int size;
	private Node head;
	private Node tail;

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = tail = null;
		size = 0;

	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		Node node = new Node(toAdd);
		// check if the is out of bounds
		Node tempNode = head;
		if (index < size) {

			if (isEmpty()) {
				head = tail = node;
				return true;
			} else {

				for (int i = 0; i < size; i++) {

					if (i == index) {
						node.setPrev(tempNode.getPrev());
						node.setNext(tempNode.getNext());
					} else {
						tempNode = tempNode.getNext();
					}
				}

			}
			size++;
		} else {
			throw new IndexOutOfBoundsException();
		}
		return false;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		Node node = new Node(toAdd);
		// if the list is empty
		if (isEmpty()) {
			head = tail = node;
			size++;
			return true;

		} else if (!isEmpty()) { // if the list is not empty
			tail.setNext(node);

			node.setPrev(tail);

			tail = node;
			tail.setNext(null);
			size++;
			return true;
		}

		return false;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		Node newNode = head;
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = 0; i < size; i++) {

			if (i == index) {
				return (E) newNode;
			} else {
				newNode.getNext();
			}
		}
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
		Node newNode = head;
		Node node = new Node(toChange);
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