package studySystem;

import java.awt.Dimension;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StudyPage extends JFrame {
	private JPanel mainPanel = new JPanel();
	private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JPanel pomodoroPanel = new JPanel();
    private JPanel detailsPanel = new JPanel();
    
    private JButton pomodoroButton = new JButton("Start Pomodoro");
    
    private JLabel didYouLabel = new JLabel("Did you study today?");
    private JLabel methodLabel = new JLabel("Study method:");
    
    private DefaultComboBoxModel<StudyMethod> methodModel = new DefaultComboBoxModel<StudyMethod>();
    private JComboBox<StudyMethod> methodCombo = new JComboBox<StudyMethod>(methodModel);
	
	public StudyPage() {
		initWindow();
		createStructure();
		createSizing();
		
		this.setVisible(true);
	}
	
	void initWindow() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
	}
	
	void createStructure() {
		this.add(mainPanel);
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);
		leftPanel.add(pomodoroPanel);
		leftPanel.add(detailsPanel);
		pomodoroPanel.add(pomodoroButton);
	}
	
	void createSizing() {
		//pomodoroPanel.setPreferredSize(new Dimension(300, 100));
		pomodoroButton.setPreferredSize(new Dimension(300, 100));
	}
}
