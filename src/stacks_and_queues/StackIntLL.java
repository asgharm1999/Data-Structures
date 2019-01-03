package stacks_and_queues;

public class StackIntLL {
	
	Node top = null;
	
	public void push(int i) {
		top = new Node(i, top);
	}
	
	public void push(String s) {
		top = new Node(s, top);
	}
	
	public void pop() {
		top = top.next;
	}
	
	public int top() {
		return top.x;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}
