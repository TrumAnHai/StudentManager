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
public class ArraylistProvin {
	private ArrayList<Provin> pList = new ArrayList<Provin>();

	public ArraylistProvin() {
	}

	public ArraylistProvin(ArrayList<Provin> _list) {
		this.pList = _list;
	}

	public ArrayList<Provin> getpList() {
		return pList;
	}

	public void setpList(ArrayList<Provin> pList) {
		this.pList = pList;
	}

	@Override
	public String toString() {
		return "ArraylistProvin [pList=" + pList + "]";
	}
	
	 public Provin getProvin(int _index) {
		_index = _index - 1;
		return (Provin)pList.get(_index);
	}
	public boolean addProvin(Provin _provin) {
		pList.add(_provin);
		return true;
	}

	public int search(String _nameProvin) {
		for (int i = 0; i < pList.size(); i++)
			if (_nameProvin.equals(pList.get(i).getNameProvin())) {
				return pList.get(i).getIdProvin();
			} 
		return 0;
		}

	public String searchName(int _idProvin) {
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getIdProvin() == _idProvin) {
				return pList.get(i).getNameProvin();
			}
		}
		return null;

	}
	
	public boolean removeProvin(int _idProvin){
		_idProvin = _idProvin - 1;
		if (_idProvin >= 0 && _idProvin < pList.size()){
			pList.remove(_idProvin);
			return true;
		}else{
			return false;
		}
	}
}
