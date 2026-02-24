# File Name: insert_vertex.py

graph = []

def insert_vertex():
    graph.append([])
    print(f"Vertex {len(graph) - 1} inserted successfully.")

def display_graph():
    print("\nAdjacency List:")
    for i in range(len(graph)):
        print(f"{i} -> {graph[i]}")

while True:
    print("\n1. Insert Vertex")
    print("2. Display Graph")
    print("3. Exit")
    choice = int(input("Enter your choice: "))

    if choice == 1:
        insert_vertex()
    elif choice == 2:
        display_graph()
    elif choice == 3:
        break
    else:
        print("Invalid choice")
