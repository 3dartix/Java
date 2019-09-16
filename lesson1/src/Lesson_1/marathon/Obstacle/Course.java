package Lesson_1.marathon.Obstacle;

import Lesson_1.marathon.Competitors.Competitor;
import Lesson_1.marathon.Competitors.Team;

public class Course {
    Obstacle[] course = {new Cross(80), new Wall(2), new Wall(1), new Cross(120)};

    public void DoIt (Team team){
        for (Competitor c : team.competitors) {
            for (Obstacle o : course) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }

    }
}
