package algo.sort;

import java.util.Random;

public class SortCompare {
    private static Random random = new Random();

    private static int[] genData(int n) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt();
        }
        return data;
    }

    private static long time(String sortType, int[] data) {
        long start = System.currentTimeMillis();
        if (sortType.equals("bubble")) new BubbleSorter().sort(data);
        else if (sortType.equals("selection")) new SelectionSorter().sort(data);
        else if (sortType.equals("insertion")) new InsertionSorter().sort(data); //不交换
        else if (sortType.equals("insertion1")) new InsertionSorter().sort1(data); //交换
        else if (sortType.equals("shell")) new ShellSorter().sort(data); //不交换
        else if (sortType.equals("shell1")) new ShellSorter().sort3(data); //交换
        else if (sortType.equals("merge")) new MergeSorter().sort(data); //递归
        else if (sortType.equals("mergeBU")) new MergeSorter().sortBU(data); //迭代
        else if (sortType.equals("quick")) new QuickSorter().sort(data);
        else if (sortType.equals("threewayquick")) new ThreeWayQuickSorter().sort(data);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long manyTimesSort(String sortType, int n, int k) {
        long totalTime = 0;
        for (int i = 0; i < k; i++) {
            totalTime += time(sortType, genData(n));
        }
        return totalTime;
    }

    public static void main(String[] args) {
        int n = 1000, k = 100;
        double t1 = manyTimesSort("bubble", n, k);
        double t2 = manyTimesSort("selection", n, k);
        double t3 = manyTimesSort("insertion1", n, k); //不交换
        double t4 = manyTimesSort("insertion", n, k); //交换
        double t5 = manyTimesSort("shell", n, k); //不交换
        double t6 = manyTimesSort("shell1", n, k); //交换
        double t7 = manyTimesSort("merge", n, k); //递归
        double t8 = manyTimesSort("mergeBU", n, k); //迭代
        double t9 = manyTimesSort("quick", n, k);
        double t10 = manyTimesSort("threewayquick", n, k);
        System.out.println(t1 / t2); // t1 > t2
        System.out.println(t2 / t3); // t2 > t3
        System.out.println(t3 / t4); // t3 > t4
        System.out.println(t5 / t6); // t5 > t6
        System.out.println(t3 / t5); // t3 > t5
        System.out.println(t4 / t6); // t4 > t6
        System.out.println(t3 / t6); // t3 > t6
        System.out.println(t7 / t8); // t7 > t8
        System.out.println(t9 / t10); // t9 > t10
        System.out.println(t5 / t7); // t5 > t7
        System.out.println(t5 / t10); // t5 > t10
        System.out.println(t7 / t10); // t7 > t10
    }
}
