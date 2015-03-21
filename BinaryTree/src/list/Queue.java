package list;

@SuppressWarnings("unchecked")
public class Queue<T>{
	Node head, tail;
	
	public Queue(){
		head = null;
		tail = head;
	}
	public Queue(T data){
		head = new Node(data);
		tail = head;
	}
	
	public void add(T data){
		Node n = new Node(data);
		if(head == null){
			head = n;
			tail = n;
			return;
		}
		
		tail.next = n;
		tail = tail.next;
	}
	
	
	public T peek(){
		return head == null ? null : (T)head.data;
	}
	
	public T poll(){
		if(head == null) return null;
		Node n = head;
		head = head.next;
		return (T)n.data;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
}
