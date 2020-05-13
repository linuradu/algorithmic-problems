package hackerrank.datastructures;

public class BinarySearchTree {

    /*
    Given the Root Node, return if is on not a correct binary tree
     */
    class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {
        return recursiveCheck(root, -1, 10001);
    }

    boolean recursiveCheck(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        return (root.data > min && root.data < max) &&
                (recursiveCheck(root.left, min, root.data) && recursiveCheck(root.right, root.data, max));

    }
}
