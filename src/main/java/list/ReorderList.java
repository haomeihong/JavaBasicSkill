package list;

import common.ListNode;

import java.util.Stack;

/**
 * Created by wangxiaomin03 on 17/8/3.
 * 题目
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */
public class ReorderList {

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode pre = h;
        ListNode post = head;
        Stack<ListNode> stack = new Stack<>();

        while (post.next != null && post.next.next != null) {
            stack.add(pre);
            pre = pre.next;
            post = post.next.next;
        }
        boolean isOdd = false;
        if (post.next == null) {
            isOdd = true;
        }
        ListNode h1 = new ListNode(-1);
        if (isOdd) {
            ListNode listNode = pre.next;
            pre.next = pre.next.next;
            listNode.next = null;
            h1.next = listNode;
        } else {
            ListNode listNode = pre.next;
            pre.next = pre.next.next.next;
            listNode.next.next = null;
            h1.next = listNode;
        }
        while (!stack.empty()) {
            ListNode node = stack.pop();
            ListNode node1 = node.next;
            node.next = node.next.next.next;
            node1.next.next = h1.next;
            h1.next = node1;
        }
        h.next = null;
        h1.next = null;
    }

    public static void main(String[] arg) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
//        h.next.next.next = new ListNode(4);
        reorderList(h);
        ListNode p = h;
        while (p != null) {
            System.out.print(p.val + ",");
            p = p.next;
        }
    }
}
