package Tree;

import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
		private E data;
		private  BNode<E> left;
		private BNode<E> right;
		public BNode(E data) {
			this.setData(data);
			this.left = null;
			this.right = null;
		}
		public BNode(E data, BNode<E> left, BNode<E> right) {
			this.setData(data);
			this.left = left;
			this.right = right;
			}
		public BNode<E> getLeft() {
			return left;
		}
		public void setLeft(BNode<E> left) {
			this.left = left;
		}
		public BNode<E> getRight() {
			return right;
		}
		public void setRight(BNode<E> right) {
			this.right = right;
		}
		public E getData() {
			return data;
		}
		public void setData(E data) {
			this.data = data;
		}
	@Override
		public String toString() {
			return "BNode [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
		
		public boolean contains(E e) {
			int comp= e.compareTo(data);
			if (comp==0) 
				return true;
			
			else if (comp<0) 
				return ((left== null) ? false: left.contains(e)) ;
			else
				return ((right== null) ? false: right.contains(e)) ;
			}
		public List<E> ancestors(E e) {
			int comp= e.compareTo(data);
			List<E>re= new ArrayList<>();
			if (comp==0) {
				return re;
				
			}
			if (left!= null) {
				if (left.contains(e)) {
					re.addAll(left.ancestors(e));
					re.add(data);
				}
			}
			if (right!= null) {
				if (right.contains(e)) {
					re.addAll(right.ancestors(e));
					re.add(data);
				}
			}
			return re;
		}
		public BNode createNode(E k) {
			BNode<E> n= new BNode<E>(k);
			n.left= null;
			n.right= null;
			return n;
		}
		public BNode add(BNode node, E k) {
			if (node==null) 
				return createNode(k);
				if (k.compareTo((E) node.data)<0 ) 
	           node.left=add(node.left, k);
	         if (k.compareTo((E) node.data)>0) 
	        	node.right=add(node.right, k);
	        
			
				return node;
			
		}
		
}
