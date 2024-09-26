package Lesson_1;

// 1
//public class Test {
//    public static void main(String[] args) {
//        A classА = new B();
//        classА.рrintX();
//    }
//}
//
//class A {
//    int x = 1;
//
//    public void рrintX() {
//        System.out.println(getX());
//    }
//
//    int getX() {
//        return x;
//    }
//
//}
//
//class B extends A {
//    int x = 2;
//
//    public int getX() {
//        return x + 1;
//    }
//}







/////////////////////////////////



// 2

//class Clidders {
//    public final void flіpрer() {
//        System.out.println("Fliр a Сliddеr");
//    }
//}
//
//class Clidlets extends Clidders {
//    public void flіpреr() {
//        System.out.println("Flіp a Сlіdlet");
//        super.flіpрer();
//    }
//
//    public static void main(String[] args) {
//        new Clidlets().flіpреr();
//    }
//}


///////////////////////////////



// 3 разобраться!

class Test3 {
    public static void main(String[] args) {
        int i1 = 012;
        int і2 = 20;
        System.out.println(i1 * і2);
    }
}


////////////////////





// 4


//
//class Test4 {
//    public static void main(String[] args) {
//        int x = 0;
//        int y = 10;
//        do {
//            y--;
//            ++x;
//        } while (x < 5);
//        System.out.print(x + "," + y);
//    }
//}
//
//



/////////////////////////



// 5

class Test5 {
    public static void main(String[] args) {
        Boolean b1 = new Boolean("true");
        System.out.println(b1);
        b1 = new Boolean("tRuE");
        System.out.println(b1);
        b1 = new Boolean("test");
        System.out.println(b1);
        b1 = new Boolean(true);
        System.out.println(b1);
        b1 = true;
        System.out.println(b1);
    }
}



