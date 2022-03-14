public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(100);
        tree.add(50);
        tree.add(51);
        tree.add(120);
        tree.add(111);
        tree.add(112);
        tree.add(250);
        tree.add(20);
        tree.add(21);
        tree.add(19);
        tree.add(251);
        tree.add(245);
        tree.add(256);
        tree.add(254);
        tree.printInOrder();
    }
}