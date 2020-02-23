package LinkedList;

/*
 * 给定一个单向链表的表头head，节点的值是整型，再给定一个整数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于pivot的节点，中间部分都是等于pivot的节点。
 * 右部分都是大于pivot的节点，对于每个部分的节点顺序无要求
 * 
 * 进阶：在原问题的要求上再加两个要求：在左中右三个部分的内部也做顺序要求，要求每个部分的节点从左到右的顺序与原链表中节点的先后顺序一致。
 * 如果链表长度为N，时间复杂度要求为O(N),额外空间复杂度为O(1)
 */
public class SmallEqualBig {
    public static class Node{
        private int value;
        private Node next;
        
        public Node(int val) {
            this.value = val;
        }
    }
    
    public static Node smallEqualBig(Node head, int pivot) {
        Node maxNode = new Node(-1), minNode = new Node(-1), equalNode = new Node(-1);
        Node headmaxNode = maxNode, headminNode = minNode, headequalNode = equalNode;
        while(head != null) {
            if(head.value > pivot) {
                maxNode.next = head;
                maxNode = maxNode.next;
            }else if (head.value < pivot) {
                minNode.next = head;
                minNode = minNode.next;
            }else {
                equalNode.next = head;
                equalNode = equalNode.next;
            }
            head = head.next;
        }
        maxNode.next = null;
        if(headminNode.next != null && headequalNode.next != null) {
            minNode.next = headequalNode.next;
            equalNode.next = headmaxNode.next;
            return headminNode.next;
        }else if (headminNode.next != null && headequalNode.next == null) {
            minNode.next = headmaxNode.next;
            return headmaxNode.next;
        }else if (headminNode.next == null && headequalNode.next != null) {
            equalNode.next = headmaxNode.next;
            return headequalNode.next;
        }else {
            return headmaxNode.next;
        }
    }
    
    // just for test
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = smallEqualBig(head1, 5);
        printLinkedList(head1);

    }

}
