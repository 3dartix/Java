package Lesson_5;

//1. Необходимо написать два метода, которые делают следующее:
//        1) Создают одномерный длинный массив, например:
//static final int size = 10000000;
//static final int h = size / 2;
//        float[] arr = new float[size];
//        2) Заполняют этот массив единицами;
//        3) Засекают время выполнения: long a = System.currentTimeMillis();
//        4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
//        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        5) Проверяется время окончания метода System.currentTimeMillis();
//        6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
//        Отличие первого метода от второго:
//        Первый просто бежит по массиву и вычисляет значения.
//        Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
//
//        Пример деления одного массива на два:
//        System.arraycopy(arr, 0, a1, 0, h);
//        System.arraycopy(arr, h, a2, 0, h);
//
//        Пример обратной склейки:
//        System.arraycopy(a1, 0, arr, 0, h);
//        System.arraycopy(a2, 0, arr, h, h);
//
//        Примечание:
//        System.arraycopy() копирует данные из одного массива в другой:
//        System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
//        По замерам времени:
//        Для первого метода надо считать время только на цикл расчета:
//        for (int i = 0; i < size; i++) {
//        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//        Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.

import java.util.ArrayList;

public class Homework {
    public static void main(String[] args) {
        float[] arr = CreateArray();
        arr = FillInArray(arr);

        //One(arr);
        Two(arr,10);

    }

    static void One(float[] arr){
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        GetRuntime(a);
    }

    static void Two(float[] arr, int streamCount){
        long a = System.currentTimeMillis();
        int h = arr.length/streamCount; //25

        for (int i = 0; i < streamCount; i++) {
            float[] tempArr = new float[h];
            System.arraycopy(arr, i*h, tempArr, 0, h);

            MyThread t = new MyThread(tempArr,arr,h,(i*h));
            t.start();

            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        GetRuntime(a);
    }

    static float[] CreateArray(){
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        return arr;
    }
    static float[] FillInArray(float[] arr){
        for (float el: arr) {
            el = 1;
        }
        return arr;
    }
    static void GetRuntime(double a){
        System.out.println(System.currentTimeMillis() - a);
    }

    static class MyThread extends Thread {
        private float[] tempArr;
        private float[] arr;
        private int h;
        private int startPosArr;

        public MyThread(float[] tempArr, float[] arr, int h, int startPosArr) {
            this.tempArr = tempArr;
            this.arr = arr;
            this.h = h;
            //передаем параметр элемента с которого мы начинаем копировать
            // результаты в старый массив arr
            this.startPosArr = startPosArr;
    }

        @Override
        public void run() {
            for (int i = 0; i < tempArr.length; i++){
                tempArr[i] = (float)(tempArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(tempArr, 0, arr, startPosArr, h);

        }
    }

}
