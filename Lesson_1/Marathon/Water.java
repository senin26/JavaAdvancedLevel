package Lesson_1.Marathon;

public class Water extends Obstacle {
    int len;

    public Water(int len) {
        this.len = len;
    }

    public int getLen() {
        return len;
    }

    @Override
    public void doit(Competitor competitor) {
        competitor.swim(len);
    }
}
