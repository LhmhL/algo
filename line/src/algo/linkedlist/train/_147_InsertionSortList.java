package algo.linkedlist.train;

import algo.linkedlist.ListNode;

public class _147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val >= prev.val) {
                prev = curr;
                curr = curr.next;
            } else {
                ListNode p = dummyNode;
                while (p.next != null && p.next.val < curr.val) {
                    p = p.next;
                }
                // 将 curr 插入到 p 和 p.next 之间
                prev.next = curr.next;
                curr.next = p.next;
                p.next = curr;
                // curr 后移
                curr = prev.next;
            }
        }
        return dummyNode.next;
    }
}
