package tree;

import java.util.Arrays;

public class KruskalsAlgorithm {
	int V;
	int E;
	static Edge[] edge;
	
	static class Edge implements Comparable<Edge>{
		int src;
		int dest;
		int weight;
		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}	
	}
	
	public KruskalsAlgorithm(int v2, int e2) {
		V=v2;
		E=e2;
		edge=new Edge[E];
		for(int i=0;i<E;i++){
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
	
	static void KruskalMST(KruskalsAlgorithm graph){
		int[] parent=new int[graph.V];
		Edge[] result=new Edge[graph.V];
		for(int i=0;i<graph.V;i++){
			parent[i]=-1;
			result[i]=new Edge();
		}
		
		int r=0;
		int e=0;
		
		Arrays.sort(edge);
		
		while(e<=graph.V-1){
			int srcParent=find(parent, edge[e].src);
			int destParent=find(parent,edge[e].dest);
			
			if(srcParent!=destParent){
				result[r]=edge[e];
				union(parent,srcParent,destParent);
				r++;
			}
			
			e++;
		}
		
	}
	public static void main(String[] args) {
		int V=4;
		int E=5;
		KruskalsAlgorithm graph=new KruskalsAlgorithm(V,E);
		// add edge 0-1 
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
        graph.edge[0].weight = 10; 
  
        // add edge 0-2 
        graph.edge[1].src = 0; 
        graph.edge[1].dest = 2; 
        graph.edge[1].weight = 6; 
  
        // add edge 0-3 
        graph.edge[2].src = 0; 
        graph.edge[2].dest = 3; 
        graph.edge[2].weight = 5; 
  
        // add edge 1-3 
        graph.edge[3].src = 1; 
        graph.edge[3].dest = 3; 
        graph.edge[3].weight = 15; 
  
        // add edge 2-3 
        graph.edge[4].src = 2; 
        graph.edge[4].dest = 3; 
        graph.edge[4].weight = 4; 
  
        graph.KruskalMST(graph);
        //Arrays.sort(graph.edge);

	}

}
