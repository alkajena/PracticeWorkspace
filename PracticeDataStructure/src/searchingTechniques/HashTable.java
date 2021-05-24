package searchingTechniques;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
	static List<Node> nodesArr=new ArrayList<>();
	static int bucketsize=10;
	static int size=0;
	static class Node{
		int key;
		int value;
		Node next;
		
		public Node(int key,int value){
			this.key=key;
			this.value=value;
			next=null;
		}
		
	}
	public HashTable(){
		for(int i=0;i<bucketsize;i++)
			nodesArr.add(null);
	}
	static int getIndex(int key){
		return key%bucketsize;
	}
	
	static void add(int key,int value){
		int index=getIndex(key);
		Node node=nodesArr.get(index);
		if(node==null){
			nodesArr.set(index, new Node(key,value));
			size++;
		}
		//overriding  concept
		Node temp=node;
		while(temp!=null){
			if(temp.key==key){
				temp.value=value;
			}
			temp=temp.next;
		}
		
			Node newNode=new Node(key,value);
			newNode.next=node;
			nodesArr.set(index, newNode);
			size++;
			
	}
	static void delete(int key){
		int index=getIndex(key);
		Node node=nodesArr.get(index);
		if(node.key==key){
			nodesArr.set(index, node.next);
		}
		else{
			Node temp=node;
			Node prev=null;
			while(temp!=null){
				if(temp.key==key){
					prev.next=temp.next;
					size--;
					return;
				}
				prev=temp;
				temp=temp.next;
			}
		}
		
	}
	public static void main(String[] args) {
		HashTable hashTable = new HashTable(); 
		hashTable.add(1,1); 
		hashTable.add(2,2); 
		hashTable.add(3,2);
		hashTable.add(5,2);
		hashTable.add(11,11);
		hashTable.add(21,21);
		hashTable.add(31,31);
		hashTable.add(1,2); 
		hashTable.delete(11); 
		
		for(Node node:nodesArr){
			if(node!=null){
				Node temp=node;
				while(temp!=null){
					System.out.println("key :"+temp.key+"value :"+temp.value);
					temp=temp.next;
				}
				
			}
				
			else
				continue;
		}
	}

}
