package BST;

// this is used when the tree is empty
public class BST {
	
	private BSTNode root = null;
	
	private int[] A;
	private int i;
	
	public void balance() {
		inOrder();
		root = null;
		bisectionInsert(0, A.length - 1);
	}
	
	public void bisectionInsert(int first, int last) {
		if(first <= last) {
			int middle = (first + last) / 2;
			insert(A[middle]);
			bisectionInsert(first, middle - 1);
			bisectionInsert(middle + 1, last);
		}
	}
	
	public void inOrder() {
		if(!isEmpty()) 
			A = new int[count()];
			i = 0;
			root.inOrder();
	}
	
	public void insert(int value) {
		if(isEmpty())	root = new BSTNode(value);
		else 			root.insert(value);
	}
	
	public BSTNode search(int value) {
		if(isEmpty()) 	return null;
		else 			return root.binaryTreeSearch(value);
	}
	
	public int count() {
		if(isEmpty())	return 0;
		else 			return root.count();
	}

	public void printInOrder() {
		if(!isEmpty())	root.printInOrder();
	}
	
	public int height() {
		if(isEmpty()) 	return 0;
		else 			return root.height();
	}
	
	public int min() {
		if(isEmpty())	return -1; // sentinel value
		else 			return root.min();
	}
	
	public int max() {
		if(isEmpty())	return Integer.MAX_VALUE;
		else 			return root.max();
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public class BSTNode {
		
		private int x;
		
		private BSTNode left  = null;
		private BSTNode right = null;
		
		public BSTNode(int value) {
			x = value;		
		}
		
		public void insert(int value) {
			if(value < x) {
				if(left != null) 	left.insert(value);
				else 				left = new BSTNode(value);
			}
			if(value > x) {
				if(right != null)	right.insert(value);
				else 				right = new BSTNode(value);
			}
		}
		
		public BSTNode binaryTreeSearch(int value) {
			if(value == x) 						return this;
			if(value < x && left != null) 		return left.binaryTreeSearch(value);
			if(value > x && right != null) 		return right.binaryTreeSearch(value);
			return null;
		}
		
		public void inOrder() {
			if(left != null) left.inOrder();
			A[i] = x;
			i++;
			if(right != null) right.inOrder();
		}
	 	
		public void printInOrder() {
			if(left != null) 			left.printInOrder();
			System.out.println(x);
			if(right != null) 			right.printInOrder();
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
}
