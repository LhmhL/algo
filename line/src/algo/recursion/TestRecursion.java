package algo.recursion;

import java.util.*;

public class TestRecursion {
    public static int walkStair(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return walkStair(n - 1) + walkStair(n - 2);
    }

    public static int fibonacci(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        return  fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int sum(int n) {
        if (n == 1) return 1;
        return n + sum(n - 1);
    }

    public static void a(int times) {
        if (times == 0) return;
        System.out.println("前参数 times = " + times);
        a(times - 1);
        System.out.println("后参数 times = " + times);
    }

    public static void a() {
        System.out.println("调用方法 a()");
        a();
        System.out.println("调用本身结束");
    }

    public static long factorials(int n) {
        if (n == 1) return 1;
        return n * factorials(n - 1);
    }

    private static class Data {
        int a; // 参数的值
        int codeBlock; // 记录需要执行哪一个代码块

        public Data(int a, int codeBlock) {
            this.a = a;
            this.codeBlock = codeBlock;
        }
    }

    public static long factorials1(int n) {
        long res = 1;

        Stack<Data> stack = new Stack<>();
        stack.push(new Data(n, 0));

        while (!stack.isEmpty()) {
            Data p = stack.pop();
            int a = p.a;
            int codeBlock = p.codeBlock;

            if (codeBlock == 0) { // 执行代码块 0
                if (a == 1) {
                    // 执行边界条件
                    stack.push(new Data(a,  1)); // 可以省略
                    res = 1;
                } else {
                    // 压栈
                    stack.push(new Data(a, 1));
                    stack.push(new Data(a - 1, 0));
                }
            } else if (codeBlock == 1) { // 执行代码块 1
                res = a * res;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        a(2);
        System.out.println(factorials(5));
        System.out.println(factorials1(5));
        System.out.println(fibonacci(12));
        System.out.println(walkStair(11));

        Deque<Integer> deque1 =new ArrayDeque<>();
        Deque<Integer> deque2 =new LinkedList<>();
        Queue<Integer> queue1 =new ArrayDeque<>();
        Queue<Integer> queue2 =new LinkedList<>();
        Deque<Integer> stack1 =new ArrayDeque<>();
        Deque<Integer> stack2 =new LinkedList<>();
        Stack<Data> stack = new Stack<>();
    }
}
