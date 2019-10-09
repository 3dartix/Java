package Lesson_2;

public class FactorialException extends Exception {
    private int number;

    public int getNumber() {
        return number;
    }

    public FactorialException(String msg, int number) {
        super(msg);
        this.number = number;
    }
}

class Factorial {
    public static int getFactorial(int num) throws FactorialException {
        int res = 1;

        if (num < 1) throw new FactorialException("Число не может меньше 1", num);

        for (int i = 1; i <=num ; i++) {
            res *= i;
        }

        return res;
    }
}

class MainFacEx {
    public static void main(String[] args) {
        try {
            int res = Factorial.getFactorial(-10);
        } catch (FactorialException e) {
           // System.out.println(e.getMessage());
//            e.getMessage();
            //e.printStackTrace();
        }
    }
}