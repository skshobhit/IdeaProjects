import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exam1corrections {
   // 2.) public static <E> void removePrefixStrings(List<String. list, String prefix){
     //   for(int i = 0; i < list.size(); i++){
       //     if(list.get(i).startsWith(prefix)){
         //       list.remove(i);
           //     i--;
            //}
        //}
    //}
// 3.) o(n^2)
//4.) Already Correct
// 5.) o(n^2)
   public static Map<String,Integer> wordCount(List<String> words){
       Map <String, Integer> map = new HashMap<String, Integer>();

       for (String a: strings){
           if (!map.containsKey(a)){
               map.put(a, 1);
           }
           else{
               int count = map.get(a);
               map.put(a, count +1);
           }
       }
       return map
