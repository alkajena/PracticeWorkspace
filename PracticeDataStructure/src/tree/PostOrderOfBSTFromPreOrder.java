package tree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderOfBSTFromPreOrder {
	public void postOrderFromPreOrder(List<Integer> pre,int size){
		int root=pre.get(0);
		List<Integer> leftsubtree=new ArrayList<>();
		List<Integer> rightsubtree=new ArrayList<>();
		for(Integer i:pre){
			if(i<root)
				leftsubtree.add(i);
			else
				rightsubtree.add(i);
		}
		
		if(leftsubtree.size()!=0)
			postOrderFromPreOrder(leftsubtree,leftsubtree.size());
		
		if(rightsubtree.size()!=0)
			postOrderFromPreOrder(rightsubtree,rightsubtree.size());
		
		System.out.println(pre.get(0));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
