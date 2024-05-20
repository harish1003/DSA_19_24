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

     //   singleLinkedList.createLinkedListManual();

        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.add(4);
        singleLinkedList.add(5);
        singleLinkedList.add(6);


        Node node = singleLinkedList.head;
        while(node.next != null){
            System.out.println("data : "+ node.data);
            node = node.next;
        }
        System.out.println("data : "+ node.data);

        singleLinkedList.deleteAtIndex(2);


        System.out.println("After deleting at index 2");

        node = singleLinkedList.head;
        while(node.next != null){
            System.out.println("data : "+ node.data);
            node = node.next;
        }
        System.out.println("data : "+ node.data);

        singleLinkedList.insertAtIndex(2, 4);

        System.out.println("After inserting at index 2");

        node = singleLinkedList.head;
        while(node.next != null){
            System.out.println("data : "+ node.data);
            node = node.next;
        }
        System.out.println("data : "+ node.data);


    }

    private void insertAtIndex(int index, int data) {

        Node node = head;

        Node newNode = new Node(data, null);

        for(int i=0; i<index-1; i++){
            node = node.next;
        }
        newNode.next = node.next;
        node.next = newNode;

    }

    private void deleteAtIndex(int index) {
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
