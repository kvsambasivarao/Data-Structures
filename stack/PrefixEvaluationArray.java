/* File Name: PrefixEvaluationArray.java */

import java.util.Scanner;

class Stack {
    int[] stack = new int[100];
    int top = -1;

    void push(int x) {
        stack[++top] = x;
    }

    int pop() {
        return stack[top--];
    }
}

public class PrefixEvaluationArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();

        System.out.print("Enter prefix expression: ");
        String prefix = sc.nextLine();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);

            if (Character.isDigit(ch)) {
                s.push(ch - '0');
            } else {
                int op1 = s.pop();
                int op2 = s.pop();
                int result = 0;

                switch (ch) {
                    case '+': result = op1 + op2; break;
                    case '-': result = op1 - op2; break;
                    case '*': result = op1 * op2; break;
                    case '/': result = op1 / op2; break;
                }
                s.push(result);
            }
        }

        System.out.println("Result = " + s.pop());
        sc.close();
    }
}
