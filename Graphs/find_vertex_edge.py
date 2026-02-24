# File Name: find_vertex_edge.py

graph = []
vertices = int(input("Enter number of vertices: "))

for i in range(vertices):
    graph.append([])

def find_vertex(v):
    if 0 <= v < vertices:
        print(f"Vertex {v} exists in the graph.")
    else:
        print("Vertex does not exist!")

def find_edge(u, v):
    if u >= vertices or v >= vertices:
        print("Invalid vertices!")
        return

    if v in graph[u]:
        print(f"Edge exists between {u} and {v}.")
    else:
        print("Edge does not exist!")

def display_graph():
    print("\nAdjacency List:")
    for i in range(vertices):
        print(f"{i} -> {graph[i]}")

while True:
    print("\n1. Find Vertex")
    print("2. Find Edge")
    print("3. Display Graph")
    print("4. Exit")
    choice = int(input("Enter your choice: "))

    if choice == 1:
        v = int(input("Enter vertex to find: "))
        find_vertex(v)
    elif choice == 2:
        u, v = map(int, input("Enter two vertices (u v): ").split())
        find_edge(u, v)
    elif choice == 3:
        display_graph()
    elif choice == 4:
        break
    else:
        print("Invalid choice")
