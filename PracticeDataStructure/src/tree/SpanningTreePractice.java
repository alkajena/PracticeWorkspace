package tree;

public class SpanningTreePractice {
	static int v;
	static int e;
	static Edge[] edge;
	
	static class Edge{
		int src;
		int dest;
	}
	
	public SpanningTreePractice(int V,int E){
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
	static int findCycle(SpanningTreePractice graph){
		int[] parent=new int[graph.v];
		for(int i=0;i<graph.v;i++){
			parent[i]=-1;
		}
		for(Edge edge:edge){
			int srcParent=find(parent,edge.src);
			int destParent=find(parent,edge.dest);
			if(srcParent==destParent){
				return 1;
			}else{
				union(parent,edge.src,edge.dest);
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		SpanningTreePractice graph=new SpanningTreePractice(3,3);
		graph.edge[0].src=0;
		graph.edge[0].dest=1;
		graph.edge[1].src=1;
		graph.edge[1].dest=2;
		graph.edge[2].src=2;
		graph.edge[2].dest=0;
		if(findCycle(graph)==1){
			System.out.println("cycle found");
		}
		else{
			System.out.println("cycle not found");
		}
	}

}
