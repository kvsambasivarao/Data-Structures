# File Name: prims.py

import sys

def min_key(key, mst_set, vertices):
    min_val = sys.maxsize
    min_index = -1

    for v in range(vertices):
        if not mst_set[v] and key[v] < min_val:
            min_val = key[v]
            min_index = v

    return min_index

def prim_mst(graph, vertices):
    parent = [-1] * vertices
    key = [sys.maxsize] * vertices
    mst_set = [False] * vertices

    key[0] = 0

    for _ in range(vertices - 1):
        u = min_key(key, mst_set, vertices)
        mst_set[u] = True

        for v in range(vertices):
            if graph[u][v] != 0 and not mst_set[v] and graph[u][v] < key[v]:
                parent[v] = u
                key[v] = graph[u][v]

    print("Edge \tWeight")
    for i in range(1, vertices):
        print(f"{parent[i]} - {i}\t{graph[i][parent[i]]}")

vertices = int(input("Enter number of vertices: "))
print("Enter weighted adjacency matrix:")

graph = []
for _ in range(vertices):
    graph.append(list(map(int, input().split())))

prim_mst(graph, vertices)
