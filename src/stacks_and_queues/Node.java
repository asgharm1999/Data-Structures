package stacks_and_queues;

public class Node {
	
	int x;
	String y;
	Node next;
	
	public Node(int x, Node next) {
		this.x = x;
		this.next = next;
	}
	
	public Node(String s, Node next) {
		y = s;
		this.next = next;
	}
}
