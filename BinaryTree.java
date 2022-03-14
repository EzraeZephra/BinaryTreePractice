import java.util.ArrayList;

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

    public boolean contains(T data) {
        return containsRecursion(root, data);
    }

    public boolean containsRecursion(TreeNode<T> subRoot, T data) {
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
            return containsRecursion(subRoot, data);
        }
    }

    public boolean isMarked(TreeNode<T> node, ArrayList<TreeNode<T>> marked) {
        for (int i = 0; i < marked.size(); i++) {
            if (node == marked.get(i)) {
                return true;
            }
        }
        return false;
    }

    public TreeNode<T> getMax() {
        TreeNode<T> tempNode = root;
        while (tempNode.getRight() != null) {
            tempNode = tempNode.getRight();
        }
        return tempNode;
    }

    public void printInOrder() {
        ArrayList<TreeNode<T>> marked = new ArrayList<TreeNode<T>>();
        printRecursion(root, marked);
    }

    public void printRecursion(TreeNode<T> node, ArrayList<TreeNode<T>> marked) {
        ArrayList<TreeNode<T>> tempList = marked;
        if (node.getLeft() != null && (isMarked(node.getLeft(), marked) == false)) {
            printRecursion(node.getLeft(), tempList);
        }
        else if (node.getRight() != null) {
            if (isMarked(node, marked) == false) {
                System.out.print(node.getData() + ": ");
            }
            marked.add(node);
            printRecursion(node.getRight(), tempList);
        }
        else if (node == getMax()) {
            System.out.print(node.getData());
        }
        else {
            marked.add(node);
            System.out.print(node.getData() + ": ");
            printRecursion(root, tempList);
        }
    }
}
