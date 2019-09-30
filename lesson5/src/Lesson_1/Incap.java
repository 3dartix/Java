package Lesson_1;

import java.util.Arrays;

public class Incap {

    private String[] mass = {"Vickor", "Anna", "Semen"};

    public String[] getMass() {
        String[] copyMass = new String[mass.length];

        for (int i = 0; i < copyMass.length; i++) {
            copyMass[i] = mass[i];
        }
        return copyMass;
    }

    void info() {
        System.out.println(Arrays.toString(mass));
    }
}

class MainIncap {
    public static void main(String[] args) {
        Incap incap = new Incap();
        String[] mass = incap.getMass();

        mass[2] = "Vaska";

        incap.info();

    }
}
