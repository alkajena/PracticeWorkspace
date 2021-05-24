package tree;

public class PrimAlgPractice {
	
	static void PrimeMST(int[][] graph){
		int v=5;
		int[] parent=new int[v];
		boolean[] mst=new boolean[v];
		int[] key=new int[v];
		
		for(int i=0;i<v;i++){
			mst[i]=false;
			key[i]=Integer.MAX_VALUE;
		}
		
		key[0]=0;
		parent[0]=-1;
		for(int i=0;i<v;i++){
			int u=minValue(key,mst);
			mst[u]=true;
			for(int j=0;j<v;j++){
				if(graph[u][j]!=0 && mst[j]==false && graph[u][j]<key[j]){
					parent[j]=u;
					key[j]=graph[u][j];
				}
			}
			
		}
		
	}
	
	static int minValue(int[] key,boolean[] mst){
		int v=5;
		int min_index=-1;
		int min_value=Integer.MAX_VALUE;
		for(int i=0;i<v;i++){
			if(mst[i]==false && key[i]<min_value){
				min_value=key[i];
				min_index=i;
			}
		}
		return min_index;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
