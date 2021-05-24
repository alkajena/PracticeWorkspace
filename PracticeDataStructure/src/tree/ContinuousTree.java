package tree;

public class ContinuousTree {
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
	
	public ContinuousTree(int key){
		root=new Node(key);
	}
	
	public boolean continuousTree(Node root){
		if(root==null)
			return true;
		if(root.left==null && root.right==null)
			return true;
		if(root.left==null || root.right==null){
			if(root.left==null){
				return Math.abs(root.key-root.right.key)==1 && continuousTree(root.right);
			}
			else{
				return Math.abs(root.key-root.left.key)==1 && continuousTree(root.left);
			}	
		}
		if(root.left!=null && root.right!=null){
			return Math.abs(root.key-root.left.key)==1 && Math.abs(root.key-root.right.key)==1 && continuousTree(root.left) && continuousTree(root.right);
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
