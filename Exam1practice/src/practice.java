import java.util.ArrayList;
import java.util.List;

public class practice {
    // [hello, world, nice] -> [olleh, dlrow, ecin]
    public void reverseWords(List<String> list) {
        List<String> tempList = new ArrayList<>();
        for (String word : list){
            String reversed = "";
            for (int i = word.length()-1; i >= 0 ; i--) {
                reversed += word.charAt(i);

            }
            }
        tempList.equals(t)
        tempList.add(reversed);
    }
    return tempList;
}