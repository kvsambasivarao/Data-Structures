# File Name: GraphADT.py

class GraphADT:
    def __init__(self):
        self.graph = {}

    def insert_vertex(self, v):
        if v not in self.graph:
            self.graph[v] = []

    def insert_edge(self, u, v):
        self.graph[u].append(v)
        self.graph[v].append(u)

    def delete_edge(self, u, v):
        if v in self.graph[u]:
            self.graph[u].remove(v)
        if u in self.graph[v]:
            self.graph[v].remove(u)

    def delete_vertex(self, v):
        if v in self.graph:
            for n in self.graph[v]:
                self.graph[n].remove(v)
            del self.graph[v]

    def display(self):
        for v in self.graph:
            print(v, "->", self.graph[v])

    def bfs(self, start):
        visited = set()
        queue = [start]
        visited.add(start)

        while queue:
            v = queue.pop(0)
            print(v, end=" ")
            for n in self.graph[v]:
                if n not in visited:
                    visited.add(n)
                    queue.append(n)

    def dfs(self, start, visited=None):
        if visited is None:
            visited = set()
        visited.add(start)
        print(start, end=" ")
        for n in self.graph[start]:
            if n not in visited:
                self.dfs(n, visited)

if __name__ == "__main__":
    g = GraphADT()
    g.insert_vertex(0)
    g.insert_vertex(1)
    g.insert_vertex(2)

    g.insert_edge(0,1)
    g.insert_edge(1,2)

    print("Graph:")
    g.display()

    print("BFS:", end=" ")
    g.bfs(0)

    print("\nDFS:", end=" ")
    g.dfs(0)
