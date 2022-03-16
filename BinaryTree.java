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

    public boolean inList(TreeNode<T> node, ArrayList<TreeNode<T>> list) {
        for (int i = 0; i < list.size(); i++) {
            if (node == list.get(i)) {
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
        ArrayList<TreeNode<T>> exhausted = new ArrayList<TreeNode<T>>();
        printRecursion(root, marked, exhausted);
    }

    public void printRecursion(TreeNode<T> node, ArrayList<TreeNode<T>> marked, ArrayList<TreeNode<T>> exhausted) {
        ArrayList<TreeNode<T>> tempList = marked;
        ArrayList<TreeNode<T>> exList = exhausted;
        if (node.getLeft() != null && (inList(node.getLeft(), marked) == false)) {
            printRecursion(node.getLeft(), tempList, exList);
        }
        else if (node.getRight() != null) {
            if (inList(node, exList) == false) {
                exList.add(node);
                System.out.print(node.getData() + ": ");
            }
            if (inList(node.getRight(), exList) == true) {
                marked.add(node);
            }
            if (inList(node.getRight(), tempList) == true) {
                tempList.add(node);
                printRecursion(root, tempList, exList);
            }
            else {
                printRecursion(node.getRight(), tempList, exList); 
            }
        }
        else if (node == getMax()) {
            System.out.print(node.getData());
        }
        else {
            marked.add(node);
            System.out.print(node.getData() + ": ");
            printRecursion(root, tempList, exList);
        }
    }

    public int size() {
        ArrayList<TreeNode<T>> marked = new ArrayList<TreeNode<T>>();
        ArrayList<TreeNode<T>> exhausted = new ArrayList<TreeNode<T>>();
        return sizeRecursion(root, marked, exhausted, 0);
    }

    public int sizeRecursion(TreeNode<T> node, ArrayList<TreeNode<T>> marked, ArrayList<TreeNode<T>> exhausted, int counter) {
        ArrayList<TreeNode<T>> tempList = marked;
        ArrayList<TreeNode<T>> exList = exhausted;
        int num = counter;
        if (node.getLeft() != null && (inList(node.getLeft(), marked) == false)) {
            return sizeRecursion(node.getLeft(), tempList, exList, num);
        }
        else if (node.getRight() != null) {
            if (inList(node, exList) == false) {
                exList.add(node);
                num++;
            }
            if (inList(node.getRight(), exList) == true) {
                marked.add(node);
            }
            if (inList(node.getRight(), tempList) == true) {
                tempList.add(node);
                return sizeRecursion(root, tempList, exList, num);
            }
            else {
                return sizeRecursion(node.getRight(), tempList, exList, num);
            }
        }
        else if (node != getMax()) {
            marked.add(node);
            num++;
            return sizeRecursion(root, tempList, exList, num);
        }
        else {
            num++;
            return num;
        }
    }
}
