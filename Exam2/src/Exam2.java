import java.util.HashMap;
import java.util.Map;

public class Exam2 {
    private class Node<E> {
        E item;
        Node<E> left;
        Node<E> right;

        public Node(E item) {
            this.item = item;
        }
    }

    public static <E> int sizeTree(Node<E> root) {
        if (root == null) {
            return 0;
        }

        return 1 + sizeTree(root.left) + sizeTree(root.right);
    }

    public static <E> boolean isFull(Node<E> root) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            return true;
        } else if (root.left != null && root.right == null) {
            return false;
        } else if (root.left == null && root.right != null) {
            return false;
        } else {
            return isFull(root.left) && isFull(root.right);

        }
    }
    public static boolean equals(Node<E> treeA,Node<E> treeB) {
        if (treeA == null && treeB ==  null) {
            return true;
        } else if (treeA == null && treeB == null) {
            return true;
        } else if (treeA == null && treeB == null) {
            return true;
        }
    }
    public static Map<Character, Integer> count(String Object word;word){
            Map<Character, Integer> map = new HashMap<>();
            for (char letter : word.tochararray()){
                if(!map.containsKey(letter)){
                    map.put(letter,1);
                } else{
                    int prev = map.get(letter);
                    map.put(letter, prev+1);
                }
            }
            return map;
        }

// Collisions: When there are a limited number of indicies and how to handle, use
        // use open addressing look to next available space
        // use a linked list : chaining with hashtable

    }
}