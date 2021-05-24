package sortingTechnique;

public class QuickSort {
	static void sort(int[] arr,int l,int h){
		if(l<h){
			int index=partition(arr,l,h);
			sort(arr,l,index-1);
			sort(arr,index+1,h);
		}
	}
	
	static int partition(int[] arr,int l,int h){
		int pivot=arr[h];
		int i=l-1;
		for(int j=l;j<h;j++){
			if(arr[j]<pivot){
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[h];
		arr[h]=temp;
		
		return i+1;
	}
	public static void main(String[] args) {
		int[] arr={1,2,3,4,5};
		 int n = arr.length; 
		 sort(arr, 0, n-1); 
		 for(int x:arr){
			 System.out.println(x);
		 }
	}

}
