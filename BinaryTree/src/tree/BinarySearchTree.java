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
		Node p = root;

		while (true) {
			if (a.compareTo(p.data) <= 0) {
				if (p.left != null)
					p = p.left;
				else {
					p.left = new Node(a);
					return;
				}
			} else {
				if (p.right != null)
					p = p.right;
				else {
					p.right = new Node(a);
					return;
				}
			}
		}
	}

	public void printTree() {

		BTreePrinter.printNode(root);
	}

	public class Node {
		T data;
		Node left, right;

		public Node(T x) {
			data = x;
			left = null;
			right = null;
		}
	}
}