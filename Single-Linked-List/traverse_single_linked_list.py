# File Name: traverse_list.py
# Program to traverse and print a singly linked list from left to right

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

head = None

# Function to traverse and print the list
def traverse():
    global head

    if head is None:
        print("List is empty.")
        return

    temp = head
    print("Linked List contents:", end=" ")
    while temp is not None:
        print(temp.data, end=" -> ")
        temp = temp.next
    print("NULL")

if __name__ == "__main__":
    traverse()
