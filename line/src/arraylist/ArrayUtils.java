package arraylist;

public class ArrayUtils {
    public static boolean isEmpty(int[] arr) {
        for (int num : arr) {
            // 这里假设等于 0 表示没有元素
            // 这个是不严谨的，因为元素的值就可能是 0
            if (num != 0) return false;
        }
        return true;
    }

    public static int getSize(int[] arr) {
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            // 这里假设等于 0 表示没有元素
            // 这个是不严谨的，因为元素的值就可能是 0
            if (arr[i] != 0) size++;
        }
        return size;
    }

    public static boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    /**
     * 将指定的元素插入到指定数组的指定位置上
     * @param src   需要插入元素的数组
     * @param index 插入数组的位置
     * @param element   需要插入的元素值
     * @return  包含了插入元素的数组
     */
    public static int[] insertElement(int[] src, int index, int element) {
        int[] dest = new int[src.length + 1];

        for (int i = 0; i < index; i++) {
            dest[i] = src[i];
        }

        dest[index] = element;

        for (int i = index; i < src.length; i++) {
            dest[i + 1] = src[i];
        }
        return dest;
    }

    /**
     * 从数组中删除指定位置的元素
     * @param src   数组
     * @param index 指定的位置
     * @return 删除元素之后的数组
     */
    public static int[] removeElement(int[] src, int index) {
        int[] dest = new int[src.length - 1];

        for (int i = 0; i < index; i++) {
            dest[i] = src[i];
        }

        for (int i = index; i < src.length - 1; i++) {
            dest[i] = src[i + 1];
        }
        return dest;
    }

    public static void main(String[] args) {
        int[] data = new int[]{0,1,2,3};

        boolean isempty = ArrayUtils.isEmpty(data);
        System.out.println(isempty);

        int getsize = ArrayUtils.getSize(data);
        System.out.println(getsize);

        boolean contains = ArrayUtils.contains(data,3);
        System.out.println(contains);

        int[] newdata = ArrayUtils.insertElement(data,4,4);
        for (int i = 0; i < newdata.length; i++) {
            System.out.println(newdata[i]);
        }

        newdata = ArrayUtils.removeElement(data,3);
        for (int i = 0; i < newdata.length; i++) {
            System.out.println(newdata[i]);
        }
    }
}
