package map;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class JavaSetMap {
    public static void main(String[] args) {
        // TreeSet：红黑树，有序的，O(logn)
        // HashSet：hash，链表法，数组 + 链表（jdk1.7），O(1)，数组 + 链表 + 红黑树（jdk1.8），O(1)
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new TreeSet<>();

        // TreeMap：红黑树，key 有序的，O(logn)
        // HashMap：hash，链表法，数组 + 链表（jdk1.7），O(1)，数组 + 链表 + 红黑树（jdk1.8），O(1)
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new TreeMap<>();
    }
}
