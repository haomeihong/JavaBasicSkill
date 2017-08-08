package list;

import common.ListNode;

/**
 * Created by wangxiaomin03 on 17/8/7.
 * 题目
 * Given a linked list, determine if it has a cycle in it.
 */
public class ListHasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;

    }
}
