/* File Name: ReverseList_Stack_Array.c */

#include <stdio.h>

int stack[100];
int top = -1;

void push(int x) {
    stack[++top] = x;
}

int pop() {
    return stack[top--];
}

int main() {
    int n, i, arr[100];

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter elements:\n");
    for (i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
        push(arr[i]);
    }

    for (i = 0; i < n; i++)
        arr[i] = pop();

    printf("Reversed list:\n");
    for (i = 0; i < n; i++)
        printf("%d ", arr[i]);

    return 0;
}
