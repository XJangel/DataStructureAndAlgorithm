package LinkedList;

import java.util.HashSet;

import org.apache.xerces.dom3.as.NodeEditAS;

import LinkedList.SmallEqualBig.Node;

/*
 * 两个单链表相交的一系列问题
 * 单链表可能有环，也可能无环。给定两个单链表的头节点，请实现一个函数，如果两个链表相交，返回相交的第一个节点，如果不相交，返回null。
 * 
 * 要求：时间复杂度为O(M+N),额外空间复杂度为O(1)
 */
public class FindFirstIntersectNode {
    public static class Node{
        private int value;
        private Node next;
        
        public Node(int val) {
            this.value = val;
        }
    }
    // 分为三种情况：①两个链表都无环；②两个链表其中一个有环；③两个链表都有环
    public static Node findFirstIntersectNode(Node head1, Node head2) {
        if(head1 == null || head2 == null) return null;
        Node entryNode1 = hasRing1(head1);
        Node entryNode2 = hasRing1(head2);
        Node entryNextNode;
        if(entryNode1 == null && entryNode2 == null) {
            return withoutRingIntersect(head1,head2);
        }else if (entryNode1 != null && entryNode2 != null) {
            return entryNode1;
        }else {
            return null;
        }
    }
    
    // 判断链表是否有环:使用hashset,判断当前节点是否在hashset，若无则加入hashset，若有，则当前节点就是入环节点
    // 额外空间复杂度为O(N)
    public static Node hasRing1(Node head) {
        if(head == null || head.next == null) return null;
        HashSet<Node> nodeSet = new HashSet<FindFirstIntersectNode.Node>();
        Node curNode = head;
        while(curNode != null) {
            if(nodeSet.contains(curNode)) return curNode;
            nodeSet.add(curNode);
            curNode = curNode.next;
        }
        return null;
    }
    // 判断链表是否有环：通过快慢指针,快指针每次走两步，慢指针每次走一步，若无环：则快指针会先走到null;若有环：快慢指针一定会在环上相遇，此时快指针返回到头节点，
    // 并且每次走一步，慢指针也同时继续走，则快慢指针会在入环口相遇
    public static Node hasRing2(Node head) {
        if(head == null || head.next == null) return null;
        Node fastNode = head, slowNode = head;
        while(fastNode != null && fastNode.next != null) {
            if(fastNode == slowNode) {
                fastNode = head;
                while(fastNode != slowNode) {
                    fastNode = fastNode.next;
                    slowNode = slowNode.next;
                }
                return fastNode;
            }else {
                fastNode = fastNode.next.next;
                slowNode = slowNode.next;
            }
        }
        return null;
    }
    // 判断两个无环链表是否相交
    public static Node withoutRingIntersect(Node head1, Node head2) {
        if(head1 == null && head2 == null) return null;
        int len1 = 0, len2 = 0;
        Node cur1 = head1, cur2 = head2;
        while(cur1 != null) {
            len1++;
            cur1 = cur1.next;
        }
        while(cur2 != null) {
            len2++;
            cur2 = cur2.next;
        }
        if(cur1 != cur2) return null; // 若两链表相交，则最后一个节点一定是同一个
//        cur1 = head1;
//        cur2 = head2;
//        if(len1 >= len2) {
//            for(int i =0; i < len1-len2;i++) {
//                cur1 = cur1.next;
//            }
//        }else {
//            for(int i =0; i < len2-len1;i++) {
//                cur2 = cur2.next;
//            }
//        }
//        另一种写法：让cur1永远指向更长的那个链表
        cur1 = len1 >= len2 ? head1 : head2;
        cur2 = len1 >= len2 ? head2 : head1;
        int n = Math.abs(len1-len2);
        while(n > 0) {
            n--;
            cur1 = cur1.next;
        }
        while(cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
        
    }
    
    // 两个链表皆有环
    public static Node bothRingIntersect(Node head1, Node head2) {
        Node loop1 = hasRing2(head1);
        Node loop2 = hasRing2(head2);
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    // for test
    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(findFirstIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(findFirstIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(findFirstIntersectNode(head1, head2).value);

    }
}
