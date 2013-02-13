package TreePackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

import StackAndQueuePackage.LinkedStack;
import StackAndQueuePackage.StackInterface;

public class PostorderIterator<T> implements Iterator<T>
	{
		private StackInterface<BinaryNodeInterface<T>> nodeStack;
		private BinaryNodeInterface<T> currentNode;
		
		public PostorderIterator(BinaryNodeInterface<T> root)
		{
			nodeStack = new LinkedStack<BinaryNodeInterface<T>>();
			currentNode = root;
		} // end default constructor
		
		public boolean hasNext() 
		{
			return !nodeStack.isEmpty() || (currentNode != null);
		} // end hasNext
		
		public T next()
		{
			boolean foundNext = false;
			BinaryNodeInterface<T> leftChild, rightChild, nextNode = null;
			
			// find leftmost leaf
			while (currentNode != null)
			{
				nodeStack.push(currentNode);
				leftChild = currentNode.getLeftChild();
				if (leftChild == null)	
					currentNode = currentNode.getRightChild();
				else
					currentNode = leftChild;
			} // end while
			
			// stack is not empty either because a node was just pushed, or
			// it wasn't empty to begin with since hasNext() is true.
			// The Iterator specifies an exception for next() in case
			// hasNext() is false.
			
			if (!nodeStack.isEmpty())
			{
				nextNode = nodeStack.pop();
				// nextNode != null since stack was not empty before pop

				BinaryNodeInterface<T> parent = nodeStack.peek();
				
				if (parent != null && nextNode == parent.getLeftChild())
					currentNode = parent.getRightChild();	
				else
					currentNode = null;
			}
			else
			{
				throw new NoSuchElementException();
			} // end if
			
			return nextNode.getData();
		} // end next

		public void remove()
		{
			throw new UnsupportedOperationException();
		} // end remove
	} // end PostorderIterator