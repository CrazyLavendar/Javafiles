public class Tree {
    private TreeNode root;

    public void insert(int value) {

        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public TreeNode get(int value) {
        if (root != null)
            return root.get(value);
        return null;
    }

    public void travereInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    public TreeNode delete(TreeNode subtreeRoot, int value) {
        if (subtreeRoot == null)
            return subtreeRoot;
        if (value < subtreeRoot.getData()) {
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        } else if (value > subtreeRoot.getData()) {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        } else {
            // Cases 0 and 1: node to delete has 0 or 1 child(ren)
            if (subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild();
            } else if (subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();
            }

            // Case 3: node to delete has 2 children

            // replace with smallest on right subtree
            subtreeRoot.setData(subtreeRoot.getRightChild().min());

            // delete the node that u made root
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
        }
        return subtreeRoot;
    }

    public int min() {
        return root.min();
    }

    public int max() {
        return root.max();
    }

}
