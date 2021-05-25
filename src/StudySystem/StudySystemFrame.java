package StudySystem;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class StudySystemFrame extends JFrame {
	
	public StudySystemFrame() {
		this.setTitle("Study System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(600,400);
		
		ImageIcon logo = new ImageIcon("res/StudySystem2.png");
		this.setIconImage(logo.getImage());
		
		this.setVisible(true);
		
		this.getContentPane().setBackground(new Color(64,0,128));
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
