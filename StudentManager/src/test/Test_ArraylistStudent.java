/**
 * 
 */
package test;

import bin.ArraylistStudent;
import bin.Student;

/**
 * @author Heretic
 *
 * UNSC
 */
public class Test_ArraylistStudent {
public static void main(String[] args) {
	ArraylistStudent list = new ArraylistStudent();
	list.addStudent(new Student());
	//list.addStudent(new Student("thanh", 1));
	list.addStudent(new Student(2, "Thanh", 2, "23/4/1996", 1, 9, 9, 9));

	System.out.println(list.toString());
	list.removeStudent(2);
	System.out.println(list.toString());
	
}
}
