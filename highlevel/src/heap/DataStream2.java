package heap;

public class DataStream2 {
    private MaxHeap<Integer> maxHeap;

    public DataStream2() {
        maxHeap = new MaxHeap<>();
    }

    // O(logn)
    public void add(int val) {
        maxHeap.add(val);
    }

    // O(logn)
    public int removeMax() {
        return maxHeap.removeMax();
    }
}
