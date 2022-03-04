public class BinaryTree<T extends Comparable<T>> {
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
                if ((data.compareTo(tempNode.getData()) >= 0) && (tempNode.getRight() != null)) {
                    tempNode = tempNode.getRight();
                }
                else if ((data.compareTo(tempNode.getData()) < 0) && tempNode.getLeft() != null) {
                    tempNode = tempNode.getLeft();
                }
                if (tempNode.getLeft() == null && (data.compareTo(tempNode.getData()) < 0)) {
                    tempNode.setLeft(newNode);
                    break;
                }
                if (tempNode.getRight() == null && (data.compareTo(tempNode.getData()) >= 0)) {
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
        else if (data.compareTo(subRoot.getData()) == 0) {
            return true;
        }
        else {
            if (data.compareTo(subRoot.getData()) >= 0) {
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
