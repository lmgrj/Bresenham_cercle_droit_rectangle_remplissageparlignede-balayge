package infographie.tp;

import java.util.ArrayList;
//@Author : lamgarraj mohamed
public class etoile {
    point center;
    ArrayList<point> sommets = new ArrayList<point>();
    ArrayList<segment> bras = new ArrayList<segment>();

    etoile(point center) {
        this.center = center;
        for(int i=0;i<5;i++){
            sommets.add(new point(center.getX()+50*Math.cos(i*2*Math.PI/5),center.getY()+50*Math.sin(i*2*Math.PI/5)));
            System.out.println(center.getX()+50*Math.cos(i*2*Math.PI/5)+"  etoil points    "+center.getY()+50*Math.sin(i*2*Math.PI/5));
        }
    }

   public ArrayList<segment> etoil()

    {
        bras.add(new segment(sommets.get(0),sommets.get(2)));
        bras.add(new segment(sommets.get(2),sommets.get(4)));
        bras.add(new segment(sommets.get(4),sommets.get(1)));
        bras.add(new segment(sommets.get(1),sommets.get(3)));
       // bras.add(new segment(sommets.get(3),sommets.get(2)));

   return bras;
    }
}
