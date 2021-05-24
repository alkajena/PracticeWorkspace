package tree;

import java.util.ArrayList;
import java.util.List;

public class ExpressionTree {
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
	
	public ExpressionTree(int key){
		root=new Node(key);
	}
	
	public Node expressiontree(String exp){
		List<Node> list=new ArrayList<>();
		char[] expArray=exp.toCharArray();
		Node node;
		for(char ch:expArray){
			if(Character.isLetterOrDigit(ch)){
				list.add(new Node(ch));
			}
			else{
				node=new Node(ch);
				node.right=list.remove(list.size()-1);
				node.left=list.remove(list.size()-1);
				list.add(node);
			}
		}
		Node temp=list.remove(list.size()-1);
		return temp;
		//inOrder(temp);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
