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
	
	private Node insert(T a, Node node){
		if(node == null) return new Node(a);
		
		int cmp = a.compareTo(node.val);
		
		if(cmp <= 0) node.left = insert(a, node.left);
		else node.right = insert(a, node.right);
		
		return node;
	}

	public void printTree() {

		BTreePrinter.printNode(root);
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