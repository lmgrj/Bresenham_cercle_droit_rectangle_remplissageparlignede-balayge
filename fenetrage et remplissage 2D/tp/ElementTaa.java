package infographie.tp;

import bresenham.Element;

public class ElementTaa extends Element {
	 
	public String toString() {
		return super.toString()+" ElementTaa [r=" + r + ", test=" + test + "]";
	}
	int r;
	boolean test=false;

	public ElementTaa(int r) {
		super();
		this.r = r;
	}

	public ElementTaa() {
		super();
 	}
	public ElementTaa(int yhaut, int xbas, int dx, int dy, int ybas) {
		super(yhaut, xbas, dx, dy, ybas);
		test=true;
	}
	public ElementTaa(int yhaut, int xbas, int dx, int dy, int ybas, int r) {
		super(yhaut, xbas, dx, dy, ybas);
		this.r=r;
	}
	public void calculR(boolean gch){
		int r;
		this.test=false;
		if(this.dx>0){
			if(this.dx<this.dy){
				if(gch)this.r=this.dy-1;
				else this.r= 0;
			}else
			{
				if(gch) this.r= -1;
				else this.r= 0;
			}
		}else
		{
			if(Math.abs(this.dx)<=this.dy){
				if(gch)this.r= 0;
				else this.r=-this.dy;
			}else
			{
				if(gch)this.r=0;
				else this.r= 0;
			}
		}
	}

}
