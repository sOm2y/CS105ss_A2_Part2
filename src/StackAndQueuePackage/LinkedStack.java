package StackAndQueuePackage;import java.util.Stack;/*    An ReferenceBased Stack implementing StackInterface.	The stack stores entries in a chain of nodes.    COMPSCI 105	Assignment 2 - Part 2	Name: 	UPI: */public class LinkedStack<T> implements StackInterface<T>{	private StackNode<T> topNode; // references last node in the chain that is at the top of the Stack		public LinkedStack()	{		topNode = null;	} // end default constructor		public void push(T newEntry)	{		StackNode<T> newNode = new StackNode<T>(newEntry, topNode);		topNode = newNode;	} // end push	public T peek()	{		T top = null;				if (topNode != null)			top = topNode.getData();				return top;	} // end peek	public T pop()	{		T top = null;				if (topNode != null)      {			top = topNode.getData();	      topNode = topNode.getPreviousNode();       } // end if      	   return top;	} // end pop	public boolean isEmpty()	{		return topNode == null;	} // end isEmpty		public void clear()	{		topNode = null;		} // end clear	/*private class Node	//inner class Node	{      private T    data;     // entry in stack      private Node previous; // link to previous node      private Node(T dataValue)      {         data = dataValue;         previous = null;	      } // end constructor      private Node(T dataValue, Node linkValue)      {         data = dataValue;         previous = linkValue;	      } // end constructor      private T getData()      {         return data;      } // end getData      private void setData(T newData)      {         data = newData;      } // end setData      private Node getPreviousNode()      {         return previous;      } // end getPreviousNode      private void setPreviousNode(Node previousNode)      {         previous = previousNode;      } // end setPreviousNode	} // end Node*/} // end LinkedStack