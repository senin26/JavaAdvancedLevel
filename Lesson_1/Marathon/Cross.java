package Lesson_1.Marathon;

public class Cross extends Obstacle {
    int len;

    public Cross(int len) {
        this.len = len;
    }

    public int getLen() {
        return len;
    }

    @Override
    public void doit(Competitor competitor) {
        competitor.run(len);
    }
}
