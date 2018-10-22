package Lesson_1.Marathon;

public class MainMarathon {
    public static void main(String[] args) {

        Obstacle[] obstacles = {new Cross(100), new Wall(2), new Water(10)};

        Course course = new Course(obstacles);

        Competitor[] competitors = {new Cat("Вася", 95, 15, 2),
                new Dog("Билли",120,20,1),
                new Cat("Джонни", 130,7,2),
                new Dog ("Роджер",150,15,2)};

        Team team = new Team(competitors);

        team.getParticipantsInfo();

        course.doit(team);

        team.getFinishedParticipantsInfo();

    }
}
