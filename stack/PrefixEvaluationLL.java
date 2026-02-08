/* File Name: PrefixEvaluationLL.java */

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class Stack {
    Node top = null;

    void push(int x) {
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
    }

    int pop() {
        int x = top.data;
        top = top.next;
        return x;
    }
}

public class PrefixEvaluationLL {

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
