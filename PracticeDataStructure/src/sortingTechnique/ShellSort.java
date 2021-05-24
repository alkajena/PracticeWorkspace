package sortingTechnique;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr={12, 34, 54, 2, 3,84,1,13,76,50};
		int size=arr.length;
		for(int i=size/2;i>0;i=i/2){
			for(int j=i;j<size;j++){
				int k=j-i;
				while(k>=0){
					if(arr[k+i]<arr[k]){
						int temp=arr[k];
						arr[k]=arr[k+i];
						arr[k+i]=temp;
					}
					k--;
				}
			}
		}
		
	for(int x:arr)
		System.out.println(x);

	}

}
