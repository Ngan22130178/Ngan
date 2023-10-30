package Task2;

public class SinglyLinkedList<E> {
	
	public static void main(String[] args) {
		SinglyLinkedList list= new SinglyLinkedList<>();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addFirst(0);
		list.addLast(5);
		list.display();
		list.removeFirst();
		list.removeLast();
		list.display();
	}
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;
	public SinglyLinkedList() {
		super();
	}
	
	public void addNode(int data) {
		 
        Node newNode = new Node(data);
        //kiểm tra danh sách trống
        if (head == null) {
 
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);;
            tail = newNode;
        }
        
    }
	
	public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("Danh sách này trống.");
            return;
        }
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
	
	// Returns the number of elements in the list.
	public int size() {
		return size;
	}
	
	// Returns true if the list is empty, and false otherwise.
	public boolean isEmpty() {
		return size==0;
	}
	
	// Returns (but does not remove) the first element in the list.
	public E first() {
		return head.getData();
	}
	
	// Returns (but does not remove) the last element in the list.
	public E last() {
		return tail.getData();
	}
	
	//Adds a new element to the front of the list.
	public void addFirst(E e) {
		Node newNode = new Node(e);
        //kiểm tra danh sách trống
        if (head == null) {
 
            head = newNode;
            tail = newNode;
        } else {
            Node temp = head; 
            head = newNode;
            head.setNext(temp);
        }
	}
	
	//Adds a new element to the end of the list.
	public void addLast(E e) {
		Node newNode = new Node(e);
     
        if (head == null) {
 
            head = newNode;
            tail = newNode;
        } else {
        	tail.setNext(newNode);; 
            tail= newNode;
        }
	}
	

	public void removeFirst() {
		if (head == null) {
            System.out.println("Danh sách này trống!");
            return;
        } else {
            if (head != tail) {
                head= head.getNext();
            } else {
                head = tail = null;
            }
        }
	}
	
	public void removeLast() {
		if (head == null) {
            System.out.println("Danh sách này trống!");
            return;
        } else {
            if(head != tail ) {  
                Node current = head;  
                
                while(current.getNext() != tail) {  
                    current = current.getNext();  
                }  
                
                tail = current;  
                tail.setNext(null);;  
            }  
 
          
            else {  
                head = tail = null;  
            }  
        }  
	}	
	
}
