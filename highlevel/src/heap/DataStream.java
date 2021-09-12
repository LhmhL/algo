package heap;

public class DataStream {
    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node dummyNode;

    public DataStream() {
        this.dummyNode = new Node(-1);
    }

    // O(1)
    public void add(int val) {
        Node newNode = new Node(val);
        newNode.next = dummyNode.next;
        dummyNode.next = newNode;
    }

    // O(n)
    public int removeMax() {
        if (dummyNode.next == null)
            throw new RuntimeException("removeMax 失败，因为数据流中没有元素");

        // 遍历一遍链表，找到最大值所在的节点
        Node curr = dummyNode.next;
        Node maxValueNode = curr;
        while (curr != null) {
            if (curr.val > maxValueNode.val) {
                maxValueNode = curr;
            }
            curr = curr.next;
        }

        // 找到最大值节点的前一个节点
        curr = dummyNode.next;
        Node maxValueNodePrev = dummyNode;
        while (curr != null) {
            if (curr.val == maxValueNode.val) {
                break;
            }
            maxValueNodePrev = curr;
            curr = curr.next;
        }

        // 删除最大值所在的节点
        maxValueNodePrev.next = maxValueNode.next;
        maxValueNode.next = null;

        return maxValueNode.val;
    }
}
