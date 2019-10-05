package Lesson_1;

import javax.swing.*;

public class SomeClass {
    // создаем колбек и его метод
    Callback callback;

    public void registerCallBack(Callback callback){
        this.callback = callback;
    }

    void doSomething(){
        JOptionPane.showMessageDialog(null, "Выполняется работа");
        // вызываем метод обратного вызова
        callback.callingBack();
    }
}

interface Callback{
    void callingBack();
}

class MyClass implements Callback {

    @Override
    public void callingBack() {

        System.out.println("Вызов метода обратного вызова");

    }
}

class Main1 {
    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        MyClass myClass = new MyClass();
//инициализируем колбек, передавая методу registerCallBack экземпляр MyClass, реализующий интерфейс колбек
        someClass.registerCallBack(myClass);
        someClass.doSomething();

    }
}