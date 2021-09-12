package _6_day;

public class _476_number_complement {
    public int findComplement(int num) {
        int mask = ~0; // 0xFFFFFFFF
        while ((num & mask) > 0) mask <<= 1;
        return ~mask ^ num;
    }
}
