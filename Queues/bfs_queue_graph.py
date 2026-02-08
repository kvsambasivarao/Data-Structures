from collections import deque

nodes = ['S','A','F','C','G','H','D']

adj = [
    [0,1,1,0,0,0,0],  # S
    [0,0,1,1,1,0,0],  # A
    [0,0,0,0,1,1,0],  # F
    [0,0,0,0,0,0,1],  # C
    [0,0,0,0,0,0,0],  # G
    [0,0,0,0,0,0,0],  # H
    [0,0,0,0,0,0,0]   # D
]

V = 7

def bfs(start):
    visited = [False] * V
    queue = deque()

    visited[start] = True
    queue.append(start)

    print("BFS Traversal:", end=" ")

    while queue:
        v = queue.popleft()
        print(nodes[v], end=" ")

        for i in range(V):
            if adj[v][i] == 1 and not visited[i]:
                visited[i] = True
                queue.append(i)

bfs(0)   # Start BFS from S
