package Lesson_1.Marathon.Competitor;

public class Team {
    private String title;
    private Competitor[] members;

    public Competitor[] getMembers() {
        return members;
    }

    public Team(String title, Competitor...members) {
        this.title = title;
        this.members = members;
    }

    public void showWinners() {
        System.out.println("win");
        for(Competitor o: members) {
            if(o.isOnDistance()) {
                o.info();
            }
        }
    }
}