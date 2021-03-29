//deleting a node at a position in doubly ll works either way
import java.util.Scanner;

class Node {
    int data;
    Node nextNode;
    Node prevNode;
}

class LinkedList {
    private Node head;

    public void insert(int data)
     {
        Node node = new Node();
        node.data = data;
        node.nextNode = null;

        if (this.head == null) {
            node.prevNode=null;
            head = node;
            return;
        }

        Node tempNode = this.head;
        while (tempNode.nextNode != null) 
        {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode=node;
        node.prevNode=tempNode;
    }

    public void deleting(int position) {

        
        Node temp = this.head;
        if(position==1)
        {
            head=temp.nextNode;
            return;
        }
        int i = 1;
        while (i < position) {
          
            temp = temp.nextNode;
            if (temp == null) {
                break;
            }
            i++;
        }
        System.out.println(" "+temp.data);
        temp.prevNode.nextNode=temp.nextNode; 
    }

    public void print() {
        if (this.head == null) {
            return;
        }

        // print all nodes
        Node tempNode = this.head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.nextNode;
        }
        System.out.println("NULL");
    }
}

public class dll4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.println("\nEnter nodes: ");
        LinkedList ls = new LinkedList();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            ls.insert(x);
        }
        System.out.print("\nOriginal node: ");
        ls.print();
        System.out.print("\nEnter index of node to be deleted: ");
        int pos = sc.nextInt();
        //System.out.print("\nEnter new node: ");
        //int newNode = sc.nextInt();
        ls.deleting(pos);
        System.out.print("\nModified node: ");
        ls.print();
        sc.close();
    }
}