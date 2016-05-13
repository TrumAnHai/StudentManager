/**
 * 
 */
package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import bin.ArraylistProvin;
import bin.ArraylistStudent;
import bin.Student;

import dataSQL.IOdata;

/**
 * @author Heretic
 *
 *         UNSC
 */
public class Table extends JTable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] myHeaders = { "Ma thi sinh", "Ten thi sinh", "Que quan", "Ngay sinh", "Gioi tinh", "Toan", "Ly",
			"Hoa" };
	private Class[] myClass = { Integer.class, String.class, String.class, String.class, Integer.class, Double.class,
			Double.class, Double.class };
	private MyTableModel tblModel = new MyTableModel();
	private MyFrame myFrame;

	private ArraylistStudent sList;
	private ArraylistProvin pList;
	private JButton btnFilter1 = new JButton();

	public Table(MyFrame _myFrame) {
		super();
		this.myFrame = _myFrame;
		this.pList = _myFrame.getListProvin();
		this.sList = _myFrame.getListStudent();
		// JButton btnFilter1 = myFrame.getFilterPanel().btnFilter;
//		btnFilter1 = myFrame.getFilterPanel().btnFilter;
//		btnFilter1.addActionListener(this);
		
		// this.setTblModel(tblModel);
		this.setModel(tblModel);
		this.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		this.getTableHeader().setPreferredSize(new Dimension(0, 30));
		this.setRowHeight(20);
		// this.getColumnModel().getColumn(0).setPreferredWidth(200);
		this.getColumnModel().getColumn(1).setPreferredWidth(200);
		this.getColumnModel().getColumn(2).setPreferredWidth(200);
		this.getColumnModel().getColumn(3).setPreferredWidth(100);
		this.getColumnModel().getColumn(4).setPreferredWidth(100);
		this.getColumnModel().getColumn(5).setPreferredWidth(100);
		this.getColumnModel().getColumn(6).setPreferredWidth(100);
		this.getColumnModel().getColumn(7).setPreferredWidth(100);
		/*
		 * add listeners
		 */
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getSelectionModel().addListSelectionListener(new MyListSelectionHandler(myFrame));
	}

	public String[] getMyHeaders() {
		return myHeaders;
	}

	public void setMyHeaders(String[] myHeaders) {
		this.myHeaders = myHeaders;
	}

	public Class[] getMyClass() {
		return myClass;
	}

	public void setMyClass(Class[] myClass) {
		this.myClass = myClass;
	}

	public MyTableModel getTblModel() {
		return tblModel;
	}

	public void setTblModel(MyTableModel tblModel) {
		this.tblModel = tblModel;
	}

	public MyFrame getMyFrame() {
		return myFrame;
	}

	public void setMyFrame(MyFrame myFrame) {
		this.myFrame = myFrame;
	}

	public ArraylistStudent getsList() {
		return sList;
	}

	public void setsList(ArraylistStudent sList) {
		this.sList = sList;
	}

	class MyListSelectionHandler implements ListSelectionListener {
		MyFrame myFrame;

		public MyListSelectionHandler(MyFrame _myFrame) {
			this.myFrame = _myFrame;
		}

		public void valueChanged(ListSelectionEvent e) {
			int index = getSelectedRow();
			if (index >= 0) {
				myFrame.getInfoPanel().updateData(index);
			}
		}
	}

	public class MyTableModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyTableModel() {
			super();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see javax.swing.table.TableModel#getColumnCount()
		 */
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return myHeaders.length;
		}

		public String getColumnName(int _cols) {
			return myHeaders[_cols];
		}

		public Class getColumnClass(int _cols) {
			return myClass[_cols];
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see javax.swing.table.TableModel#getRowCount()
		 */
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return sList.getsList().size();
		}

		public boolean isEditable(int _rowIndex, int _columnIndex) {
			return false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see javax.swing.table.TableModel#getValueAt(int, int)
		 */
		@Override
		public Object getValueAt(int _rowIndex, int _columnIndex) {
			// TODO Auto-generated method stub
			
//			Student student = (Student) IOdata.getListStudent().getStudent(_rowIndex);//get data from SQL
//			String provin = IOdata.getListProvin().getProvin(student.getIdProvin()).getNameProvin();//get data from SQL
			
			Student student = sList.getStudent(_rowIndex);
			
			switch (_columnIndex) {
			case 0:
				return new Integer(student.getIdStudent());
			case 1:
				return student.getNameStudent();
			case 2:
//				return provin;
				return pList.searchName(student.getIdProvin());
			case 3:
				return student.getBirth();
			case 4:
				if (student.getSex() == 0) {
					return "Nam";
				} else {
					return "Nữ";
				}
			case 5:
				return new Double(student.getMath());
			case 6:
				return new Double(student.getPhysics());
			case 7:
				return new Double(student.getChemistry());
			default:
				throw new RuntimeException("no column selected");
			}

		}
	}


}
