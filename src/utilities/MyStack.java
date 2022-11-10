package utilities;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class MyStack<E> implements StackADT<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 733021355610782032L;
	private int capacity;
	private E[] data = null;
	private int size;

	@SuppressWarnings("unchecked")
	@Override
	public void Stack(int capacity) {
		this.capacity = capacity;
		data = (E[]) new Object[capacity];
		int size = 0;

	}

	@Override
	public void push(E element) throws NullPointerException {
		if (size == capacity) {
			System.out.println("Stack is full");
		} else
			size++;
		data[size - 1] = element;
		System.out.println(element + " was added to the top of the stack");

	}

	@Override
	public E pop() throws NullPointerException {

		if (size == 0) {
			System.out.println("The stack is empty");
		} else

			size--;
		E element = data[size];
		System.out.println(element + " The topmost element was removed from  the stack");

		return element;
	}

	@Override
	public E peek() throws NullPointerException {
		return data[size - 1];
	}

	/*
	 * NOT SURE what it does
	 */
	@Override
	public boolean equals(StackADT<E> that) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == that) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyStackIterator();
	}

	private class MyStackIterator implements Iterator {
		private int pos;
		private int size;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return pos < size;
		}

		@Override
		public E next() throws NoSuchElementException {
			if (pos >= size) {
				throw new NoSuchElementException();
			}
			E toReturn = data[pos++];
			return toReturn;
		}

	}

	@Override
	public Object[] toArray() {
		// flips inputted elements around.
		// uses the stack in the system currently

		Class<?> clazz = data.getClass().getComponentType();

		E[] newArray = (E[]) Array.newInstance(clazz, size);

		int stackIndex = size;

		if (size > 0) {
			for (int i = 0; i < size; i++) {
				newArray[stackIndex - 1] = data[i];
				stackIndex--;
			}

		}
		return newArray;
	}

	@Override
	public E[] toArray(E[] copy) throws NullPointerException {
		if (copy == null) {
			throw new NullPointerException();
		}

		if (copy.length < size) {
			Class<?> clazz = copy.getClass().getComponentType();
			copy = (E[]) Array.newInstance(clazz, size);

			// if the array is too small, allocate the new array the same component type
			// copy = (E[]) Array.newInstance(getClass().getComponentType(), size);
		} else if (copy.length > size) {
			copy[size] = null;
		}

		int stackIndex = size;
		for (int i = 0; i < size; i++) {
			copy[stackIndex - 1] = data[i];
			stackIndex--;
		}

		return copy;
	}

	@Override
	public int search(E object) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == object) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(E obj) throws NullPointerException {

		for (int i = 0; i < data.length; i++) {
			if (data[i] == obj) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		size = 0;
		data = null;

	}

	public int getCapacity() {
		return capacity;
	}

	public int getSize() {
		return size;
	}

}
