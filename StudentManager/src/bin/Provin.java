/**
 * 
 */
package bin;

/**
 * @author Heretic
 *
 *         UNSC
 */
public class Provin {
	public static int PCODE = 0;

	private int idProvin;
	private String nameProvin;

	public Provin() {
		idProvin = PCODE;
		nameProvin = null;
		PCODE++;
	}

	public Provin(String _nameProvin) {
		this.idProvin = PCODE;
		this.nameProvin = _nameProvin;
		PCODE++;
	}

	public Provin(int _idProvin, String _nameProvin) {
		this.idProvin = _idProvin;
		this.nameProvin = _nameProvin;
	}

	public Provin(Provin _p) {
		this.idProvin = _p.idProvin;
		this.nameProvin = _p.nameProvin;
	}

	public static int getPCODE() {
		return PCODE;
	}

	public static void setPCODE(int pCODE) {
		PCODE = pCODE;
	}

	public int getIdProvin() {
		return idProvin;
	}

	public void setIdProvin(int idProvin) {
		this.idProvin = idProvin;
	}

	public String getNameProvin() {
		return nameProvin;
	}

	public void setNameProvin(String nameProvin) {
		this.nameProvin = nameProvin;
	}

	@Override
	public String toString() {
		return "Provin [idProvin=" + idProvin + ", nameProvin=" + nameProvin + "]";
	}

}
