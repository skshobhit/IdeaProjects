import org.w3c.dom.Node;

import javax.management.openmbean.ArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListMethod {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List myList = new ArrayList<Integer>(Arrays.asList(1, 25, 2, 5, 30, 19, 57, 2, 25));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(25);
        list.add(2);
        list.add(5);
        list.add(30);
        list.add(19);
        list.add(57);
        list.add(2);
        list.add(25);
        List list2 = new ArrayList();
        list2.add("I");
        list2.add("like");
        list2.add("to");
        list2.add("eat");
        list2.add("eat");
        list2.add("eat");
        list2.add("bananas");
        list2.add("and");
        list2.add("apples");
        List list3 = new ArrayList();
        List list4 = new ArrayList();
        list3.add(1);
        list3.add(2);
        list3.add(4);
        list4.add(3);
        list4.add(1);
        list4.add(4);
        List list5 = new ArrayList();
        list5.add("shob");
        list5.add("shob");
        list5.add("show");
        list5.add("shon");

        List<Integer> result = allMultiples(list, 5);
        System.out.println(result);
        List<String> word = allStringsOfSize(list2, 3);
        System.out.println(word);
        System.out.println(isPermutation(list3, list4));
        removeallinstances(list5, "sho");
        System.out.println(list5.toString());
        String str = "Hello World!";
        System.out.println(stringToListOfWords(str));
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        System.out.println(end-start);


    }

    public static boolean unique(List myList) {
        for (int i = 0; i < myList.size(); i++) {
            for (int j = i + 1; j < myList.size(); j++) {
                if (myList.get(i).equals(myList.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Integer> allMultiples(List<Integer> list, int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % n == 0) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public static List<String> allStringsOfSize(List<String> list2, int length) {
        List<String> word = new ArrayList<>();
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).length() == length) {
                word.add(list2.get(i));
            }
        }
        return word;
    }

    public static boolean isPermutation(List a, List b) {
        if (a.size() != b.size()) {
            return false;
        }
        List<Integer> samenum = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                if (a.get(i) == b.get(j)) {
                    return true;
                }
            }
        }
        return false;
    }
    ArrayList<E> hello = new ArrayList<E>()
    public static List<String> stringToListOfWords(String m){
        List<String> list = new ArrayList<String>();
        m = m.replaceAll("[^\\w\\s]"," ");
        list.addAll(Arrays.asList(m.split(" ")));
        return list;


    }

    public static <E> void removeallinstances(List<String> vegeta, String prefix) {
        prefix = "sho";
        for (int i = 0; i < vegeta.size(); i++) {
            if (vegeta != null && vegeta.contains(prefix)) {
                vegeta.remove(i);
            }
        }
        void removeDuplicates()
        {
            /*Another reference to head*/
            Node head;
            Node curr = head;

            /* Traverse list till the last node */
            while (curr != null) {
                Node temp = curr; 
            /*Compare current node with the next node and  
            keep on deleting them until it matches the current  
            node data */
                while(temp!=null && temp.data==curr.data) {
                    temp = temp.next;
                } 
            /*Set current node next to the next different  
            element denoted by temp*/
                curr.next = temp;
                curr = curr.next;
            }
        }


    }

        }



// unique: o(n)
// allMultiples o(n^2)
// allStringsofSize o(n)
//isPermutation o(n^2)
// stringToListOfWords  o(1)
// removeAllinstances o(1)
