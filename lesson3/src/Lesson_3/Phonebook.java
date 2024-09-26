package Lesson_3;

import java.util.*;


public class Phonebook {
    private HashMap<String, List<String>> phonebook = new HashMap<String, List<String>>();

    public void Add (String name, String...arr){
        List<String> phoneList = Arrays.asList(arr);
        phonebook.put(name, phoneList);
    }

    public void GetContactByName(String name){
        System.out.println(phonebook.get(name));
    }

}
