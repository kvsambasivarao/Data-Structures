# File Name: delete_beg.py
# Program to delete the first node of a singly linked list

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

head = None

# Function to delete beginning node
def delete_beg():
    global head
    if head is None:
        print("List is empty. Deletion not possible.")
        return
    head = head.next
    print("First node deleted successfully.")

if __name__ == "__main__":
    delete_beg()
