/* File Name: PrefixEvaluation_Array.c */

#include <stdio.h>
#include <string.h>
#include <ctype.h>

int stack[100];
int top = -1;

void push(int x) {
    stack[++top] = x;
}

int pop() {
    return stack[top--];
}

int main() {
    char prefix[100];
    int i, op1, op2, result;

    printf("Enter prefix expression: ");
    scanf("%s", prefix);

    /* Scan from right to left */
    for (i = strlen(prefix) - 1; i >= 0; i--) {
        if (isdigit(prefix[i])) {
            push(prefix[i] - '0');
        } else {
            op1 = pop();
            op2 = pop();

            switch (prefix[i]) {
                case '+': result = op1 + op2; break;
                case '-': result = op1 - op2; break;
                case '*': result = op1 * op2; break;
                case '/': result = op1 / op2; break;
            }
            push(result);
        }
    }

    printf("Result = %d\n", pop());
    return 0;
}
