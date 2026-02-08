/* File Name: InfixToPostfix_LL.c */

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

struct Node {
    char data;
    struct Node* next;
};

struct Node* top = NULL;

/* Stack operations using Linked List */
void push(char ch) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = ch;
    newNode->next = top;
    top = newNode;
}

char pop() {
    if (top == NULL)
        return '\0';
    struct Node* temp = top;
    char ch = temp->data;
    top = temp->next;
    free(temp);
    return ch;
}

char peek() {
    if (top == NULL)
        return '\0';
    return top->data;
}

int precedence(char ch) {
    if (ch == '+' || ch == '-') return 1;
    if (ch == '*' || ch == '/') return 2;
    return 0;
}

int main() {
    char infix[100], postfix[100];
    int i = 0, k = 0;
    char ch;

    printf("Enter infix expression: ");
    scanf("%s", infix);

    while ((ch = infix[i++]) != '\0') {
        if (isalnum(ch)) {
            postfix[k++] = ch;
        }
        else if (ch == '(') {
            push(ch);
        }
        else if (ch == ')') {
            while (peek() != '(')
                postfix[k++] = pop();
            pop(); // remove '('
        }
        else {
            while (top != NULL && precedence(peek()) >= precedence(ch))
                postfix[k++] = pop();
            push(ch);
        }
    }

    while (top != NULL)
        postfix[k++] = pop();

    postfix[k] = '\0';

    printf("Postfix Expression: %s\n", postfix);
    return 0;
}
