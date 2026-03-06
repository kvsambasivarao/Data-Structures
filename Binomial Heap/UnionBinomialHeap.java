// File: UnionBinomialHeap.java

class Node {

    int key, degree;
    Node parent, child, sibling;

    Node(int key){
        this.key = key;
        degree = 0;
        parent = child = sibling = null;
    }
}

public class UnionBinomialHeap {

    static Node merge(Node h1, Node h2){

        if(h1 == null) return h2;
        if(h2 == null) return h1;

        Node head;

        if(h1.degree <= h2.degree){
            head = h1;
            h1 = h1.sibling;
        }
        else{
            head = h2;
            h2 = h2.sibling;
        }

        Node tail = head;

        while(h1 != null && h2 != null){

            if(h1.degree <= h2.degree){
                tail.sibling = h1;
                h1 = h1.sibling;
            }
            else{
                tail.sibling = h2;
                h2 = h2.sibling;
            }

            tail = tail.sibling;
        }

        tail.sibling = (h1 != null) ? h1 : h2;

        return head;
    }

    static void link(Node y, Node z){
        y.parent = z;
        y.sibling = z.child;
        z.child = y;
        z.degree++;
    }

    static Node union(Node h1, Node h2){

        Node head = merge(h1, h2);

        Node prev = null;
        Node curr = head;
        Node next = curr.sibling;

        while(next != null){

            if(curr.degree != next.degree ||
               (next.sibling != null && next.sibling.degree == curr.degree)){

                prev = curr;
                curr = next;
            }

            else{

                if(curr.key <= next.key){
                    curr.sibling = next.sibling;
                    link(next, curr);
                }

                else{

                    if(prev == null)
                        head = next;
                    else
                        prev.sibling = next;

                    link(curr, next);
                    curr = next;
                }
            }

            next = curr.sibling;
        }

        return head;
    }

    static void display(Node head){

        while(head != null){
            System.out.print(head.key + " ");
            head = head.sibling;
        }
        System.out.println();
    }

    public static void main(String[] args){

        Node h1 = new Node(10);
        h1.sibling = new Node(30);

        Node h2 = new Node(5);
        h2.sibling = new Node(20);

        Node result = union(h1, h2);

        System.out.print("Roots after union: ");
        display(result);
    }
}
