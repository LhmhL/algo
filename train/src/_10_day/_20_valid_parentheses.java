package _10_day;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class _20_valid_parentheses {
    /*  leetcode 20 号算法题：有效的括号
        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

        有效字符串需满足：
        1. 左括号必须用相同类型的右括号闭合。
        2. 左括号必须以正确的顺序闭合。

        输入：s = "()"
        输出：true

        输入：s = "([)]"
        输出：false

        输入：s = "()[]{}"
        输出：true

        1 <= s.length <= 10^4
        s 仅由括号 '()[]{}' 组成
    */

    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c != map.get(top)) return false;
            }
        }
        return stack.isEmpty();
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public boolean isValid1(String s) {
        if (s.length() % 2 == 1) return false;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
