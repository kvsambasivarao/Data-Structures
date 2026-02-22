# File: rbt_search.py

class Node:
    def __init__(self, data):
        self.data = data
        self.color = "RED"
        self.left = None
        self.right = None
        self.parent = None


class RedBlackTree:

    def search(self, root, key):

        if not root or root.data == key:
            return root

        if key < root.data:
            return self.search(root.left, key)
        else:
            return self.search(root.right, key)


if __name__ == "__main__":

    tree = RedBlackTree()

    # Manual Red-Black Tree structure (BST property maintained)
    root = Node(20)
    root.color = "BLACK"

    root.left = Node(10)
    root.right = Node(30)

    key = 10

    result = tree.search(root, key)

    if result:
        print(f"Key {key} found in Red-Black Tree.")
    else:
        print(f"Key {key} not found in Red-Black Tree.")
