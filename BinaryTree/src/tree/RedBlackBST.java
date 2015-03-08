package tree;


public class RedBlackBST<Key extends Comparable<Key>, Value> extends BST<Key, Value>{
	private static final boolean RED = true, BLACK = false;
	
	public RedBlackBST(){
		super();
	}
	public RedBlackBST(Key[] keys, Value[] vals) {
		root = new Node(keys[0], vals[0], BLACK);

		for (int i = 1; i < keys.length; i++){
			put(keys[i], vals[i]);
		}
	}

	public RedBlackBST(Key key, Value val) {
		root = new Node(key, val, BLACK);
	}

	public void put(Key key, Value val) {
		if (root == null) {
			root = new Node(key, val, BLACK);
			return;
		}
		else root = put(key, val,  root);
		root.color = BLACK;
	}
	
	public Value get(Key key){
		return get(key, root);
	}
	
	
	private Node put(Key key, Value val, Node node){
		if(node == null) return new Node(key, val, RED);
		
		int cmp = key.compareTo(node.key);
		
		if(cmp <  0) node.left = put(key, val,  node.left);
		else if(cmp > 0) node.right = put(key, val, node.right);
		else node.value = val;
		
		if(isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
		if(isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
		if(isRed(node.left) && isRed(node.right)) flipColors(node);
		
		return node;
	}
	
	public Value get(Key key, Node node){
		if(node == null) return null;
		int cmp = key.compareTo(node.key);
		
		if(cmp < 0) return get(key, node.left);
		if(cmp > 0) return get(key, node.right);
		return node.value;
	
	}
	
	

	private boolean isRed(Node node){
		if(node == null) return false;
		return node.color == RED;
		
	}
	
	private Node rotateLeft(Node node){
		Node p = node.right;
		node.right = p.left;
		p.left = node;
		p.color = node.color;
		node.color = RED;
		return p;
	}
	
	private Node rotateRight(Node node){
		Node p = node.left;
		node.left = p.right;
		p.right = node;
		p.color = node.color;
		node.color = RED;
		return p;
	}
	
	private void flipColors(Node node){
		node.color = RED;
		node.left.color = BLACK;
		node.right.color = BLACK;
	}
	

}
