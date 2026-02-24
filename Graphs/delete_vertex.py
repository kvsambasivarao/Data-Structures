# File Name: delete_vertex.py

graph = []
vertices = int(input("Enter number of vertices: "))

for i in range(vertices):
    graph.append([])

def delete_vertex(v):
    global vertices
    if v >= vertices:
        print("Invalid vertex!")
        return

    # Remove all edges pointing to v
    for adj in graph:
        if v in adj:
            adj.remove(v)

    # Remove the vertex itself
    graph.pop(v)

    # Adjust remaining vertex numbers
    for adj in graph:
        for i in range(len(adj)):
            if adj[i] > v:
                adj[i] -= 1

    vertices -= 1
    print(f"Vertex {v} deleted successfully.")

def display_graph():
    print("\nAdjacency List:")
    for i in range(len(graph)):
        print(f"{i} -> {graph[i]}")

while True:
    print("\n1. Delete Vertex")
    print("2. Display Graph")
    print("3. Exit")
    choice = int(input("Enter your choice: "))

    if choice == 1:
        v = int(input("Enter vertex to delete: "))
        delete_vertex(v)
    elif choice == 2:
        display_graph()
    elif choice == 3:
        break
    else:
        print("Invalid choice")
