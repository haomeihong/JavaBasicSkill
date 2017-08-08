package sortList;

import java.util.Scanner;

/**
 * Created by wangxiaomin03 on 17/7/31.
 */
public class InsertSolution {


    public static void main(String[] arg) {
//        ListNode head = new ListNode(4);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(7);
//        head.next.next.next.next = new ListNode(5);
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        scanner.close();
        String[] tars = line.split(",");
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (String s : tars) {
            System.out.println(s);
            p.next = new ListNode(Integer.valueOf(s));
            p = p.next;
        }
        System.out.println(head.next.toString());
        ListNode node = insertionSortList(head.next);
        System.out.println(node.toString());


    }


    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h = new ListNode(0);
        h.next = head;

        ListNode current = head;
        while (current != null && current.next != null) {
            ListNode pre = h;
            ListNode next = current.next;
            int v = next.val;
            if (v < current.val) {
                while (pre.next.val < v) {
                    pre = pre.next;
                }
                current.next = next.next;
                next.next = pre.next;
                pre.next = next;
            } else {
                current = current.next;
            }
        }
        return h.next;
    }

}
