package LinkedList;

import java.util.HashSet;

import org.hibernate.hql.internal.ast.tree.LiteralNode;

public class CommonPart {
    private static class Node{
        int value;
        Node next;
        
        public Node(int val) {
            this.value = val;
        }
    }
    public static void commonPart(Node head1, Node head2) {
        HashSet<Node> linkSet = new HashSet<CommonPart.Node>();
        Node link1 = head1, link2 = head2;
        while(link1 != null) {
            linkSet.add(link1);
            link1 = link1.next;
        }
        while(link2 != null) {
            if(linkSet.contains(link2)) {
                while(link2 != null) {
                    System.out.println(link2.value);
                    link2 = link2.next;
                }
                break;
            }
            link2 = link2.next;
        }
    }
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        commonPart(node1, node2);

    }

}
