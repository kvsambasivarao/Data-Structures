# File: rbt_rotate.py

class Node:
    def __init__(self, data):
        self.data = data
        self.color = "RED"
        self.left = None
        self.right = None
        self.parent = None


class RedBlackTree:

    def __init__(self):
        self.root = None

    def left_rotate(self, x):
        y = x.right

        x.right = y.left
        if y.left:
            y.left.parent = x

        y.parent = x.parent

        if not x.parent:
            self.root = y
        elif x == x.parent.left:
            x.parent.left = y
        else:
            x.parent.right = y

        y.left = x
        x.parent = y

    def right_rotate(self, y):
        x = y.left

        y.left = x.right
        if x.right:
            x.right.parent = y

        x.parent = y.parent

        if not y.parent:
            self.root = x
        elif y == y.parent.left:
            y.parent.left = x
        else:
            y.parent.right = x

        x.right = y
        y.parent = x


if __name__ == "__main__":
    print("Red-Black Tree rotation operations implemented successfully.")
