package tree;

public class Symmetrictree {
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
	
	public Symmetrictree(int key){
		root=new Node(key);
	}
	
	public boolean checkSymmetric(Node left,Node right){
		if(left==null && right==null)
			return true;
		if(left==null || right==null)
			return false;
		if(left.key==right.key && checkSymmetric(left.left,right.right) && checkSymmetric(left.right,right.left)){
			return true;
		}
		return false;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
