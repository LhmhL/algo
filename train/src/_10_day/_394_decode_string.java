package _10_day;

import java.util.ArrayDeque;

public class _394_decode_string {
    /* leetcode 394 号算法题：字符串解码
    给定一个经过编码的字符串，返回它解码后的字符串。

    编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
    注意 k 保证为正整数。

    你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

    此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，
    例如不会出现像 3a 或 2[4] 的输入。

    输入：s = "3[a]2[bc]"
    输出：aaabcbc

    输入：s = "3[a2[c]]"
    输出：accaccacc

    输入：s = "2[abc]3[cd]ef"
    输出： abcabccdcdcdef

    输入：s = "abc3[cd]xyz"
    输出：abccdcdcdxyz
    */

    public String decodeString(String s) {
        int num = 0;
        StringBuilder res = new StringBuilder();
        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        ArrayDeque<String> strStack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(res.toString());
                res.delete(0, res.length());
                num = 0;
            } else if (c == ']') {
                String item = res.toString();
                int itemCnt = numStack.pop();
                for (int i = 1; i < itemCnt; i++) {
                    res.append(item);
                }
                res.insert(0, strStack.pop());
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "2[a2[b2[m]d]]";
        String res = new _394_decode_string().decodeString(str);
        System.out.println(res);
    }
}