/**
 * 
 */
package test;

import bin.Student;

/**
 * @author Heretic
 *
 * UNSC
 */
public class TestStudent {
public static void main(String[] args) {
	Student s = new Student();
	
	s.setStudentName("Thanh");
	s.setBirth("23/4/1996");
	s.setIdProvin(1);
	
	System.out.println(s);
	
	Student q =new Student(s);
	System.out.println(q);
	System.out.println(s);
	
	q.setStudentName("Vu Quoc Doanh");
	q.setIdProvin(2);
	q.setBirth("22/5/1995");
	System.out.println(q);
	System.out.println(s);
}
}
