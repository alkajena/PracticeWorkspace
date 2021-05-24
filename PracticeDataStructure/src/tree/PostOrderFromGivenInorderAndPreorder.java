package tree;

import java.util.List;

public class PostOrderFromGivenInorderAndPreorder {
	
	public int search(List<Integer> in,int root,int size){
		for(int i=0;i<size;i++){
			if(in.get(i)==root){
				return i;
			}
		}
		return -1;
	}
	public void postOrder(List<Integer> in,List<Integer> pre,int size){
		int root=pre.get(0);
		int rootIndex=search(in,root,size);
		
		if(rootIndex!=0)
			postOrder(in.subList(0, rootIndex),pre.subList(1, rootIndex+1),rootIndex);
		
		if(rootIndex!=size-1)
			postOrder(in.subList(rootIndex+1, size),pre.subList(rootIndex+1, size),size-rootIndex-1);
		
		System.out.println(pre.get(0));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
