package infographie.tp;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPanel extends JPanel{

    String Action;


    cercle cer=new cercle(new point(400,300),100);
    segment seg=new segment(new point(100,100),new point(500,400));
    etoile et=new etoile(new point(300,300));
    segment etoilbras=new segment(new point(300+50*Math.cos(3*2*Math.PI/5),300+50*Math.sin(3*2*Math.PI/5)),
            new point(300+50*Math.cos(0*2*Math.PI/5),300+50*Math.sin(0*2*Math.PI/5)));
    Polygone poly=new Polygone(new point(200,200),new point(380,200),new point(380,300),new point(200,300));




    public void tracerRectangles(Graphics g){

        for(int i=0;i<=12;i++)
            g.drawRect(120, 100, 60*i, 30);

    }

    public void tracerPoints(Graphics g)
    {
        //pour tracer un point(pixel) : g.drawLine(x, y, x, y);
        g.setColor(Color.red);
        for(int i=0;i<=15;i++)
            g.drawLine(100, 20*i, 100, 20*i);

        for(int i=0;i<=150;i++)
            g.drawLine(150, 20+i, 150, 20+i);
    }


    //**********************************actions réaliser aprés quliquer sur les butons********************
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if(Action=="Ligne"){

            g.drawLine(100, 120, 300, 200);
        }
        ///////////////////
        if(Action=="Rectangle"){
            g.drawRect(120, 100, 600, 300);
        }
        /////////////////
        if(Action=="Rectangles"){
            tracerRectangles(g);
        }
        ///////////////////
        if(Action=="Points"){
            tracerPoints(g);
        }


        if(Action=="BresenhamCercle"){
            g.setColor(Color.green);
            affichecercle(cer,g);
        }
        if(Action=="BresenhamSegment"){
            g.setColor(Color.YELLOW);
            affichesegment(seg,g);
        }
        if(Action=="BresenhamEtoile"){
            for(int j=0;j<5;j++) {
                g.setColor(Color.MAGENTA);
            affichesegment(et.etoil().get(j),g);
            System.out.println(et.etoil().get(j).getP1().getX()+"  "+et.etoil().get(j).getP1().getY()+"         "+et.etoil().get(j).getP2().getX()+"  "+et.etoil().get(j).getP2().getY());

        }
            affichesegment(etoilbras,g);
    }
        if(Action=="BresenhamPolygone"){
            for(int i=0;i<4;i++) {
                 if(i!=1){  //pasque tjr j'ai le probleme de segment lié la dernier pa le premier point il s'affice ps a sa position
                g.setColor(Color.blue);
                affichesegment(poly.getSegments().get(i), g);
                System.out.println(et.etoil().get(i).getP1().getX() + "  " + et.etoil().get(i).getP1().getY() + "         " + et.etoil().get(0).getP2().getX() + "  " + et.etoil().get(0).getP2().getY());
            }
            }
            //  voila le dernier segment j'ai la fait séparment pou qu'il s'affiche
            g.setColor(Color.blue);
            affichesegment(new segment(new point(200,200),new point(200,300)),g);
            System.out.println(et.etoil().get(1).getP1().getX() + "  " + et.etoil().get(1).getP1().getY() + "         " + et.etoil().get(1).getP2().getX() + "  " + et.etoil().get(1).getP2().getY());


        }

        if(Action=="TPdemandé"){

            tpDemandé(g);

        }


        if(Action=="remplissage"){
            g.setColor(Color.MAGENTA);

            drawPolyPlein(g,new Polygone(new point(200,200),new point(380,200),new point(380,300),new point(200,300)));
        }


    }


    public void setAction(String action) {
        Action=action;
        repaint();
    }


    //****************************afficher point (la primitive utilisé our tracer tt les elements de tp *************************
    public void affichepoint(point p,Graphics g){

        g.drawRect(p.getX(),p.getY(),1,1);//rectangle 1,1  comme un pixel


    }


    //****************************bresenham cercle ****************************
    public void affichecercle(cercle c,Graphics g){
        ArrayList<point> list2 =cercle.drawCircle(c);
        ListIterator<point> l2=list2.listIterator();
        point p2;
        while(l2.hasNext()){
            p2=l2.next();
            affichepoint(p2,g);


        }

    }

// *********************bresenham segment*********************************

    public void affichesegment(segment s,Graphics g) {

        int dx = s.getP2().getX() - s.getP1().getX();
        int dy = s.getP2().y - s.getP1().y ;
        int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0 ;
        if (dx<0) dx1 = -1 ; else if (dx>0) dx1 = 1 ;
        if (dy<0) dy1 = -1 ; else if (dy>0) dy1 = 1 ;
        if (dx<0) dx2 = -1 ; else if (dx>0) dx2 = 1 ;
        int longest = Math.abs(dx) ;
        int shortest = Math.abs(dy) ;
        if (!(longest>shortest)) {
            longest = Math.abs(dy) ;
            shortest = Math.abs(dx) ;
            if (dy<0) dy2 = -1 ; else if (dy>0) dy2 = 1 ;
            dx2 = 0 ;
        }
        int numerator = longest >> 1 ;
        for (int i=0;i<=longest;i++) {
            affichepoint(s.getP1(),g);
            numerator += shortest ;
            if (!(numerator<longest)) {
                numerator -= longest ;
                s.getP1().setX(s.getP1().getX() + dx1);
                s.getP1().y += dy1 ;
            } else {
                s.getP1().setX(s.getP1().getX() + dx2);
                s.getP1().y += dy2 ;
            }
        }
    }



    // ********************** utilisation de tout les réalisation de bresenham pour réalise le tp demandé*********************
    public void tpDemandé(Graphics g){


        point e =new point(290,250);



        cercle c1=new cercle(new point(100,100),20);
        cercle c2=new cercle(new point(100,135),15);
        cercle c3=new cercle(new point(100,170),20);
        cercle c4=new cercle(new point(135,135),20);
        cercle c5=new cercle(new point(65,135),20);

        cercle c=new cercle(new point(65,135),20);
        segment arb1=new segment(new point(100,190),new point(100,400));
        segment arb2=new segment(new point(100,300),new point(130,260));
        segment arb3=new segment(new point(100,380),new point(60,330));


        Polygone vase=new Polygone(new point(70,400),new point(130,400),new point(120,450),new point(80,450));
        Polygone brasDrapeau=new Polygone(new point(380,200),new point(388,200),new point(388,450),new point(380,450));

        Polygone drap=new Polygone(new point(200,200),new point(380,200),new point(380,300),new point(200,300));
        etoile et =new etoile(e);
        segment etoilbra=new segment(new point(290+50*Math.cos(3*2*Math.PI/5),250+50*Math.sin(3*2*Math.PI/5)),
                new point(290+50*Math.cos(0*2*Math.PI/5),250+50*Math.sin(0*2*Math.PI/5)));

        g.setColor(Color.red);
        affichecercle(c,g);
        affichecercle(c1,g);
        affichecercle(c3,g);
        affichecercle(c4,g);
        affichecercle(c5,g);

        g.setColor(Color.green);
        affichecercle(c2,g);

        g.fillOval(50,320,40,40);
        g.fillOval(120,240,40,40);
        affichesegment(arb1,g);
        affichesegment(arb2,g);
        affichesegment(arb3,g);

   for(int i=0 ;i<4;i++){
        g.setColor(Color.red);
        if(i!=1)
        affichesegment(drap.segments.get(i), g);
        }

   //***********affichage de l'etoile*************
   affichesegment(new segment(new point(200,200),new point(200,300)),g);// segment 4 de drapeau
        for(int j=0;j<5;j++) {
            g.setColor(Color.green);
            affichesegment(et.etoil().get(j),g);
            System.out.println(et.etoil().get(j).getP1().getX()+"  "+et.etoil().get(j).getP1().getY()+"         "+et.etoil().get(j).getP2().getX()+"  "+et.etoil().get(j).getP2().getY());
        }
        g.setColor(Color.green);
        affichesegment(etoilbra,g); // le dernier segemnt de l'etoile ne s'affiche ps correctement on l'affiche séparement



        //le vase plien ***************************
         g.setColor(Color.cyan);
        drawPolyPlein(g,vase);
        // le bras de drapeau *************************
        g.setColor(Color.ORANGE);
        drawPolyPlein(g,brasDrapeau);

    }



    //************************remplissage par ligne de balayage******************************
    public void drawPolyPlein(Graphics g,Polygone p) {
        ArrayList<Element> Tag = new ArrayList<Element>();
        ArrayList<ElementTaa> Taa = new ArrayList<ElementTaa>();
        Tag = constTag(p);
        int y = Tag.get(0).ybas;
        int ymax = ymax(Tag);
        while (y <= ymax) {
            Taa = misAjourTaa(Taa, y, Tag);
            Plotline(Taa, y, g);
            System.out.println(y);
            Taa = miseajour(Taa);
            y++;
        }

    }

    //**************************construire table des segments**************************

    public ArrayList<Element> constTag(Polygone pp) {
       //Polygone pp=new Polygone(new point(200,200),new point(380,200),new point(380,300),new point(200,300));
        ArrayList<Element> Tag = new ArrayList<Element>();
        point a, b;
        Element el = new Element();
        LinkedList<Element> h = new LinkedList<Element>();
        for (int i = 0; i < pp.segments.size(); i++) {
            a = pp.segments.get(i).getP1();
            b = pp.segments.get(i).getP2();
            if (a.getY() > b.getY()) {
                el.xbas = b.getX();
                el.ybas = b.getY();
                el.yhaut = a.getY();
                el.dx = a.getX() - b.getX();
                el.dy = a.getY() - b.getY();

            } else {
                el.xbas = a.getX();
                el.ybas = a.getY();
                el.yhaut = b.getY();
                el.dx = b.getX() - a.getX();
                el.dy = b.getY() - a.getY();
            }
            if (el.yhaut != el.ybas) {
                Tag.add(new Element(el.yhaut, el.xbas, el.dx, el.dy, el.ybas));
            }
        }
        for (int i = 0; i < Tag.size(); i++)
            System.out.println("les segment actiff               "+Tag.get(i).toString());


        for (int i = 0; i < Tag.size() - 1; i++)
            for (int j = i; j < Tag.size(); j++)
                if (Tag.get(i).ybas > Tag.get(j).ybas) {
                    el = Tag.get(i);
                    Tag.set(i, Tag.get(j));
                    Tag.set(j, el);
                }
        return Tag;
    }


    //****************************mise a jour de y max pour les segmants******************************
    public int ymax(ArrayList<Element> Tag) {
        int y = Tag.get(0).yhaut;
        for (int i = 0; i < Tag.size(); i++) {
            if (Tag.get(i).yhaut > y)
                y = Tag.get(i).yhaut;
        }
        return y;
    }

//********************************mise a jour de table des segments actif **************************
    public ArrayList<ElementTaa> misAjourTaa(ArrayList<ElementTaa> Taa, int y, ArrayList<Element> Tag) {

        for (int i = 0; i < Taa.size(); i++) {
            if (Taa.get(i).yhaut == y) {
                Taa.remove(i);
                i--;
            }
        }

        for (int i = 0; i < Tag.size(); i++) {
            if (Tag.get(i).ybas == y && Tag.get(i).ybas != Tag.get(i).yhaut)
                Taa.add(new ElementTaa(Tag.get(i).yhaut, Tag.get(i).xbas, Tag.get(i).dx, Tag.get(i).dy, Tag.get(i).ybas));
        }

        ElementTaa el;
        for (int i = 0; i < Taa.size() - 1; i++)
            for (int j = i; j < Taa.size(); j++)
                if (Taa.get(i).xbas > Taa.get(j).xbas) {
                    el = new ElementTaa(Taa.get(i).yhaut, Taa.get(i).xbas, Taa.get(i).dx, Taa.get(i).dy, Taa.get(i).ybas);
                    Taa.set(i, Taa.get(j));
                    Taa.set(j, el);
                }

        for (int i = 0; i < Taa.size(); i++) {
            if (Taa.get(i).test) {
                if (i % 2 == 0)
                    Taa.get(i).calculR(true);
                else
                    Taa.get(i).calculR(false);
            }
        }
        for (int p = 0; p < Taa.size(); p++)
            System.out.println("les ligne a allumé        "+Taa.get(p).toString());
        return Taa;
    }


    public ArrayList<ElementTaa> miseajour(ArrayList<ElementTaa> Taa) {
        for (int i = 0; i < Taa.size(); i++) {
            ElementTaa p = Taa.get(i);
            p.r = Taa.get(i).r + Taa.get(i).dx;
            int e = p.r / p.dy;
            p.xbas = p.xbas + e;
            p.r -= p.dy * e;
            Taa.set(i, p);

        }

        return Taa;
    }


 //************************* afficher ligne (utilisé pour remplissage de polygone) pour afficher la partie de ligne qu'est inclus dand le polygone **************************
    public void Plotline(ArrayList<ElementTaa> taa, int y, Graphics g) {
        for (int i = 0; i < taa.size(); i += 2) {
            for (int j=taa.get(i).xbas; j<taa.get(i+1).xbas; j++)
                affichepoint(new point(j,y), g);
        }
    }

}