package StudySystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StudySystemFrame extends JFrame {
	
	public StudySystemFrame() {
		
		JPanel leftPanel = new JPanel();
		
		JPanel generalPanel = new JPanel();
		generalPanel.setBackground(new Color(40, 80, 220));
//		generalPanel.setBounds(0, 60, 400, 150);
		generalPanel.setPreferredSize(new Dimension(400, 150));
//		generalPanel.setAlignmentX(LEFT_ALIGNMENT);
//		generalPanel.setAlignmentY(TOP_ALIGNMENT);
		JPanel navPanel = new JPanel();
		navPanel.setBackground(Color.gray);
//		navPanel.setBounds(0, 0, 800, 60);
		navPanel.setPreferredSize(new Dimension(800, 60));
//		navPanel.setAlignmentY(TOP_ALIGNMENT);
		JPanel coursePanel = new JPanel();
		coursePanel.setBackground(new Color(40, 80, 180));
//		coursePanel.setBounds(0, 210, 400, 390);
		coursePanel.setPreferredSize(new Dimension(400, 390));
//		coursePanel.setAlignmentX(LEFT_ALIGNMENT);
//		coursePanel.setAlignmentY(BOTTOM_ALIGNMENT);
		JPanel calendarPanel = new JPanel();
		calendarPanel.setBackground(new Color(70, 80, 100));
//		calendarPanel.setBounds(400, 60, 400, 540);
		calendarPanel.setPreferredSize(new Dimension(400, 540));
		
//		JButton button = new JButton();
//		button.setBounds(10, 10, 100, 50);
//		button.setBackground(new Color(200, 200, 200));
//		button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
//		button.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		JLabel generalLabel = new JLabel();
		generalLabel.setText("General Information");
		generalPanel.add(generalLabel);
		
		this.setTitle("Study System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		leftPanel.setLayout(new BorderLayout());
//		this.setResizable(false);
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		
		ImageIcon logo = new ImageIcon("res/StudySystem2.png");
		this.setIconImage(logo.getImage());
		
		this.add(leftPanel, BorderLayout.WEST);

		leftPanel.add(generalPanel, BorderLayout.NORTH);

		this.add(navPanel, BorderLayout.NORTH);

		leftPanel.add(coursePanel, BorderLayout.CENTER);

		this.add(calendarPanel, BorderLayout.CENTER);
		
//		this.add(button);

//		SwingUtilities.updateComponentTreeUI(this);
		
		this.setVisible(true);
		
//		this.getContentPane().setBackground(new Color(64,0,128));
	}
}
