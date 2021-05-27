package StudySystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainScreenFrame extends JFrame {
	
	public MainScreenFrame(Course[] courses) {
		
		JPanel leftPanel = new JPanel();
		
		JPanel studyPanel = new JPanel();
		studyPanel.setBackground(new Color(40, 80, 220));
//		generalPanel.setBounds(0, 60, 400, 150);
		studyPanel.setPreferredSize(new Dimension(400, 150));
		studyPanel.setLayout(new BorderLayout());
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
		
		JLabel courseDisplayLabel = new JLabel("No course selected");
        calendarPanel.add(courseDisplayLabel);
        JList<Course> courseList = new JList<Course>();
        DefaultListModel<Course> courseModel = new DefaultListModel<Course>();
        courseList.setModel(courseModel);
        courseList.getSelectionModel().addListSelectionListener(e -> {
        	Course c = courseList.getSelectedValue();
            courseDisplayLabel.setText(c.getName());
            return;
        });
        
        JScrollPane courseScrollPane = new JScrollPane(courseList, 20, 30);
        courseScrollPane.setBorder(null);
        courseModel.addElement(new Course("Functional Programming"));
        courseModel.addElement(new Course("Computer Architecture"));
        courseModel.addElement(new Course("Advanced Systems Programming"));
		
//		JButton button = new JButton();
//		button.setBounds(10, 10, 100, 50);
//		button.setBackground(new Color(200, 200, 200));
//		button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
//		button.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
//		JLabel generalLabel = new JLabel();
//		generalLabel.setText("General Information");
//		studyPanel.add(generalLabel);
		JButton studyButton = new JButton("Study");
		studyButton.setFont(new Font(studyButton.getFont().getName(), studyButton.getFont().getStyle(), 25));
		studyButton.setFocusable(false);
		studyButton.setBorder(null);
		studyButton.setBackground(new Color(40, 80, 220));
		studyButton.addActionListener(e -> {
			new StudyFrame();
			this.setVisible(false);
		});
		studyPanel.add(studyButton, BorderLayout.CENTER);
		
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

		leftPanel.add(studyPanel, BorderLayout.NORTH);

		this.add(navPanel, BorderLayout.NORTH);

		leftPanel.add(courseScrollPane, BorderLayout.CENTER);

		this.add(calendarPanel, BorderLayout.CENTER);
		
//		this.add(button);

//		SwingUtilities.updateComponentTreeUI(this);
		
		this.setVisible(true);
		
//		this.getContentPane().setBackground(new Color(64,0,128));
	}
}
