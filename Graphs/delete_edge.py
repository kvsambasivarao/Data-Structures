# File Name: delete_edge.py

graph = []
vertices = int(input("Enter number of vertices: "))

for i in range(vertices):
    graph.append([])

def delete_edge(u, v):
    if u >= vertices or v >= vertices:
        print("Invalid vertices!")
        return

    if v not in graph[u]:
        print("Edge does not exist!")
        return

    graph[u].remove(v)
    graph[v].remove(u)   # Undirected graph

    print(f"Edge deleted between {u} and {v}")

def display_graph():
    print("\nAdjacency List:")
    for i in range(vertices):
        print(f"{i} -> {graph[i]}")

while True:
    print("\n1. Delete Edge")
    print("2. Display Graph")
    print("3. Exit")
    choice = int(input("Enter your choice: "))

    if choice == 1:
        u, v = map(int, input("Enter two vertices (u v): ").split())
        delete_edge(u, v)
    elif choice == 2:
        display_graph()
    elif choice == 3:
        break
    else:
        print("Invalid choice")
