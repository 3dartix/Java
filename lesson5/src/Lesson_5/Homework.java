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

    public static float[] arr;
    public static float combineTimeArr;

    public static void main(String[] args) {
        arr = CreateArray();
        arr = FillInArray(arr);

        //One();
        //Two(10);
        //Two(50);
        Two(4);
    }

    static void One(){
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время затраченное на выполнение задачи одним потоком: " + (System.currentTimeMillis() - a));
    }

    static void Two(int streamCount){
        System.out.println("Количество потоков: " + streamCount);
        int h = arr.length/streamCount;
        ArrayList<float[]> arrayList = new ArrayList<float[]>(streamCount);

        long fullTime = System.currentTimeMillis();
        long a = System.currentTimeMillis();
        for (int i = 0; i < streamCount; i++) {
            float[] tempArr = new float[h];
            System.arraycopy(arr, i*h, tempArr, 0, h);
            arrayList.add(tempArr);
        }
        System.out.println("Время затраченное на разделение массивов: " + (System.currentTimeMillis() - a));

        for (int i=0; i < streamCount; i++) {
            a = System.currentTimeMillis();
            MyThread t = new MyThread(arrayList.get(i),h,(i*h));
            t.start();

            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Время затраченное на расчет " + (i+1) + " массива: " + (System.currentTimeMillis() - a));
        }
        System.out.println("Время затраченное на склейку: " + combineTimeArr);
        System.out.println("\nВремя выполнения задачи: " + (System.currentTimeMillis() - fullTime));
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

    static class MyThread extends Thread {
        private float[] tempArr;
        private int h;
        private int startPosArr;

        public MyThread(float[] tempArr, int h, int startPosArr) {
            this.tempArr = tempArr;
            this.h = h;
            //передаем параметр элемента с которого мы начинаем копировать
            // результаты в основной массив arr
            this.startPosArr = startPosArr;
    }

        @Override
        public void run() {
            for (int i = 0; i < tempArr.length; i++){
                tempArr[i] = (float)(tempArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            long a = System.currentTimeMillis();
            System.arraycopy(tempArr, 0, arr, startPosArr, h);
            combineTimeArr += System.currentTimeMillis() - a;
        }
    }

}
