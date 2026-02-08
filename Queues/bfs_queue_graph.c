#include <stdio.h>

#define V 7

int adj[V][V] = {
    {0,1,1,0,0,0,0},  // S
    {0,0,1,1,1,0,0},  // A
    {0,0,0,0,1,1,0},  // F
    {0,0,0,0,0,0,1},  // C
    {0,0,0,0,0,0,0},  // G
    {0,0,0,0,0,0,0},  // H
    {0,0,0,0,0,0,0}   // D
};

char nodes[V] = {'S','A','F','C','G','H','D'};
int visited[V] = {0};
int queue[V], front = -1, rear = -1;

void enqueue(int v) {
    if (front == -1)
        front = 0;
    queue[++rear] = v;
}

int dequeue() {
    return queue[front++];
}

void bfs(int start) {
    enqueue(start);
    visited[start] = 1;

    printf("BFS Traversal: ");

    while (front <= rear) {
        int v = dequeue();
        printf("%c ", nodes[v]);

        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1 && visited[i] == 0) {
                visited[i] = 1;
                enqueue(i);
            }
        }
    }
}

int main() {
    bfs(0);   // Start BFS from S
    return 0;
}
