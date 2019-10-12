package Lesson_3;

import java.util.*;

public class MainCollection {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5};
//        System.out.println(Arrays.toString(arr));
//        int[] arr2 = new int[20];
//        System.arraycopy(arr, 0, arr2,0, arr.length);
//        System.out.println(Arrays.toString(arr2));

//        ArrayList<Integer> ai = new ArrayList<>();
//      //  ai.ensureCapacity(1000000);
//        System.out.println(ai.size());
//        ai.add(1);
//        ai.add(2);
//        ai.add(3);
//        ai.add(4);
//        ai.add(null);
//        System.out.println(ai.size());
//
//      //  ai.remove((Integer) 2);
//        System.out.println(ai.get(2));
//        System.out.println(ai);
//
//        if (ai.contains(11)) {
//            System.out.println("коллекция содержит 1");
//        }

//        ArrayList<String> states = new ArrayList<String>();
//        states.add("Германию");
//        states.add("Германию");
//        states.add("Францию");
//        states.add("Италия");
//        states.add("Россия");

//        for (int i = 0; i < states.size(); i++) {
//            if (states.get(i).equalsIgnoreCase("Германию")) {
//                states.remove(i);
//                i--;
//            }
//        }

//        Iterator<String> iter = states.iterator();
//        while (iter.hasNext()) {
//            if (iter.next().equalsIgnoreCase("Германию")) {
//                iter.remove();
//            }
//        }

//        ListIterator<String> iter = states.listIterator();
//
//        while (iter.hasNext()) {
//            iter.ha
//        }

//        System.out.println(states);

       // List<String> ll = new LinkedList<>();

//        ll.add("A");
//        ll.add("B");
//        ll.add("C");
//        ll.add("D");
//        System.out.println(ll);

//        Box b1 = new Box("Red", 2);
//        Box b2 = new Box("Red", 2);
//
//        System.out.println(b1.hashCode());
//        System.out.println(b2.hashCode());
//        System.out.println(b1.equals(b2));

//        String a = "10";
////        String b = "10";
////
////        System.out.println(a.hashCode());
////        System.out.println(b.hashCode());



//        HashMap<String, Integer> hm = new HashMap<>();
//
//        hm.put("Васька", 6);
//        hm.put("Мурзик", 6);
//        hm.put("Рыжик", 6);
//        hm.put("Васька", 61);
//
//        System.out.println(hm.get("Васька"));
//
//        System.out.println(hm);

//        Set<Map.Entry<String, Integer>> set = hm.entrySet();
//        for (Map.Entry<String, Integer> me : set) {
//            System.out.println(me.getKey());
//            System.out.println(me.getValue());
//        }



//        Random random = new Random();
//
//        Map<Integer, Integer> hm = new HashMap<>();
//
//        for (int i = 0; i < 100; i++) {
//            int num = random.nextInt(10);
//            Integer current = hm.get(num);
//            hm.put(num, current == null ? 1 : current + 1);
//        }
//        System.out.println(hm);



//        Set<String> hs = new HashSet<>();
//
//        hs.add("Bbcfdgdfg");
//        hs.add("Abc");
//        hs.add("C");
//        hs.add("D");
//
//        System.out.println(hs);

//        TreeSet<Empl> ts = new TreeSet<>(new MySalaryComp());
//
//        ts.add(new Empl("Bob1", 100));
//        ts.add(new Empl("Bob2", 200));
//        ts.add(new Empl("Bob3", 300));
//
//        for (Empl o : ts) {
//            o.info();
//        }

        //System.out.println(map.getOrDefault(key, "Default"));
    }

    static HashMap<Integer, String> initHm() {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(100, "Test11");
        hm.put(101, "Test12");
        return hm;
    }

}

class MySalaryComp implements Comparator<Empl> {

    @Override
    public int compare(Empl o1, Empl o2) {
        if (o1.getSalary() < o2.getSalary()) {
            return 1;
        } else {
            return -1;
        }
    }
}


class Empl {
    private String name;
    private int salary;

    public Empl(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void info() {
        System.out.println(name + " " + salary);
    }
}

class Box {
    String color;
    int size;

    public Box(String color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public int hashCode() {
        return size + color.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Box) {
            Box another = (Box)obj;
            if (this.color.equalsIgnoreCase(another.color) && this.size == another.size) {
                return true;
            }
        }
        return false;
    }
}
