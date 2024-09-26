package Lesson_3.DZ;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBox {
    HashMap<String, HashSet<String>> hm;

    public PhoneBox() {
        this.hm = new HashMap<>();
    }

    public void add(String name, String phone) {
        HashSet<String> hs = hm.getOrDefault(name, new HashSet<>());
        hs.add(phone);
        hm.put(name, hs);
    }

    public void findString(String name) {
        if(hm.containsKey(name)) {
            System.out.println(hm.get(name));
        } else {
            System.out.println("такой фамилии нет");
        }
    }
}