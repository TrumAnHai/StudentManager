/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import bin.ArraylistStudent;
import bin.DateTranform;
import bin.Student;
import dataSQL.IOdata;

/**
 * @author Heretic
 *
 * UNSC
 */
public class MyToolbar extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnInsert = new JButton("Insert");
	private JButton btnDelete = new JButton("Delete");
	private JButton btnEdit = new JButton("Edit");
	private JButton btnNew = new JButton("New");
	private JButton btnCancel = new JButton("Cancel");
	private MyFrame myFrame;
	
	public MyToolbar(MyFrame _myFrame){
		this.myFrame = _myFrame;
		
		this.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "", 
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));		
		btnNew.addActionListener(this);
		this.add(btnNew);
		btnEdit.addActionListener(this);
		this.add(btnEdit);
		btnInsert.addActionListener(this);
		this.add(btnInsert);
		btnDelete.addActionListener(this);
		this.add(btnDelete);
		btnCancel.addActionListener(this);
		this.add(btnCancel);
			
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if (command.equals(btnNew.getText())){
			StudentInfoPanel infoPanel = myFrame.getInfoPanel();
			infoPanel.clearData();
		}
		if (command.equals(btnCancel)){
			ArraylistStudent list = IOdata.getListStudent();
			myFrame.setListStudent(list);;
			//myFrame.getTable().setsList(list);
			myFrame.getTable().revalidate();
		}
		if (command.equals(btnInsert.getText())){
			StudentInfoPanel infoPanel = myFrame.getInfoPanel();
			//int id = Integer.parseInt(infoPanel.getTxfId().getText());
			//region trung
			int index1 = this.myFrame.getListStudent().getsList().size()-1;
			int id =  this.myFrame.getListStudent().getsList().get(index1).getIdStudent()+1;
			//endregion
			String name = infoPanel.getTxfName().getText().trim();
			String provinName = infoPanel.getTxfProvin().getText().trim();
			int idProvin = myFrame.getListProvin().search(provinName);
			Date dob = infoPanel.getTxfBirth().getDate();
			String birth = DateTranform.convertDateToString(dob);
			
			int sex;
			if (infoPanel.getCkbMale().isSelected()==true){
				sex = 0;
			}else {
				sex =1;
			}
			double math = Double.parseDouble(infoPanel.getTxfMathScore().getText().trim());
			double phy = Double.parseDouble(infoPanel.getTxfPhyScore().getText().trim());
			double che = Double.parseDouble(infoPanel.getTxfCheScore().getText().trim());
			if ( name.equals("")||birth == null||math <0 ||math>10||phy<0||phy>10||che<0||che>10||(infoPanel.getCkbFemale().isSelected()==true&& infoPanel.getCkbMale().isSelected()==true)){
				JOptionPane.showMessageDialog(myFrame, "Invalid data");
			}else {
				int result = JOptionPane.showConfirmDialog(myFrame, "Do u want to add this info to the list?", "Confirm",JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.OK_OPTION){
					Student s = new Student();
					//region trung
					s.setIdStudent(id);
					//endregion
					s.setStudentName(name);
					s.setIdProvin(idProvin);
					s.setBirth(birth);
					s.setSex(sex);
					s.setMath(math);
					s.setPhysics(phy);
					s.setChemistry(che);
					IOdata.insertStudent(s);
					int index = myFrame.getListStudent().getsList().size()-1;
					myFrame.getListStudent().addStudent(s);
					myFrame.getTable().setRowSelectionInterval(index, index);
					myFrame.getTable().revalidate();
					JOptionPane.showMessageDialog(myFrame, "Done!");
				}
			}
					
		}
		if(command.equals(btnEdit.getText())){
			int index = myFrame.getTable().getSelectedRow();
			if (index >=0 ){
				StudentInfoPanel infoPanel = myFrame.getInfoPanel();
				String _id = infoPanel.getTxfId().getText();
				int id = Integer.parseInt(_id);
				String name = infoPanel.getTxfName().getText().trim();
				String provinName = infoPanel.getTxfProvin().getText().trim();
				int idProvin = myFrame.getListProvin().search(provinName);
				Date dob = infoPanel.getTxfBirth().getDate();
				String birth = DateTranform.convertDateToString(dob);
				
				int sex;
				if (infoPanel.getCkbMale().isSelected()==true){
					sex = 0;
				}else {
					sex =1;
				}
				double math = Double.parseDouble(infoPanel.getTxfMathScore().getText().trim());
				double phy = Double.parseDouble(infoPanel.getTxfPhyScore().getText().trim());
				double che = Double.parseDouble(infoPanel.getTxfCheScore().getText().trim());
				if ( name.equals("")||birth == null||math <0 ||math>10||phy<0||phy>10||che<0||che>10||(infoPanel.getCkbFemale().isSelected()==true&& infoPanel.getCkbMale().isSelected()==true)){
					JOptionPane.showMessageDialog(myFrame, "Invalid data");
				}else {
					int result = JOptionPane.showConfirmDialog(myFrame, "Do u want to add this info to the list?", "Confirm",JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.OK_OPTION){
						Student s = myFrame.getListStudent().getStudent(index);
						s.setStudentName(name);
						s.setIdProvin(idProvin);
						s.setBirth(birth);
						s.setSex(sex);
						s.setMath(math);
						s.setPhysics(phy);
						s.setChemistry(che);
						IOdata.updateStudent(index, myFrame.getListStudent());
						myFrame.getTable().getTblModel().fireTableRowsUpdated(index, index);
						myFrame.getTable().revalidate();
					}
				}
			}
		}
		if (command.equals(btnDelete.getText())){
			int index = myFrame.getTable().getSelectedRow();
			if (index >=0){
				int result = JOptionPane.showConfirmDialog(myFrame, "Do u want to delete this info?","Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.OK_OPTION){
					IOdata.deleteStudent(index,myFrame.getListStudent());
					myFrame.getListStudent().removeStudent(index);
					myFrame.getTable().getSelectionModel().clearSelection();
					int size = myFrame.getListStudent().getsList().size();
					if (index <size ){
						myFrame.getTable().setRowSelectionInterval(index, index);
					}else {
						if (size >0 ){
							myFrame.getTable().setRowSelectionInterval(0, 0);
						}
					}
					myFrame.getTable().revalidate();
				}
			}
		}
		
	}		
	

	public void setActionEnabled(int status){
		switch (status){
		case MyFrame.WHEN_START:
			btnNew.setEnabled(false);
			//btnEdit.setEnabled(false);
			//btnInsert.setEnabled(false);
			//btnDelete.setEnabled(false);
			btnCancel.setEnabled(false);
			break;
		case MyFrame.WHEN_OPEN:
			btnNew.setEnabled(true);
			btnEdit.setEnabled(true);
			btnInsert.setEnabled(true);
			btnDelete.setEnabled(true);
			btnCancel.setEnabled(true);
			break;
		default:
			break;
		}
	}
}
