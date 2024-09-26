package Lesson_3;

import java.util.*;

public class WordsArray {
    public static void main(String[] args) {
        ArrayList<String> wordsArr = new ArrayList<String>();
        wordsArr.add("слово1");
        wordsArr.add("слово1");
        wordsArr.add("слово2");
        wordsArr.add("слово2");
        wordsArr.add("слово3");
        wordsArr.add("слово5");
        wordsArr.add("слово5");
        wordsArr.add("слово1");
        wordsArr.add("слово1");

        GetCountUniqueWords(wordsArr);
    }

    public static void GetCountUniqueWords(ArrayList<String> arr){
        Iterator<String> iter = arr.iterator();

        HashMap<String, Integer> hm = new HashMap<>();

        while (iter.hasNext()) {
            String t = iter.next();
            if (hm.containsKey(t)){
                int value = hm.get(t);
                hm.put(t, value + 1);
            } else {
                hm.put(t, 1);
            }
        }

        System.out.println(hm);
    }
}
