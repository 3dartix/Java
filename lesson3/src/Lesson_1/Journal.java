package Lesson_1;

class Journal implements Printable {

    private String name;

    String getName(){
        return name;
    }
    Journal(String name){

        this.name = name;
    }
}

interface Printable {

    default void print(){

        System.out.println("Undefined printable");
    }

    static void read(){

        System.out.println("Read printable");
    }
}

class Main2 {
    public static void main(String[] args) {

        Printable.read();
    }
}