package Lesson_3.DZ;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordVar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите пароль");
        String s = sc.nextLine();
        System.out.println(check(s));
        System.out.println(secondCheck(s));

    }

    private static boolean check(String s){
        Pattern p = Pattern.compile("^.{8,20}$");
        Matcher m = p.matcher(s);
        if(m.matches()){
            Pattern p1 = Pattern.compile("^.*\\d+.*$");
            Matcher m1 = p1.matcher(s);
            if(m1.matches()){
                Pattern p2 = Pattern.compile("^.*[a-z]+.*$");
                Matcher m2 = p2.matcher(s);
                if(m2.matches()){
                    Pattern p3 = Pattern.compile("^.*[A-Z]+.*$");
                    Matcher m3 = p3.matcher(s);
                    return m3.matches();
                }
            }
        }
        return false;
    }

    private static boolean secondCheck(String s){
        Pattern p = Pattern.compile("^(?=.{8,20})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$");
        Matcher m = p.matcher(s);
        return m.matches();
    }
}