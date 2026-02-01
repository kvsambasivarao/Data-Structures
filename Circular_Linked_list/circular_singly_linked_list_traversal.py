# File Name: circular_singly_linked_list_traversal.py
# Program to traverse a circular singly linked list
# left to right and right to left (using recursion)

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

head = None

# Left to Right traversal
def traverse_forward():
    global head
    if head is None:
        print("List is empty")
        return

    temp = head
    print("Left to Right:", end=" ")
    while True:
        print(temp.data, end=" -> ")
        temp = temp.next
        if temp == head:
            break
    print("HEAD")

# Recursive helper
def traverse_reverse_util(node, start):
    if node.next != start:
        traverse_reverse_util(node.next, start)
    print(node.data, end=" -> ")

# Right to Left traversal
def traverse_backward():
    global head
    if head is None:
        print("List is empty")
        return

    print("Right to Left:", end=" ")
    traverse_reverse_util(head, head)
    print("HEAD")

if __name__ == "__main__":
    traverse_forward()
    traverse_backward()
