package Task1;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;

import java.util.ArrayList;

public class MyArrayList <E>{
		public static void main(String[] args) {
			ArrayList<Integer> list = new ArrayList<Integer>( );
			list.add(42); list.add(57); list.add(86);
			int size= 3;
			
			list.get(2);
			//System.out.println(list.isEmpty());
			list.set(0, 69);
			list.get(0);
			list.add(72);
			list.add(1, 10);
			list.remove(1);
			//list.clear();
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i)+ " ");
			}
			//System.out.println(list.isEmpty());
			//System.out.println(list.lastIndexOf(1));
			Integer[] arr = new Integer[list.size()];
			arr = list.toArray(arr);
		    System.out.print("\n(To Array) Mảng: "+ Arrays.toString(arr));
			System.out.println("\n");
			ArrayList<Integer> arrayList2 = (ArrayList<Integer>)list.clone();
			System.out.println(arrayList2);
			System.out.println(list.contains(69));
			System.out.println(list.contains(79));
			list.sort(Comparator.naturalOrder());
			System.out.println("Array List xếp theo thứ tự tăng dần: ");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i)+ " ");
			}
			
			list.sort(Comparator.reverseOrder());
			System.out.println("\nArray List xếp theo thứ tự giảm dần: ");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i)+ " ");
			}
			list.add(69);
			list.add(86);
			System.out.println("\n");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i)+ " ");
			}
			
			System.out.println("\n"+list.lastIndexOf(86));
			System.out.println(list.indexOf(69));
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i)+ " ");
			}
		}
	
		public static final int DEFAULT_CAPACITY = 10;
		private E[] elements;
		private int size;
		public MyArrayList() {
			this.elements = (E[]) new Object[DEFAULT_CAPACITY];
		}
		
		public MyArrayList(int capacity) {
			this.elements = (E[]) new Object[capacity];
		}
		
		// creates an array of double-size if the array of elements is full
		public void growSize() {
			elements = (E[]) new Object[DEFAULT_CAPACITY];
		}
		
		// Returns the number of elements in this list.
		public int size() {
			return size;
		}
		
		// Returns whether the list is empty.
		public boolean isEmpty() {
			return size==0;
		}
		
		// Returns (but does not remove) the element at index i.
		public E get(int i) throws IndexOutOfBoundsException {
			if (i<0 || i >=size) 
				throw new ArrayIndexOutOfBoundsException("Khong co phan tu");
			else
				return elements[i];
		}
		
		// Replaces the element at index i with e, and returns the replaced element. ∗/
		public E set(int i, E e) throws IndexOutOfBoundsException {
			if (i<0 || i >=size) 
				throw new ArrayIndexOutOfBoundsException("Khong co phan tu");
			else
				elements[i]= e;
				return elements[i];
		}
		
		// It is used to append the specified element at the end of a list.
		public boolean add(E e) {
			return elements[size+1]== e;
		}
		
		// Inserts element e to be at index i, shifting all subsequent elements later.
		public void add(int i, E e) throws IndexOutOfBoundsException {
			if (i<0 || i >size) 
				throw new ArrayIndexOutOfBoundsException("Khong the them");
			else
				elements[i]= e;
				for (int j = i; j < elements.length; j++) {
					elements[j+1]= elements[i];
				}
		
		}
		
		// Removes and returns the element at index i, shifting subsequent elements earlier.
		public E remove(int i) throws IndexOutOfBoundsException {
			if (i<0 || i >=size) 
				throw new ArrayIndexOutOfBoundsException("Khong co phan tu de go");
			else
				return elements[i]= elements[i+1];
		}
		
		// It is used to clear all elements in the list.
		public void clear() {
			for (int i = 0; i < size; i++) {
				removeElement(elements[i]);
			}
		}
		
		// It is used to return the index in this list of the last occurrence of the specified element, or -1 if the list does not contain this element.
		public int lastIndexOf(Object o) {
			for (int i = size-1; i >= 0; i--) {
				if (o== elements[i]) 
					return i;					
			}
			return -1;
		}
		
		// It is used to return an array containing all of the elements in this list in the correct order.
		
		

		// It is used to return a shallow copy of an ArrayList.
		public MyArrayList<E> clone() {
			return clone();
		}
		
		// It returns true if the list contains the specified element
		public boolean contains(E o) {
			for (int i = 0; i < size; i++) {
				if (elements[i]== o) {
					return true;
				}
			}
			return false;
		}
		
		// It is used to return the index in this list of the first occurrence of the specified element, or -1 if the List does not contain this element.
		public int indexOf(E o) {
			for (int i = 0; i < size; i++) {
				if (elements[i]== o) {
					return i;
				}		
			}
		return -1;
		}
		
		// It is used to remove the first occurrence of the specified element.
		public void removeElement(E e) {
			for (int i = 0; i < size; i++) {
				if(elements[i]== e)
					remove(i);
			}
			System.out.println("Khong ton tai phan tu can xoa");
		}
		
		// It is used to sort the elements of the list on the basis of specified comparator.
		public void sort(Comparator<E> c) {
			
		}
}
