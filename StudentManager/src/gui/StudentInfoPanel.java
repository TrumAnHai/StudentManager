/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import bin.DateTranform;
import bin.Provin;
import bin.Student;

/**
 * @author Heretic
 *
 *         UNSC
 */
public class StudentInfoPanel extends JPanel {
	/* JPanel panel = new JPanel(); */

	/*
	 * attributes
	 */
	// Label
	private MyFrame myFrame;
	private JLabel lblId = new JLabel("ID");
	private JLabel lblName = new JLabel("Name");
	private JLabel lblProvin = new JLabel("BirthPlace");
	private JLabel lblBirth = new JLabel("Birth");
	private JLabel lblMathScore = new JLabel("Math");
	private JLabel lblPhyScore = new JLabel("Physical");
	private JLabel lblCheScore = new JLabel("Chemistry");
	private JLabel lblTotal = new JLabel("Total");
	private JLabel lblSex = new JLabel("Sex");
	// Textfield
	private JTextField txfId = new JTextField();
	private JTextField txfName = new JTextField();
	private JDateChooser txfBirth = new JDateChooser("dd/MM/yyyy", "##/##/####",'_');
	private JTextField txfProvin = new JTextField();
	private JTextField txfMathScore = new JTextField();
	private JTextField txfPhyScore = new JTextField();
	private JTextField txfCheScore = new JTextField();
	private JTextField txfTotal = new JTextField();
	// Checkbox
	private JRadioButton ckbMale = new JRadioButton("Male");
	private JRadioButton ckbFemale = new JRadioButton("Female");

	public StudentInfoPanel(MyFrame _myFrame) {

		// super();
		this.myFrame = _myFrame;
		this.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Thong tin thi sinh",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));

		this.setLayout(new GridLayout(5, 4, 20, 5));
		txfId.setEditable(false);
		this.add(lblId);
		this.add(txfId);

		this.add(lblMathScore);
		this.add(txfMathScore);

		this.add(lblName);
		this.add(txfName);

		this.add(lblPhyScore);
		this.add(txfPhyScore);

		this.add(lblBirth);
		this.add(txfBirth);
		txfBirth.getJCalendar().setTodayButtonVisible(true);
		this.add(lblCheScore);
		this.add(txfCheScore);

		this.add(lblProvin);
		this.add(txfProvin);

		this.add(lblTotal);
		this.add(txfTotal);

		this.add(lblSex);
		this.add(ckbMale);
		this.add(ckbFemale);
		/*
		 * this.add(comp); this.add(comp); this.add(comp);
		 */
		clearData();
	}

	public JTextField getTxfId() {
		return txfId;
	}

	public void setTxfId(JTextField txfId) {
		this.txfId = txfId;
	}

	public JTextField getTxfName() {
		return txfName;
	}

	public void setTxfName(JTextField txfName) {
		this.txfName = txfName;
	}

	public JDateChooser getTxfBirth() {
		return txfBirth;
	}

	public void setTxfBirth(JDateChooser txfBirth) {
		this.txfBirth = txfBirth;
	}

	public JTextField getTxfProvin() {
		return txfProvin;
	}

	public void setTxfProvin(JTextField txfProvin) {
		this.txfProvin = txfProvin;
	}

	public JTextField getTxfMathScore() {
		return txfMathScore;
	}

	public void setTxfMathScore(JTextField txfMathScore) {
		this.txfMathScore = txfMathScore;
	}

	public JTextField getTxfPhyScore() {
		return txfPhyScore;
	}

	public void setTxfPhyScore(JTextField txfPhyScore) {
		this.txfPhyScore = txfPhyScore;
	}

	public JTextField getTxfCheScore() {
		return txfCheScore;
	}

	public void setTxfCheScore(JTextField txfCheScore) {
		this.txfCheScore = txfCheScore;
	}

	public JTextField getTxfTotal() {
		return txfTotal;
	}

	public void setTxfTotal(JTextField txfTotal) {
		this.txfTotal = txfTotal;
	}

	public JRadioButton getCkbMale() {
		return ckbMale;
	}

	public void setCkbMale(JRadioButton ckbMale) {
		this.ckbMale = ckbMale;
	}

	public JRadioButton getCkbFemale() {
		return ckbFemale;
	}

	public void setCkbFemale(JRadioButton ckbFemale) {
		this.ckbFemale = ckbFemale;
	}

	public void updateData(int _index) {
		Student s = (Student) myFrame.getListStudent().getStudent(_index);
		Provin p = (Provin) myFrame.getListProvin().getProvin(s.getIdProvin());
		txfId.setText("" + s.getIdStudent());
		txfName.setText(s.getNameStudent());
		txfBirth.setDate(DateTranform.convertStringToDate(s.getBirth()));
		txfProvin.setText(p.getNameProvin());
		txfMathScore.setText("" + s.getMath());
		txfPhyScore.setText("" + s.getPhysics());
		txfCheScore.setText("" + s.getChemistry());
		if (s.getSex() == 0) {
			ckbMale.setSelected(true);
			ckbFemale.setSelected(false);
		} else {
			ckbFemale.setSelected(true);
			ckbMale.setSelected(false);
		}
	}

	public void clearData() {
		txfId.setText("");
		txfName.setText("");
		txfBirth.setDate(null);
		txfProvin.setText("");
		txfMathScore.setText("");
		txfPhyScore.setText("");
		txfCheScore.setText("");
		ckbFemale.setSelected(false);
		ckbMale.setSelected(false);
	}
}
