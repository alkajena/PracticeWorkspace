package sortingTechnique;

public class HeapSort {
	static void sort(int[] arr,int n){
		for(int i=n/2-1;i>=0;i--){
			hepify(arr,n,i);
		}
		
		for(int i=n-1;i>=0;i--){
			int temp=arr[i];
			arr[i]=arr[0];
			arr[0]=temp;
			
			hepify(arr,i,0);
		}
	}
	
	static void hepify(int[] arr,int n,int i){
		int largest=i;
		int l=2*i+1;
		int r=2*i+2;
		
		if(l<n && arr[l]>arr[largest]){
			largest=l;
		}
		
		if(r<n && arr[r]>arr[largest]){
			largest=r;
		}
		
		if(largest!=i){
			int temp=arr[i];
			arr[i]=arr[largest];
			arr[largest]=temp;
			
			hepify(arr,n,largest);
		}
		
	}
	public static void main(String[] args) {
		int[] arr={12, 11, 13, 5, 6, 7};
		 int n = arr.length; 
		 sort(arr, n); 
		 for(int x:arr){
			 System.out.println(x);
		 }

	}

}
