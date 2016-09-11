/**
 *
 *
 *
 *
 **/
public class MyQueue<T> extends Queue<T>
{
	public MyQueue()
	{
		
	}
	/**
 	 *
 	 *
 	 *
 	 *
 	 **/
	public static void main(String [] args)
	{
		System.out.println("\r\nQueue 1.0");	
		MyQueue<Integer> myQueue = new MyQueue<Integer>();
		System.out.println("\r\n Queue is empty :" + myQueue.isEmpty());
		for(int i=0;i<10;i++) myQueue.enqueue(i);
		while(myQueue.hasMore()) System.out.println(myQueue.dequeue());
		System.out.println("\r\n Queue is empty :" + myQueue.isEmpty());
	}
}