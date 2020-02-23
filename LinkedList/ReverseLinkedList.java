package LinkedList;


public class ReverseLinkedList {
    public static class Node{
        private int val;
        private Node next;
        
        public Node(int val) {
            this.val = val;
        }
    }
    
    public static Node reverseList(Node head) {
        Node cur = null, pre = head.next;
        while(pre != null) {
            head.next = cur;
            cur = head;
            head = pre;
            pre = pre.next;
        }
        head.next = cur;
        return head;
    }
    
    // 双向链表
    public static class DoubleNode{
        private int val;
        private DoubleNode next;
        private DoubleNode last;
        
        public DoubleNode(int val) {
            this.val = val;
        }
    }
    
    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode curNode = null, preNode = head.next;
        while(preNode != null) {
            head.next = curNode;
            head.last = preNode;
            curNode = head;
            head = preNode;
            preNode = preNode.next;
        }
        head.next = curNode;
        head.last = preNode;
        return head;
    }
    
    // for test
    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.val + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.val + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkedList(head1);
        head1 = reverseList(head1);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(reverseList(head2));

    }

}
