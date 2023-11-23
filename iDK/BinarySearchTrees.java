package iDK;

/**
 * This class implements the SearchTreeInterface
 * Has methods to check if the tree is empty, get the height of tree, get # of nodes, clear the tree, check if it contains a specfic entry, get the entry, add/remove entries, and perform in-order traversal
 */
public class BinarySearchTrees<T extends Comparable<? super T>> implements SearchTreeInterface<T> {
    private BinaryNode<T> root;

    public BinarySearchTrees() {
        root = null;
	//creates empty BinarySearchTrees instance
    }

    public BinarySearchTrees(T rootData) {
        root = new BinaryNode<>(rootData);
	//creates BinarySearchTrees instance with a specific root
    }

    @Override
    public boolean isEmpty() {
        return root == null;
	//checks if tree is empty, returns true or false
    }

    @Override
    public int getHeight() {
        return root == null ? 0 : root.getHeight();
	//returns height of the tree
    }

    @Override
    public int getNumberOfNodes() {
        return root == null ? 0 : root.getNumberOfNodes();
	//returns the # of nodes in the tree
    }

    @Override
    public void clear() {
        root = null;
	//sets root to null, clearing tree
    }

    @Override
    public boolean contains(T entry) {
        return getEntry(entry) != null;
	//checks if tree contains entry, returns entry, or false
    }

    @Override
    public T getEntry(T entry) {
        return findEntry(root, entry);
	// returns entr from tree, or returns null
    }

    @Override
    public T add(T newEntry) {
        root = addEntry(root, newEntry);
        return newEntry;
	// Adds entry to the tree, returns the entry
    }

    @Override
    public T remove(T entry) {
        return removeEntry(root, entry);
	// Removes entry from tree, and returns the removed entry
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
	//in-order traversal (left -> current -> right); prints each element traversed
    }

    private T findEntry(BinaryNode<T> rootNode, T entry) {
        if (rootNode == null) {
            return null;
        }

        int comparison = compareEntries(entry, rootNode.getData());

        if (comparison == 0) {
            return rootNode.getData();
        } else if (comparison < 0) {
            return findEntry(rootNode.getLeftChild(), entry);
        } else {
            return findEntry(rootNode.getRightChild(), entry);
	//searches for an entry in the tree, and returns the entry, or null
        }
    }

    private BinaryNode<T> addEntry(BinaryNode<T> rootNode, T newEntry) {
        if (rootNode == null) {
            return new BinaryNode<>(newEntry);
        }

        int comparison = compareEntries(newEntry, rootNode.getData());

        if (comparison < 0) {
            rootNode.setLeftChild(addEntry(rootNode.getLeftChild(), newEntry));
        } else if (comparison > 0) {
            rootNode.setRightChild(addEntry(rootNode.getRightChild(), newEntry));
        }

        return rootNode;
	//adds a new entry to the tree, and returns the root of the subtree
    }

    private T removeEntry(BinaryNode<T> rootNode, T entry) {
        if (rootNode == null) {
            return null;
        }

        int comparison = compareEntries(entry, rootNode.getData());

        if (comparison == 0) {
            T data = rootNode.getData();
            rootNode = removeFromRoot(rootNode);
            return data;
        } else if (comparison < 0) {
            rootNode.setLeftChild(removeEntry(rootNode.getLeftChild(), entry));
        } else {
            rootNode.setRightChild(removeEntry(rootNode.getRightChild(), entry));
        }

        return rootNode.getData();
	//removes a specifc entry from the tree, using root of subtree, and returnng the removed entry
    }

    private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode) {
        if (rootNode.isLeaf()) {
            return null;
        } else if (rootNode.hasLeftChild() && rootNode.hasRightChild()) {
            T replacement = findLargest(rootNode.getLeftChild());
            rootNode.setData(replacement);
            rootNode.setLeftChild(removeLargest(rootNode.getLeftChild()));
        } else {
            return (rootNode.hasLeftChild()) ? rootNode.getLeftChild() : rootNode.getRightChild();
        }

        return rootNode;
	// removes a node from root, and returns the root after removal
    }

    private T findLargest(BinaryNode<T> rootNode) {
        return (rootNode.hasRightChild()) ? findLargest(rootNode.getRightChild()) : rootNode.getData();
	//returns the largest entry in the subtree
    }

    private BinaryNode<T> removeLargest(BinaryNode<T> rootNode) {
        return (rootNode.hasRightChild()) ? removeLargest(rootNode.getRightChild()) : rootNode.getLeftChild();
	//removes largest entry from current subtree; returns the root after removal
    }

    private void inOrderTraversal(BinaryNode<T> node) {
        if (node != null) {
            inOrderTraversal(node.getLeftChild());
            System.out.println(node.getData());
            inOrderTraversal(node.getRightChild());
	//in-order traversal (left -> current -> right) of root of current subtree; prints each element
	
        }
    }

    private int compareEntries(T entry1, T entry2) {
        return entry1.compareTo(entry2); 
	//compares entry1 to entry2, and returns negative if entry1 is less than, 0 if equal to, or positive if greater than entry2
    }
}
