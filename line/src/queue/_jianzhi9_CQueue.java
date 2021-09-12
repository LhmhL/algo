package queue;

import java.util.Stack;

public class _jianzhi9_CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public _jianzhi9_CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }


	
    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return  -1;
        }
        return stack2.pop();
    }

	public void appendTail1(int value) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(value);
    }

    public int deleteHead1() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        if (stack2.isEmpty()) {
            return  -1;
        }
        return stack2.pop();
    }
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("队首：[");
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        for (Integer i : stack1) {
            sb.append(i + ",");
        }
        sb.append("]");
        return sb.toString();
    }
	
    public static void main(String[] args) {
        _jianzhi9_CQueue data = new _jianzhi9_CQueue();

        data.appendTail(10);
        data.appendTail(20);
        data.appendTail(30);
        data.appendTail(40);
        System.out.println(data);

        data.deleteHead();
        System.out.println(data);
        data.deleteHead();
        System.out.println(data);

        data.appendTail(50);
        System.out.println(data);

        data.deleteHead();
        System.out.println(data);
    }
}
