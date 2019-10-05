package Lesson_2;

public enum Fruit {
    ORANGE("Апельсин", 3), APPLE("Яблоко", 4), BANANA("Банан", 2), CHERRY("Вишня", 7);

    private String rus;
    private int weight;

    public String getRus() {
        return rus;
    }

    public int getWeight() {
        return weight;
    }

    Fruit(String rus, int weight) {
        this.rus = rus;
        this.weight = weight;
    }
}

class MainEnum {
    public static void main(String[] args) {
      //  Fruit f = Fruit.APPLE;

        for (Fruit o: Fruit.values()) {
            System.out.println(o.getRus());
        }

      //  System.out.println(Fruit.valueOf("APPLE").ordinal());

       // System.out.println(f);
//        System.out.println(Fruit.APPLE);

//        switch (f) {
//            case APPLE:
//
//            case BANANA:
//
//            case CHERRY:
//        }
    }
}