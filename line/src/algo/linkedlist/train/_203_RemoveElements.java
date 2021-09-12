package algo.linkedlist.train;

import algo.linkedlist.ListNode;

public class _203_RemoveElements {
    // 虚拟结点统一删除逻辑
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curr = head;
        ListNode prev = dummyNode;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                curr.next = null;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummyNode.next;
    }

    public ListNode removeElements1(ListNode head, int val) {
        // 1. 删除表头节点
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if (head == null) return null;

        // 2. 删除非表头节点
        ListNode curr = head.next;
        ListNode prev = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                curr.next = null;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
