// For the purposes of this challenge, we define a binary search tree to be a
// binary tree with the following ordering properties:

// The data value of every node in a node's left subtree is less than the
// data value of that node.

// The data value of every node in a node's right subtree is greater than the
// data value of that node.

// Given the root node of a binary tree, can you determine if it's also a
// binary search tree?

import java.util.*;

public class BSTCheck {

  public static void main(String[] args) {
    // Test tree.
    Node n_1 = new Node(1, null, null);
    Node n_4 = new Node(4, null, null);
    Node n_6 = new Node(6, null, null);
    Node n_5 = new Node(5, n_1, n_4);
    Node n_2 = new Node(2, n_6, null);
    Node n_3 = new Node(3, n_5, n_2);
    Node parent = n_3;

    // Execute function.
    System.out.println(checkBST(parent) ? "Yes" : "No");
  }

    public static boolean checkBST(Node root) {
      // We need some more data to solve this.
      return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean check(Node root, int min, int max) {
      // No children to check. We good.
      if (root == null)
        return true;

      // We blew our cap!
      if (root.data <= min || root.data >= max)
        return false;

      // L children should fall between the current min and the parent (root) val.
      // R children should fall between the parent (root) val and the current max.
      return check(root.left, min, root.data) &&
        check(root.right, root.data, max);
    }
}

// Define the Node class.
class Node {
  public int data;
  public Node left;
  public Node right;

  public Node(int d, Node l, Node r) {
    data = d; left = l; right = r;
  }
}
