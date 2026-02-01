# File Name: delete_end.py
# Program to delete the last node of a singly linked list

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

head = None

# Function to delete the last node
def delete_end():
    global head

    if head is None:
        print("List is empty. Deletion not possible.")
        return

    # If only one node exists
    if head.next is None:
        head = None
        print("Last node deleted successfully.")
        return

    temp = head
    while temp.next.next is not None:
        temp = temp.next
    temp.next = None
    print("Last node deleted successfully.")

if __name__ == "__main__":
    delete_end()
