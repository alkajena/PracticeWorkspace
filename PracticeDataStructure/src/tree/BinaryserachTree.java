package tree;

import java.util.ArrayList;
import java.util.List;

import tree.BinaryTreeInsertionDeletion.Node;

public class BinaryserachTree {
	Node root;
	
	public BinaryserachTree(int key){
		root=new Node(key);
	}
	static class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int key){
			this.key=key;
			left=null;
			right=null;
		}
	}
	
	static void insertion(Node root,int key){
		List list=new ArrayList<>();
		list.add(root);
		while(list.size()!=0){
			Node node=(Node)list.remove(0);
			if(key>node.key){
				if(node.right!=null){
					list.add(node.right);
				}
				else{
					node.right=new Node(key);
					break;
				}
			}
			else{
				if(node.left!=null){
					list.add(node.left);
				}
				else{
					node.left=new Node(key);
					break;
				}
			}
		}
		
	}
	static Node search(Node root,int key){
		List list=new ArrayList<>();
		list.add(root);
		Node temp=null;
		Node prev=null;
		while(list.size()!=0){
			Node node=(Node)list.remove(0);
			if(key==node.key){
				temp=node;
			}
			if(key>node.key){
				if(node.right!=null){
					list.add(node.right);
				}
			}
			else{
				if(node.left!=null){
					list.add(node.left);
				}
			}
		}
		return temp;
	}
	
	static void Deletion(int key,Node root){
		Node node=search(root,key);
		//Node prev=previousNode(node,root);
		if(node.left==null && node.right==null){
			node=null;
		}
		else if(node.left==null && node.right!=null){
			node.key=node.right.key;
			node.right=null;
		}
		else if(node.right==null && node.left!=null){
			node.key=node.left.key;
			node.left=null;
		}
		else{
			Node inorder=findInorderSuccessor(node);
			node.key=inorder.key;
		}
		
	}
	
	static Node findInorderSuccessor(Node node){
		Node temp=node.right;
		Node prev=node;
		boolean count=false;
		while(temp.left!=null){
			count=true;
			if(temp.left.left!=null){
				prev=temp;
				temp=temp.left;
			}
			else{
				prev=temp.left;
				temp.left=null;
			}
		}
		if(!count && temp.left==null && temp.right!=null ){
			prev.right=prev.right.right;
			return temp;
		}
		else if(!count && temp.left==null && temp.right==null){
			prev.right=null;
			return temp;
		}
		return prev;
		
	}
	static void inOrder(Node root){
		if(root==null)
			return;
		inOrder(root.left);
		System.out.println(root.key);
		inOrder(root.right);
	}
	public static void main(String[] args) {
		BinaryserachTree bst=new BinaryserachTree(60);
		bst.insertion(bst.root, 40);
		bst.insertion(bst.root, 70);
		bst.insertion(bst.root, 30);
		bst.insertion(bst.root, 42);
		bst.insertion(bst.root, 65);
		bst.insertion(bst.root, 80);
		bst.insertion(bst.root, 75);
		bst.insertion(bst.root, 72);
		bst.insertion(bst.root, 90);
		bst.inOrder(bst.root);
		System.out.println("\n");
		bst.Deletion(70, bst.root);
		bst.inOrder(bst.root);
	}

}
