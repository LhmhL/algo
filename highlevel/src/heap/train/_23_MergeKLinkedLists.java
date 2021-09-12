package heap.train;

import java.util.PriorityQueue;

public class _23_MergeKLinkedLists {
    // 优先队列
    // 时间复杂度：O(k*n*logk)
    // 空间复杂度：O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        // O(k*logk)
        for (ListNode node : lists) { // O(k)
            minHeap.add(node); // O(logk)
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        // O(k*n*logk)
        while (!minHeap.isEmpty()) { // O(kn)
            ListNode minNode = minHeap.remove(); // O(logk)
            curr.next = minNode;
            curr = curr.next;
            if (minNode.next != null) {
                minHeap.add(minNode.next); // O(logk)
            }
        }
        return dummyNode.next;
    }

    // 分治思想
    // 时间复杂度：O(k*n*logk)
    // 空间复杂度：O(logk)
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        ListNode mergedLeftList = merge(lists, left, mid);
        ListNode mergedRightList = merge(lists, mid + 1, right);
        return mergeTwoLists(mergedLeftList, mergedRightList);
    }

    // 顺序合并
    // 时间复杂度：O(k^2 * n)
    // 空间复杂度：O(1)
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode outputList = lists[0];
        for (int i = 1; i < lists.length; i++) {
            outputList = mergeTwoLists(outputList, lists[i]);
        }
        return outputList;
    }

    // 时间复杂度：O(2n)
    // 空间复杂度：O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 == null) curr.next = l2;
        if (l2 == null) curr.next = l1;
        return dummyNode.next;
    }
}
