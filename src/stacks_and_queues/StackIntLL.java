package stacks_and_queues;

public class StackIntLL {
	
	Node top = null;
	
	public void push(int x) {
		top = new Node(x, top);
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
