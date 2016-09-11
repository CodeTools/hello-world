/**
 *
 *
 *
 *
 **/
public class Tree<T extends Comparable<T>>
{

	private Node<T> root;

	
	/**
	 *
	 *
	 *
	 *
	 **/
	public Tree(Node<T> root)
	{
		this.root = root;
	}

	/**
	 *
	 *
	 *
	 *
	 **/
	public Tree() 
	{
		this.root = null;
	}



	/**
	 *
	 *
	 *
	 *
	 **/
	public void inOrder(Node<T> root)
	{
		if(root != null)
		{	
			inOrder(root.getLeft());
			System.out.println(root.getData().get());
			inOrder(root.getRight());
		}		
	}

	/**
	 *
	 *
	 *
	 *
	 **/
	public void inOrder() 
	{
		if(this.root != null)
		{
			inOrder(this.root);
		}	
	}

	/**
	 *
	 *
	 *
	 *
	 **/
	public Integer height(Node<T> root)
	{
		if(root != null)
		{
			return Math.max(height(root.getLeft()), height(root.getRight())) + 1;				
		}
		else 
		{
			return 0;
		}
	}	



	public static void main(String [] args)
	{
		System.out.println("\r\nTree");
		Node<Integer> root = new Node<Integer>(new Data<Integer>(0));
		Node<Integer> previous = null;
		Node<Integer> node = null;
		for(int counter=1;counter<22;counter++)
		{
			node = new Node<Integer>(new Data<Integer>(counter));
			if(previous != null)
			{
				if(node.getData().get().compareTo(previous.getData().get()) <= 0)
					node.setRight(previous);
				else
					node.setLeft(previous);
			}			
			previous = node;
		}
		root.setRight(node);		
		Tree<Integer> tree = new Tree<Integer>(root);
		tree.inOrder(root);
		System.out.println("\r\n");
		tree.inOrder();
		System.out.println("\r\n");
		Integer height  = tree.height(root);
		System.out.println("\r\nHeight = " + height);
	}			
}