public class CustomTree {
    TreeNode root;

    CustomTree() {
        root = null;
    }

    void insert(int value) {
        root = insert(root, value);
    }

    public TreeNode insert(TreeNode root, int value) {

        if (root == null) {
            root = new TreeNode(value);
            return root;
        } else if (root.data > value) {
            root.leftChild = insert(root.leftChild, value);

        } else {
            root.rightChild = insert(root.rightChild, value);
        }
        return root;
    }

    public TreeNode get(int value) {
        return get(root, value);
    }

    public TreeNode get(TreeNode pointer, int value) {

        if (value == pointer.data)
            return pointer;
        else if (value < pointer.data && pointer.leftChild != null)
            return get(pointer.leftChild, value);
        else if (value > pointer.data && pointer.rightChild != null) // can also write : else if (pointer.rightChild !=
                                                                     // null)
            return get(pointer.rightChild, value);

        return null;

    }

    public void delete(int value) {
        root = delete(root, value);
    }

    public TreeNode delete(TreeNode pointer, int value) {
        if (pointer == null)
            return pointer;
        else if (value < pointer.data)
            pointer.leftChild = delete(pointer.leftChild, value);
        else if (value > pointer.data)
            pointer.rightChild = delete(pointer.rightChild, value);
        else {
            if (pointer.leftChild == null)
                return pointer.rightChild;
            else if (pointer.rightChild == null)
                return pointer.leftChild;

            pointer.data = min(pointer.rightChild);
            pointer.rightChild = delete(pointer.rightChild, pointer.data);
        }

        return pointer;

    }

    void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traverseInOrder(TreeNode root) {
        if (root.leftChild != null) {
            traverseInOrder(root.leftChild);
        }
        System.out.print(root.data + ", ");
        if (root.rightChild != null) {
            traverseInOrder(root.rightChild);
        }
    }

    int min() {
        return min(root);
    }

    public int min(TreeNode pointer) {
        while (pointer.leftChild != null)
            pointer = pointer.leftChild;
        return pointer.data;
    }

    int max() {
        return max(root);
    }

    public int max(TreeNode pointer) {
        while (pointer.rightChild != null)
            pointer = pointer.rightChild;
        return pointer.data;
    }
}
