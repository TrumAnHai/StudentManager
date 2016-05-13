/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import bin.ArraylistStudent;
import bin.Student;

import dataSQL.IOdata;

/**
 * @author Heretic
 *
 *         UNSC
 */
public class FilterPanel extends JPanel {

	/**
	 * 
	 */
	// private static final long serialVersionUID = 1L;
	JLabel lblProvin = new JLabel("Provincial");
	JLabel lblSex = new JLabel("ID Student");
	JTextField txfProvin = new JTextField();
	JTextField txfID = new JTextField();
	JButton btnFilter = new JButton("Filter");
	private MyFrame myFrame;

	public FilterPanel(MyFrame _myFrame) {
		this.myFrame = _myFrame;

		this.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Filter",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		this.setLayout(new GridLayout(1, 5, 20, 0));
		this.add(lblSex);
		this.add(txfID);
		this.add(lblProvin);
		this.add(txfProvin);

		this.add(btnFilter);
		this.btnFilter.addActionListener(new ActionListener() {
			/*
			 * 2 cai text field isempty -. get toan bo du lieu (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// test region
				if (e.getSource() == btnFilter) {
					if (txfID.getText().compareTo("") != 0 && txfProvin.getText().compareTo("") != 0) {
						ArrayList<Student> list = IOdata.listStudentFilter(txfID.getText().trim(),
								txfProvin.getText().trim());
						// end region
						// ArrayList<Student> list =
						// IOdata.listStudentFilter(txfProvin.getText().trim());
						System.out.println(list);
						for (Student i : list) {
							System.out.println(i.toString());
						}
						myFrame.getListStudent().setsList(list);
						myFrame.getTable().setsList(list);
						myFrame.getTable().revalidate();
					}
					if (txfID.getText().compareTo("") == 0 && txfProvin.getText().compareTo("") != 0) {
						ArrayList<Student> list = IOdata.listStudentFilter(txfProvin.getText().trim());
						// end region
						// ArrayList<Student> list =
						// IOdata.listStudentFilter(txfProvin.getText().trim());
						System.out.println(list);
						for (Student i : list) {
							System.out.println(i.toString());
						}
						myFrame.getListStudent().setsList(list);
						myFrame.getTable().setsList(list);
						myFrame.getTable().revalidate();
					}
					if (txfID.getText().compareTo("") != 0 && txfProvin.getText().compareTo("") == 0) {
						int idStudent = Integer.parseInt(txfID.getText().trim());
						ArrayList<Student> list = IOdata.listStudentFilter(idStudent);
						System.out.println(list);
						for (Student i : list) {
							System.out.println(i.toString());
						}
						myFrame.getListStudent().setsList(list);
						myFrame.getTable().setsList(list);
						myFrame.getTable().revalidate();
					}

					// end test region
					/*
					 * normal code ArrayList<Student> list =
					 * IOdata.listStudentFilter(txfProvin.getText().trim());
					 * System.out.println(list); for (Student i : list) {
					 * System.out.println(i.toString()); }
					 * myFrame.getListStudent().setsList(list);
					 * myFrame.getTable().setsList(list);
					 * myFrame.getTable().revalidate();
					 */
				}
			}
		});
	}

}
