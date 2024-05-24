package LinkedList;

public class DoublyCircularLinkedList {

    public Node head;

    public Node tail;

    public int size ;

    class Node{

        int data;
        Node next;
        Node prev;


        public Node(int data) {
            this.data = data;
        }
    }


    public static void main(String[] args) throws Exception {
     /*   traversal
       1. Add
       2. Delete
       3. Insert
       4. search
       5. removeAll (full method)
     */

        DoublyCircularLinkedList doublyCircularLinkedList = new DoublyCircularLinkedList();
        doublyCircularLinkedList.add(5);   doublyCircularLinkedList.add(4);   doublyCircularLinkedList.add(3);   doublyCircularLinkedList.add(2);   doublyCircularLinkedList.add(1);
        doublyCircularLinkedList.printF();
        doublyCircularLinkedList.printB();


        System.out.println("Delete at index");

        doublyCircularLinkedList.deleteAtIndex(0);
        doublyCircularLinkedList.printF();
        doublyCircularLinkedList.deleteAtIndex(3);
        doublyCircularLinkedList.printF();
        doublyCircularLinkedList.deleteAtIndex(0);
        doublyCircularLinkedList.printF();
        doublyCircularLinkedList.deleteAtIndex(0);
        doublyCircularLinkedList.printF();
        doublyCircularLinkedList.deleteAtIndex(0);
        doublyCircularLinkedList.printF();

        System.out.println("\nInsert at index");

        doublyCircularLinkedList.insertAtIndex(0,  4);
        doublyCircularLinkedList.printF();

        doublyCircularLinkedList.insertAtIndex(1,  3);
        doublyCircularLinkedList.printF();
        doublyCircularLinkedList.insertAtIndex(0,  5);
        doublyCircularLinkedList.printF();

        doublyCircularLinkedList.insertAtIndex(3,  2);
        doublyCircularLinkedList.insertAtIndex(4,  1);
        doublyCircularLinkedList.printF();


        doublyCircularLinkedList.insertAtIndex(0,  1);
        doublyCircularLinkedList.printF();
        doublyCircularLinkedList.insertAtIndex(4,  1);

        doublyCircularLinkedList.printF();

        doublyCircularLinkedList.removeAll(1);
        doublyCircularLinkedList.printF();

    }

    private void removeAll(int data) throws Exception {
        Node currNode = head;

        if(head == null){
            throw new Exception("Empty list");
        }
        int tsize = size;
        int tempP = 0;

        for(int i=0;i<tsize;i++){
            if(currNode.data == data){
               deleteAtIndex(i-tempP);
               tempP++;
            }
            currNode =currNode.next;
        }

/*        while (head.next != currNode){
               if(head.data == data){
                   head.prev.next = head.next;
                   head.next.prev = head.prev;
               }
               else {
                   head = head.next;
               }
        }*/

    }

    private void insertAtIndex(int index, int data) throws Exception {
        if(index < 0 || index > size){
            throw new Exception("Index out of bounds");
        }

        if(head == null || index == 0){
            if (head == null) add(data);
            else {
                Node newnode = new Node(data);
                head.prev.next = newnode;
                newnode.prev = head.prev;
                head.prev = newnode;
                newnode.next = head;
                head = newnode;
                size++;
            }
        }
        else{
            Node newnode = new Node(data);
            Node currnode = head;

            if(index == size){
                newnode.prev =tail;
                newnode.next = head;
                tail.next = newnode;
                head.prev = newnode;
                tail = newnode;
                size++;
                return;
            }

            for(int i=0; i<index; i++){     // will land on top of node, before this node should add
                currnode =currnode.next;
            }

            currnode.prev.next = newnode;
            newnode.prev = currnode.prev;
            newnode.next = currnode;
            currnode.prev = newnode;
            size++;

        }



    }

    private void deleteAtIndex(int index) throws Exception{

        if(head == null || index > size -1 || index < 0){
            throw new Exception("Index Out of Bounds");
        }

        if(size == 1 && index == 0){
            head=null;
            tail=null;
            size--;
            return;
        }

        if(index == 0){
            Node currNode = head;
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            head = head.next;
            size--;
            return;
        }

        if(index == size -1){
            Node currNode = tail;
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            tail=tail.prev;
            size--;
            return;
        }
        else{

            Node curr = head;
            for(int i=0; i<index;i++){
                curr = curr.next;
            }

            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

        }


    }

    private void printB() {
        System.out.print("Printing Backward using head Element ");
        Node temp = head.prev;

        while(temp.prev != head.prev){
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
        System.out.print(temp.data);
        System.out.println();
    }

    public void printF() {
        if (head == null){
            System.out.print("List is Empty");
            return;
        }

        System.out.print("Printing Forward Elements ");
        Node temp = head;
        if(size > 1) {
            while (temp.next != head) {
                  System.out.print(temp.data + " ");
                  temp = temp.next;
             }
        }
        System.out.print(temp.data);
        System.out.println();


    }

    private void add(int data) {
        Node newNode = new Node(data);

        if(head == null){
             head = newNode;
             tail = newNode;
             size++;
        }
        else{
             tail.next = newNode;
             newNode.prev = tail;
             newNode.next = head;
             tail = newNode;
             head.prev = tail;
             size++;
        }

    }
}
