package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class tester {

	public static void main(String[] args) throws FileNotFoundException {
		//BinarySearchTree<String> tree = new BinarySearchTree<String>(new String[]{"Robinson", "Lynn", "Bary", "Jr", "TingTing", "Zack"});
		
		File file = new File("input.txt");
		String[] words = splitFile(file);
		BinarySearchTree<String> tree = new BinarySearchTree<String>(words);
		tree.printTree();
	}

	private static String[] splitFile(File file) throws FileNotFoundException {
		Scanner scn = new Scanner(file);
		StringBuilder sb = new StringBuilder();
		
		
		while(scn.hasNext()){
			sb.append(scn.nextLine()+" ");
		}
		
		return sb.toString().split(" ");
	}

}
