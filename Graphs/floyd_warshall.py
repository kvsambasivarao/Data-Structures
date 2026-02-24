# File Name: floyd_warshall.py

INF = 99999

def floyd_warshall(graph, vertices):
    dist = [row[:] for row in graph]

    for k in range(vertices):
        for i in range(vertices):
            for j in range(vertices):
                if dist[i][k] + dist[k][j] < dist[i][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]

    print("Shortest distance matrix:")
    for i in range(vertices):
        for j in range(vertices):
            if dist[i][j] == INF:
                print("INF", end=" ")
            else:
                print(dist[i][j], end=" ")
        print()

vertices = int(input("Enter number of vertices: "))
print("Enter weighted adjacency matrix (use 99999 for INF):")

graph = []
for _ in range(vertices):
    graph.append(list(map(int, input().split())))

floyd_warshall(graph, vertices)
