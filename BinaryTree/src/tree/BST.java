package tree;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;

	public BST(Key[] keys, Value[] vals) {
		root = new Node(keys[0], vals[0]);

		for (int i = 1; i < keys.length; i++)
			insert(keys[i], vals[i]);
	}

	public BST(Key key, Value val) {
		root = new Node(key, val);
	}

	public void insert(Key key, Value val) {
		if (root == null) {
			root = new Node(key, val);
			return;
		}
		else root = insert(key, val,  root);
	}
	
	public void printTree() {
		BTreePrinter.printNode(root);
	}
	
	public boolean delete(Key key){
		root = delete(key, root);
		return true;
	}
	
	private Node insert(Key key, Value val, Node node){
		if(node == null) return new Node(key, val);
		
		int cmp = key.compareTo(node.key);
		
		if(cmp <= 0) node.left = insert(key, val,  node.left);
		else node.right = insert(key, val, node.right);
		
		return node;
	}
	
	/* deletion using T.Hibbard's eager deletion */
	private Node delete(Key key, Node node){
		if(node == null) return null;
		
		int cmp = key.compareTo(node.key);
		
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
		if(node.left == null) return node;
		else return min(node.left);
	}
	
	private Node deleteMin(Node node){
		if(node.left == null) return node.right;
		node.left = deleteMin(node.left);
		return node;
	}


	public class Node {
		Key key;
		Value value;
		Node left, right;
		
		public Node(Key k, Value v) {
			key = k;
			value = v;
			left = null;
			right = null;
		}
	}
}