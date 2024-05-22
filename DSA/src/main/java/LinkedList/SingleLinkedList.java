package LinkedList;

public class SingleLinkedList {

    public Node head;
    public Node tail;


    class  Node{
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        int  data;
        Node next;
    }

    private void add(int data) {

        if (head == null){
            Node node = new Node(data, null);
            head = node;
            tail = node;
        }
        else{
            Node node = new Node(data, null);
            tail.next = node;
            tail = node;
        }
    }

    public static void main(String args[]){

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.add(4);
        singleLinkedList.add(5);
        singleLinkedList.add(6);

        singleLinkedList.print(singleLinkedList.head);

        singleLinkedList.deleteAtIndex(2);

        System.out.println("After deleting at index 2");

        singleLinkedList.print(singleLinkedList.head);

        singleLinkedList.insertAtIndex(2, 4);

        System.out.println("After inserting at index 2");

        singleLinkedList.print(singleLinkedList.head);

        Node element = singleLinkedList.getNode(singleLinkedList.head, 5);

        if(element == null)
            System.out.print("Element Not found");
        else
            System.out.print("Element found : "+ element +" data : "+ element.data);


    }

    private Node getNode(Node head, int data) {
        /*
        * traversing till the data value matches to it, if matches return it
        * */

        Node temp = head;
        while(temp.next != null){
            if (temp.data == data) {
                return temp;
            }
            temp =temp.next;
        }

        if(temp.data == data){
            return temp;
        }
        else {
            return null;
        }
    }

    private void print(Node node) {

        while(node.next != null){
            System.out.println("data : "+ node.data);
            node = node.next;
        }
        System.out.println("data : "+ node.data);
    }

    private void insertAtIndex(int index, int data) {
        /* Creating a new node, traversing till index means ( 2 mean, 0, 1, 2 ->  1 iter, stopping before the index reach
           adding next sequence of elements ref to newly created node
           adding new node ref to existing sequence node
        */

        Node node = head;

        Node newNode = new Node(data, null);

        for(int i=0; i<index-1; i++){
            node = node.next;
        }
        newNode.next = node.next;
        node.next = newNode;

    }

    private void deleteAtIndex(int index) {

        /*
        *  Traverse before the element of index
        *  assigning next ref == next of next ref of node
        *  so middle element will be GC
        * */

        Node node = head;

        for(int i=0; i<index-1; i++){
            node = node.next;
        }

        node.next = node.next.next;
    }


    private  void createLinkedListManual() {

        Node node3 = new Node(3, null);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);

        Node node = node1;
        while(node.next != null){
            System.out.println("data : "+ node.data);
            node = node.next;
        }

        System.out.println("data : "+ node.data);
    }
}
