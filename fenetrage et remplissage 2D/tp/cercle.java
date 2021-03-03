package infographie.tp;

import java.util.ArrayList;
public class cercle {
    point centre;
    int r;
    ArrayList<cercle> cercles;
    cercle(point centre,int r){
        this.centre=centre;
        this.r=r;
    }
    public point getCentre() {
        return centre;
    }
    public void setCentre(point centre) {
        this.centre = centre;
    }
    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    static ArrayList<point> drawCircle(cercle c) {
        int d = 3-2*c.r;
        int x = 0;
        int y = c.r;
        ArrayList<point> C = new ArrayList<point>();

        do {
            C.add(new point(c.centre.getX() + x, c.centre.y + y));
            C.add(new point(c.centre.getX() + x, c.centre.y - y));
            C.add(new point(c.centre.getX() - x, c.centre.y + y));
            C.add(new point(c.centre.getX() - x, c.centre.y - y));
            C.add(new point(c.centre.getX() + y, c.centre.y + x));
            C.add(new point(c.centre.getX() + y, c.centre.y - x));
            C.add(new point(c.centre.getX() - y, c.centre.y + x));
            C.add(new point(c.centre.getX() - y, c.centre.y - x));
            if (d < 0) {
                d += 4 * x + 6;
            } else {
                d +=  4*(x - y) + 10;
                y--;
            }
            x++;
        } while (x < y);
return C;
    }

}
