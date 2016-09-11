import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 *
 *
 *
 **/
public class Queue<T>
{

	protected List<T> list;
	protected int start = -1;
	protected int end = -1;


	/**
	 *
	 *
 	 *
	 **/
	public Queue()
	{
		list = new LinkedList<T>();
	}

	
	/**
	 *
	 *
	 *
	 **/
	public final void enqueue(T element)
	{
		list.add(element);
		if(start < 0 ) start++;
		end++;
	}

	
	/**
	 *
	 *
	 *
	 **/
	public final T dequeue()
	{
		T element = list.get(start);
		end--;
		list.remove(start);
		if(end < 0) start--;
		return element;
	}

	
	/**
	 *
	 *
	 **/
	public final boolean hasMore()
	{
		return (end > -1) || !(start == end); // if start and end of queue are same there are no more elements
	}


	/**
	 *
	 *
	 **/
	public final boolean isEmpty() 
	{
		return (start == -1) && (start == end);
	}


	/**
	 *
	 *
	 **/
	public static void main(String [] args)
	{
		System.out.println("\r\nQueue 1.0");	
		Queue<Character> myQueue = new Queue<Character>();
		System.out.println("\r\n Queue is empty :" + myQueue.isEmpty());
		myQueue.enqueue('r');
		myQueue.enqueue('a');
		myQueue.enqueue('c');
		myQueue.enqueue('e');
		myQueue.enqueue('c');
		myQueue.enqueue('a');
		myQueue.enqueue('r');
		while(myQueue.hasMore()) System.out.println(myQueue.dequeue());
		System.out.println("\r\n Queue is empty :" + myQueue.isEmpty());
	}
	
}