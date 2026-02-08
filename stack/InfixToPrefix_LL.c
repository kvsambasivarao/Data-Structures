/* File Name: InfixToPrefix_LL.c */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

struct Node {
    char data;
    struct Node* next;
};

struct Node* top = NULL;

void push(char ch) {
    struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
    temp->data = ch;
    temp->next = top;
    top = temp;
}

char pop() {
    struct Node* temp = top;
    char ch = temp->data;
    top = temp->next;
    free(temp);
    return ch;
}

char peek() {
    return top->data;
}

int precedence(char ch) {
    if (ch == '+' || ch == '-') return 1;
    if (ch == '*' || ch == '/') return 2;
    return 0;
}

int main() {
    char infix[100], rev[100], postfix[100];
    int i, j = 0, k = 0;

    printf("Enter infix expression: ");
    scanf("%s", infix);

    int len = strlen(infix);
    for (i = len - 1; i >= 0; i--) {
        if (infix[i] == '(') rev[j++] = ')';
        else if (infix[i] == ')') rev[j++] = '(';
        else rev[j++] = infix[i];
    }
    rev[j] = '\0';

    for (i = 0; rev[i] != '\0'; i++) {
        if (isalnum(rev[i]))
            postfix[k++] = rev[i];
        else if (rev[i] == '(')
            push(rev[i]);
        else if (rev[i] == ')') {
            while (peek() != '(')
                postfix[k++] = pop();
            pop();
        }
        else {
            while (top != NULL && precedence(peek()) >= precedence(rev[i]))
                postfix[k++] = pop();
            push(rev[i]);
        }
    }

    while (top != NULL)
        postfix[k++] = pop();

    postfix[k] = '\0';
    strrev(postfix);

    printf("Prefix Expression: %s\n", postfix);
    return 0;
}
