package Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static  void main(String[] args) {
		BST<Integer> bst= new BST<>();
		//25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90
		bst.add(25);
		bst.add(15);
		bst.add(50);
		Collection<Integer> collection = List.of(10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90);
		bst.add(collection);
		System.out.println(bst);
		System.out.println(bst.depth(10));
		System.out.println(bst.height());
		System.out.println(bst.size());
		System.out.println(bst.contains(25));
		System.out.println(bst.findMin());
		System.out.println(bst.findMax());
		bst.remove(90);
		System.out.println(bst.contains(90));
		bst.add(90);
		System.out.println(bst.descendants(35));
		System.out.println(bst.ancestors(35));
		System.out.println("Inorder: ");
		bst.inorder();
		System.out.println("Prerder: ");
		bst.preorder();
		System.out.println("Postorder: ");
		bst.postorder();
	}
}
