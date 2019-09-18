package Lesson_1.marathon;

import Lesson_1.marathon.Competitors.Team;
import Lesson_1.marathon.Obstacle.Course;

public class Main {
    public static void main(String[] args) {
        Course course = new Course(); // Создаем полосу препятствий
        Team team = new Team("Братва"); // Создаем команду
        course.DoIt(team); // Просим команду пройти полосу
        team.ShowResults(); // Показываем результаты
    }
}
