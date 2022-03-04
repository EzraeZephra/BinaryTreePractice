public class BinaryTree<T> {
    private TreeNode<T> root;

    public void add(T data) {
        if(root == null) {
            TreeNode<T> newNode = new TreeNode<>(data);
            root = newNode;
        }
        else {
            TreeNode<T> newNode = new TreeNode<>(data);
            TreeNode <T> tempNode = root;
            while (true) {
                if (((int)data >= (int)tempNode.getData()) && (tempNode.getRight() != null)) {
                    tempNode = tempNode.getRight();
                }
                else if ((int)data < (int)tempNode.getData() && tempNode.getLeft() != null) {
                    tempNode = tempNode.getLeft();
                }
                if (tempNode.getLeft() == null && (int)data < (int)tempNode.getData()) {
                    tempNode.setLeft(newNode);
                    break;
                }
                if (tempNode.getRight() == null && (int)data >= (int)tempNode.getData()) {
                    tempNode.setRight(newNode);
                    break;
                }
            }
        }
    }

    public boolean contains(TreeNode<T> subRoot, T data) {
        if (root == null) {
            return false;
        }
        else if (subRoot.getData() == data) {
            return true;
        }
        else {
            if ((int)data > (int)subRoot.getData()) {
                subRoot = subRoot.getRight();
            }
            else {
                subRoot = subRoot.getLeft();
            }
            return contains(subRoot, data);
        }
    }

    public TreeNode<T> getRoot() {
        return root;
    }
}
