package cn.lizhi.algorithm;

import java.util.HashSet;

/**
 * 找两个单链表的相交起始节点
 *
 * @author 种花家的兔子
 * @version v1.0
 * @date 2019年11月15日
 */
public class FindIntersectionOfTwoLinks {
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public static void main(String[] args) {
        ListNode headA = new ListNode(2);
        ListNode headB = new ListNode(5);
        ListNode listA1 = new ListNode(3);
        ListNode listA2 = new ListNode(8);
        ListNode listB1 = new ListNode(0);
        ListNode listC1 = new ListNode(11);
        ListNode listC2 = new ListNode(7);
        listC1.next = listC2;
        listA2.next = listC1;
        listB1.next = listC1;
        listA1.next = listA2;
        headA.next = listA1;
        headB.next = listB1;
        
        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);
    }
    
    /**
     * 双指针实现
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        
        while (pointerA != pointerB) {
            if (pointerA == null) {
                pointerA = headB;
            } else {
                pointerA = pointerA.next;
            }
            
            if (pointerB == null) {
                pointerB = headA;
            } else {
                pointerB = pointerB.next;
            }
        }
        
        return pointerA;
    }
    
    /**
     * hash表实现
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            
            headB = headB.next;
        }
        
        return null;
    }
}
