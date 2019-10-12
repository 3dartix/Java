package Lesson_3.DZ;

import java.util.HashMap;
import java.util.HashSet;

public class MainPhone {
    public static void main(String[] args) {

//        String[] arr = {"Abc","Bcd","Abc","Tre"};
//        HashSet<String> hs= new HashSet<>();
//        for(String o: arr) {
//            hs.add(o);
//        }
//        System.out.println(hs);
//
//

//        String[] arr = {"Abc","Bcd","Abc","Tre"};
//        HashMap<String, Integer> hm = new HashMap<>();
//        for(String o: arr) {
//            hm.put(o, hm.getOrDefault(o,0) + 1);
//        }
//        System.out.println(hm);

        PhoneBox book = new PhoneBox();
        book.add("Ivanov", "123");
        book.add("Ivanov", "124");
        book.add("Ivanov", "125");
        book.add("Petrov", "444");
        book.add("Petrov", "445");
        book.add("Petrov", "446");

        book.findString("Ivanov");
        book.findString("Petrov");
        book.findString("Petrasdov");

    }
}
