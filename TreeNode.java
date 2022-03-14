public class TreeNode<T> {
    T data;
    private TreeNode<T> left;
    private TreeNode<T> right;
    public Object getLeft;

    public TreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public String toString() {
        return "TreeNode:" + " data=" + data + ", right=" + right + ", left=" + left;
    }
}