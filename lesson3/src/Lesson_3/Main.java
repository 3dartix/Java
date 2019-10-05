package Lesson_3;

public class Main {
    public static void main(String[] args) {
        Phonebook book = new Phonebook();
        book.Add("Вася", "+9985556654", "+84488855544", "+75256687445");
        book.Add("Игорь", "+9985556654");
        book.Add("Маша", "+9985556654", "+8625566544");

        book.GetContactByName("Игорь");
    }
}
