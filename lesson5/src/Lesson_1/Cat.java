package Lesson_1;

public class Cat {
    String name;
    String color;
    int age;

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void info() {
        System.out.println(name + " " + color + " " + age);
    }
}

class MainCat {
    public static void main(String[] args) {
//        Cat cat1 = new Cat("Vaska", "red", 10);
//
//        Cat cat2 = new Cat("Jora", "black", 5);
//        cat2 = cat1;
//
//        cat1.info();
//        cat2.info();
//        Object o = new Object();

//        System.out.println(sum(1,2,3));
//        System.out.println(sum(1,2,3,7,8));
//        System.out.println(sum(1,2,3,7,8,8,9));

        test1();
    }


    static void test1() {
        System.out.println(1);
    }

//    static int sum(int a, int b) {
//        return a + b;
//    }
//
//    static int sum(int a, int b, int c) {
//        return a + b + c;
//    }

//    static int sum(Object c) {
////        int res = 0;
////
////        for (int i = 0; i < mass.length; i++) {
////            res += mass[i];
////        }
////
////        return res;
//    }
}

abstract class SuperAnimal1 {
    void info() {

    }

    abstract void run();
}



abstract class SuperAnimal {
    void info() {

    }

    abstract void run();
}

class SuperCat extends SuperAnimal {
    @Override
    void run() {

    }

//    @Override
//    void run() {
//
//    }
}
