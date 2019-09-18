package Lesson_1.Game;

public class Game {
    public static void main(String[] args) {
        Hero h1 = new Warrior(100, "war1", 20);
        Hero h2 = new Warrior(100, "war2", 30);

        h1.info();
        h2.info();

        h1.hit(h2);

        h1.info();
        h2.info();
    }

}

abstract class Hero {
    protected int health;
    protected String type;
    protected int damage;

    public Hero(int health, String type, int damage) {
        this.health = health;
        this.type = type;
        this.damage = damage;
    }

    abstract void hit(Hero h);
    abstract void healing(Hero h);

    void causeDamage(int damage) {
        health -= damage;
    }

    void info() {
        System.out.println(health + " " + type + " " + damage);
    }

}

class Warrior extends Hero {

    public Warrior(int health, String type, int damage) {
        super(health, type, damage);
    }

    @Override
    void hit(Hero h) {
        if(h != this) {
            h.causeDamage(damage);
        }
    }

    @Override
    void healing(Hero h) {
        System.out.println("Войны не умеют лечить!");
    }
}

class Damager {

}

class Healing {

}