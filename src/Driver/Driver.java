package Driver;

import utilities.MyDLL;
import utilities.MyQueue;
import utilities.MyStack;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack myStack = new MyStack();

		MyQueue<String> q1 = new MyQueue<String>();

		MyDLL<String> d1 = new MyDLL<String>();

		MyDLL<String> d2 = new MyDLL<String>();

		d1.add("A");
		d1.add("B");
		d1.add("C");
		d1.add("X");

		d1.remove("A");
//
//		System.out.println(d1.get(1));
//
//		MyDLL<String> d = new MyDLL<String>();
		d2.add("Z");
		d2.add("L");
		d2.add("O");

		
		d1.addAll(d2);
//		System.out.println(d1.get(1));

		Object[] a2 = d1.toArray();

		for (int i = 0; i < a2.length; i++) {
			System.out.println("Element in array: " + a2[i]);
		}

//		System.out.println("Does the DLL contain this letter? " + d1.contains("A"));
//
//		System.out.println("Does first DLL = second DLL? " + d1.equals(d2));
//
//		d1.get(1);
//
//		d1.isEmpty();
//
//		d1.remove(0);
//		d1.remove(3);
//
//		d1.remove("B");

//		for (int i = 0; i < d1.size(); i++) {
//			System.out.println(d1.get(i));
//		}

		// String[] a1 = { "yerr", "berr", "jerr" };

	}

}
