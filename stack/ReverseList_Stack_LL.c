/* File Name: ReverseList_Stack_LL.c */

#include <stdio.h>
#include <stdlib.h>

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
