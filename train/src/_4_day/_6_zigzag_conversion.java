package _4_day;

public class _6_zigzag_conversion {
    // 按行访问
    public String convert(String s, int numRows) {
        StringBuilder res = new StringBuilder();
        int delta = 2 * numRows - 2;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col + row < s.length(); col += delta) {
                res.append(s.charAt(col + row));
                if (row != 0 && row != numRows - 1 && col + delta - row < s.length()) {
                    res.append(s.charAt(col + delta - row));
                }
            }
        }
        return res.toString();
    }
    
    public String convert2(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int currRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            sbs[currRow].append(c);
            if (currRow == 0 || currRow == numRows - 1) goingDown = !goingDown;
            currRow += (goingDown ? 1 : -1);
        }
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            res.append(sbs[j]);
        }
        return res.toString();
    }

    public String convert1(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int n = s.length();
        int i = 0;
        while (i < n) {
            // 垂直向下
            for (int idx = 0; idx < numRows && i < n; idx++, i++) {
                sbs[idx].append(s.charAt(i));
            }
            // 右前向上
            for (int idx = numRows - 2; idx >= 1 && i < n; idx--, i++) {
                sbs[idx].append(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            res.append(sbs[j]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String res = new _6_zigzag_conversion().convert1("PAYPALISHIRING",3);
        System.out.println(res);
    }
}
