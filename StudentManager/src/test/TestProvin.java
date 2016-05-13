/**
 * 
 */
package test;

import bin.Provin;

/**
 * @author Heretic
 *
 * UNSC
 */
public class TestProvin {
public static void main(String[] args) {
	Provin p = new Provin();
	p.setIdProvin(1);
	p.setNameProvin("Ha Noi");
	
	System.out.println(p);
	
	Provin q  = new Provin(p);
	System.out.println(q);
	System.out.println(p);
	
	q.setIdProvin(2);
	q.setNameProvin("Hung Yen");
	System.out.println(q);
	System.out.println(p);
	
}
}
