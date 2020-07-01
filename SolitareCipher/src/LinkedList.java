public class LinkedList<E> {
    private static class Node<E>{

        private E data;
        private Node<E> next; //memory location of the next node
        //memory location on the right gets
        // stored with the variable on the left
        public Node(E data){
            this.data = data;

        }

    }

    public static void main(String[] args) {
        Node<String> n1 = new Node<>("Bread");
        Node<String> n2 = new Node<>("milk");
        Node<String> n3 = new Node<>("eggs");
        n1.next  = n2;
        // memory location on the right
        // is stored in the variable on the left
        n2.next = n3;
        n1.next = n2; //last node has an arrow but it points to nothing
        Node<String> current = n1; //n1 and current are aliases of the same node
        // n1,n2,n3 are labels
        while(current != null){
            System.out.println(current.data);
            current = current.next;
            //memory location on the right gets stored with
            // variable on the left
        }
    }

}
