package Lesson_1.marathon.Competitors;

public interface Competitor { //участники
    void run(int dist);
    void swim(int dist);
    void jump(int height);
    boolean isOnDistance();
    void info();
}