package Lesson_1.Marathon;

public class Course {

    private Obstacle[] obstacles = new Obstacle[3];

    public Course(Obstacle[] obstacles) {
        int obstacleNumber = 0;
        for (Obstacle eachObstacle: obstacles) {
            this.obstacles[obstacleNumber] = eachObstacle;
            obstacleNumber++;
        }
    }

    public void doit(Team team){

        for (Competitor eachParticipant: team.getTeam()) {
            eachParticipant.run(((Cross) this.obstacles[0]).getLen());
            eachParticipant.jump(((Wall) this.obstacles[1]).getHeight());
            eachParticipant.swim(((Water) this.obstacles[2]).getLen());
            System.out.println();
        }
    }


}
