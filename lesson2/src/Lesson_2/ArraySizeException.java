package Lesson_2;

public class ArraySizeException extends Exception {
    private String[][] myArr;

    public String[][] getMyArr() {
        return myArr;
    }

    public ArraySizeException(String message, String[][] myArr) {
        super(message);
        this.myArr = myArr;
    }
}

public class MyArrayDataException extends Exception {
    private String[][] myArr;

    public String[][] getMyArr() {
        return myArr;
    }

    public MyArrayDataException(String message, String[][] myArr) {
        super(message);
        this.myArr = myArr;
    }
}

class Array {
    public static String[][] GetArray (String[][] myArr) throws ArraySizeException {
        int sizeArray = 4;

        if (myArr.length != sizeArray || myArr[1].length != sizeArray){
            throw new ArraySizeException("Ваш массив имеет недопустимый размер.", myArr);
        }
        return myArr;
    }

    public static float GetSumA

}

//    int sum;
//        for (int i = 0; i > sizeArray; i++){
//                for (int j = 0; j > sizeArray; j++){
//
//
//
//                }
//                }

class MainArray {
    public static void main(String[] args) {
        try{
            String[][] arr = Array.GetArray(new String[4][4]);
        } catch (ArraySizeException e) {
            System.out.println(e.getMessage());
        }



    }
}

