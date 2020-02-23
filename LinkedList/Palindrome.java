package LinkedList;

import java.util.Stack;

import javax.persistence.criteria.CriteriaBuilder.In;
/*
 * 给定一个链表的头节点head，请判断该链表是否为回文结构，是返回true,否则返回false。
 */
public class Palindrome {
    public static class Node{
        int value;
        Node nextNode;
        
        public Node(int val) {
            this.value = val;
        }
    }
    // 为了达到逆序，链表的值先全部放到栈，再依次取出判断.
    // 额外空间：O(n)
    public static boolean palindrome1(Node head) {
        if(head ==null || head.nextNode == null) return true;
        Stack<Integer> stack = new Stack<Integer>();
        Node pNode = head;
        while(pNode != null) {
            stack.add(pNode.value);
            pNode =pNode.nextNode;
        }
        pNode = head;
        while(pNode != null) {
            if(pNode.value != stack.pop()) return false;
            pNode =pNode.nextNode;
        }
        return true;
    }
    // 改进额外空间：设置快慢指针，慢指针每次走一步，快指针每次走两步，当快指针走到尽头时，慢指针刚好走到一半，将后面的节点值放入栈，再依次拿出与前面比较
    // 额外空间：O(n/2)
    public static boolean palindrome2(Node head) {
        if(head ==null || head.nextNode == null) return true;
        Node fastNode = head, slowNode = head;
        Stack<Integer> stack = new Stack<Integer>();
        while(fastNode != null && fastNode.nextNode != null) {
            fastNode = fastNode.nextNode.nextNode;
            slowNode = slowNode.nextNode;
        }
        if(fastNode != null) slowNode = slowNode.nextNode;
        while(slowNode != null) {
            stack.add(slowNode.value);
            slowNode = slowNode.nextNode;
        }
        slowNode = head;
        while(!stack.isEmpty()) {
            if(slowNode.value != stack.pop()) return false;
            slowNode = slowNode.nextNode;
        }
        return true;
    }
    // 改进额外空间，使其达到O(1)：先将链表后半部分逆序，再进行比较，最后将链表还原。
    public static boolean palindrome3(Node head) {
        if(head ==null || head.nextNode == null) return true;
        Node fastNode = head, slowNode = head;
        Stack<Integer> stack = new Stack<Integer>();
        while(fastNode != null && fastNode.nextNode != null) {
            fastNode = fastNode.nextNode.nextNode;
            slowNode = slowNode.nextNode;
        }
        if(fastNode != null) slowNode = slowNode.nextNode;
        slowNode = reverseLink(slowNode);
        Node head2 = slowNode;//记录后半部分逆序链表的头部
        fastNode = head; // 复用fastNode指针重新从头进行挨个遍历与后半部分比较，此处节省一个变量，但是可读性不好，可以再创建一个变量进行遍历达到比较目的
        while(slowNode != null) {
            if(slowNode.value != fastNode.value) {
                reverseLink(head2);
                return false;
            }
            slowNode = slowNode.nextNode;
            fastNode = fastNode.nextNode;
        }
        reverseLink(head2);
        return true;
    }
    // 将给定链表逆序
    public static Node reverseLink(Node head) {
        Node curNode = null, preNode = head.nextNode;
        while(preNode != null) {
            head.nextNode = curNode;
            curNode = head;
            head = preNode;
            preNode = preNode.nextNode;
        }
        head.nextNode = curNode;
        return head;
    }
    
    // the following is just for test
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.nextNode;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(palindrome1(head) + " | ");
        System.out.print(palindrome2(head) + " | ");
        System.out.println(palindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(palindrome1(head) + " | ");
        System.out.print(palindrome2(head) + " | ");
        System.out.println(palindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.nextNode = new Node(2);
        printLinkedList(head);
        System.out.print(palindrome1(head) + " | ");
        System.out.print(palindrome2(head) + " | ");
        System.out.println(palindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.nextNode = new Node(1);
        printLinkedList(head);
        System.out.print(palindrome1(head) + " | ");
        System.out.print(palindrome2(head) + " | ");
        System.out.println(palindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.nextNode = new Node(2);
        head.nextNode.nextNode = new Node(3);
        printLinkedList(head);
        System.out.print(palindrome1(head) + " | ");
        System.out.print(palindrome2(head) + " | ");
        System.out.println(palindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.nextNode = new Node(2);
        head.nextNode.nextNode = new Node(1);
        printLinkedList(head);
        System.out.print(palindrome1(head) + " | ");
        System.out.print(palindrome2(head) + " | ");
        System.out.println(palindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.nextNode = new Node(2);
        head.nextNode.nextNode = new Node(3);
        head.nextNode.nextNode.nextNode = new Node(1);
        printLinkedList(head);
        System.out.print(palindrome1(head) + " | ");
        System.out.print(palindrome2(head) + " | ");
        System.out.println(palindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.nextNode = new Node(2);
        head.nextNode.nextNode = new Node(2);
        head.nextNode.nextNode.nextNode = new Node(1);
        printLinkedList(head);
        System.out.print(palindrome1(head) + " | ");
        System.out.print(palindrome2(head) + " | ");
        System.out.println(palindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.nextNode = new Node(2);
        head.nextNode.nextNode = new Node(3);
        head.nextNode.nextNode.nextNode = new Node(2);
        head.nextNode.nextNode.nextNode.nextNode = new Node(1);
        printLinkedList(head);
        System.out.print(palindrome1(head) + " | ");
        System.out.print(palindrome2(head) + " | ");
        System.out.println(palindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }

}
