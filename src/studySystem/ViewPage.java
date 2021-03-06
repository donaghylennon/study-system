package studySystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class ViewPage extends JFrame implements ActionListener {
	private MainPage ancestor;
	private StudySystem studySystem;
	
	private JPanel mainPanel = new JPanel();
	
	private JLabel titleLabel = new JLabel("View Previous Sessions");
	
	private JTabbedPane viewTP = new JTabbedPane();
	private JTextArea sessionsTA = new JTextArea();
	private JScrollPane sessionsPane = new JScrollPane(sessionsTA);
	private JTextArea coursesTA = new JTextArea();
	private JScrollPane coursesPane = new JScrollPane(coursesTA);
	
	private JButton backButton = new JButton("Back");
	
	public ViewPage(MainPage ancestor, StudySystem studySystem) {
		this.ancestor = ancestor;
		this.studySystem = studySystem;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        mainPanel.setLayout(new BorderLayout());
        
        this.add(mainPanel);
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(viewTP, BorderLayout.CENTER);
        mainPanel.add(backButton, BorderLayout.SOUTH);
        viewTP.addTab("Sessions", sessionsPane);
        viewTP.addTab("Courses", coursesPane);
        
        backButton.addActionListener(this);
        
        sessionsTA.setText(studySystem.getSessionsText());
//        sessionsPane.setPreferredSize(new Dimension(200, 200));
        sessionsTA.setEditable(false);
        coursesTA.setText(studySystem.getCoursesText());
        coursesTA.setEditable(false);
        
        this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == backButton) {
			this.dispose();
			ancestor.setVisible(true);
		}
	}
}
