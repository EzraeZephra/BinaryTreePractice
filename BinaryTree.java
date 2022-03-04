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
            while (tempNode.getRight() != null && tempNode.getLeft() != null) {
                if (((int)data >= (int)tempNode.getData()) && (tempNode.getRight() != null)) {
                    tempNode = tempNode.getRight();
                }
                else {
                    if (tempNode.getLeft() != null) {
                        tempNode = tempNode.getLeft();
                    }
                }
            }

            if ((int)data >= (int)tempNode.getData()) {
                tempNode.setRight(newNode);
            }
            else {
                tempNode.setLeft(newNode);
            }
        }
    }
}
