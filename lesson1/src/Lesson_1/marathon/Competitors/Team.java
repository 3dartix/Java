package Lesson_1.marathon.Competitors;

import Lesson_1.marathon.Competitors.Cat;
import Lesson_1.marathon.Competitors.Competitor;
import Lesson_1.marathon.Competitors.Dog;
import Lesson_1.marathon.Competitors.Human;

public class Team {
    private String teamName;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};

    public void GetCompetitors() {
        System.out.printf("" + competitors);
    }

    public void ShowResults() {
        for (Competitor c : competitors) {
            c.info();
        }
    }
}
