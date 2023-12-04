package Tree;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



public class BST <E extends Comparable<E>> {
		private BNode<E> root;
		public BST() {
			this.root = null;
		}
		
		
		
		// Add element e into BST
		public void add(E e) {
			if (root== null) 
	            this.root= new BNode<E>(e);
	           
	   
			else
				root.add(root, e);
	      
		}
		
		

		
		// Add a collection of elements col into BST
		public void add(Collection<E> col) {
			for (E e : col) {
				add(e);
			}
		}
		
		// compute the depth of a node in BST
		public int depth(E node) {
			return depth(root, node, 0);
		}
		private int depth(BNode root, E target , int depth) {
	        if (root == null) {
	            return -1;  // Node not found
	        }

	        int compareResult = target.compareTo((E) root.getData());
	      
	        if (compareResult < 0) {
	            return depth(root.getLeft(), target, depth + 1);
	        } else if (compareResult > 0) {
	            return depth(root.getRight(), target, depth + 1);
	        } else {
	            return depth;  // Node found, return its depth
	        }
	    }
		
		// compute the height of BST
		public int height() {
			return height(root);
		}
		private int height(BNode node) {
	        if (node == null) {
	            return -1; // Height of an empty tree is -1
	        }

	        int leftHeight = height(node.getLeft());
	        int rightHeight = height(node.getRight());

	        return Math.max(leftHeight, rightHeight) + 1;
	    }
		// Compute total nodes in BST
		public int size() {
				
		return size(root);
		}
		 private int size(BNode node) {
		        if (node == null) {
		            return 0; // Size of an empty tree is 0
		        }

		        int leftSize = size(node.getLeft());
		        int rightSize = size(node.getRight());

		        return leftSize + rightSize + 1; // Add 1 for the current node
		    }
		
		// Check whether element e is in BST
		public boolean contains(E e) {
			if (root==null) {
				return false;
			}
			return root.contains(e);
		}
		// Find the minimum element in BST
		public E findMin() {
			if (root == null) {
	            throw new IllegalStateException("BST is empty");
	        }

	        return (E)findMin(root).getData();
		}
		private BNode findMin(BNode node) {
	        while (node.getLeft() != null) {
	            node = node.getLeft();
	        }
	        return node;
	    }
		
		// Find the maximum element in BST
		public E findMax() {
			if (root == null) {
	            throw new IllegalStateException("BST is empty");
	        }

	        return (E)findMax(root).getData();
		}
		private BNode findMax(BNode node) {
	        while (node.getRight() != null) {
	            node = node.getRight();
	        }
	        return node;
	    }
		
		// Remove element e from BST
		public boolean remove(E e) {
			if (root == null) {
	            return false; // Empty tree, element not found
	        }

	        return remove(root, null, e);
		}
		private boolean remove(BNode node, BNode parent, E target) {
	        if (node == null) {
	            return false; // Element not found
	        }

	        int compareResult = target.compareTo((E) node.getData());

	        if (compareResult < 0) {
	            return remove(node.getLeft(), node, target);
	        } else if (compareResult > 0) {
	            return remove(node.getRight(), node, target);
	        } else {
	            // Node to be removed found

	            if (node.getLeft() != null && node.getRight() != null) {
	                // Node has two children
	                BNode successor = findMin(node.getRight());
	                node.setData(successor.getData()); 
	                remove(node.getRight(), node, (E) successor.getData());
	            } else {
	                // Node has zero or one child
	                BNode child = (node.getLeft() != null) ? node.getLeft() : node.getRight();

	                if (parent == null) {
	                    root = child; // Updating root
	                } else if (parent.getLeft() == node) {
	                    parent.setLeft(child);;
	                } else {
	                    parent.setRight(child);;
	                }
	            }

	            return true;
	        }
	    }
		
		// get the descendants of a node
		public List<E> descendants(E data) {
			List<E> descendantsList = new ArrayList<>();
	        BNode targetNode = findNode(root, data);

	        if (targetNode != null) {
	            collectDescendants(targetNode, descendantsList);
	        }

	        return descendantsList;
		}
		 // Helper method to find a node in the BST
	    private BNode findNode(BNode node, E target) {
	        if (node == null) {
	            return null;
	        }

	        int compareResult = target.compareTo((E) node.getData());

	        if (compareResult < 0) {
	            return findNode(node.getLeft(), target);
	        } else if (compareResult > 0) {
	            return findNode(node.getRight(), target);
	        } else {
	            return node; // Node found
	        }
	    }

	    // Helper method to collect descendants of a node
	    private void collectDescendants(BNode node, List<E> descendantsList) {
	        if (node != null) {
	            collectDescendants(node.getLeft(), descendantsList);
	            descendantsList.add((E) node.getData());
	            collectDescendants(node.getRight(), descendantsList);
	        }
	    }
		
		// get the ancestors of a node
		public List<E> ancestors(E data) {
			if (root==null) {
				return null;
			}
			return	root.ancestors(data);
		}
		
		public void inorder() {
			inorder(root);
	        System.out.println();
		}
		private void inorder(BNode node) {
	        if (node != null) {
	            inorder(node.getLeft());
	            System.out.print(node.getData() + " ");
	            inorder(node.getRight());
	        }
	    }
		// display BST using preorder approach
		public void preorder() {
			preorder(root);
	        System.out.println(); 
			}
		private void preorder(BNode node) {
	        if (node != null) {
	            System.out.print(node.getData() + " ");
	            preorder(node.getLeft());
	            preorder(node.getRight());
	        }
	    }
			// display BST using postorder approach
			public void postorder() {
				 postorder(root);
			        System.out.println();
			}
			private void postorder(BNode node) {
		        if (node != null) {
		            postorder(node.getLeft());
		            postorder(node.getRight());
		            System.out.print(node.getData() + " ");
		        }
		    }

		@Override
		public String toString() {
			return "BST [root=" + root + "]";
		}
		 
}
		
		

