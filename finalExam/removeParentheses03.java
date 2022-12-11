import java.util.ArrayList;
import java.util.Stack;
// Time complexity: O(N)
public class removeParentheses03 {
    public static void main(String[] args) {
        System.out.println(getValidString("lee(t(c)o)de))"));
    }

    private static String getValidString(String s) {
        char[] array = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                stack.push(i);
            } else if (array[i] == ')') {
                if (stack.isEmpty()) {
                    indexes.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            indexes.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (!indexes.contains(i)) {
                sb.append(array[i]);
            }
        }

        return sb.toString();
    }

}