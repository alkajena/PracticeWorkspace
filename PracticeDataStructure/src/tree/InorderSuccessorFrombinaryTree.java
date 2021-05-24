package tree;

public class InorderSuccessorFrombinaryTree {
	Node root;
	
	static class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int key){
			this.key=key;
			left=right=null;
		}
		
		public Node(){
			
		}
	}
	
	public InorderSuccessorFrombinaryTree(int key){
		root=new Node(key);
	}
	
	public Node leftMostNode(Node node){
		Node temp=node;
		while(temp.left!=null){
			temp=temp.left;
		}
		return temp;
	}
	Node temp=new Node();
	public Node rightMostNode(Node node){
		Node temp=node;
		while(temp.right!=null){
			temp=temp.right;
		}
		return temp;
	}
	public Node inOrderRecursiveCall(Node root,Node x){
		if(root ==null)
			return null;
		else if(root==x || (temp=inOrderRecursiveCall(root.left,x))!=null || (temp=inOrderRecursiveCall(root.right,x))!=null){
			if(temp!=null){
				if(root.left==temp){
					System.out.println(root.key);
				}
			}
			return root;
		}
		return null;
	}
	public Node inOrderSuccessor(Node root,Node x){
		 if(x.right!=null){
			 return leftMostNode(x.right);
		 }
		 else{
			 Node node=rightMostNode(root);
			 if(node.key==x.key){
				 System.out.println("right most node");
			 }
			 else{
				return inOrderRecursiveCall(root,x);
			 }
		 }
		 return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
