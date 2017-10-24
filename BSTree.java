import java.util.Comparator;

public class BSTree {
	
	//inner class 
	class BSTNode{
		
		private String data;
		private BSTNode left;
		private BSTNode right;
		
		//constructor for BSTNode
		public BSTNode(String value){
			data = value;
			left = null;
			right = null;
		}
	}
	//root of Binary Search tree 
	private BSTNode root;
	
	//public method that calls on the private method find
	public boolean find(String value){
		return find(value, root);
	}
	
	//private method find that performs recursively through the tree
	private boolean find(String value, BSTNode node){
		if (node == null){
			return false;
		}
		if (value.compareTo(node.data)==0){
			return true;
		}
		else if (value.compareTo(node.data) < 0){
			return find(value, node.left);
		}
		else{
			return find (value, node.right);
		}
	}
	
	//regular public print statement
	public void print(BSTNode node){
		if (node == null){
			return;
		}
		print(node.left);
		System.out.println(node.data);
		print(node.right);
	}
	
	//public insert method that calls on private insert method
	public void insert(String value){
		//reassigns root 
		root = insert(value, root);
	}
	
	//private insert that performs recursive, moving the left and right depending on the value of the node
	private BSTNode insert(String value, BSTNode node){
		if (node == null){
			return new BSTNode(value);
		}
		if (value.compareTo(node.data)<0){
			node.left = insert(value, node.left);
			return node;
		}else{
			node.right = insert(value, node.right);
			return node;
		}
	}
	
	//private helper method for delete. Returns the smallest element 
	private String removeSmallest(BSTNode node){
		if (node.left.left == null){
			String smallest = node.left.data;
			node.left = node.left.right;
			return smallest; 
		}
		return removeSmallest(node.left);
	}
	
	//public method that calls on private method 
	public void delete(String value){
		root = delete(value, root);
	}
	
	private BSTNode delete(String value, BSTNode node){
		//base case: checks if node is null. 
		if (node == null){
			return null;
		}
		if (node.data.compareTo(value)==0){
			if (node.left == null){
				return node.right;
			}
			else if (node.right == null){
				return node.left;
			}
		}
		if (node.right.left == null){
			node.data= node.right.data;
			node.right = node.right.right;
			return node;
		}else{
			node.data = removeSmallest(node.right);
			return node;
		}
	}

	//In-order is left, root/this.node, right
	private String toStringInOrder(BSTNode node, String s){
		if (node != null){
			//do stuff
			s = toStringInOrder(node.left, s);
			s+= node.data + " "; //not root because not always root
			s = toStringInOrder(node.right, s);
			return s;
		}
		return s;
	}
	//Pre-Order: Root, left, right
	private String toStringPreOrder(BSTNode node, String n){
		if (node != null){
			n += node.data + " ";
			n = toStringPreOrder(node.left, n);
			n = toStringPreOrder(node.right, n);
			return n;
		}
		return n;
	}
	
	public String toStringInOrder(){
		String s = "";
		return toStringInOrder(root, s).trim();
	}
	
	
	public String toStringPreOrder(){
		String n = "";
		return toStringPreOrder(root, n).trim();
	}
}
