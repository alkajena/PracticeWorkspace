package tree;

import javax.swing.text.html.MinimalHTMLWriter;

public class PrimsAlgorithm {
	
	static int minValue(int[] key,boolean[] MST){
		int V=5;
		int min=Integer.MAX_VALUE;
		int minIndex=-1;
		for(int i=0;i<V-1;i++){
			if(MST[i]==false && key[i]<min){
				min=key[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
	static void primsMST(int[][] graph){
		int V=5;
		int[] parent=new int[V];
		boolean[] MST=new boolean[V];
		int[] key=new int[V];
		
		for(int i=0;i<V;i++){
			MST[i]=false;
			key[i]=Integer.MAX_VALUE;
		}
		key[0]=0;
		parent[0]=-1;
		
		for(int count=0;count<V-1;count++){
			int u=minValue(key, MST);
			MST[u]=true;
			for(int v=0;v<V;v++){
				if(MST[v]==false && graph[u][v]!=0 && graph[u][v]<key[v]){
					parent[v]=u;
					key[v]=graph[u][v];
				}
			}
			
		}
		
		print(key,MST,parent);
	}
	
	static void print(int[] key,boolean[] MST,int[] parent){
		int V=5;
		for(int i=1;i<=V-1;i++){
			System.out.println(parent[i]+"--->"+i+" weight "+key[i]);
		}
	}
	public static void main(String[] args) {
		 int graph[][] = {{ 0, 2, 0, 6, 0 },{ 2, 0, 3, 8, 5 },{ 0, 3, 0, 0, 7 },{ 6, 8, 0, 0, 9 },{ 0, 5, 7, 9, 0 }};  
		 primsMST(graph);

	}

}
