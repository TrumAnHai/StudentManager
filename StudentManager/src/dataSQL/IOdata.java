/**
 * 
 */
package dataSQL;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bin.ArraylistProvin;
import bin.ArraylistStudent;
import bin.Provin;
import bin.Student;

/**
 * @author Heretic
 *
 *         UNSC
 */
public class IOdata {
	public static ArraylistStudent getListStudent() {
		ArraylistStudent sList = new ArraylistStudent();
		Connection connect = DBConnect.open();
		// ListStudent listS = new ListStudent();
		try {
			if (connect != null) {
				Statement st = connect.createStatement();

				String sqlQuery = "SELECT * FROM thisinh";

				ResultSet rs = st.executeQuery(sqlQuery);

				while (rs.next()) {
					int CURRENT_CODE = rs.getInt("idthisinh");
					String name = rs.getString("studentName");
					String birth = rs.getString("birth");
					int addr = rs.getInt("idProvin");
					int sex = rs.getInt("sex");
					double mathScore = rs.getDouble("mathScore");
					double phyScore = rs.getDouble("phyScore");
					double cheScore = rs.getDouble("cheScore");
					Student s = new Student(CURRENT_CODE, name, addr, birth, sex, mathScore, phyScore, cheScore);
					((ArraylistStudent) sList).addStudent(s);
				}

			}
		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {
			DBConnect.close(connect);
		}
		return sList;
	}

	public static boolean insertStudent(Student _s) {
		Connection connect = DBConnect.open();
		try {
			if (connect != null) {
				Statement st = connect.createStatement();

				int CURRENT_CODE = _s.getIdStudent(); // ma thi sinh
				String name = _s.getNameStudent();
				String birth = _s.getBirth();
				int addr = _s.getIdProvin();
				int sex = _s.getSex();
				double mathScore = _s.getMath();
				double phyScore = _s.getPhysics();
				double cheScore = _s.getChemistry();
				String sqlInsertQuery = "INSERT INTO `thituyensinh`.`thisinh` (`idthisinh`, `studentName`, `idProvin`, `birth`, `sex`, `mathScore`, `phyScore`, `cheScore`) VALUES ('"
						+ CURRENT_CODE + "', '" + name + "', '" + addr + "', '" + birth + " ', '" + sex + "', '"
						+ mathScore + "', '" + phyScore + "', '" + cheScore + "')";

				st.execute(sqlInsertQuery);
				if (st != null) {
					st.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnect.close(connect);
		}
		return true;
	}

	public static boolean updateStudent(int _index, ArraylistStudent _sList) {
		Connection connect = DBConnect.open();

		try {
			if (connect != null) {
				Statement st = connect.createStatement();

				int CURRENT_CODE = _sList.getStudent(_index).getIdStudent(); // ma
																				// thi
																				// sinh
				String name = _sList.getStudent(_index).getNameStudent();
				String birth = _sList.getStudent(_index).getBirth();
				int addr = _sList.getStudent(_index).getIdProvin();
				int sex = _sList.getStudent(_index).getSex();
				double mathScore = _sList.getStudent(_index).getMath();
				double phyScore = _sList.getStudent(_index).getPhysics();
				double cheScore = _sList.getStudent(_index).getChemistry();
				int studentCode = _sList.getStudent(_index).getIdStudent();
				String sqlUpdateQuery = "UPDATE `thituyensinh`.`thisinh` SET `studentName`='" + name + "', `idProvin`='"
						+ addr + "', `Birth`='" + birth + "', `Sex`='" + sex + "', `mathScore`='" + mathScore
						+ "', `phyScore`='" + phyScore + "', `cheScore`='" + cheScore + "' WHERE `idthisinh`='"
						+ CURRENT_CODE + "';";
				st.executeUpdate(sqlUpdateQuery);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnect.close(connect);
		}
		return true;
	}

	public static boolean deleteStudent(int _index, ArraylistStudent _sList) {
		// _index = _index -1;
		Connection connect = DBConnect.open();
		// ListStudent _s = new ListStudent();
		try {
			if (connect != null) {
				Statement st = connect.createStatement();
				int studentCode = _sList.getStudent(_index).getIdStudent();
				String sqlDeleteQuery = "DELETE FROM `thituyensinh`.`thisinh` WHERE `idthisinh`='" + studentCode + "'";
				st.execute(sqlDeleteQuery);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnect.close(connect);
		}
		return true;
	}

	// test region
	public static ArrayList<Student> listStudentFilter(String _idStudent, String _addr) {
		ArrayList<Student> fList = new ArrayList<Student>();
		int idProvin = IOdata.getListProvin().search(_addr);

		Connection connect = DBConnect.open();
		try {
			if (connect != null) {
				Statement st = connect.createStatement();

				int idStudent = Integer.parseInt(_idStudent);
				String sqlQuery = "SELECT * FROM thisinh WHERE `idProvin`='" + idProvin + "' and `idthisinh` = '"
						+ idStudent + "';";
				ResultSet rs = st.executeQuery(sqlQuery);
				while (rs.next()) {
					int CURRENT_CODE = rs.getInt("idthisinh");
					String name = rs.getString("studentName");
					String birth = rs.getString("birth");
					int addr = rs.getInt("idProvin");
					int sex = rs.getInt("sex");
					double mathScore = rs.getDouble("mathScore");
					double phyScore = rs.getDouble("phyScore");
					double cheScore = rs.getDouble("cheScore");

					Student s = new Student(CURRENT_CODE, name, addr, birth, sex, mathScore, phyScore, cheScore);
					fList.add(s);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(connect);
		}
		return fList;
	}

	public static ArrayList<Student> listStudentFilter(String _addr) {
		ArrayList<Student> fList = new ArrayList<Student>();
		int idProvin = IOdata.getListProvin().search(_addr);
		Connection connect = DBConnect.open();

		// ListStudent listS = new ListStudent();
		try {
			if (connect != null) {
				Statement st = connect.createStatement();

				String sqlQuery = "SELECT * FROM thisinh WHERE `idProvin`='" + idProvin + "';";
				ResultSet rs = st.executeQuery(sqlQuery);

				while (rs.next()) {
					int CURRENT_CODE = rs.getInt("idthisinh");
					String name = rs.getString("studentName");
					String birth = rs.getString("birth");
					int addr = rs.getInt("idProvin");
					int sex = rs.getInt("sex");
					double mathScore = rs.getDouble("mathScore");
					double phyScore = rs.getDouble("phyScore");
					double cheScore = rs.getDouble("cheScore");

					Student s = new Student(CURRENT_CODE, name, addr, birth, sex, mathScore, phyScore, cheScore);
					fList.add(s);

				}

			}
		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {
			DBConnect.close(connect);
		}
		return fList;
	}

	public static ArrayList<Student> listStudentFilter(int _idStudent) {
		ArrayList<Student> fList = new ArrayList();
		Connection connect = DBConnect.open();
		// ListStudent listS = new ListStudent();
		try {
			if (connect != null) {
				Statement st = connect.createStatement();
				//int idStudent = Integer.parseInt(_idStudent);
				String sqlQuery = "SELECT * FROM thisinh WHERE `idthisinh`='" + _idStudent + "';";
				ResultSet rs = st.executeQuery(sqlQuery);

				while (rs.next()) {
					int CURRENT_CODE = rs.getInt("idthisinh");
					String name = rs.getString("studentName");
					String birth = rs.getString("birth");
					int addr = rs.getInt("idProvin");
					int sex = rs.getInt("sex");
					double mathScore = rs.getDouble("mathScore");
					double phyScore = rs.getDouble("phyScore");
					double cheScore = rs.getDouble("cheScore");

					Student s = new Student(CURRENT_CODE, name, addr, birth, sex, mathScore, phyScore, cheScore);
					fList.add(s);

				}

			}
		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {
			DBConnect.close(connect);
		}
		return fList;
	}
	public static ArraylistProvin getListProvin() {
		Connection connect = DBConnect.open();
		ArraylistProvin pList = new ArraylistProvin();
		try {
			if (connect != null) {
				Statement st = connect.createStatement();

				String sqlQuery = "SELECT * FROM tinhthanh";

				ResultSet rs = st.executeQuery(sqlQuery);

				while (rs.next()) {
					int CURRENT_CODE = rs.getInt("idProvin");
					String nameP = rs.getString("provinname");

					Provin p = new Provin(CURRENT_CODE, nameP);
					pList.addProvin(p);
				}

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		} finally {
			DBConnect.close(connect);
		}
		return pList;
	}

	// public static boolean insertProvin(Provin _p) {
	// Connection connect = DBConnect.open();
	// try {
	// if (connect != null) {
	// Statement st = connect.createStatement();
	//
	// int PCODE = _p.PCODE; // ma tinh thanh
	// String proName = _p.getNameProvin();
	//
	// String sqlQuery = "INSERT INTO `thituyensinh`.`tinhthanh` (`idProvin`,
	// `provinName`) VALUES ('" + PCODE
	// + "', '" + proName + "')";
	//
	// st.execute(sqlQuery);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// return false;
	// } finally {
	// DBConnect.close(connect);
	// }
	// return true;
	// }
	//
	// public static boolean deleteProvin(int _index, ArraylistProvin _pList) {
	// // _index = _index -1;
	// Connection connect = DBConnect.open();
	// // ListStudent _s = new ListStudent();
	// try {
	// if (connect != null) {
	// Statement st = connect.createStatement();
	// int provinCode = _pList.getProvin(_index).getIdProvin();
	// String sqlQuery = "DELETE FROM `quanlituyensinh`.`provincial` WHERE
	// `idProvin`='" + provinCode + "'";
	// st.execute(sqlQuery);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// return false;
	// } finally {
	// DBConnect.close(connect);
	// }
	// return true;
	// }
}
