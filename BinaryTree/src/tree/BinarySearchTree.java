package tree;

public class BinarySearchTree<T extends Comparable<? super T>> {
	private Node root;

	public BinarySearchTree(T[] a) {
		root = new Node(a[0]);

		for (int i = 1; i < a.length; i++)
			insert(a[i]);
	}

	public BinarySearchTree(T a) {
		root = new Node(a);
	}

	public void insert(T a) {
		if (root == null) {
			root = new Node(a);
			return;
		}
		else root = insert(a, root);
	}
	
	public void printTree() {

		BTreePrinter.printNode(root);
	}
	
	public boolean delete(T key){
		root = delete(key, root);
		return true;
	}
	
	private Node insert(T a, Node node){
		if(node == null) return new Node(a);
		
		int cmp = a.compareTo(node.val);
		
		if(cmp <= 0) node.left = insert(a, node.left);
		else node.right = insert(a, node.right);
		
		return node;
	}
	
	/* deletion using T.Hibbard's eager deletion */
	private Node delete(T key, Node node){
		if(node == null) return null;
		
		int cmp = key.compareTo(node.val);
		
		if(cmp < 0) node.left = delete(key, node.left);
		else if (cmp > 0) node.right = delete(key, node.right);
		else{
			if(node.right == null)	return node.left;
			if(node.left == null) return node.right;
			
			Node tmp = node;  
			node = min(tmp.right);
			node.right = deleteMin(tmp.right);
			node.left = tmp.left;
			}
		
		return node;
	}
	
	private Node min(Node node){
		if(node.left == null){ 
			
			return node;
		
		}
		else return min(node.left);
	}
	
	private Node deleteMin(Node node){
		if(node.left == null) return node.right;
		node.left = deleteMin(node.left);
		return node;
	}


	public class Node {
		T val;
		Node left, right;

		public Node(T x) {
			val = x;
			left = null;
			right = null;
		}
	}
}