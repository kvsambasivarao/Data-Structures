/* File Name: InfixToPrefix_Array.c */

#include <stdio.h>
#include <string.h>
#include <ctype.h>

char stack[100];
int top = -1;

void push(char ch) {
    stack[++top] = ch;
}

char pop() {
    return stack[top--];
}

char peek() {
    return stack[top];
}

int precedence(char ch) {
    if (ch == '+' || ch == '-') return 1;
    if (ch == '*' || ch == '/') return 2;
    return 0;
}

int main() {
    char infix[100], prefix[100], rev[100];
    int i, j = 0, k = 0;

    printf("Enter infix expression: ");
    scanf("%s", infix);

    /* Reverse infix and swap parentheses */
    int len = strlen(infix);
    for (i = len - 1; i >= 0; i--) {
        if (infix[i] == '(')
            rev[j++] = ')';
        else if (infix[i] == ')')
            rev[j++] = '(';
        else
            rev[j++] = infix[i];
    }
    rev[j] = '\0';

    /* Convert reversed infix to postfix */
    for (i = 0; rev[i] != '\0'; i++) {
        if (isalnum(rev[i])) {
            prefix[k++] = rev[i];
        }
        else if (rev[i] == '(') {
            push(rev[i]);
        }
        else if (rev[i] == ')') {
            while (peek() != '(')
                prefix[k++] = pop();
            pop();
        }
        else {
            while (top != -1 && precedence(peek()) >= precedence(rev[i]))
                prefix[k++] = pop();
            push(rev[i]);
        }
    }

    while (top != -1)
        prefix[k++] = pop();

    prefix[k] = '\0';

    /* Reverse postfix to get prefix */
    strrev(prefix);

    printf("Prefix Expression: %s\n", prefix);
    return 0;
}
