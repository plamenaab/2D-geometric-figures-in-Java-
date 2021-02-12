package geometrie;

import java.awt.Graphics;
import java.awt.Point;

public class Vieleck extends GObjekt {
	
	protected Punkt z;
	protected double r;
	protected int anzahl;
	protected Punkt[] eckpunkte = new Punkt[anzahl];
	
	public Vieleck(int anzahlN) {
		
		super("Vieleck", anzahlN);
		
		anzahl = anzahlN;
		eckpunkte = new Punkt[anzahlN];
		z = new Punkt(0,0);
		r = 1;
	}
	
	public Vieleck(int anzahlN, double rN) {
		
		super("Vieleck", anzahlN);
		
		anzahl = anzahlN;
		eckpunkte = new Punkt[anzahlN];
		z = new Punkt(0,0);
		r = rN;	
	}
	
	public Vieleck(int anzahlN, Punkt zentrum, double rN) {
		
		super("Vieleck", anzahlN);
		
		anzahl = anzahlN;
		eckpunkte = new Punkt[anzahlN];
		z = zentrum;
		r = rN;
	}
	
	public Vieleck(Vieleck v) {
		
		super("Vieleck", 2);
		
		eckpunkte = new Punkt[anzahl];
		
		for (int i = 0; i < eckpunkte.length; i++) {
			eckpunkte[i] = new Punkt(v.eckpunkte[i]);
		}
		
		r = v.r;
		z = v.z;
		anzahl = v.anzahl;
	}
	
	@Override
	 public int kontrolle() {
		 if(r<=0)
			 return 1;
		 else if(anzahl<=3)
			 return 3;
		 else 
			 return 0;
	 }
	 
	 @Override
	 public void eingabe()
	 {
		 do {
			 System.out.println("Anzahl der Seiten ");
			 anzahl = Hilfe.SCANNER.nextInt();
		  
			 System.out.println("Zentrum: ");
			 z.eingabe();
			 System.out.println("Radius: ");
			 r = Hilfe.SCANNER.nextDouble();
			  if(kontrolle()==1)
				 System.out.println("Falsches Radius!");
			  else if(kontrolle()==3)
				  System.out.println("Falsche Anzahl!");
		 }
		 while (kontrolle()!=0);
	 }
	 
	 @Override
	 public double umfang() {
		 return 2 * anzahl * r * Math.sin(Math.PI / anzahl);
	 }
	 
	 @Override
	 public double flaeche() {
		 return ((r * r * anzahl) / 2) * Math.sin((2 * Math.PI) / anzahl);
	 }
	 
	 @Override
	 public String art() {
		 String art;
		 art = "regelmaessiges " + anzahl + "-eck";
		 return art;
	 }
	 
	 @Override
	 public void ausgabe() {
		System.out.println(this);
		System.out.println("Radius = " + r);
		System.out.println("Zentrum = " + z);
		System.out.println("Umfang: " + umfang());
		System.out.println("Flaeche: " + flaeche());
		System.out.println("Art: " + art());
	 }
	 
	 @Override
	 public String toString() {
		 return "Vieleck: " + anzahl + " Seiten";
	 }
	 
	 @Override
	 public void zeichnen(Graphics g, double koef) {
		 
		 eckpunkteZ = new Punkt[anzahl];
		 for(int i=0; i < eckpunkteZ.length; i++) {
			 int x=(int)(eckpunkte[i].x*koef);
			 int y=(int)(eckpunkte[i].y*koef);
			 eckpunkteZ[i] = new Punkt(x,y);
		 }
		 
		
		 int mx[], my[];
		 mx = new int[eckpunkteZ.length];
		 my = new int[eckpunkteZ.length];
		 
		 for(int i=0; i<eckpunkteZ.length; i++) {
			 mx[i] = new Double(eckpunkteZ[i].x).intValue();
			 my[i] = new Double(eckpunkteZ[i].y).intValue();
		 }
		 
		 g.drawPolygon(mx, my, eckpunkteZ.length);
	 }

	 public boolean contains(int x, int y){
		 /*
			Point p1, p2, pp1=null, pp2=null, m=new Point(x,y);
			int i=0, j, zaehler=0;
			do  {
				j=(i+1)%eckpunkteZ.length;
				if(eckpunkteZ[i].x<eckpunkteZ[j].x)  {
					p1=eckpunkteZ[i];    p2=eckpunkteZ[j];
				}else    {
					p1=eckpunkteZ[j];    p2=eckpunkteZ[i];
				 }
				if(p1.x == p2.x)   {    
					if(vertikale(m, p1, p2))         return true;
				}else    {              				
					Point pp=schnittpunkt(m,p1,p2);				
					if(pp != null)    {
						if(pp.equals(m))             return true;
						if(zaehler==0)    {
							pp1=new Point(pp);
						}else if(zaehler==1)   {
							     pp2=new Point(pp);
						      }
						zaehler++;
					}		 
				}
				i++;
			}while(i<eckpunkteZ.length && zaehler < 2);
			if(zaehler==2)   {
				if(pp1.y >= y && pp2.y <= y || pp1.y <= y && pp2.y >= y)
				  return true;
			}
		    return false;
		    */
		 return false;
		}
		public static boolean vertikale(Point m, Point p1, Point p2)   {
			if(p1.x==m.x && ((p1.y<=m.y && m.y<=p2.y) || (p1.y>=m.y && m.y >=p2.y)))
				return true;
			else
				return false;
		}
		public static Point schnittpunkt(Point m, Point p1, Point p2)   {
			int y0=p1.y+(int)((m.x-p1.x)*(p2.y-p1.y)/(p2.x-p1.x));
			if(m.x >p1.x && m.x<p2.x)             
				return new Point(m.x,y0);
			else
				return null;
		}


	@Override
	boolean equal(GObjekt g) {
		
		Vieleck v = (Vieleck) g;
		double[] a = new double[anzahl];
		double[] b= new double[v.anzahl];
		eckpunkte = new Punkt[anzahl];
		int check=0;
		for (int i = anzahl - 1; i < eckpunkte.length; i--) {
			a[i] = Gerade.abstand(eckpunkte[i], eckpunkte[i - 1]);
			if (i == 0) {
				a[anzahl - 1] = Gerade.abstand(eckpunkte[0], eckpunkte[anzahl - 1]);
			}
		}
		for (int i = v.anzahl - 1; i < eckpunkte.length; i--) {
			b[i] = Gerade.abstand(eckpunkte[i], eckpunkte[i - 1]);
			if (i == 0) {
				b[v.anzahl - 1] = Gerade.abstand(eckpunkte[0], eckpunkte[anzahl - 1]);
			}
		}
        for (int i = 0; i < eckpunkte.length; i++) {
			if(a[i]==b[i]) {
				check++;
			}
		}
        if(check==anzahl)
        	return true;
        else 
        return false;
				
	}

}

	
