package iDK;

/**
 * Class represents a binary tree
 * Implements BinaryTreeInterface
 * Uses methods to manage, returning root, emptiness, height, and number of nodes
 */
public class BinaryTree<T> implements BinaryTreeInterface<T> {
    private BinaryNode<T> root;

    public BinaryTree() {
        root = null;
	//creates empty binary tree
    }

    @Override
    public void setTree(T rootData) {
        root = new BinaryNode<>(rootData);
	//sets tree with root data
    }

    @Override
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
        root = new BinaryNode<>(rootData,
                leftTree != null ? leftTree.getRootNode() : null,
                rightTree != null ? rightTree.getRootNode() : null);
	//sets tree with specific root data, left sub, and right sub
    }

    @Override
    public BinaryNode<T> getRootNode() {
        return root;
	//returns root node of tree
    }

    @Override
    public boolean isEmpty() {
        return root == null;
	//checks if tree is empty, returns true or false
    }

    @Override
    public int getHeight() {
        return root == null ? 0 : root.getHeight();
	//returns height ofthe tree
    }

    @Override
    public int getNumberOfNodes() {
        return root == null ? 0 : root.getNumberOfNodes();
	//returns number of nodes in the tree
    }

    @Override
    public void clear() {
        root = null;
	//sets root to null, clearing tree
    }
}
