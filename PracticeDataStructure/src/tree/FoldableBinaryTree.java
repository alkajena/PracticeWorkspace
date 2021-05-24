package tree;

import tree.MirrorBinaryTree.Node;

public class FoldableBinaryTree {
	Node root;
	
	static class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int key){
			this.key=key;
			left=right=null;
		}
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
	public FoldableBinaryTree(int key){
		root=new Node(key);
	}
	
	public boolean isStructure(Node left,Node right){
		if(left==null && right==null)
			return true;
		else if(left!=null && right!=null && isStructure(left.left,right.left) && isStructure(left.right,right.right))
			return true;
		else
			return false;
		}
			
	public boolean foldablebinaryTree(Node root){
		if(root==null)
			return true;
		else{
			root.left=mirrorTree(root.left);
			boolean isfoldable=isStructure(root.left,root.right);
			mirrorTree(root.left);
			return isfoldable;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
