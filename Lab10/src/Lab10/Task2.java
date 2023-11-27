package Lab10;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Task2 {
	
		public static void main(String[] args) {
			Queue<Integer> myQueue = new LinkedList<>();
	        myQueue.offer(1);
	        myQueue.offer(2);
	        myQueue.offer(3);

	        System.out.println("Original Queue: " + myQueue);
	        stutter(myQueue);
	        System.out.println("Stuttered Queue: " + myQueue);
	        
	        Queue<String> queue = new LinkedList<>();
	        queue.offer("a");
	        queue.offer("b");
	        queue.offer("c");

	        System.out.println("Original Queue: " + queue);
	        ;
	        System.out.println("Mirrored Queue: " );
	        mirror(queue);
		}
		
		// method stutter that accepts a queue of integers as a parameter and replaces
		// every element of the queue with two copies of that element
		// front [1, 2, 3] back
		// becomes
		// front [1, 1, 2, 2, 3, 3] back
		public static <E> void stutter(Queue<E> input) {
			int size = input.size();
	        for (int i = 0; i < size; i++) {
	            E element = input.poll();
	           input.offer(element);
	           input.offer(element);
	        }
		}
		
		// Method mirror that accepts a queue of strings as a parameter and appends the
		// queue's contents to itself in reverse order
		// front [a, b, c] back
		// becomes
		// front [a, b, c, c, b, a] back
		public static <E> void mirror(Queue<E> input) {
			Stack<String> stack = new Stack<>();
			
	        // Push all elements onto a stack
	        while (!input.isEmpty()) {
	            E element = input.poll();
	            stack.push((String) element);
	            
	        }
	       
	        // Pop elements from the stack and enqueue them to mirror the original order
	        while (!stack.isEmpty()) {
	            String element = stack.pop();
	            input.offer((E) element);
	        }
	        
		}
}
