package sortingTechnique;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr={4,3,2,10,12,15,6};
		for(int i=1;i<arr.length;i++){
			int j=i-1;
			while(j>=0){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
				j--;
			}
		}
		for(int x:arr){
			System.out.println(x);
		}

	}

}
