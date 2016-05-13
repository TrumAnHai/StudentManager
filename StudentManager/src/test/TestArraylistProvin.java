/**
 * 
 */
package test;

import bin.ArraylistProvin;
import bin.Provin;

/**
 * @author Heretic
 *
 * UNSC
 */
public class TestArraylistProvin {
public static void main(String[] args) {
	ArraylistProvin list = new ArraylistProvin();
	list.addProvin(new Provin(1,"Ha Noi"));
	list.addProvin(new Provin(2, "Hung Yen"));
	list.addProvin(new Provin(3, "Hai Duong"));
	System.out.println(list.toString());
	
	list.removeProvin(1);
	System.out.println(list.toString());
	
	list.getProvin(2).setNameProvin("ha Noi");
	System.out.println(list.toString());
	
	System.out.println(list.search("ha Noi"));
}
}
