public class Node<T extends Comparable<T>> 
{
	private Node<T> left;
	private Node<T> right;
	private Data<T> data;

	public Node()
	{
		left = null;
		right = null;
	}

	public Node(Data<T> data)
	{
		this.data = data;
	}


	public Node<T> getLeft() 
	{
		return left;
	}


	public Node<T> getRight() 
	{
		return right;
	}

	public void setLeft(Node<T> left)
	{
		this.left = left;
	}

	public void setRight(Node<T> right)
	{
		this.right = right;
	}


	public Data<T> getData()
	{
		return this.data;
	}

	public void setData(Data<T> data)
	{
		this.data = data;
	}

	public String toString() 
	{
		StringBuilder builder = new StringBuilder("");
		if(left != null) 
		{
			builder.append("left->"+left);
		}
		builder.append("data+>"+data);
		if(right != null)
		{
			builder.append("right->"+right);
		}
		return builder.toString();
	}	
}