package LinkedList;

import java.util.HashMap;

/*
 * 复制含有随机指针节点的链表
 * 一种特殊的链表结构如下：
 * public class Node{
 *      private int value;
 *      private Node next;
 *      private Node random;
 *      
 *      public Node(int value){
 *          this.value = value;
 *      }
 * }
 * next指针指向下一个节点，rand指针是Node类中新增的指针，这个指针可能指向 链表中的任意一个节点，也可能指向Null。给定一个由Node节点类型组成的
 * 无环单链表的头节点head，请实现一个函数完成这个链表中所有结构的复制，并返回复制的新链表的头节点。
 * 
 * 进阶：额外空间复杂度为O(1)，时间复杂度为O(N)
 */
public class CopyWithRandomNode {
    public static class Node{
              private int value;
              private Node next;
              private Node random;
              
              public Node(int value){
                  this.value = value;
              }
         }
    // 使用hashmap存储新旧节点，hashmap单个数据的存取时间都是常数
    public static Node copyWithRandomNode1(Node head) {
        if(head == null) return null;
        HashMap<Node, Node> nodeMap = new HashMap<CopyWithRandomNode.Node, CopyWithRandomNode.Node>();
        Node pNode = head;
        while(pNode != null) {
                nodeMap.put(pNode, new Node(pNode.value));
                pNode = pNode.next;
            }
        pNode = head;
        while(pNode != null) {
            nodeMap.get(pNode).next = nodeMap.get(pNode.next);
            nodeMap.get(pNode).random = nodeMap.get(pNode.random);
            pNode = pNode.next;
        }
        return nodeMap.get(head);
        
    }
    
    // with extra space O(1)
    public static Node copyWithRandomNode2(Node head) {
        if(head == null) return null;
        Node pNode = head, qNode = null;
        while(pNode != null) {
            qNode = new Node(pNode.value);
            qNode.next = pNode.next;
            pNode.next = qNode;
            pNode = qNode.next;
        }
        pNode = head;
        while(pNode != null && pNode.next != null ) {
            if(pNode.random != null) {
                pNode.next.random = pNode.random.next;
            }
            pNode = pNode.next.next;
        }
        pNode = head;
        qNode = head.next;
        Node headNewNode = qNode;
        while(pNode != null && pNode.next != null) {
            pNode.next = qNode.next;
            pNode = qNode;
            qNode = qNode.next;
        }
        return headNewNode;
        
    }
    
    // for test
    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.random == null ? "- " : cur.random.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyWithRandomNode1(head);
        printRandLinkedList(res1);
        res2 = copyWithRandomNode2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.random = head.next.next.next.next.next; // 1 -> 6
        head.next.random = head.next.next.next.next.next; // 2 -> 6
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next.next; // 4 -> 3
        head.next.next.next.next.random = null; // 5 -> null
        head.next.next.next.next.next.random = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyWithRandomNode1(head);
        printRandLinkedList(res1);
        res2 = copyWithRandomNode2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }
}
