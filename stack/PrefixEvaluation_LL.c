/* File Name: PrefixEvaluation_LL.c */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

struct Node {
    int data;
    struct Node* next;
};

struct Node* top = NULL;

void push(int x) {
    struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
    temp->data = x;
    temp->next = top;
    top = temp;
}

int pop() {
    int x;
    struct Node* temp = top;
    x = temp->data;
    top = temp->next;
    free(temp);
    return x;
}

int main() {
    char prefix[100];
    int i, op1, op2, result;

    printf("Enter prefix expression: ");
    scanf("%s", prefix);

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
