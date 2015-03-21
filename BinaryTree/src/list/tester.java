package list;

public class tester {

	public static void main(String[] args) {
		testQueue();
		System.out.println();
		testStack();
	}
	
	public static void testStack(){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		System.out.println();
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		
	}
	
	public static void testQueue(){
		Queue<Integer> queue = new Queue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		
		while(!queue.isEmpty()){
			System.out.println(queue.poll());
		}
		System.out.println();
		queue.add(4);
		queue.add(3);
		queue.add(2);
		queue.add(1);
		
		while(!queue.isEmpty()){
			System.out.println(queue.poll());
		}
		
	}

}
