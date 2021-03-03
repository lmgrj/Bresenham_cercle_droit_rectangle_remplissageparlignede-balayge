package infographie.tp;

public class Element {
	int yhaut,xbas,dx,dy,ybas;
    public Element(){
    	
    }
	public Element(int yhaut, int xbas, int dx, int dy, int ybas) {
		this.yhaut = yhaut;
		this.xbas = xbas;
		this.dx = dx;
		this.dy = dy;
		this.ybas = ybas;
	}
	@Override
	public String toString() {
		return "Element [yhaut=" + yhaut + ", xbas=" + xbas + ", daltax=" + dx + ", daltay=" + dy + ", ybas="
				+ ybas + "]";
	}


}
