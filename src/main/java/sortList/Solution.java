package sortList;

/**
 * Created by wangxiaomin03 on 17/5/4.
 */
public class Solution {
    public static void main(String[] args){

    }
    public ListNode sortList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode curr=head;
        ListNode before=curr;
        while (curr.next!=null){
            if(curr.next.val<head.val){
                ListNode p=curr.next;
                curr.next=curr.next.next;
                p.next=before;
                before=p;
            }
            curr=curr.next;
        }
        ListNode right=sortList(head.next);
        head.next=null;
        ListNode left=sortList(before);
        head.next=right;
        return left;
    }
}

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }
