package list;
//TODO make stack and queue extend abstract class abstract list
@SuppressWarnings("unchecked")
public class Stack<T> {
	Node head;
	
	public void push(T data){
		if(head == null){
			head = new Node(data);
			return;
		}
		
		Node n = new Node(data);
		n.next = head;
		head = n;
	}
	
	public T pop(){
		if(head == null) return null;
		Node n = head;
		head = head.next;
		return (T)n.data;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
}
