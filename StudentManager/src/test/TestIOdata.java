/**
 * 
 */
package test;

import java.util.ArrayList;

import bin.ArraylistProvin;
import bin.ArraylistStudent;
import bin.Student;
import dataSQL.IOdata;

/**
 * @author Heretic
 *
 * UNSC
 */
public class TestIOdata {
	public static void main(String[] args) {
		ArrayList<Student> slist = new ArrayList<Student>();
		ArraylistProvin plist = new ArraylistProvin();
		int idProvin = IOdata.getListProvin().search("Hưng Yên");
//		slist = IOdata.getListStudent();
//		System.out.println(slist);
//		plist = IOdata.getListProvin();
//		System.out.println(plist);
		
		slist = IOdata.listStudentFilter("Hưng Yên");
		System.out.println(slist);
		
		slist = IOdata.listStudentFilter(1);
		//System.out.println(slist);
	}
	
	
}
