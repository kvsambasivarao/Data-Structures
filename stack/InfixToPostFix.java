import java.util.Scanner;
import java.util.Stack;

class InfixToPostfix {

    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String infix, postfix = "";

        System.out.print("Enter infix expression: ");
        infix = sc.next();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix += ch;
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    postfix += stack.pop();
                stack.pop(); // remove '('
            }
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch))
                    postfix += stack.pop();
                stack.push(ch);
            }
        }

        while (!stack.isEmpty())
            postfix += stack.pop();

        System.out.println("Postfix expression: " + postfix);
        sc.close();
    }
}
