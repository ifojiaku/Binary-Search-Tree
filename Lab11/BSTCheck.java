package Lab11;

public class BSTCheck {
	
	public static void main(String [] args) {
		boolean x = true;
		Tree root = new Tree (4);
		root.left = new Tree(2);
		root.right = new Tree(6);
		root.left.left = new Tree(1);
		root.left.right = new Tree(3);
		root.right.left = new Tree(5);
		root.right.right = new Tree(7);
		//if the root is null, the code won't execute the functions since the tree would still be a valid bst.
		//this is because the left and right nodes still exist, but as null values, making it a valid bst
		if(root != null) {
			x = check(root);
		}
		System.out.print("Is the tree a valid binary search tree?\n"+x);
	}
	
	static class Tree{
		int data;
		Tree left, right;
		Tree(int data){
			this.data = data;
			left = right = null;
		}
	}
		
	public static boolean check(Tree root) {
		boolean x = true;
		//if there is no left node of the main root, the code doesn't execute the checking of the left side at all
		if(root.left != null) {
			//enters the left side of the tree
			x = checkLeft(root.left, root.data);
		}
		/*if there is no right node of the main root, the code doesn't execute the checking of the right side at all.
		 *If the left side check comes across a subtree that breaks the rules of BST, it also doesn't perform the right
		 *check since there is no need when the condition is false anyway*/
		if(x == true && root.right != null) {
			//enters the right side of the tree
			x = checkRight(root.right, root.data);
		}
		//if x hasn't been set to false after the method's instructions, then the tree is a valid BST.
		//it wouldn't be a BST otherwise when x is false.
		return x;
	}
	
	//this method executes for the left side of the tree which ensures all input values are less than or equal to the main root
	public static boolean checkLeft(Tree root, int max) {
		boolean x = true;
		//stops at the leaf nodes when checking for null values
		if(root.left != null) {
			/*compares left node to previous root of subtree, while also checking to see if it's less then or equal to 
			 *main root value. The tree isn't a valid subtree if it doesn't follow the comparison rule at the subtree level*/
			if(root.left.data <= max && root.left.data <= root.data) {
				//recursively calls it if left node holds true for bst rules
				checkLeft(root.left, max);
			}else{
				//when condition is false, the recursion is halted and the result of the entire bst will be false
				return x = false;
			}
		}
		//stops at the leaf nodes when checking for null values
		if(root.right != null) {
			/*compares right node to previous root of subtree, while also checking to see if it's less then or equal to 
			 *main root value. The tree isn't a valid subtree if it doesn't follow the comparison rule at the subtree level*/
			if(root.right.data < max && root.right.data > root.data) {
				//recursively calls it if right node holds true for bst rules
				checkLeft(root.right, max);
			}else{
				//when condition is false, the recursion is halted and the result of the entire bst will be false
				return x = false;
			}
		}
		//if x isn't false, returns x as true to the previous method that called this iteration
		return x;
	}
	
	//this method executes for the right side of the tree which ensures all input values are greater than the main root
	public static boolean checkRight(Tree root, int min) {
		boolean x = true;
		//stops at the leaf nodes when checking for null values
		if(root.left != null) {
			/*compares left node to previous root of subtree, while also checking to see if it's greater than main root 
			 *value. The tree isn't a valid subtree if it doesn't follow the comparison rule at the subtree level*/
			if(root.left.data > min && root.left.data <= root.data) {
				//recursively calls it if left node holds true for bst rules
				x = checkRight(root.left, min);
			}else{
				//when condition is false, the recursion is halted and the result of the entire bst will be false
				return x = false;
			}
		}
		//stops at the leaf nodes when checking for null values
		if(root.right != null) {
			/*compares right node to previous root of subtree, while also checking to see if it's greater than the main 
			 *root value. The tree isn't a valid subtree if it doesn't follow the comparison rule at the subtree level*/
			if(root.right.data > min && root.right.data > root.data) {
				//recursively calls it if right node holds true for bst rules
				x = checkRight(root.right, min);
			}else{
				//when condition is false, the recursion is halted and the result of the entire bst will be false
				return x = false;
			}
		}
		//if x isn't false, returns x as true to the previous method that called this iteration
		return x;
	}
	/*Test Case 1: If the entire tree is null, then "true" is still returned as a result as an empty tree with a
	 *null left and right side is still a valid bst*/
}
