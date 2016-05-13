/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;

/**
 * @author Heretic
 *
 *         UNSC
 */
public class AboutMe extends JDialog implements ActionListener {
	private JButton btnCloseHelplog = new JButton("Close");

	public AboutMe(MyFrame _myFrame) {
		setResizable(false);
		setTitle("About me");
		setBounds(_myFrame.getLocation().x + 200, _myFrame.getLocation().y + 250, 500, 350);
		getContentPane().setLayout(new BorderLayout(2, 2));

		JTextArea text = new JTextArea();
		this.getContentPane().add(text, BorderLayout.CENTER);
		this.getContentPane().add(btnCloseHelplog, BorderLayout.SOUTH);
		text.setEditable(false);

		text.setFont(new Font("Times New Roman", Font.BOLD, 13));
		text.setText("\n\n");
		text.append("\t Project: Examinee management\n\n");
		text.append("\t Created by: Đào Kỳ Thanh\n\n");
		text.append("\t                       Vũ Quốc Doanh\n\n");
		text.append("\t                       Nguyễn Văn Anh\n\n");
		text.append("\t Class: CNTT 4\n\n");
		text.append("\t Course: K55\n\n");
		text.append("\t School: University of Transport and Communication\n\n");
		text.append("\t Thanh's repository(Public): https://github.com/TrumAnHai/StudentManager");

		btnCloseHelplog.addActionListener(this);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnCloseHelplog)) {
			this.setVisible(false);

		}
	}

}
