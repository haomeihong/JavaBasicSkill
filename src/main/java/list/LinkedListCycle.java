package list;

import common.ListNode;

/**
 * Created by wangxiaomin03 on 17/8/4.
 * 题目
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 */
public class LinkedListCycle {
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        boolean hasCycle = false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = slow.next;
        int count1 = 0;
        int count2 = 0;
        while (p1 != fast) {
            count1++;
            p1 = p1.next;
        }
        while (p2 != fast) {
            count2++;
            p2 = p2.next;
        }
        int div = count1 - count2;
        ListNode h1 = head;
        ListNode h2 = slow.next;
        while (div > 0) {
            div--;
            h1 = h1.next;
        }
        while (div < 0) {
            div++;
            h2 = h2.next;
        }
        while (h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;
        }
        return h1;
    }

    public static void main(String[] arg) {
        ListNode h = new ListNode(1);
        h.next=h;
//        h.next = new ListNode(2);
//        h.next.next = new ListNode(3);
//        h.next.next.next = new ListNode(4);
//        h.next.next.next.next = h.next;
        ListNode cycle = detectCycle(h);
        System.out.println(cycle.val);
    }
}
