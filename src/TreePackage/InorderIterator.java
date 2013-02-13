package TreePackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

import StackAndQueuePackage.LinkedStack;
import StackAndQueuePackage.StackInterface;

public class InorderIterator<T> implements Iterator<T>
	{
      private StackInterface<BinaryNodeInterface<T>> nodeStack;
      private BinaryNodeInterface<T> currentNode;

      public InorderIterator(BinaryNodeInterface<T> rootIterate)
      {
         nodeStack = new LinkedStack<BinaryNodeInterface<T>>();
         currentNode = rootIterate;
      } // end default constructor

      public boolean hasNext() 
      {
         return !nodeStack.isEmpty() || (currentNode != null);
      } // end hasNext

      public T next()
      {
         BinaryNodeInterface<T> nextNode = null;

         // find leftmost node with no left child
         while (currentNode != null)
         {
            nodeStack.push(currentNode);
            currentNode = currentNode.getLeftChild();
         } // end while

         // get leftmost node, then move to its right subtree
         if (!nodeStack.isEmpty())
         {
            nextNode = nodeStack.pop();
            assert nextNode != null; // since nodeStack was not empty
                                  // before the pop
            currentNode = nextNode.getRightChild();
         }
         else
            throw new NoSuchElementException();

         return nextNode.getData(); 
      } // end next

      public void remove()
      {
         throw new UnsupportedOperationException();
      } // end remove
	} // end InorderIterator