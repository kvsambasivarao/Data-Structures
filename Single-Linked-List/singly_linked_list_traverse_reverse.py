# File Name: singly_linked_list_traverse_reverse.py
# Program to traverse and display a singly linked list in reverse order

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

head = None

# Recursive function to traverse in reverse
def traverse_reverse(node):
    if node is None:
        return
    traverse_reverse(node.next)
    print(node.data, end=" -> ")

if __name__ == "__main__":
    if head is None:
        print("List is empty.")
    else:
        print("Reverse order:", end=" ")
        traverse_reverse(head)
        print("NULL")
