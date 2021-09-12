package algo.linkedlist.train;

import algo.linkedlist.ListNode;

public class _876_MiddleOfTheLinkedList {
    // 快慢指针
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode middleNode1(ListNode head) {
        if (head == null || head.next == null) return head;
        // 1. 计算链表的长度
        int length = 0;
        ListNode curr = head;
        while (curr != null) { // O(n)
            length++;
            curr = curr.next;
        }
        // 2. 找到链表的中间节点
        for (int i = 0; i < length / 2; i++) { // O(n/2)
            head = head.next;
        }
        return head;
    }
}
