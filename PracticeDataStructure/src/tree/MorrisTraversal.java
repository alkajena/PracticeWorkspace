package tree;

public class MorrisTraversal {
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
	
	public MorrisTraversal(int key){
		root=new Node(key);
	}
	
	public void orrisTraversal(Node root){
		Node current=root;
		if(root.left==null){
			System.out.println(root.key);
			current=current.right;
		}
		else{
			Node pre=root.left;
			while(pre.right!=null || pre.right!=root){
				pre=pre.right;
			}
			if(pre.right==null){
				pre.right=current;
				current=current.left;
			}
			else{
				pre.right=null;
				current=current.right;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
