package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class tester {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("input.txt");
		//String[] words = splitFile(file);
		//String[] vals = new String[words.length];
		BST<String, String> tree = new BST<String, String>();
		insertFile(file, tree);
		//tree.printTree();
		String toGet = "meatus";
		System.out.println(toGet  + " - " + tree.get(toGet));
		
		tree.inorderTraverse();
	}

	private static void insertFile(File file, BST<String, String> tree) throws FileNotFoundException{
		Scanner scn = new Scanner(file);
		StringBuilder sb = new StringBuilder();
		
		while(scn.hasNext()){
			//get word
			String word = scn.nextLine();
			//get definition
			while(scn.hasNext()){
				String s = scn.nextLine();
				if(s.length() == 0) break;
				if(s.length() > 30){
					String[] split = s.split(" ");
					for(int i = 0; i*10 < split.length; i ++){
						for(int j = i*10; j< split.length && j < i*10 +10; j++){
							sb.append(split[j] + " ");
						}
						sb.append("\n");
					}
				}
				else
					sb.append(s);
			}
			String def = sb.toString();
			sb = new StringBuilder("");
			tree.put(word, def);
		}
		scn.close();
		
		
	}
	private static String[] splitFile(File file) throws FileNotFoundException {
		Scanner scn = new Scanner(file);
		StringBuilder sb = new StringBuilder();
		
		while(scn.hasNext()){
			sb.append(scn.nextLine()+" ");
		}
		scn.close();
		return sb.toString().split(" ");
		
	}

}
