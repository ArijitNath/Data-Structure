package datastructure.tree.interviewtodo;

public class TreeTraversals {

	public static void main(String[] args) {
		Node head = new Node(10);
		head.setLeft(new Node(20));
		head.setRight(new Node(30));
		head.getLeft().setLeft(new Node(40));
		head.getLeft().setRight(new Node(50));
		head.getRight().setLeft(new Node(60));
		head.getRight().setRight(new Node(70));
		
		TreeTraversalsImpl traversal = new TreeTraversalsImpl();
		traversal.preOrder(head);
		System.out.println();
		traversal.inOrder(head);
		System.out.println();
		traversal.postOrder(head);
		System.out.println();
		System.out.println("height : " + traversal.height(head));
		
		System.out.println();
		traversal.levelOrder(head);
	}
}

class TreeTraversalsImpl { 
	public void preOrder(Node node) {
		if( node == null ) return;
		
		System.out.print(node.getData() + " ");
		preOrder(node.getLeft());
		preOrder(node.getRight());
	}
	
	public void inOrder(Node node) {
		if( node == null ) return;
		
		inOrder(node.getLeft());
		System.out.print(node.getData() + " ");
		inOrder(node.getRight());
	}
	
	public void postOrder(Node node) {
		if( node == null ) return;
		
		postOrder(node.getLeft());
		postOrder(node.getRight());
		System.out.print(node.getData() + " ");		
	}
	
	public int height(Node node) {
		if ( node == null ) return 0;
		int rHeight = height(node.getRight());
		int lHeight = height(node.getLeft());
		
		if(lHeight > rHeight) 
			return lHeight + 1;
		return rHeight + 1;
	}
	
	public void levelOrder(Node node) {
		int height = height(node);
		for(int i = 1; i <= height; i++) {
			printGivenLevel(node, i);
		}
	}

	private void printGivenLevel(Node node, int level) {
		if( node == null ) return;
		
		if(level == 1)
			System.out.print(node.getData() + " ");
		else if( level > 1 ) {
			printGivenLevel(node.getLeft(), level - 1);
			printGivenLevel(node.getRight(), level - 1);
		}
		
	}
}
