/* File Name: InfixToPrefixLL.java */

import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
    }
}

class Stack {
    Node top = null;

    void push(char ch) {
        Node temp = new Node(ch);
        temp.next = top;
        top = temp;
    }

    char pop() {
        char ch = top.data;
        top = top.next;
        return ch;
    }

    char peek() {
        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }
}

public class InfixToPrefixLL {

    static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();

        System.out.print("Enter infix expression: ");
        String infix = sc.nextLine();

        String rev = "";
        for (int i = infix.length() - 1; i >= 0; i--) {
            char ch = infix.charAt(i);
            if (ch == '(') rev += ')';
            else if (ch == ')') rev += '(';
            else rev += ch;
        }

        String postfix = "";

        for (char ch : rev.toCharArray()) {
            if (Character.isLetterOrDigit(ch))
                postfix += ch;
            else if (ch == '(')
                s.push(ch);
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

        String prefix = new StringBuilder(postfix).reverse().toString();
        System.out.println("Prefix Expression: " + prefix);
        sc.close();
    }
}
