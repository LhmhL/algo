package _4_day;

public class _165_compare_version_numbers {
    // 不使用内置函数
    public int compareVersion(String version1, String version2) {
        int i1 = 0, i2 = 0;
        while (i1 < version1.length() || i2 < version2.length()) {
            int v1 = 0, v2 = 0;
            while (i1 < version1.length() && version1.charAt(i1) != '.') {
                v1 = v1 * 10 + (version1.charAt(i1) - '0');
                i1++;
            }
            while (i2 < version2.length() && version2.charAt(i2) != '.') {
                v2 = v2 * 10 + (version2.charAt(i2) - '0');
                i2++;
            }
            if (v1 != v2) {
                return v1 > v2 ? 1 : -1;
            }
            i1++;
            i2++;
        }
        return 0;
    }

    // 使用内置函数
    public int compareVersion1(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length;
        int n2 = nums2.length;
        int v1, v2;
        for (int i = 0; i < Math.max(n1, n2); i++) {
            v1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            v2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (v1 != v2) {
                return v1 > v2 ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int res = new _165_compare_version_numbers().compareVersion1("7.10.01","7.10");
        System.out.println(res);
    }
}
