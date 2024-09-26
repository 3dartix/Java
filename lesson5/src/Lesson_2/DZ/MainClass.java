package Lesson_2.DZ;

import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        int sum = 0;
        Random random = new Random();
        String[][] sArray = new String[4][4];

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                sArray[i][j] = String.valueOf(random.nextInt(50));
            }
        }

        sArray[2][3] = "abc";

        try {
            sum = sumArray(sArray);
        } catch (MyArraySizeExeption e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
        System.out.println(sum);

    }

    public static int sumArray(String[][] sArray){
        int sum = 0;
        if(sArray.length != 4) throw new MyArraySizeExeption();
        for(int i = 0; i < sArray.length; i++) {
            if(sArray[i].length != 4) throw new MyArraySizeExeption();
            for(int j = 0; j < sArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(sArray[i][j]);
                }catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }

            }
        }
        return sum;
    }
}

class MyArrayDataException extends RuntimeException{
    int row, column;

    public MyArrayDataException(int row, int column) {
        super(row + " " + column);
        this.row = row;
        this.column = column;
    }
}

class MyArraySizeExeption extends RuntimeException{

    public MyArraySizeExeption() {
        super("wrong size");
    }
}