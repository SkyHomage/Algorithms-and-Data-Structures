package tree;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {
	protected Node root;
	
	public BST(){
		root = null;
	}
	public BST(Key[] keys, Value[] vals) {
		root = new Node(keys[0], vals[0]);

		for (int i = 1; i < keys.length; i++)
			put(keys[i], vals[i]);
	}

	public BST(Key key, Value val) {
		root = new Node(key, val);
	}

	public void put(Key key, Value val) {
		if (root == null) {
			root = new Node(key, val);
			return;
		}
		else root = put(key, val,  root);
	}
	
	public Value get(Key key){
		return get(key, root);
	}
	
	public void printTree() {
		try {
			BTreePrinter.printNode(root);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public boolean delete(Key key){
		root = delete(key, root);
		return true;
	}
	
	private Node put(Key key, Value val, Node node){
		if(node == null) return new Node(key, val);
		
		int cmp = key.compareTo(node.key);
		
		if(cmp <= 0) node.left = put(key, val,  node.left);
		else node.right = put(key, val, node.right);
		
		return node;
	}
	
	public Value get(Key key, Node node){
		if(node == null) return null;
		int cmp = key.compareTo(node.key);
		
		if(cmp < 0) return get(key, node.left);
		if(cmp > 0) return get(key, node.right);
		return node.value;
	
	}
	
	public void inorderTraverse(){
		inorderTraverse(root);
	}
	
	public void postorderTraverse(){
		postorderTraverse(root);
	}
	
	public void reverseInOrderTraverse(){
		reverseInOrderTraverse(root);
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
	
	protected Node min(Node node){
		if(node.left == null) return node;
		else return min(node.left);
	}
	
	protected Node max(Node node){
		if(node.right == null) return node;
		else return max(node.right);
	}
	
	private Node deleteMin(Node node){
		if(node.left == null) return node.right;
		node.left = deleteMin(node.left);
		return node;
	}
	
	protected void inorderTraverse(Node node){
		if(node == null) return;
		inorderTraverse(node.left);
		System.out.println(node.key);
		inorderTraverse(node.right);
	}
	
	protected void reverseInOrderTraverse(Node node){
		if(node == null) return;
		reverseInOrderTraverse(node.right);
		System.out.println(node.key);
		reverseInOrderTraverse(node.left);
	}
	
	protected void postorderTraverse(Node node){
		if(node == null) return;
		postorderTraverse(node.left);
		postorderTraverse(node.right);
		System.out.println(node.key);
	}
	
	public Key successor(Key key){

		Node p = successor(key, root, null);
		return p != null ? p.key : null;
	}
	
	public Key predecessor(Key key){
		Node p = predecessor(key, root, null);
		return p != null ? p.key : null;
	}
	

	private Node predecessor(Key key, Node node, Node prev) {
		if(node == null) return null;
		int cmp = key.compareTo(node.key);
		if(cmp < 0){
			return predecessor(key, node.left, prev);
		}
		if(cmp > 0){
			return predecessor(key, node.right, node);
		}
		
		if(node.left != null) return max(node.left); 
		
		
		//the prev node should hold a parent who is the predecessor
		return prev;
	}
	private Node successor(Key key, Node node, Node prev){
		if(node == null) return null;
		int cmp = key.compareTo(node.key);
		if(cmp < 0){
			return successor(key, node.left, node);
		}
		if(cmp > 0){
			return successor(key, node.right, prev);
		}
		
		if(node.right != null) return min(node.right); 
		
		
		//the prev node should hold a parent who is the successor
		return prev;
	
	}
	


	public class Node {
		Key key;
		Value value;
		Node left, right;
		boolean color;
		
		public Node(Key k, Value v) {
			key = k;
			value = v;
			left = null;
			right = null;
			color = false;
		}
		
		public Node(Key k, Value v, boolean color) {
			key = k;
			value = v;
			left = null;
			right = null;
			this.color = color;
	
		}
	}
}