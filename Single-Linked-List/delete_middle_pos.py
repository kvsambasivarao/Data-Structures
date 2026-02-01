# File Name: delete_pos.py
# Program to delete a node at a given position in a singly linked list

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

head = None

# Function to delete node at given position
def delete_pos(pos):
    global head

    if head is None:
        print("List is empty. Deletion not possible.")
        return

    # If position is 1
    if pos == 1:
        head = head.next
        print(f"Node at position {pos} deleted successfully.")
        return

    temp = head
    for i in range(1, pos - 1):
        temp = temp.next
        if temp is None or temp.next is None:
            print("Invalid position.")
            return

    temp.next = temp.next.next
    print(f"Node at position {pos} deleted successfully.")

if __name__ == "__main__":
    delete_pos(3)   # example position
