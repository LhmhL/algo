package _4_day;

public class _38_look_and_say_sequence {
    public String countAndSay(int n) {
        StringBuilder prev;
        StringBuilder curr = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            prev = curr;
            curr = new StringBuilder();
            char say = prev.charAt(0);
            int look = 1;
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) == say) {
                    look++;
                } else {
                    curr.append(look).append(say);
                    say = prev.charAt(j);
                    look = 1;
                }
            }
            curr.append(look).append(say);
        }
        return curr.toString();
    }

    public static void main(String[] args) {
        String res = new _38_look_and_say_sequence().countAndSay(5);
        System.out.println(res);
    }
}
