/**
 * 
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author Heretic
 *
 * UNSC
 */
public class MyMenu extends JMenuBar implements ActionListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*
 * attributes
 */
	private JMenu mnFile = new JMenu("File");
	private JMenuItem mntmOpen = new JMenuItem("Open");
	private JMenuItem mntmSave = new JMenuItem("Save");
	private JMenuItem mntmClose = new JMenuItem("Close");	
	private JMenu mnAbout = new JMenu("About");
	private JMenuItem mntmAboutme = new JMenuItem("About me");
	private MyFrame myFrame;
/*
 * Constructors
 */
	public MyMenu(MyFrame _myFrame){
		this.myFrame =_myFrame;
		this.add(mnFile);
		this.add(mnAbout);
		//mntmOpen.setMnemonic(KeyEvent.VK_CONTROL+ KeyEvent.VK_O);
		mntmSave.setMnemonic(KeyEvent.VK_CONTROL+KeyEvent.VK_S);
		mntmClose.setMnemonic(KeyEvent.VK_CONTROL+KeyEvent.VK_ESCAPE);
		
		//mnFile.add(mntmOpen);
		mnFile.add(mntmSave);
		mnFile.addSeparator();
		mnFile.add(mntmClose);
		mnAbout.add(mntmAboutme);
		
		//mntmOpen.setToolTipText("Open a file");
		mntmSave.setToolTipText("save a file");
		mntmClose.setToolTipText("Close program");
		
		mntmAboutme.addActionListener(this);
		mntmSave.addActionListener(this);
		mntmClose.addActionListener(this);
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals(mntmAboutme.getText())){
			myFrame.helpAction();
		}
		if (e.getActionCommand().equals(mntmSave.getText())){
			myFrame.saveAction();
		}
		if(e.getActionCommand().equals(mntmClose.getText())){
			myFrame.closeWindows();
		}
	}
	
}
