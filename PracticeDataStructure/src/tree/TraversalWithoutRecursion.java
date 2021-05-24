package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TraversalWithoutRecursion {
	
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
	
	public TraversalWithoutRecursion(int key){
		root=new Node(key);
	}
	
	public void inOrder(Node root){
		List<Node> list=new ArrayList<>();
		Node current=root;
		while(list.size()!=0 || current!=null){
			while(current!=null){
				list.add(current);
				current=current.left;
			}
			Node temp=list.remove(list.size()-1);
			System.out.println(temp.key);
			current=temp.right;
		}
	}
	
	public void postOrder(Node root){
		List<Node> list1=new ArrayList<>();
		List<Node> list2=new ArrayList<>();
		list1.add(root);
		while(list1.size()!=0){
			Node temp=list1.remove(list1.size()-1);
			if(temp!=null){
				list2.add(temp);
				list1.add(temp.left);
				list1.add(temp.right);
			}
		}
		
		Collections.reverse(list2);
		for(Node node:list2){
			System.out.println(node.key);
		}
	}
	
	public void preOrder(Node root){
		List<Node> list1=new ArrayList<>();
		List<Node> list2=new ArrayList<>();
		Node current=root;
		while(list1.size()!=0 || current!=null){
			while(current!=null){
				list1.add(current);
				list2.add(current);
				current=current.left;
			}
			Node temp=list1.remove(list1.size()-1);
			//System.out.println(temp.key);
			current=temp.right;
		}
		for(Node node:list2){
			System.out.println(node.key);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
