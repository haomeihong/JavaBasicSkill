package common;

/**
 * Created by wangxiaomin03 on 17/8/3.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        if (this == null) {
            return "null";
        }
        ListNode node = this;
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val).append("->");
            node = node.next;
        }
        return builder.toString();
    }
}
