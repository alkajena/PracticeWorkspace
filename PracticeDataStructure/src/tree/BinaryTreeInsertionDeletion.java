package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInsertionDeletion {
	static Node root;
	
	static class Node{
		int key;
		Node left;
		Node right;
		
		public  Node(int key){
			this.key=key;
			left=right=null;
		}
	}
	public  BinaryTreeInsertionDeletion(int key){
		root=new Node(key);
	}
	static void insertion(int key,Node root){
		List list=new ArrayList<>();
		list.add(root);
		while(list.size()!=0){
			Node node=(Node)list.remove(0);
			if(node.left!=null){
				list.add(node.left);
			}
			else{
				node.left=new Node(key);
				break;
			}
			
			if(node.right!=null){
				list.add(node.right);
			}
			else{
				node.right=new Node(key);
				break;
			}
		}
	}
	
	static void LevelOrerTraversal(Node root){
		List list=new ArrayList<>();
		list.add(root);
		while(list.size()!=0){
			Node node=(Node)list.remove(0);
			System.out.println(node.key);
			if(node.left!=null){
				list.add(node.left);
			}
			if(node.right!=null){
				list.add(node.right);
			}
		}
	}
	
	static void inOrder(Node root){
		if(root==null)
			return;
		inOrder(root.left);
		System.out.println(root.key);
		inOrder(root.right);
	}
	
	static void postOrder(Node root){
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.key);
	}
	
	static void preOrder(Node root){
		if(root==null)
			return;
		
		System.out.println(root.key);
		preOrder(root.left);
		preOrder(root.right);
	}
	static Node search(Node root,int key){
		List list=new ArrayList<>();
		list.add(root);
		Node temp=null;
		while(list.size()!=0){
			Node node=(Node)list.remove(0);
			if(node.key==key){
				temp=node;
			}
			if(node.left!=null){
				list.add(node.left);
			}
			if(node.right!=null){
				list.add(node.right);
			}
		}
		return temp;
	}
	static void deletion(Node root,int key){
		Node node=search(root,key);
		Node rightMostNode=findRightMostNode(node);
		node.key=rightMostNode.key;	
	}
	
	static Node findRightMostNode(Node node){
		Node temp = null;
		while(node.right!=null){
			if(node.right.right!=null){
				node=node.right;
			}
			else{
				temp=node.right;
				break;
			}
		}
		node.right=null;
		return temp;
	}
	public static void main(String[] args) {
		BinaryTreeInsertionDeletion bTree=new BinaryTreeInsertionDeletion(1);
		bTree.insertion(2, bTree.root);
		bTree.insertion(3, bTree.root);
		bTree.insertion(4, bTree.root);
		bTree.insertion(5, bTree.root);
		bTree.insertion(6, bTree.root);
		bTree.insertion(7, bTree.root);
		bTree.deletion(bTree.root, 2);
		System.out.println("\n");
		LevelOrerTraversal(bTree.root);
		//bTree.inOrder(bTree.root);
	}

}
