/* File Name: GraphADT.c */

#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int adj[MAX][MAX];
int vertices = 0;

/* Insert Vertex */
void insertVertex() {
    vertices++;
}

/* Insert Edge */
void insertEdge(int u, int v) {
    adj[u][v] = 1;
    adj[v][u] = 1;
}

/* Delete Edge */
void deleteEdge(int u, int v) {
    adj[u][v] = 0;
    adj[v][u] = 0;
}

/* Delete Vertex */
void deleteVertex(int v) {
    for(int i=0;i<vertices;i++){
        adj[v][i]=0;
        adj[i][v]=0;
    }
}

/* Display Graph */
void display() {
    for(int i=0;i<vertices;i++){
        for(int j=0;j<vertices;j++){
            printf("%d ",adj[i][j]);
        }
        printf("\n");
    }
}

/* BFS */
void BFS(int start){
    int visited[MAX]={0},queue[MAX],front=0,rear=0;
    queue[rear++]=start;
    visited[start]=1;
    while(front<rear){
        int v=queue[front++];
        printf("%d ",v);
        for(int i=0;i<vertices;i++){
            if(adj[v][i]==1 && !visited[i]){
                queue[rear++]=i;
                visited[i]=1;
            }
        }
    }
}

/* DFS */
void DFS(int start){
    static int visited[MAX]={0};
    printf("%d ",start);
    visited[start]=1;
    for(int i=0;i<vertices;i++){
        if(adj[start][i]==1 && !visited[i]){
            DFS(i);
        }
    }
}

/* Main */
int main(){
    insertVertex(); insertVertex(); insertVertex();
    insertEdge(0,1);
    insertEdge(1,2);

    printf("Adjacency Matrix:\n");
    display();

    printf("\nBFS: ");
    BFS(0);

    printf("\nDFS: ");
    DFS(0);

    return 0;
}
