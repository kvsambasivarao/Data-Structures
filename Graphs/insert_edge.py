# File Name: insert_edge.py

graph = []
vertices = int(input("Enter number of vertices: "))

for i in range(vertices):
    graph.append([])

def insert_edge(u, v):
    if u >= vertices or v >= vertices:
        print("Invalid vertices!")
        return
    graph[u].append(v)
    graph[v].append(u)   # Undirected graph
    print(f"Edge inserted between {u} and {v}")

def display_graph():
    print("\nAdjacency List:")
    for i in range(vertices):
        print(f"{i} -> {graph[i]}")

while True:
    print("\n1. Insert Edge")
    print("2. Display Graph")
    print("3. Exit")
    choice = int(input("Enter your choice: "))

    if choice == 1:
        u, v = map(int, input("Enter two vertices (u v): ").split())
        insert_edge(u, v)
    elif choice == 2:
        display_graph()
    elif choice == 3:
        break
    else:
        print("Invalid choice")
