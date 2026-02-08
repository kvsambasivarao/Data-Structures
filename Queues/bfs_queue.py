from collections import deque

adj = [
    [0, 1, 1, 0, 0, 0],
    [1, 0, 0, 1, 1, 0],
    [1, 0, 0, 0, 1, 0],
    [0, 1, 0, 0, 0, 1],
    [0, 1, 1, 0, 0, 1],
    [0, 0, 0, 1, 1, 0]
]

V = 6

def bfs(start):
    visited = [False] * V
    queue = deque()

    visited[start] = True
    queue.append(start)

    print("BFS Traversal:", end=" ")

    while queue:
        v = queue.popleft()
        print(v, end=" ")

        for i in range(V):
            if adj[v][i] == 1 and not visited[i]:
                visited[i] = True
                queue.append(i)

bfs(0)   # Starting BFS from vertex 0
