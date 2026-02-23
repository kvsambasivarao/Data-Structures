# File Name: BiconnectedGraph.py

from collections import defaultdict

class Graph:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = defaultdict(list)
        self.time = 0

    def addEdge(self, u, v):
        self.graph[u].append(v)
        self.graph[v].append(u)

    def APUtil(self, u, visited, parent, low, disc, ap):
        children = 0
        visited[u] = True
        disc[u] = low[u] = self.time
        self.time += 1

        for v in self.graph[u]:
            if not visited[v]:
                parent[v] = u
                children += 1
                self.APUtil(v, visited, parent, low, disc, ap)

                low[u] = min(low[u], low[v])

                # Root case
                if parent[u] == -1 and children > 1:
                    ap[u] = True

                # Non-root case
                if parent[u] != -1 and low[v] >= disc[u]:
                    ap[u] = True

            elif v != parent[u]:
                low[u] = min(low[u], disc[v])

    def findArticulationPoints(self):
        visited = [False] * self.V
        parent = [-1] * self.V
        low = [float("inf")] * self.V
        disc = [float("inf")] * self.V
        ap = [False] * self.V

        for i in range(self.V):
            if not visited[i]:
                self.APUtil(i, visited, parent, low, disc, ap)

        return ap

    def isConnected(self):
        visited = [False] * self.V
        self.DFS(0, visited)
        return all(visited)

    def DFS(self, v, visited):
        visited[v] = True
        for neighbour in self.graph[v]:
            if not visited[neighbour]:
                self.DFS(neighbour, visited)

    def countLeaves(self):
        count = 0
        for i in range(self.V):
            if len(self.graph[i]) == 1:
                count += 1
        return count


# -------- Driver Code --------
if __name__ == "__main__":

    V = int(input("Enter number of vertices: "))
    E = int(input("Enter number of edges: "))

    g = Graph(V)

    print("Enter edges (u v):")
    for _ in range(E):
        u, v = map(int, input().split())
        g.addEdge(u, v)

    ap = g.findArticulationPoints()
    ap_count = sum(ap)
    leaf_count = g.countLeaves()

    is_biconnected = g.isConnected() and ap_count == 0

    print("\nIs Graph Biconnected:", is_biconnected)
    print("Number of Articulation Points:", ap_count)
    print("Number of Node Leaves:", leaf_count)
