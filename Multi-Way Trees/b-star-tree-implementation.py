# File: b-star-tree-implementation.py
# Program implementing B* Tree operations

class Node:

    def __init__(self):
        self.keys = []
        self.children = []
        self.leaf = True


class BStarTree:

    def __init__(self):
        self.root = Node()

    def traverse(self,node):

        for i in range(len(node.keys)):

            if not node.leaf:
                self.traverse(node.children[i])

            print(node.keys[i], end=" ")

        if not node.leaf:
            self.traverse(node.children[len(node.keys)])

    def search(self,node,key):

        i=0

        while i < len(node.keys) and key > node.keys[i]:
            i+=1

        if i < len(node.keys) and key == node.keys[i]:
            return node

        if node.leaf:
            return None

        return self.search(node.children[i],key)

    def insert(self,key):

        if len(self.root.keys) < 4:
            self.root.keys.append(key)
            self.root.keys.sort()


if __name__ == "__main__":

    tree = BStarTree()

    tree.insert(10)
    tree.insert(20)
    tree.insert(5)
    tree.insert(30)
    tree.insert(15)

    print("Traversal of B* Tree:")

    tree.traverse(tree.root)
