package datastructures.tree.binarysearchtree;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(tree.root);

        tree.insert(47);
        tree.insert(21);
        tree.insert(76);
        tree.insert(18);
        tree.insert(52);
        tree.insert(82);
        tree.insert(27);

        System.out.println(tree.root.left.right.value);

        System.out.println(tree.recursiveContains(27));
        System.out.println(tree.recursiveContains(100));

        tree.recursiveInsert(99);

        System.out.println(tree.root.right.right.right.value);

        tree.recursiveDelete(52);
        System.out.println(tree.recursiveContains(52));

        System.out.println(tree.findMinimumValue(tree.root));

        System.out.println(tree.BFS());

        // DFS Preorder
        System.out.println(tree.DFSPreorder());

        System.out.println(tree.bfsPractice());

        System.out.println(tree.dfsPreorderPractice());

        //DFS Post order
        System.out.println(tree.DFSPostOrder());

        System.out.println(tree.DFSInOrder());
    }
}
