/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.xml.soap.Text;

import bin.ArraylistProvin;
import bin.ArraylistStudent;
import dataSQL.IOdata;
import dataSQL.TextOutput;
import test.TestIOdata;

/**
 * @author Heretic
 *
 *         UNSC
 */
public class MyFrame extends JFrame {
	public static final int WHEN_START = 0;
	public static final int WHEN_OPEN = 1;

	public static int STATUS = WHEN_START;
	private ArraylistStudent sList = new ArraylistStudent();
	private ArraylistProvin pList = new ArraylistProvin();
	private String textFile = "";
	MyMenu menu = new MyMenu(this);
	FilterPanel filterPanel = new FilterPanel(this);
	MyToolbar toolbar = new MyToolbar(this);
	StudentInfoPanel infoPanel = new StudentInfoPanel(this);
	// DSTSPanel dstsPanel = new DSTSPanel(this);
	Table table = null;

	public MyFrame() {
		JPanel contentPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JScrollPane listPane = new JScrollPane();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 600);
		this.setTitle("Phan mem quan li thi tuyen sinh- ver1.0");
		// this.setVisible(true);

		this.setJMenuBar(menu);

		// JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPanel.setLayout(new BorderLayout());
		this.setContentPane(contentPanel);
		// this.setResizable(false);// ko thay doi kich thuoc
		// JPanel centerPanel = new JPanel();
		centerPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		centerPanel.setLayout(new GridLayout(2, 1));
		pList = IOdata.getListProvin();
		sList = IOdata.getListStudent();
		// sList.setpList(pList);
		table = new Table(this);
		JScrollPane listPanel = new JScrollPane();
		listPanel.setViewportView(table);
		centerPanel.add(listPanel, BorderLayout.CENTER);
		centerPanel.add(infoPanel, BorderLayout.SOUTH);
		contentPanel.add(centerPanel, BorderLayout.CENTER);
		contentPanel.add(toolbar, BorderLayout.SOUTH);
		contentPanel.add(filterPanel, BorderLayout.NORTH);
		contentPanel.add(centerPanel, BorderLayout.CENTER);

		// this.addWindowListener(this);

	}
	
	public String getTextFile() {
		return textFile;
	}

	public void setTextFile(String textFile) {
		this.textFile = textFile;
	}

	public ArraylistProvin getListProvin() {
		return pList;
	}

	public void setListProvin(ArraylistProvin _pList) {
		this.pList = _pList;
	}

	public ArraylistStudent getListStudent() {
		return sList;
	}

	public void setListStudent(ArraylistStudent _sList) {
		this.sList = _sList;
	}

	public MyMenu getMenu() {
		return menu;
	}

	public void setMenu(MyMenu menu) {
		this.menu = menu;
	}

	public FilterPanel getFilterPanel() {
		return filterPanel;
	}

	public void setFilterPanel(FilterPanel filterPanel) {
		this.filterPanel = filterPanel;
	}

	public MyToolbar getToolbar() {
		return toolbar;
	}

	public void setToolbar(MyToolbar toolbar) {
		this.toolbar = toolbar;
	}

	public StudentInfoPanel getInfoPanel() {
		return infoPanel;
	}

	public void setInfoPanel(StudentInfoPanel infoPanel) {
		this.infoPanel = infoPanel;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

//	public void openAction() {
//		MyFrame.STATUS = WHEN_OPEN;
//		ArraylistStudent sList = new ArraylistStudent();
//		ArraylistProvin pList = new ArraylistProvin();
//	}
	public void saveAction(){
		JFileChooser chooser = new JFileChooser();
		//ExampleFileFilter filter = new ExampleFileFilter();
		int abc = chooser.showSaveDialog(this);
		if (abc ==JFileChooser.APPROVE_OPTION){
			String fileName = chooser.getSelectedFile().getName();
			String path = chooser.getCurrentDirectory().getPath();
			String filePath = path + "\\" + TextOutput.updateFileName(fileName);
			//TextOutput.writeData(filePath, sList);
			System.out.println(fileName);
			System.out.println(path);
			System.out.println(filePath);
			if(TextOutput.writeData(filePath, sList)){
				this.setTextFile(filePath);
				System.out.println(sList);
			}
		}
	}
	public void helpAction() {
		AboutMe helpDialog = new AboutMe(this);
		helpDialog.setVisible(true);
	}
	public void closeWindows(){
		int result = JOptionPane.showConfirmDialog(this, "Do u want to quit?", "Confirm", JOptionPane.YES_NO_OPTION);
		if ( result == JOptionPane.OK_OPTION){
			//TextOutput.writeData(this.getTextFile(), sList);
			this.dispose();
			System.exit(0);
		} 
	}
}
