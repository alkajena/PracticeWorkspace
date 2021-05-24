package tree;

public class HeapTree {
	static int size=0;
	static int[] heap;
	
	public HeapTree(int size){
		heap=new int[size];
		heap[0]=Integer.MAX_VALUE;
	}
	
	static int parent(int pos){
		return pos/2;
	}
	
	static int leftChild(int pos){
		return 2*pos;
	}
	
	static int rightChild(int pos){
		return 2*pos+1;
	}
	
	static void swap(int x,int y){
		int temp=heap[x];
		heap[x]=heap[y];
		heap[y]=temp;
	}
	
	static void insert(int data){
		heap[++size]=data;
		int current=size;
		while(heap[current]>heap[parent(current)]){
			swap(current,parent(current));
			current=parent(current);
		}
	}
	static void hepify(int size,int i){
		int largest=i;
		int l=2*i;
		int r=2*i+1;
		
		if(l<size && heap[l]>heap[largest])
			largest=l;
		if(r<size && heap[r]>heap[largest])
			largest=r;
		
		if(largest!=i){
			int temp=heap[largest];
			heap[largest]=heap[i];
			heap[i]=temp;
			hepify(size,largest);
		}
		
	}
	static void deletion(int data){
		int i=0;
		for(i=0;i<size;i++){
			if(data==heap[i]){
				heap[i]=heap[size--];
				break;
			}
		}
		hepify(size,i);
		print();
	}
	
	static void print(){
		for(int i=1;i<size/2;i++){
			System.out.println("parent "+heap[i]+" left child "+heap[2*i]+" right child "+heap[2*i+1]);
		}
	}
	public static void main(String[] args) {
		 HeapTree maxHeap = new HeapTree(15); 
	        maxHeap.insert(5); 
	        maxHeap.insert(3); 
	        maxHeap.insert(17); 
	        maxHeap.insert(10); 
	        maxHeap.insert(84); 
	        maxHeap.insert(19); 
	        maxHeap.insert(6); 
	        maxHeap.insert(22); 
	        maxHeap.insert(9); 
		//tree.insertion(3);
		print();

	}

}
