# File: insert_binomial_heap.py

class Node:

    def __init__(self, key):
        self.key = key
        self.degree = 0
        self.parent = None
        self.child = None
        self.sibling = None


def merge(h1, h2):

    if not h1:
        return h2
    if not h2:
        return h1

    if h1.degree <= h2.degree:
        head = h1
        h1 = h1.sibling
    else:
        head = h2
        h2 = h2.sibling

    tail = head

    while h1 and h2:

        if h1.degree <= h2.degree:
            tail.sibling = h1
            h1 = h1.sibling
        else:
            tail.sibling = h2
            h2 = h2.sibling

        tail = tail.sibling

    tail.sibling = h1 if h1 else h2

    return head


def link(y, z):
    y.parent = z
    y.sibling = z.child
    z.child = y
    z.degree += 1


def union(h1, h2):

    head = merge(h1, h2)

    prev = None
    curr = head
    next = curr.sibling

    while next:

        if curr.degree != next.degree or \
           (next.sibling and next.sibling.degree == curr.degree):

            prev = curr
            curr = next

        else:

            if curr.key <= next.key:
                curr.sibling = next.sibling
                link(next, curr)

            else:

                if prev is None:
                    head = next
                else:
                    prev.sibling = next

                link(curr, next)
                curr = next

        next = curr.sibling

    return head


def insert(heap, key):

    temp = Node(key)
    return union(heap, temp)


def display(heap):

    while heap:
        print(heap.key, end=" ")
        heap = heap.sibling
    print()


# Example
heap = None

heap = insert(heap, 10)
heap = insert(heap, 5)
heap = insert(heap, 20)
heap = insert(heap, 3)

print("Root nodes after insertion:")
display(heap)
