package _6_day;

import java.util.HashSet;
import java.util.Set;

public class _136_single_number {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public int singleNumber1(int[] nums) {
        Set<Integer> single = new HashSet<>();
        for (int num : nums) {
            if (single.contains(num)) {
                single.remove(num);
            } else {
                single.add(num);
            }
        }
        return single.iterator().next();
    }
}
