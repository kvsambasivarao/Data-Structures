# File: threaded_binary_tree.py

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
        self.lThread = True
        self.rThread = True


class ThreadedBinaryTree:

    def __init__(self):
        self.root = None

    def insert(self, key):
        parent = None
        current = self.root

        while current:
            if key == current.data:
                return

            parent = current

            if key < current.data:
                if not current.lThread:
                    current = current.left
                else:
                    break
            else:
                if not current.rThread:
                    current = current.right
                else:
                    break

        node = Node(key)

        if parent is None:
            self.root = node
        elif key < parent.data:
            node.left = parent.left
            node.right = parent
            parent.lThread = False
            parent.left = node
        else:
            node.left = parent
            node.right = parent.right
            parent.rThread = False
            parent.right = node

    def inorder(self):
        current = self.root
        while current and not current.lThread:
            current = current.left

        while current:
            print(current.data, end=" ")
            if current.rThread:
                current = current.right
            else:
                current = current.right
                while current and not current.lThread:
                    current = current.left

    def search(self, key):
        current = self.root
        while current:
            if key == current.data:
                return current
            if key < current.data:
                if not current.lThread:
                    current = current.left
                else:
                    break
            else:
                if not current.rThread:
                    current = current.right
                else:
                    break
        return None


if __name__ == "__main__":
    tree = ThreadedBinaryTree()

    tree.insert(20)
    tree.insert(10)
    tree.insert(30)
    tree.insert(25)

    print("Inorder Traversal:")
    tree.inorder()
