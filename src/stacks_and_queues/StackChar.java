package stacks_and_queues;

public class StackChar {

	private String[] A; 
	private int top = -1; 
	
	public StackChar(int size) { 
		A = new String[size];
	}
	
	public void push(String x) { 
		top++;
		A[top] = x;
	}
	
	public void pop() { 
		top--; 			
	}
	
	public String top() { 
		return A[top];
	}
	
	public boolean isEmpty() {
		return top == -1; 
	}
}
