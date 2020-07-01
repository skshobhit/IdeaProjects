import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class cheatershangman {
    public static int setsize = 0;
    public static int t = 1;
    public static int wrong = 0;
    public static int correctguesses = 0;
    public static Character finalGuess ;



    public static void main(String[] args) {
        Set<String> allWords = new HashSet<>();
        String fileName = "words.txt";
        int largestWord = 0;
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                String g = scanner.next();
                int h = g.length();
                if (h > largestWord) {
                    largestWord = h;
                }
                allWords.add(g);
                setsize++;

            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        System.out.println("Welcome to Hangman");
        allWords = selectSize(allWords, largestWord);
        //System.out.println(allWords);  test function to make sure the select size feature is running
        Scanner g = new Scanner(System.in);
        System.out.print("How many guesses would you like to recieve?");
        wrong = g.nextInt();
        playGame(allWords, wrong);

    }

    public static Set selectSize(Set<String> words, int largeWord) {
        Set<String> toReturn = new HashSet<>();
        Scanner console = new Scanner(System.in);
        System.out.print("How many letters would you like the word to be? ");
        t = console.nextInt();
        while (t <= 0 || t >= largeWord) {
            System.out.print("How many letters would you like the word to be? (Number was less than 0 or there were no words of that length in our library) ");
            t = console.nextInt();
        }
        if (t > 0 && t <= largeWord) {
            setsize = 0;
            for (String word : words) {
                if (word.length() == t) {
                    toReturn.add(word);
                    setsize++;
                }
            }
        }

        return toReturn;

    }

    public static void playGame(Set<String> words, int guesses) {
        List<String> wordList = new ArrayList<>();
        Map<String, List<String>> wordFams = new HashMap<>();
        for (String word : words) {
            wordList.add(word);
        }
        Scanner console = new Scanner(System.in);
        Set<Character> usedletters = new HashSet<>();
        String board = "";
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < t; i++) {
            board += "_";
        }

        while (wrong > 0 && !(win(wordList,board))) {
            System.out.println("Number of guesses: " + wrong );
            System.out.println(board);
            System.out.println("");
            System.out.println("Guessed letters:");
            System.out.println(usedletters);
            System.out.print("Guess a letter--> ");
            String c = console.next();
            Character g = c.charAt(0);
            while (usedletters.contains(g)) {
                System.out.print("You have already guessed that letter--> ");
                String h = console.next();
                g = h.charAt(0);
            }
            usedletters.add(g);
            wordFams = genFamilies(wordList,usedletters);
            String familychoice = bestFamily(wordFams);
            wordList = wordFams.get(familychoice);
            System.out.println(wordList);
            if (board.equals(familychoice)) {
                wrong--;
                if(wrong == 0){
                    finalGuess = g;
                }
            } else {
                correctguesses++;
            }
            board = familychoice;
        }
        if((win(wordList,board))){
            System.out.println("You won");
        } else {
            System.out.println("Sorry you lost the word was: " + revealWord(wordList,finalGuess));
        }

    }

    public static Map<String, List<String>> genFamilies(List<String> wordList, Set<Character> guessedLetters) {
        Map<String, List<String>> families = new HashMap<>();
        //List<String> list = new ArrayList<>();
        for (String word : wordList) {
            String wordFam = "";
            for (int i = 0; i < word.length(); i++) {
                if(guessedLetters.contains(word.charAt(i))){
                    wordFam+=word.charAt(i);
                } else {
                    wordFam += "_";
                }
            }
            if (families.containsKey(wordFam)) {
                List<String> list = families.get(wordFam);
                list.add(word);
                families.put(wordFam, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                families.put(wordFam, list);
            }

        }

        return families;
    }

    public static String bestFamily(Map<String, List<String>> families) {
        int size = 0;
        String toReturn = "";
        for (Map.Entry<String, List<String>> entry : families.entrySet()) {
            if (entry.getValue().size() > size) {
                size = entry.getValue().size();
                toReturn = entry.getKey();
            }
        }
        return toReturn;

    }


    public static String revealWord(List<String> list, Character h){
        for(String word : list){
            int counter = 0;
            for (int i = 0; i < word.length(); i++) {
                if(word.charAt(i) != h){
                    counter++;
                }
            }
            if(counter == word.length()){
                return word;
            }
        }
        return list.get(0);
    }
    public static boolean win(List<String> list, String board){
        if(list.size() == 1 && list.get(0).equals(board)){
            return true;
        }else{
            return false;
        }
    }



}
