/**
 * 
 */
package bin;

import java.util.ArrayList;

/**
 * @author Heretic
 *
 *         UNSC
 */
public class ArraylistStudent {
	private ArrayList sList = new ArrayList();
	private ArrayList pList = new ArrayList();

	
	public ArrayList getsList() {
		return sList;
	}

	public void setsList(ArrayList sList) {
		this.sList = sList;
	}

	public ArrayList getpList() {
		return pList;
	}

	public void setpList(ArrayList pList) {
		this.pList = pList;
	}

	@Override
	public String toString() {
		return "ArraylistStudent [sList=" + sList + "]";
	}

	public boolean addStudent(Student s) {
		sList.add(s);
		return true;
	}

	public String searchStudent(int _idStudent) {
		for (int i = 0; i < sList.size(); i++) {
			if (((Student) sList.get(i)).getIdStudent() == _idStudent) {
				return ((Student) sList.get(i)).getNameStudent();

			}
		}
		return null;
	}

	public Student getStudent(int _index) {
		//_index = _index - 1;
		return (Student) sList.get(_index);
	}

	public boolean removeStudent(int _index) {
			//_index = _index - 1;
		//_index 
			if (_index >0 && _index <sList.size()) {
				sList.remove(_index);
				return true;
			} else
				return false;

		}
	
}
