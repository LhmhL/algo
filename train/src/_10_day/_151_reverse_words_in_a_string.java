package _10_day;

import java.util.*;

public class _151_reverse_words_in_a_string {
    /* leetcode 151 号算法题：翻转字符串里的单词
    给定一个字符串，逐个翻转字符串中的每个单词。

    输入："the sky is blue"
    输出："blue is sky the"

    输入："  hello world!  "
    输出："world! hello"

    输入："a good   example"
    输出："example good a"

    1. 无空格字符构成一个 单词 。
    2. 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
    3. 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

    请尝试使用 O(1) 额外空间复杂度的原地解法。
    */

    // 使用内置 API
    public String reverseWords1(String s) {
        /*
        输入：s = "  Bob    Loves  Alice   "
        1. "Bob    Loves  Alice"
        2. ["Bob", "Loves", "Alice"]
        3. ["Alice", "Loves", "Bob"]
        4. "Alice Loves Bob"
        输出："Alice Loves Bob"
        */
        s = s.trim();
//        List<String> list = Arrays.asList(s.split("\\s+"));
//        Collections.reverse(list);
//        return String.join(" ", list);
        StringBuilder sb = new StringBuilder();
        String[] sArr = s.split("\\s+");
        for (int i = sArr.length - 1; i >= 0; i--) {
            sb.append(sArr[i]);
            if (i != 0) sb.append(" ");
        }
        return sb.toString();
    }

    // 不使用内置 API
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public String reverseWords2(String s) {
        /*
        输入：s = "  Bob    Loves  Alice   "
        1. "Bob Loves Alice"
        2. "ecilA sevoL boB"
        3. "Alice Loves Bob"
        输出："Alice Loves Bob"
        */
        char[] chars = s.toCharArray();
        s = trimSpaces(chars, s.length());
        chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        s = reverseEachWord(chars);
        return s;
    }

    // 空间复杂度 O(1)
    // 快慢指针
    private String trimSpaces(char[] chars, int n) {
        int slow = 0, fast = 0;
        while (fast < n) {
            while (fast < n && chars[fast] == ' ') fast++;             // skip spaces
            while (fast < n && chars[fast] != ' ') chars[slow++] = chars[fast++]; // keep non spaces
            while (fast < n && chars[fast] == ' ') fast++;             // skip spaces
            if (fast < n) chars[slow++] = ' ';                      // keep only one space
        }
        return new String(chars).substring(0, slow);
    }

    // 空间复杂度 O(n)
    private String trimSpaces1(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉开头的空格
        while (left <= right && s.charAt(left) == ' ') left++;
        // 去掉结尾的空格
        while (left <= right && s.charAt(right) == ' ') right--;
        // 去掉中间的空格
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(' ');
            }
            left++;
        }
        return sb.toString();
    }

    private void reverse(char[] cArr, int start, int end) {
        char temp;
        while (start < end) {
            temp = cArr[start];
            cArr[start++] = cArr[end];
            cArr[end--] = temp;
        }
    }

    private String reverseEachWord(char[] chars) {
        int n = chars.length;
        int left = 0;
        while (left < n) {
            if (chars[left] != ' ') {
                int right = left;
                while (right + 1 < n && chars[right + 1] != ' ') right++;
                reverse(chars, left, right);
                left = right + 1;
            } else {
                left++;
            }
        }
        return new String(chars);
    }

    // 使用双端队列 栈
    public String reverseWords(String s) {
        /*
        输入：s = "  Bob    Loves  Alice   "
        1. "Bob    Loves  Alice"
        2.
          -----------------------------
                Alice Loves Bob
          ----------------------------
        输出："Alice Loves Bob"
        */
        int left = 0, right = s.length() - 1;
        // 去掉开头的空格
        while (left <= right && s.charAt(left) == ' ') left++;
        // 去掉结尾的空格
        while (left <= right && s.charAt(right) == ' ') right--;
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.length() != 0) {
                deque.offerFirst(sb.toString());
                sb.setLength(0); // 清空
            }
            left++;
        }
        deque.offerFirst(sb.toString());
        sb.setLength(0); // 清空
        int n = deque.size();
        for (int i = 0; i < n; i++) {
            sb.append(deque.removeFirst());
            if (i != n - 1) sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "  Bob    Loves  Alice   ";
        String res = new _151_reverse_words_in_a_string().reverseWords(str);
        System.out.println(res);
    }
}
