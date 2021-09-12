package queue;

public interface Queue<E> {
    /**
     * 查询队列中的元素个数
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入队（队尾）
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队（队首）
     * @return
     */
    E dequeue();

    /**
     * 查看队首的元素（尾入首出）
     * @return
     */
    E getFront();
}
