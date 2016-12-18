// A linked list is said to contain a cycle if any node is visited more than once
// while traversing the list.

// Complete the function provided in the editor below. It has one parameter: a
// pointer to a Node object named that points to the head of a linked list. Your
// function must return a boolean denoting whether or not there is a cycle in
// the list. If there is a cycle, return true; otherwise, return false.

// Note: If the list is empty, head will be null.

import java.util.*;

public class LinkedListsDetectCycle {
  public static void main(String[] args) {
    Node n1 = new Node(1, null);
    Node n2 = new Node(1, null);
    Node n3 = new Node(1, null);
    n1.next = n2; n2.next = n3; n3.next = null;
    Node head = n1;

    System.out.println(hasCycle(head) ? "Has cycle" : "Does not have cycle");
  }

  public static boolean hasCycle(Node head) {
    if (head == null) return false;

    HashSet<Node> visited = new HashSet<Node>();

    Node curr = head;
    while (curr != null) {
      if (visited.contains(curr)) return true;
      visited.add(curr);
      curr = curr.next;
    }
    return false;
  }
}

class Node {
  public int data;
  public Node next;

  public Node(int d, Node n) {
    data = d; next = n;
  }
}
