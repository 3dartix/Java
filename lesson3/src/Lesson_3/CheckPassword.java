package Lesson_3;

import java.util.Scanner;
import java.util.regex.Pattern;

//Требования:
//        1. Пароль должен быть не менее 8ми символов.
//        2. В пароле должно быть число
//        3. В пароле должна быть хотя бы 1 строчная буква
//        4. В пароле должна быть хотя бы 1 заглавная буква
//        5. Не должно быть пробелов

public class CheckPassword {
    static Scanner scanner = new Scanner(System.in);
    static String pass;

    public static void main(String[] args) {
        PrintRequirement();
        pass = scanner.nextLine();

        while (!ValidPass(pass)){
            print("Попробуйте снова:");
            pass = scanner.nextLine();
        }

        System.out.println("Пароль соответствует всем требованиям: " + pass);
        //Scanner scanner = new Scanner(System.in);
        //String pass = scanner.nextLine();

        //System.out.println(ValidPass(pass));
    }

    static boolean ValidPass (String pass){
        final Pattern hasUppercase = Pattern.compile("[A-ZА-Я]");
        final Pattern hasLowercase = Pattern.compile("[a-zа-я]");
        final Pattern hasNumber = Pattern.compile("[0-9]");

        boolean result = true;

        if (pass.length() < 8){
            print("ваш пароль не соответствует длине");
            result = false;
        }

        if (!hasNumber.matcher(pass).find()){
            print("в вашем пароле нет цифр ");
            result = false;
        }

        if (!hasUppercase.matcher(pass).find()){
            print("в вашем нет букв верхнего регистра ");
            result = false;
        }

        if (!hasLowercase.matcher(pass).find()){
            print("в вашем пароле нет букв нижнего регистра ");
            result = false;
        }

        if (pass.contains(" ")){
            print("в вашем пароле есть пробелы");
            result = false;
        }

        return result;
    }

    static void PrintRequirement(){
        System.out.println("Введите пароль с учетом треований: " +
                "\n1. Пароль должен быть не менее 8ми символов." +
                "\n2. В пароле должно быть число" +
                "\n3. В пароле должна быть хотя бы 1 строчная буква" +
                "\n4. В пароле должна быть хотя бы 1 заглавная буква" +
                "\n5. Не должно быть пробелов \n");
    }
    static void print(String m){
        System.out.println(m);
    }
}
