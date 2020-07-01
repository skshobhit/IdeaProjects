public class LinkedListRemoveDuplicates {
    static class Node<ListNode> {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }




    static void removeDuplicates(Node head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.val == temp.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
    public static void main(String[] args) {
        Node n1 = new Node(12);
        Node n2
    }
}
