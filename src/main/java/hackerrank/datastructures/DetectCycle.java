package hackerrank.datastructures;

public class DetectCycle {

    class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {

        Node fast = head;
        while (fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;

            if (head == fast) {
                return true;
            }
        }

        return false;

    }
}
