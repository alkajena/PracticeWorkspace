package parcticeTreeQuestion;

public class AVLTreewithDuplicateKey {
	static Node root;
	
	static class Node{
		int key;
		Node left;
		Node right;
		int count;
		int height;
		
		public Node(int key){
			this.key=key;
			left=right=null;
			count=1;
			height=1;
		}
	}
	
	public AVLTreewithDuplicateKey(int key){
		root=new Node(key);
	}
	
	public int max(int a,int b){
		return a>b?a:b;
	}
	
	public int  height(Node node){
		if (node==null){
			return 0;
		}
		return node.height;
	}
	
	public int balanceFactor(Node node){
		return max(height(node.left),height(node.right));
	}
	
	public Node LLRotation(Node node){
		Node parent=node;
		Node child=node.left;
		Node childRight=child.right;
		
		child.right=parent;
		parent.left=childRight;
		
		parent.height=1+max(height(parent.left),height(parent.right));
		child.height=1+max(height(child.left),height(child.right));
		
		return child;
		
	}
	
	public Node RRRotation(Node node){
		Node parent=node;
		Node child=node.right;
		Node childLeft=child.left;
		
		child.left=parent;
		parent.right=childLeft;
		
		parent.height=1+max(height(parent.left),height(parent.right));
		child.height=1+max(height(child.left),height(child.right));
		
		return child;
		
	}
	
	public Node insert(Node node,int key){
		if(node==null)
			return new Node(key);
		else if(key>node.key)
			node.right=insert(node.right,key);
		else if(key<node.key)
			node.left=insert(node.left,key);
		else{
			node.count++;
			return node;
		}
		node.height=1+max(height(node.left),height(node.left));
		
		int balancefactor=balanceFactor(node);
		
		if(balancefactor>1 && node.left.key>key)
			return LLRotation(node);
		else if(balancefactor>1 && node.left.key<key){
			node.left=RRRotation(node.left);
			return LLRotation(node);
		}
		else if(balancefactor<-1 && node.right.key<key){
			return RRRotation(node);
		}
		else if(balancefactor<-1 && node.right.key>key){
			node.right=RRRotation(node.right);
			return LLRotation(node);
		}
		
		return node;
		
	}
	public Node inOrderSuccessor(Node node){
		Node temp=node;
		while(node.left!=null){
			node=node.left;
		}
		return node;
	}
	public Node delete(Node node,int key){
		if(node==null)
			return node;
		else if(key>node.key)
			node.right=delete(node.right,key);
		else if(key<node.key)
			node.left=delete(node.left,key);
		else{
			if(node.count>1){
				node.count--;
				return null;
			}	
			else if(node.count==1){
				Node temp=null;
				if(node.left==null || node.right==null){
					if(node.left==null)
						temp=node.right;
					else
						temp=node.right;
					
					if(temp==null){
						temp=node;
						node=null;
					}
					else{
						temp=node;
					}
				}
				else{
					Node min=inOrderSuccessor(node.right);
					node.key=min.key;
					node.right=delete(node.right, min.key);
				}
			}
		}
				if(node==null)
					return node;
				
				node.height=1+max(height(node.left),height(node.left));
				
				int balancefactor=balanceFactor(node);
				
				if(balancefactor>1 && balanceFactor(node.left)>1)
					return LLRotation(node);
				else if(balancefactor>1 && balanceFactor(node.left)<1){
					node.left=RRRotation(node.left);
					return LLRotation(node);
				}
				else if(balancefactor<-1 && balanceFactor(node.right)<1){
					return RRRotation(node);
				}
				else if(balancefactor<-1 && balanceFactor(node.right)>1){
					node.right=RRRotation(node.right);
					return LLRotation(node);
				}
				
				return node;
				
		}
		
	
}