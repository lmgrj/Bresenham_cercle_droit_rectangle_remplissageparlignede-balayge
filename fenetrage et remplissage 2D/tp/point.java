package infographie.tp;

public class point {
    private int x;
    int y;
    public point(double x, double y){
        this.setX((int) x);
        this.y= (int) y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
