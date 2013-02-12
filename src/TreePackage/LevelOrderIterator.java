package TreePackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

import StackAndQueuePackage.LinkedQueue;
import StackAndQueuePackage.QueueInterface;

public class LevelOrderIterator<T> implements Iterator<T>
	{
		private QueueInterface<BinaryNodeInterface<T>> nodeQueue;
		
		public LevelOrderIterator(BinaryNodeInterface<T> root)
		{
			nodeQueue = new LinkedQueue<BinaryNodeInterface<T>>();
			if (root != null)
				nodeQueue.enqueue(root);
		} // end default constructor
		
		public boolean hasNext() 
		{
			return !nodeQueue.isEmpty();
		} // end hasNext
		
		public T next()
		{
			BinaryNodeInterface<T> nextNode;
			
			if (hasNext())
			{
				nextNode = nodeQueue.dequeue();
				BinaryNodeInterface<T> leftChild = nextNode.getLeftChild();
				BinaryNodeInterface<T> rightChild = nextNode.getRightChild();
				
				// add to queue in order of recursive calls
				if (leftChild != null)
					nodeQueue.enqueue(leftChild);

				if (rightChild != null)
					nodeQueue.enqueue(rightChild);
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
	} // end LevelOrderIterator