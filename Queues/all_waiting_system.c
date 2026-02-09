/* File Name: call_waiting_system.c
   Program: Call Waiting System using Queue (Array Implementation)
*/

#include <stdio.h>
#define MAX 10

int queue[MAX];
int front = -1, rear = -1;

/* Enqueue a call */
void addCall(int callId) {
    if (rear == MAX - 1) {
        printf("Call queue is full. Call %d cannot be added.\n", callId);
        return;
    }
    if (front == -1)
        front = 0;
    queue[++rear] = callId;
    printf("Incoming call %d added to queue.\n", callId);
}

/* Dequeue a call */
void handleCall() {
    if (front == -1 || front > rear) {
        printf("No calls waiting.\n");
        return;
    }
    printf("Agent handling call %d.\n", queue[front++]);
}

int main() {
    int choice, callId;

    do {
        printf("\n--- Call Waiting System ---");
        printf("\n1. Add Incoming Call");
        printf("\n2. Handle Call");
        printf("\n3. Exit");
        printf("\nEnter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter Call ID: ");
                scanf("%d", &callId);
                addCall(callId);
                break;
            case 2:
                handleCall();
                break;
            case 3:
                printf("Exiting system...\n");
                break;
            default:
                printf("Invalid choice.\n");
        }
    } while (choice != 3);

    return 0;
}
