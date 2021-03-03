package infographie.tp;

import java.util.ArrayList;

public class segment {
    private point p1,p2;

    public static void setD(ArrayList<point> d) {
        D = d;
    }
    public point getP1() {
        return p1;
    }
    public point getP2() {
        return p2;
    }
    public static ArrayList<point> getD() {
        return D;
    }
    public segment(point p1, point p2){
        this.p1=p1;
        this.p2=p2;
    }
   static ArrayList<point> D;
    static ArrayList<point> bresenhamdroit(point p1, point p2){
        D =new ArrayList<point>();
        int e=0,y=0;

        D.add(p1);
        for(int x = p1.getX() +1; x< p2.getX(); x++){
            if(2*(e+p2.y-p1.y)< p2.getX() - p1.getX())
                e+=p2.y-p1.y;
            else {
                e+=p2.y-p1.y- p2.getX() + p1.getX();
                y++;
            }
            D.add(new point(x,y+p1.y));
        }
        return D;
    }


}
