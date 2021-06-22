package studySystem;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPage extends JFrame implements ActionListener {
	private StudySystem studySystem;
	
	private JPanel mainPanel = new JPanel();
	
	private JLabel titleLabel = new JLabel("Study System");
	
	private JButton studyButton = new JButton("Study");
	private JButton courseButton = new JButton("Course");
	private JButton viewButton = new JButton("View Details");
	
	public MainPage(StudySystem studySystem) {
		this.studySystem = studySystem;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        this.add(mainPanel);
        mainPanel.add(titleLabel);
        mainPanel.add(studyButton);
        mainPanel.add(courseButton);
        mainPanel.add(viewButton);
        
        studyButton.addActionListener(this);
        courseButton.addActionListener(this);
        viewButton.addActionListener(this);
        
        this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == studyButton) {
			this.setVisible(false);
			new StudyPage(this, studySystem);
		} else if(source == viewButton) {
			this.setVisible(false);
			new ViewPage(this, studySystem);
		} else if(source == courseButton) {
			this.setVisible(false);
			new CoursePage(this, studySystem);
		}
	}
}
