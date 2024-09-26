package Lesson_1;

public class Shape {
    public void draw() {
//ничего не делаем
    }

    public void info() {
        // super.draw();
        System.out.println("info");
    }
}

class Square extends Shape {

    public Square() {
        super();
    }

    public void draw() {
       // super.draw();
        System.out.println("Квадрат");
    }

}

class Сircle extends Square {
    public void draw() {
        System.out.println("Круг");
        super.info();
    }
}

class Triangle extends Shape {
    public void draw() {
        System.out.println("Треугольник");
    }
}

class MainShape {
    public static void main(String[] args) {
//        Shape[] a = new Shape[]{new Shape(),
//                new Triangle(),
//                new Square(),
//                new Сircle()};
//
//        for(int i = 0; i < a.length; i++) {
//            a[i].draw();
//        }

        Shape shape = new Square();

       // Square square = new Shape();
    }

    public void draw() {
        System.out.println("Треугольник");
    }

    public void draw(int a) {
        System.out.println("Треугольник");
    }
}