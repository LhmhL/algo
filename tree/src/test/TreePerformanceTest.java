package test;

import avltree.AVLTree;
import bstree.BSTree;
import rbtree.RBTree;

import java.util.ArrayList;
import java.util.Random;

public class TreePerformanceTest {
    private static Random random = new Random();
    public static void main(String[] args) {
        int num = 20000000;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // list.add(random.nextInt());
            list.add(i);
        }

        long startTime = System.nanoTime();
        BSTree<Integer> bst = new BSTree<>();
        for (Integer i : list) bst.add(i);
        for (Integer i : list) bst.contains(i);
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("BST：" + time + " s");

        startTime = System.nanoTime();
        AVLTree<Integer> avl = new AVLTree<>();
        for (Integer i : list) avl.add(i);
        for (Integer i : list) avl.contains(i);
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL：" + time + " s");

        startTime = System.nanoTime();
        RBTree<Integer> rb = new RBTree<>();
        for (Integer i : list) rb.add(i);
        for (Integer i : list) rb.contains(i);
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RB：" + time + " s");
    }
}
