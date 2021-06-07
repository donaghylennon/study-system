package studySystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class StudyPage extends JFrame implements ActionListener {
	private JPanel mainPanel = new JPanel();
	private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JPanel pomodoroPanel = new JPanel();
    private JPanel detailsPanel = new JPanel();
    private JPanel methodPanel = new JPanel();
    private DetailsSection detailsSection = new DetailsSection(StudyMethod.POMODORO);
    
    
    private JButton pomodoroButton = new JButton("Start Pomodoro");
    private JButton placeholderButton = new JButton("Placeholder");
    
    private JLabel didYouLabel = new JLabel("Did you study today?");
    private JLabel methodLabel = new JLabel("Study method:");
    
    private DefaultComboBoxModel<String> methodModel = new DefaultComboBoxModel<>();
    private JComboBox<String> methodCombo = new JComboBox<>(methodModel);

    private JPanel pomodoroDetailsPanel = new JPanel();
    private JPanel makeFlashcardsDetailsPanel = new JPanel();
    private JPanel reviewFlashcardsDetailsPanel = new JPanel();
    private JPanel pastPaperDetailsPanel = new JPanel();
	
	public StudyPage() {
		initWindow();
		setLayouts();
		createStructure();
		createSizing();
		fillCombobox();
		
		this.setVisible(true);
	}
	
	void initWindow() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
	}
	
	void createStructure() {
		this.add(mainPanel, BorderLayout.CENTER);
		mainPanel.add(leftPanel, BorderLayout.WEST);
		mainPanel.add(rightPanel, BorderLayout.CENTER);
		leftPanel.add(pomodoroPanel, BorderLayout.NORTH);
		leftPanel.add(detailsPanel, BorderLayout.CENTER);
		pomodoroPanel.add(pomodoroButton);
		detailsPanel.add(didYouLabel);
		detailsPanel.add(methodPanel);
		detailsPanel.add(detailsSection);
		methodPanel.add(methodLabel);
		methodPanel.add(methodCombo);
		rightPanel.add(placeholderButton, BorderLayout.CENTER);
		
//		pomodoroDetailsPanel.add();
	}
	
	void createSizing() {
		//pomodoroPanel.setPreferredSize(new Dimension(300, 100));
		pomodoroButton.setPreferredSize(new Dimension(300, 100));
		placeholderButton.setPreferredSize(new Dimension(300, 100));
	}
	
	void setLayouts() {
		this.setLayout(new BorderLayout(0, 0));
		mainPanel.setLayout(new BorderLayout(60, 0));
		rightPanel.setLayout(new BorderLayout());
		leftPanel.setLayout(new BorderLayout(0, 30));
		detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
	}
	
	void fillCombobox() {
		methodCombo.addItem("Pomodoro");
		methodCombo.addItem("Make Flashcards");
		methodCombo.addItem("Review Flashcards");
		methodCombo.addItem("Past Paper");
		methodCombo.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == methodCombo) {
			switch (methodCombo.getSelectedIndex()) {
			case 0:
				
				break;

			default:
				break;
			}
		}
	}

	private class DetailsSection extends JPanel {
		DetailsSection(StudyMethod method) {
			switch(method) {
			case POMODORO:
				this.add(new JLabel("Number of Sessions:"));
				this.add(new JSpinner(new SpinnerNumberModel(1, 1, 20, 1)));
				this.add(new JLabel("Session Length:"));
				this.add(new JSpinner(new SpinnerNumberModel(25, 10, 500, 5)));
				this.add(new JLabel("Sessions Failed:"));
				this.add(new JSpinner(new SpinnerNumberModel(0, 0, 20, 1)));
				break;
			case MAKE_FLASHCARDS:
				break;
			case REVIEW_FLASHCARDS:
				break;
			case PAST_PAPER:
				break;
			}
		}
	}
}
