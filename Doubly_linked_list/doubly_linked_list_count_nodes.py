# File Name: doubly_linked_list_count_nodes.py
# Program to count the number of nodes in a doubly linked list

class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

head = None

# Function to count nodes
def count_nodes():
    global head
    count = 0
    temp = head

    while temp is not None:
        count += 1
        temp = temp.next

    return count

if __name__ == "__main__":
    print("Number of nodes =", count_nodes())
