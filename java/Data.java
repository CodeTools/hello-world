public class Data<T extends Comparable<T>> implements Comparable<T>
{
	private T data;


	public Data()
	{
		this.data = null;
	}

	public Data(T data)
	{
		this.data = data;
	}
	
	public T get() 
	{
		return this.data;
	}

	public void set(T data) 
	{
		this.data = data;
	}

	public String toString() 
	{
		StringBuilder builder = new StringBuilder("");		
		builder.append("data+>"+data);		
		return builder.toString();
	}

	public int compareTo(T otherData) 
	{
		return data.compareTo(otherData);				
	}
	
}