package tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class InOrderSuccessorOfNode {
	Node root;
	static List<Node> list=new ArrayList<>();
	static class Node{
		int key;
		Node left;
		Node right;
		Node next;
		Node prev;
		
		public Node(int key){
			this.key=key;
			left=right=next=prev=null;
			
		}
	}
	
	public InOrderSuccessorOfNode(int key){
		root=new Node(key);
	}
	
	public static void inOrderSucessor(Node root){
		if(root==null)
			return;
		inOrderSucessor(root.left);
		list.add(root);
		inOrderSucessor(root.right);
	}
	public static void main(String[] args) {
		InOrderSuccessorOfNode tree = new InOrderSuccessorOfNode(10); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(12); 
        tree.root.left.left = new Node(3);
        inOrderSucessor(tree.root);
        int i=0;
        int j=i;
        while(i<list.size()){
        	list.get(i).next=list.get(++j);
        	i++;
        }
        list.get(i).next=new Node(-1);
        Collections.reverse(list);
        int i1=0;
        int j1=i1;
        while(i1<list.size()){
        	list.get(i1).prev=list.get(++j1);
        	i1++;
        }
        list.get(i1).prev=new Node(-1);
        Collections.reverse(list);
        for(int k=0;k<list.size();k++){
        	System.out.println(list.get(k).prev.key+list.get(k).next.key);
        }
	}

}
