package Lesson_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainEx {
    public static void main(String[] args) {

        int a, b;

//        a = 0;
//        b = 10 / a;

//        try {
//            int[] mass = {1,2,3};
//
//            a = 0;
//            b = 10 / a;
//
//            mass[40] = 10;
//
//        } catch (ArithmeticException e) {
//           // e.printStackTrace();
//            System.out.println("Деление на 0");
//        } catch (ArrayIndexOutOfBoundsException e) {
//           // e.printStackTrace();
//            System.out.println("Вышли за границу массива");
//        }

        //System.out.println("End!");


//        try {
//            FileInputStream fileInputStream = new FileInputStream("1.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        throw new ArithmeticException("ошибка!");


//       try {
//           System.out.println(sqrt(10));
//        } catch (ArithmeticException e) {
//           System.out.println("что нужно делать");
//            e.printStackTrace();
//        }

// сервер с расчетами
//        try {
//            someThing();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        System.out.println(a());

//        try (FileInputStream fileInputStream = new FileInputStream("1.txt")) {
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

//    public static int a() {
//        try {
//            return -1;
//        } catch (ArrayIndexOutOfBoundsException e) {
//
//        } catch (ArithmeticException e) {
//
//        } finally {
//
//        }
//    }


        public static void someThing () throws FileNotFoundException {
            // клиент отправляет данные
            FileInputStream fileInputStream = new FileInputStream("1.txt");
        }

        public static int sqrt ( int n){
            if (n > 0) {
                return n / 2;
            }

            throw new ArithmeticException("нельзя отрицательное");
        }

//    public static void a() {
//        b();
//    }

        public static void b () {
            c();
        }

        public static void c () {
            int b = 10 / 0;
        }
    }
