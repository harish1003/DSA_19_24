package LinkedList;

public class DoublyLinkedList {
    public node head = null;
    public node tail = null;
    public node newNode = null;
    public class node{
        int data;
        node next;
        node prev;

        public node(int data, node next, node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    public void add(int date) {

       /*
       * 1. check if head is null, then create it as a first element of list
       *  STEPS :
       *        1. new node reference  should be added to previous node next
       *        2. previous node ref should be added to new node prev
       *        3. update tail to newly created node
       * */
        newNode = new node(date,null,null);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

    }



    public static void main(String args[]) throws Exception {

        DoublyLinkedList dllist = new DoublyLinkedList();
        dllist.add(1);
        dllist.add(2);
        dllist.add(3);
        dllist.add(4);

        dllist.printF(dllist.head);
        dllist.printB(dllist.tail);

        dllist.insertAtIndex(0, -1);
        dllist.printF(dllist.head);
        dllist.insertAtIndex(5, -1);
        dllist.printF(dllist.head);




    }

    private void insertAtIndex(int index, int data) throws Exception {

      /*  insert at beginning & ending will be handled in special case {
           existing node prev or next will be modified with new node and vice versa,
           and now new head and tail is newly created node
           }
      *
      *   insert at middle will have the 4 steps to do
      *     1. update the previous node next to new node
      *     2. new node.prev is previous node
            3. new node.next is current node (after traversal)
            4. current node.prev is new node
      *
      * */



        if (index < 0){
            throw new Exception("Invalid Index");
        }

        node newNode = new node(data,null,null);

        if (index == 0){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }
        node currNode = head;
        if(index == 5){
            for(int i=0; i<index-1;i++){
                currNode = currNode.next;
            }
            currNode.next = newNode;
            newNode.prev = currNode;
            tail = newNode;
            return;
        }





        for(int i=0; i<index;i++){
            currNode = currNode.next;
        }

        currNode.prev.next = newNode;

        newNode.prev = currNode.prev;


        newNode.next = currNode;

        currNode.prev = newNode;



    }

    private void printB(node tail) {

        node currNode = tail;
        System.out.println("Printing Backward");

        while(currNode != null){
            System.out.print(currNode.data+" ");
            currNode = currNode.prev;
        }
        System.out.println("");

    }

    private void printF(node head) {

        node currNode = head;
        System.out.println("Printing Forward");
        while(currNode != null){
            System.out.print(currNode.data+" ");
            currNode = currNode.next;
        }
        System.out.println("");
    }


}
