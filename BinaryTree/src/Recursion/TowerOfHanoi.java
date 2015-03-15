package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TowerOfHanoi {

	public int m;
	public List<Stack<Integer>> stacks;
	
	public TowerOfHanoi(int m){
		this.m = m;
		stacks = new ArrayList<Stack<Integer>>();
		stacks.add(new Stack<Integer>());
		stacks.add(new Stack<Integer>());
		stacks.add(new Stack<Integer>());
		for(int i = m; i > 0; i--) stacks.get(0).push(i);
		
	}
	
	public void solve(){
		System.out.println(stacks.get(0).toString());
		move(m, 0, 1, 2);
		//move n-1 disc to C
		//move n to B
		//move n-1 to B
		System.out.println(stacks.get(1).toString());
		
		
	}

	private void move(int n, int from, int to, int use) {
		if(n > 0){
			move(n -1, from, use, to);
			stacks.get(to).push(stacks.get(from).pop());
			move(n-1, use, to, from);
		}
	}
}
