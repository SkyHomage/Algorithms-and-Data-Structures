package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class tester {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("input.txt");
		String[] words = splitFile(file);
		String[] vals = new String[words.length];
		BST<String, String> tree = new BST<String, String>(words, vals);
		tree.printTree();
		tree.delete("Robinson");
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
