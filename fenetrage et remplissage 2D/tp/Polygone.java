package infographie.tp;

import java.util.ArrayList;

class Polygone {
    private point p1,p2,p3,p4;
    ArrayList<segment> segments ;
    public Polygone(point p1,point p2,point p3,point p4){
        super();
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
        this.p4=p4;
        segments=new ArrayList<segment>();
        segments.add(new segment(p1,p2));
       segments.add(new segment(p1,p4));
        segments.add(new segment(p2,p3));
        segments.add(new segment(p4,p3));


    }

    public ArrayList<segment> getSegments() {
        return segments;
    }
}
