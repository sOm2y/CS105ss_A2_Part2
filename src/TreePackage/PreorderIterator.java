package TreePackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

import StackAndQueuePackage.LinkedStack;
import StackAndQueuePackage.StackInterface;

	public class PreorderIterator<T> implements Iterator<T>
	{
		private StackInterface<BinaryNodeInterface<T>> nodeStack;
		
		public PreorderIterator(BinaryNodeInterface<T> root)
		{
			nodeStack = new LinkedStack<BinaryNodeInterface<T>>();
			if (root != null)
				nodeStack.push(root);
		} // end default constructor
		
		public boolean hasNext() 
		{
			return !nodeStack.isEmpty();
		} // end hasNext
		
		public T next()
		{
			BinaryNodeInterface<T> nextNode;
			
			if (hasNext())
			{
				nextNode = nodeStack.pop();
				BinaryNodeInterface<T> leftChild = nextNode.getLeftChild();
				BinaryNodeInterface<T> rightChild = nextNode.getRightChild();
				
				// push into stack in reverse order of recursive calls
				if (rightChild != null)
					nodeStack.push(rightChild);
					
				if (leftChild != null)
					nodeStack.push(leftChild);
			}
			else
			{
				throw new NoSuchElementException();
			}
		
			return nextNode.getData();
		} // end next
	
		public void remove()
		{
			throw new UnsupportedOperationException();
		} // end remove
	} // end PreorderIterator