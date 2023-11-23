package iDK;

/**
 * Each node contains data from reserved words or identfiers
 * Class has methods to return data, set data, return left and right children, return heigh, return # of nodes, and to check if the node is a leaf, or has children
 */
public class BinaryNode<T> {
    private T data;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;
	// a node in a binary tree used for the Parser

    public BinaryNode(T data) {
        this(data, null, null);
	// constructs a binaryNode node with no children
    }

    public BinaryNode(T data, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
	// creates BinaryNode with references to left and right childrens
    }

    public T getData() {
        return data;
    }
	//returns data in node

    public void setData(T data) {
        this.data = data; 
	//sets the data of the node
    }

    public BinaryNode<T> getLeftChild() {
        return leftChild;
	//returns left child node
    }

    public void setLeftChild(BinaryNode<T> leftChild) {
        this.leftChild = leftChild;
	//sets left child node
    }

    public BinaryNode<T> getRightChild() {
        return rightChild;
	//returns right child node
    }

    public void setRightChild(BinaryNode<T> rightChild) {
        this.rightChild = rightChild; 
	//sets the rght child node
    }

    public int getHeight() {
        return isLeaf() ? 1 : Math.max(leftChild != null ? leftChild.getHeight() : 0, rightChild != null ? rightChild.getHeight() : 0) + 1;
	//returns height of node
    }

    public int getNumberOfNodes() {
        return (leftChild != null ? leftChild.getNumberOfNodes() : 0) + (rightChild != null ? rightChild.getNumberOfNodes() : 0) + 1;
	//returns number of nodes in subtree, at the current node
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null; 
	//checks if node s a leaf (has no children), returns true or false
    }

    public boolean hasLeftChild() {
        return leftChild != null; 
	//checks if node has left child, returns true or false
    }

    public boolean hasRightChild() {
        return rightChild != null; 
	//checks if node has a right child, returns true or false
    }
}
