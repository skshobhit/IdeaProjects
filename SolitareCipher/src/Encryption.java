
public class Encryption {



    public static char encrypt(char letter, int key) {
        return    (char) ((((letter - 'a') + key)  % 28) + 'a');
    }


    public static void main(String[] args) {
        CircularLinkedList<Integer> deck = new CircularLinkedList<>();
        for (int i = 0; i < 28; i++) {
            deck.add((3 * i % 28) + 1);
        }
        String message = "hello world";
        String ciphertext = "";
        System.out.println(deck);
        for (char letter : message.toCharArray()) {
            int key = genKey(deck);
            ciphertext += encrypt(letter, key);
        }
        System.out.println(deck.size());
        System.out.println(ciphertext);
    }

    private static int genKey(CircularLinkedList<Integer> deck) {
        int key = 27;
        while (key >= 27) {
            step1(deck);
            step2(deck);
            step3(deck);
            step4(deck);
            key = step5(deck);

        }
        System.out.println(key);
        return key;
    }

    private static int step5(CircularLinkedList<Integer> deck) {

        return deck.get(deck.get(0));
    }
    private static void step4(CircularLinkedList<Integer> deck) {
        int count = deck.remove(deck.size -1);
        for (int i = 0; i < count; i++) {
            deck.add(deck.remove(0));
        }
        deck.add(count);


    }
    private static void step3 (CircularLinkedList < Integer > deck) {
        CircularLinkedList<Integer> top = new CircularLinkedList<>();
        CircularLinkedList<Integer> middle = new CircularLinkedList<>();
        CircularLinkedList<Integer> bottom =  new CircularLinkedList<>();
        while (deck.get(0) != 27 && deck.get(0) != 28) {
            top.add(deck.remove(0)); //6 while statements
        }
        middle.add(deck.remove(0));
        while (deck.get(0) != 27 && deck.get(0) != 28) {
            middle.add(deck.remove(0)); //6 while statements
        }
        middle.add(deck.remove(0));
        while (deck.size > 0) {
            bottom.add(deck.remove(0));
        }
        while (bottom.size > 0){
            deck.add(bottom.remove(0));
        }
        while (middle.size > 0){
            deck.add(middle.remove(0));

        }
        while (top.size >0){
            deck.add(top.remove(0));
        }
    }
    private static void step2 (CircularLinkedList <Integer> deck) {
            for (int j = 0; j < deck.size; j++) {
                if (deck.get(j).equals(28)) {
                    int joker1 = deck.remove(j);
                    deck.add((j + 2)%28, joker1);
                    break;
                }
            }

    }

    private static void step1 (CircularLinkedList <Integer> deck) {
        for (int j = 0; j < deck.size ; j++) {
            if (deck.get(j).equals(27)){
                int joker1 = deck.remove(j);
                deck.add((j+1)%28,joker1);
                break;
            }

        }


    }
}


