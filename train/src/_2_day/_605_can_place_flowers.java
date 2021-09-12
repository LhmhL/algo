package _2_day;

public class _605_can_place_flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] temp = new int[flowerbed.length + 2];
        temp[0] = 0;
        temp[temp.length - 1] = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            temp[i + 1] = flowerbed[i];
        }
        for (int i = 1; i < temp.length - 1; i++) {
            if (temp[i - 1] == 0 && temp[i] == 0 && temp[i + 1] == 0) {
                temp[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }

    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int i = 0;
        // 当所有花坛遍历完或者花种完了，则停止循环
        while (i < flowerbed.length && n > 0) {
            if (flowerbed[i] == 1) {
                // 如果当前花坛已经种花，那么至少需要到 i + 2 的地方才能种花
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                // i 没有种花，且是最后一个花坛
                // i 和 i + 1 的位置都没有种花
                // 那么 i 处肯定可以种花
                n--;
                // 至此，至少需要到 i + 2 的地方才能种花
                i += 2;
            } else {
                // i 处没有种花，但是 i + 1 处种花了
                // 那么这个时候，至少需要到 i + 3 的地方才能种花
                i += 3;
            }
        }
        return n == 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,0,0,1};
        boolean res = new _605_can_place_flowers().canPlaceFlowers(arr,1);
        System.out.println(res);
    }
}
