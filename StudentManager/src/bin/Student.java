/**
 * 
 */
package bin;

/**
 * @author Heretic
 *
 *         UNSC
 */
public class Student {
	public static int SCODE = 0;

	private int idStudent = 0;
	private String nameStudent;
	private int idProvin;
	private String birth;
	private int sex;
	private double math;
	private double physics;
	private double chemistry;
	public Student(){
		idStudent = SCODE;
		nameStudent = null;
		// provinCode =
		birth = "";
		sex = 0;
		math = 0;
		physics = 0;
		chemistry = 0;
		SCODE++;
	}

	public Student( String _studentName, String _birth, int _provinCode) {
		this.idStudent = SCODE;
		this.nameStudent = _studentName;
		this.idProvin = _provinCode;
		this.birth = _birth;
		SCODE++;
	}

	public Student(String _studentName, int _provinCode, String _birth, int _sex, double _mathScore,
			double _phyScore, double _cheScore) {
		this.idStudent = SCODE;
		this.nameStudent = _studentName;
		this.idProvin = _provinCode;
		this.birth = _birth;
		this.sex = _sex;
		this.math = _mathScore;
		this.physics = _phyScore;
		this.chemistry = _cheScore;
		SCODE++;
	}
	public Student(int _idStudent, String _nameStudent, int _idProvin, String _birth, int _sex, double _math,
			double _physics, double _chemistry) {
		super();
		this.idStudent = _idStudent;
		this.nameStudent = _nameStudent;
		this.idProvin = _idProvin;
		this.birth = _birth;
		this.sex = _sex;
		this.math = _math;
		this.physics = _physics;
		this.chemistry = _chemistry;
	}

	public Student(Student _s) {
		this.idStudent = SCODE;
		this.nameStudent = _s.nameStudent;
		this.idProvin = _s.idProvin;
		this.birth = _s.birth;
		this.sex = _s.sex;
		this.math = _s.math;
		this.physics = _s.physics;
		this.chemistry = _s.chemistry;
		SCODE++;
	}

	public static int getSCODE() {
		return SCODE;
	}

	public static void setSCODE(int sCODE) {
		SCODE = sCODE;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public void setStudentName(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public int getIdProvin() {
		return idProvin;
	}

	public void setIdProvin(int idProvin) {
		this.idProvin = idProvin;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public double getMath() {
		return math;
	}

	public void setMath(double math) {
		this.math = math;
	}

	public double getPhysics() {
		return physics;
	}

	public void setPhysics(double physics) {
		this.physics = physics;
	}

	public double getChemistry() {
		return chemistry;
	}

	public void setChemistry(double chemistry) {
		this.chemistry = chemistry;
	}

	@Override
	public String toString() {
		return "Student [idStudent=" + idStudent + ", studentName=" + nameStudent + ", idProvin=" + idProvin
				+ ", birth=" + birth + ", sex=" + sex + ", math=" + math + ", physics=" + physics + ", chemistry="
				+ chemistry + "]";
	}

}
