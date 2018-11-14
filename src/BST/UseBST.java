package BST;

public class UseBST {
	
	public static void main(String[] args) {
		BST bst = new BST();
		
		int[] A = {50, 18, 22, 420, 1024, 1738, 21, 121, 1021, 99, 69, 1, 55, 66};
		for(int i = 0; i < A.length; i++)
			bst.insert(A[i]);
	
		System.out.println("height = " + bst.height());
		System.out.println("count = " + bst.count());	
		
		bst.printInOrder();
		bst.balance();
		
		System.out.println("height = " + bst.height());
		System.out.println("count = " + bst.count());	
		
		bst.printInOrder();
	}
}
