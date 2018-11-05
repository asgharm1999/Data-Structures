package BST;

public class BSTNode {
	
	private int x;
	
	private BSTNode left  = null;
	private BSTNode right = null;
	
	public BSTNode(int value) {
		x = value;		
	}
	
	public int binaryTreeSearch(int value) {
		if(value == x) 						return x;
		if(value < x && left != null) 		return left.binaryTreeSearch(value);
		if(value > x && right != null) 		return right.binaryTreeSearch(value);
		return value;
	}
 	
	public void printInOrder() {
		if(left != null) 	left.printInOrder();
		System.out.println(x);
		if(right != null) 	right.printInOrder();
	}
	
	public int min() {
		if(left != null) 	return left.min();
		else 				return x;
	}
	
	public int max() {
		if(right != null)	return right.max();
		else 				return x;
	}

	public int height() {
		int HL = 0;
		int HR = 0;
		
		if(left != null) 	HL = left.height();
		if(right != null) 	HR = right.height();
		return max(HL, HR) + 1;
	}
	
	private int max(int a, int b) {
		if(a >= b) 			return a;
		else 				return b;
	}
	
	public int count() {
		int c = 1;
		
		if(left != null) 	c += left.count(); // left count
		if(right != null) 	c += right.count(); // right count
		return c;
	}
}
