package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class Queue {
	
	static int max=8;
	static int[] arr=new int[max];
	static int rear;
	static int front;
	
	static class QueueOperation{
		public QueueOperation(){
			rear=front=-1;
		}
		
		static boolean isEmpty(){
			if(front<0 || front>=rear)
				return true;
			return false;
		}
		
		static boolean isFull(){
			if(rear==max-1)
				return true;
			return false;
		}
		
		static void enQueue(int key){
			if(isFull())
				System.out.println("overflowing");
				
			else if(front==-1 && rear==-1){
				front=0;
				rear=0;
			}
			else
				rear++;
				
			arr[rear]=key;
		}
		
		static int deQueue(){
			int data = 0;
			if(isEmpty())
				System.out.println("underflowing");
			else{
				 data=arr[front];
				 front++;
			}
			return data;
		}
	}
	
	static class CircularQueue{
		
		public CircularQueue(){
			rear=front=-1;
		}
		static boolean isEmpty(){
			if(front<0)
				return true;
			return false;
		}
		
		static boolean isFull(){
			if((rear==max-1 && front==0) || (rear==front-1))
				return true;
			return false;
		}
		
		static void enQueue(int key){
			if(isFull())
				System.out.println("overflowing");
			else if(front==-1 && rear==-1){
				front=0;
				rear=0;
			}
			else if(rear==max-1 && front!=0)
				rear=0;
			else
				rear++;
				
			arr[rear]=key;
		}
		
		static int deQueue(){
			int data = 0;
			if(isEmpty())
				System.out.println("underflowing");
			else if(front==rear){
				data=arr[front];
				front=-1;
				rear=-1;
			}
			else if(front==max-1){
				data=arr[front];
				front=0;
			}
			else{
				data=arr[front];
				front++;
			}
			return data;
		}
	}
	
	static class Dequeue{
		public Dequeue(){
			front=rear=-1;
		}
		
		static boolean isEmpty(){
			if(front<0)
				return true;
			return false;
		}
		
		static boolean isFull(){
			if((rear==max-1 && front==0) || (rear==front-1))
				return true;
			return false;
		}
		 static void enqueueRear(int key){
			 if(isFull())
				 System.out.print("overflow");
			 else if(front==-1 && rear==-1){
				 front=0;
				 rear=0;
			 }
			 else if(rear==max-1 && front!=0)
				 rear=0;
			 else
				 rear++;
			 arr[rear]=key;
		 }
		 
		 static void enqueueFront(int key){
			 if(isFull())
				 System.out.print("overflow");
			 else if(front==-1 && rear==-1){
				 front=0;
				 rear=0;
			 }
			 else if(front==0)
				front=max-1;
			 else
				 front--;
			 arr[front]=key;
		 }
		 
		 static int dequeueRear(){
			 int data=0;
			 if(isEmpty()){
				 System.out.println("underflow");
			 }
			 else if(front==rear){
				 data=arr[rear];
				 front=-1;
				 rear=-1;
			 }
			 else if(rear==0){
				 data=arr[rear];
				 rear=max-1;
			 }
			 else{
				 data=arr[rear];
				 rear--;
			 }
			 return data;
		 }
		 static int dequeueFront(){
			 int data=0;
			 if(isEmpty()){
				 System.out.println("underflow");
			 }
			 else if(front==rear){
				 data=arr[rear];
				 front=-1;
				 rear=-1;
			 }
			 else if(front==max-1){
				 data=arr[rear];
				 front=0;
			 }
			 else{
				 data=arr[front];
				 front++;
			 }
			 return data;
		 }
		
	}
	public static void main(String[] args) throws IOException {
	/*	QueueOperation queue=new QueueOperation();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(6);
		queue.deQueue();
	for(int i=front;i<=rear;i++){
		System.out.println(arr[i]);
	}*/
	
/*	CircularQueue queue=new CircularQueue();
	queue.enQueue(1);
	queue.enQueue(2);
	queue.enQueue(3);
	queue.enQueue(4);
	queue.enQueue(5);
	queue.deQueue();
	queue.enQueue(8);
	queue.enQueue(6);
	queue.deQueue();
for(int i=front;i<=rear;i++){
	System.out.println(arr[i]);
}*/
		int x=36;
	
		String format=String.format("%%0%dd", 3);
		String result=String.format(format, x);
		System.out.println(result);
		
		String s="alka";
		int d=20;
		String format1=String.format("%"+d+"s", s);
		String result1=String.format(format1, s);
		System.out.println(format1);
		
		
		Integer i1=new Integer("10");
		Integer i2=i1;
		System.out.println(i1==i2);
		System.out.println(i1.equals(i2));
		
		TreeMap map=new TreeMap();
		map.put(100, "alka");
		map.put(200, "jena");
		map.put(400, 300);
		System.out.println(map);
		
		File file=new File("C:\\DHL\\newscpp\\alka.txt");
		FileReader reader=new FileReader(file);
		BufferedReader br=new BufferedReader(reader);
		String str;
		while((str=br.readLine())!=null){
			
			System.out.print(str);
		}
		
		int[] arr={1,2,3};
		int []arr1={4,5,6};
		int arr2[]={7,8,9};
		Integer[] a=new Integer[3];
		int[] b=new int[]{1,2,3};
		
		
		
		
		
	}

}
