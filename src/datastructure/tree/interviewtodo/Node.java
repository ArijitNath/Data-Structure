package datastructure.tree.interviewtodo;

public class Node {
	private int data;
	private Node left;
	private Node right;
	
	public int getData() { return data; }
	public void setData(int data) { this.data = data; }
	public Node getLeft() { return left; }
	public void setLeft(Node left) { this.left = left; }
	public Node getRight() { return right; }
	public void setRight(Node right) { this.right = right; }
	
	public Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
	
	public Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}	
}
