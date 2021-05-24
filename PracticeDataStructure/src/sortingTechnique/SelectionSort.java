package sortingTechnique;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr={4,3,2,10,12,15,6};
		int n=arr.length-1;
		for(int i=0;i<n;i++){
			int min_index=i;
			for(int j=i+1;j<n+1;j++){
				if(arr[min_index]>arr[j]){
					min_index=j;
				}
			}
			int temp=arr[min_index];
			arr[min_index]=arr[i];
			arr[i]=temp;
		}
		
		for(int x:arr)
			System.out.println(x);
	}

}
