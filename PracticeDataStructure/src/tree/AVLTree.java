package tree;

import tree.BinaryserachTree.Node;

public class AVLTree {
Node root;
	
	public AVLTree(int data){
		root=new Node(data);
	}
	static class Node{
		int data;
		Node left;
		Node right;
		int height;
		
		public Node(int data){
			this.data=data;
			height=1;
			left=null;
			right=null;
		}
	}
	
	static int height(Node node){
		if(node==null)
			return 0;
		return node.height;
	}
	
	static int balanceFactor(Node node){
		return height(node.left)-height(node.right);
	}
	
	static int max(int a,int b){
		return a>b?a:b;
	}
	
	static Node LLRotation(Node node){
		Node parent=node;
		Node child=parent.left;
		Node childRight=child.right;
		
		
		child.right=parent;
		parent.left=childRight;
		
		parent.height=1+(max(height(parent.left),height(parent.right)));
		child.height=1+max(height(child.left),height(child.right));
		
		return child;
		
	}
	
	static Node RRRotation(Node node){
		Node parent=node;
		Node child=parent.right;
		Node childLeft=child.left;
		
		
		child.left=parent;
		parent.right=childLeft;
		
		parent.height=1+(max(height(parent.left),height(parent.right)));
		child.height=1+max(height(child.left),height(child.right));
		
		return child;
	}
	
	static Node insertion(Node root,int key){
		if(root==null)
			return new Node(key);
		if(key>root.data)
			root.right=insertion(root.right,key);
		if(key<root.data)
			root.left=insertion(root.left,key);
		
		root.height=1+(max(height(root.left),height(root.right)));
		
		int balanceFactor=balanceFactor(root);
		
		if(balanceFactor>1 && key<root.left.data)
			return LLRotation(root);
		
		else if(balanceFactor>1 && key>root.left.data){
			root.left=RRRotation(root.left);
			return LLRotation(root);
		}
		
		else if(balanceFactor<-1 && key>root.left.data)
			return RRRotation(root);
		else if(balanceFactor<-1 && key<root.left.data){
			root.right=LLRotation(root.right);
			return RRRotation(root);
		}
		
		return root;
	}
	static Node getLeftMostChild(Node node){
		if(node.left.left==null){
			Node temp=node.left;
			node.left=null;
			return temp;
		}
		return getLeftMostChild(node.left);
	}
	static Node deletion(Node node,int key){
		if(node==null)
			return node;
		if(key>node.data)
			node.right=deletion(node.right,key);
		else if(key<node.data)
			node.left=deletion(node.left,key);
		else{
			Node temp=null;
			if(node.right==null || node.left==null){
				if(node.left==null)
					temp=node.right;
				else
					temp=node.left;
				
				if(temp==null){
					temp=node;
					node=null;
				}
				else{
					node=temp;
				}
			}
			else{
				Node child=getLeftMostChild(node);
				node.data=child.data;
				node.right=deletion(node.right,node.data);
			}
		}
		
		if(node==null)
			return node;
		
		node.height=1+max(height(node.left),height(node.right));
		
		int balanceFactor=balanceFactor(node);
		
		if(balanceFactor>1 && balanceFactor(node.left)>=0)
			return LLRotation(node);
		
		else if(balanceFactor>1 && balanceFactor(node.left)<0){
			node.left=RRRotation(node.left);
			return LLRotation(node);
		}
		
		else if(balanceFactor<-1 && balanceFactor(node.right)<0)
			return RRRotation(node);
		else if(balanceFactor<-1 && balanceFactor(node.right)>=0){
			node.right=LLRotation(node.right);
			return RRRotation(node);
		}
		return node;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
