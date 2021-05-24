package tree;

public class MirrorBinaryTree {
	static Node root;
	static class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int key){
			this.key=key;
			left=right=null;
		}
	}
	
	public MirrorBinaryTree(int key){
		root=new Node(key);
	}
	
	public Node mirrorTree(Node root){
		if(root==null)
			return root;
		root.left=mirrorTree(root.left);
		root.right=mirrorTree(root.right);
		
		Node temp=root.left;
		root.left=root.right;
		root.right=temp;
		
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
