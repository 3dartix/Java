package Lesson_2;


//Артем, здравствуйте.
//
//        Задание вроде выполнил, но сама тема в голове легла как-то поверхстно.
//
//        с одинарными исключениями все понятно
//        try {
//        пробуем выполнять, если не получется
//        } catch () {
//        выполняется второй блок
//        } finally {
//        выполняется в любом случае
//        }
//
//        а вот с пробрасыванием и написанием собственных классов исключений для меня не так очевидно.
//
//        Вот например:
//        почему блок в моем коде
//        throw new MyArrayDataException () - останавливает цикл без блока finally(continue)? очень похоже на костыль.
//
//        да и вот эта часть кода тоже выглядит не очень, т.к. условие в блоке catch никогда не выполнится, а реализации требует.
//
//        try {
//        System.out.println("Сумма элементов массива: " + Array.GetSumArray(arr));
//        } catch (MyArrayDataException e){
//        }
//
//        В общем-то все что было на лекции понятно, а то что написал сам не очень)







class ArraySizeException extends Exception {
    private String[][] myArr;

//    public String[][] getMyArr() {
//        return myArr;
//    }

    public ArraySizeException(String message, String[][] myArr) {
        super(message);
        this.myArr = myArr;
    }
}

class MyArrayDataException extends Exception {
    private int row;
    private int col;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public MyArrayDataException(String message, int row, int col) {
        this.row = row;
        this.col = col;
        System.out.println(message + row + " " + col);
    }
}

class Array {
    public static String[][] GetArray (String[][] myArr) throws ArraySizeException {
        int sizeArray = 4;

        if (myArr.length != sizeArray || myArr[1].length != sizeArray){
            throw new ArraySizeException("Ячейка массива имеет недопустимый размер.", myArr);
        }
        return myArr;
    }

    public static int GetSumArray(String[][] myArr) throws MyArrayDataException{
        int sum =0;
        for (int i=0;i<myArr.length; i++){
            for (int j=0; j<myArr.length; j++){
                try {
                    sum += Integer.parseInt(myArr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Не удалось преобразовать в int ячейку: ", i, j);
                } finally {
                    continue;
                }
            }
        }
        return sum;
    }
}

class MainArray {
    public static void main(String[] args) {
        String[][] arr = {{"1", "awdawd", "10", "7"}, {"12", "2", "1", "3"}, {"1", "3", "sdfdsf", "2"}, {"1", "7", "2", "5"}};

        try{
            Array.GetArray(arr);
        } catch (ArraySizeException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Сумма элементов массива: " + Array.GetSumArray(arr));
        } catch (MyArrayDataException e){
        }
    }
}

//throw new MyArrayDataException () - останавливает цикл без блока finally ?

