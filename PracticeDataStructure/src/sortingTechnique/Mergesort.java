package sortingTechnique;

public class Mergesort {
	public static void sort(int[] arr,int l,int h){
		int m=l+(h-l)/2;
		if(l<h){
			sort(arr,l,m);
			sort(arr,m+1,h);
			merge(arr,l,m,h);
			
		}
	}
	public static void merge(int[] arr,int l,int m,int h){
		int lsize=m-l+1;
		int rsize=h-m;
		int[] lArr=new int[lsize];
		int[] rArr=new int[rsize];
		
		for(int i=0;i<lsize;i++){
			lArr[i]=arr[l+i];
		}
		
		for(int i=0;i<rsize;i++){
			rArr[i]=arr[m+1+i];
		}
		
		int i=0;
		int j=0;
		int k=l;
		
		while(i<lsize && j<rsize){
			if(lArr[i]<rArr[j]){
				arr[k]=lArr[i];
				i++;
			}
			else{
				arr[k]=rArr[j];
				j++;
			}
			k++;
		}
		
		while(i<lsize){
			arr[k]=lArr[i];
			i++;
			k++;
		}
		
		while(j<rsize){
			arr[k]=rArr[j];
			j++;
			k++;
		}
	}
	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7}; 
		sort(arr,0,arr.length-1);
		for(int x:arr){
			System.out.println(x);
		}
	}

}
