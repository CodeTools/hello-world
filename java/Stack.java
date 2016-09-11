import java.util.LinkedList;
import java.util.List;


/**
 *
 *
 *
 *
 **/
public class Stack<T>
{

	protected LinkedList<T> stack;
	protected Integer top;


	


	/**
	 *
	 *
	 *
	 **/
	public Stack()
	{
		stack = new LinkedList<T>();
		top = -1;
			
	}

	/**
	 *
	 *
	 *
	 *
	 **/
	public final boolean hasMore()
	{
		return top != -1;
	}


	

	/**
	 *
	 *
	 *
	 **/
	public final Integer top()
	{
		return top;
	}


	
	/**
	 *
	 *
	 *
	 **/
	public final T pop()
	{
		return stack.get(top--);
	}

	/**
	 *
	 *
	 *
	 **/
	public final void push(T element)
	{
		top++;
		stack.add(element);
	}

	/**
	 *
	 *
	 *
	 **/	
	public static void main(String [] args)
	{
		System.out.println("\r\nStack 1.0");
		Stack<Character> stack = new Stack<Character>();
		
		System.out.println("\r\nStack is empty." + (stack.hasMore() == false));

		stack.push('r');
                stack.push('a');
                stack.push('c');
                stack.push('e');
                stack.push('c');
                stack.push('a');
                stack.push('r');


		while(stack.hasMore()) System.out.println(stack.pop());

		
		System.out.println("\r\nStack is empty." + (stack.hasMore() == false));
		
	}
}