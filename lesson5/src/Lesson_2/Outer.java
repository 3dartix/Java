package Lesson_2;

public class Outer {
    private int outerVar;

    class Inner {
        private int innerVar;

       void innetTest() {
            System.out.println(outerVar);
            System.out.println(innerVar);
        }
    }

    void outerTest() {
        System.out.println(outerVar);
//        Inner inner = new Inner();
//        System.out.println(inner.innerVar);
    }


}

class InnerAndOuter {
    public static void main(String[] args) {
        Outer outer = new Outer();

        Outer.Inner inner = outer.new Inner();
    }
}
