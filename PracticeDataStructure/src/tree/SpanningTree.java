package tree;

public class SpanningTree {

	int V;
	int E;
	static Edge[] edge; 
	
	static class Edge{
		int src;
		int dest;
	}
	public  SpanningTree(int V,int E){
		this.V=V;
		this.E=E;
		edge=new Edge[E];
		for(int i=0;i<E;i++){
			edge[i]=new Edge();
		}
		
	}
	
	static int Find(int[] parent,int key){
		if(parent[key]==-1)
			return key;
		return Find(parent,parent[key]);
	}
	
	static void union(int[] parent,int src,int dest){
		parent[src]=dest;
	}
	
	static int findCycle(SpanningTree graph){
		int[] parent=new int[graph.V];
		
		for(int i=0;i<graph.V;i++){
			parent[i]=-1;
		}
		
		for(Edge edge:edge){
			int srcParent=Find(parent,edge.src);
			int destParent=Find(parent,edge.dest);
			
			if(srcParent==destParent)
				return 1;
			else{
				union(parent,edge.src,edge.dest);
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		SpanningTree graph=new SpanningTree(3,3);
		graph.edge[0].src=0;
		graph.edge[0].dest=1;
		graph.edge[1].src=1;
		graph.edge[1].dest=2;
		graph.edge[2].src=2;
		graph.edge[2].dest=0;
		int x=graph.findCycle(graph);
		if(x==1){
			System.out.println("cycle found");
		}
	}

}
