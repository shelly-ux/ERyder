import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ParenthesesChecker {


    public static boolean isBalanced(String str) {

        Deque<Character> stack = new ArrayDeque<>();


        char[] chars = str.toCharArray();
        for (char c : chars) {

            if (c == '(' || c == '[' || c == '{') {·
                stack.push(c);
            }

            else if (c == ')' || c == ']' || c == '}') {

                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();

                if (!isMatching(top, c)) {
                    return false;
                }
            }

        }


        return stack.isEmpty();
    }


    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入括号字符串: ");
        String input = scanner.nextLine();
        scanner.close();

        if (isBalanced(input)) {
            System.out.println("括号平衡配对 ✅");
        } else {
            System.out.println("括号不平衡 ❌");
        }
    }
}