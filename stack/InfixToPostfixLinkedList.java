/* File Name: InfixToPostfixLL.java */

import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top = null;

    void push(char ch) {
        Node newNode = new Node(ch);
        newNode.next = top;
        top = newNode;
    }

    char pop() {
        if (top == null) return '\0';
        char ch = top.data;
        top = top.next;
        return ch;
    }

    char peek() {
        if (top == null) return '\0';
        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }
}

public class InfixToPostfixLL {

    static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();
        String infix, postfix = "";

        System.out.print("Enter infix expression: ");
        infix = sc.nextLine();

        for (char ch : infix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                postfix += ch;
            }
            else if (ch == '(') {
                s.push(ch);
            }
            else if (ch == ')') {
                while (s.peek() != '(')
                    postfix += s.pop();
                s.pop();
            }
            else {
                while (!s.isEmpty() && precedence(s.peek()) >= precedence(ch))
                    postfix += s.pop();
                s.push(ch);
            }
        }

        while (!s.isEmpty())
            postfix += s.pop();

        System.out.println("Postfix Expression: " + postfix);
        sc.close();
    }
}
