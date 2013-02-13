package TreePackage;/**	An interface for a binary decision tree.	COMPSCI 105	Assignment 2 - Part 2	Name: 	UPI: */public interface DecisionTreeInterface<T> extends BinaryTreeInterface<T>{   /* Gets the data in the current node */   public T getCurrentData();   /* Sets the data in the current node assuming the current node is not null */   public void setCurrentData(T newData);   /* Sets the data in the children of the current node, creating them if they do not exist */   public void setAnswers(T answerForNo, T answerForYes);   /* Checks whether the current node contains an answer. Returns true if the current node is a leaf, false otherwise */   public boolean isAnswer();   /* Sets the current node to its left child assuming the current node is not null.       If the child does not exist, sets the current node to null. */   public void advanceToNo();   /* Sets the current node to its right child assuming the current node is not null.       If the child does not exist, sets the current node to null*/   public void advanceToYes();   /* Makes the root of the tree the current node.*/   public void reset();} // end DecisionTreeInterface