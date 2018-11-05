package stacks_and_queues;

public class Stack {
	
	private int[] A; // = new int[8]; // use a constructor for dynamic sizes
	private int top = -1; // empty stack
	
	public Stack(int size) { // constructor same name as class
		A = new int[size];
	}
	
	// added with array
	public void resize() {
		int[] B = new int[A.length + 2];
		
		for(int i = 0; i < A.length; i ++) {
			B[i] = A[i];
		}
		
		A = B;
	}
	
	public void push(int x) { // define push()
		top++;
		
		// with an array
		if(top == A.length) {
			resize();
		}
		
		A[top] = x;
		
		
	}
	
	public void pop() { // removes the item from stack, not the array
		top--; 			// any extra code would make it slower, not a fault with the function, it's the user
			   			// no need for if statement when less than -1, if i add exception error for this
			   			// it will be 1000 times slower
	}
	
	public int top() { // also called peek()
		return A[top];
	}
	
	public boolean isEmpty() {
	//	if(top == -1) {
	//		return true;
	//	} else return false;
		return top == -1; // same as commented out stuff, can just return condition instead of simple if/else
	}
}
