package tree;

import java.util.Arrays;

public class KruskalAlgPractice {
	static int v;
	static int e;
	static Edge[] edge;
	
	static class Edge implements Comparable<Edge>{
		 int src;
		 int dest;
		 int weight;
		@Override
		public int compareTo(Edge edge) {
			return this.weight-edge.weight;
		}
	}
	
	public KruskalAlgPractice(int V,int E){
		this.v=V;
		this.e=E;
		edge=new Edge[this.e];
		for(int i=0;i<this.e;i++){
			edge[i]=new Edge();
		}
	}
	static int find(int[] parent,int key){
		if(parent[key]==-1)
			return key;
		return find(parent,parent[key]);
	}
	static void union(int[] parent,int src,int dest){
		parent[src]=dest;
	}
	
	static void kruskalAlg(KruskalAlgPractice graph){
		int[] parent=new int[graph.v];
		Edge[] result=new Edge[graph.v];
		for(int i=0;i<graph.v;i++){
			parent[i]=-1;
			result[i]=new Edge();
		}
		Arrays.sort(graph.edge);
		int r=0;
		for(Edge edge:graph.edge){
			int srcParent=find(parent,edge.src);
			int destParent=find(parent,edge.dest);
			if(srcParent!=destParent){
				result[r]=edge;
				union(parent,edge.src,edge.dest);
				r++;	
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
