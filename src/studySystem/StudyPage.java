package studySystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
    private JPanel coursePanel = new JPanel();
    private JPanel timePanel = new JPanel();
    private JPanel detailsSectionPanel = new JPanel();
    
    private JButton pomodoroButton = new JButton("Start Pomodoro");
    private JButton submitDetailsButton = new JButton("Submit");
    private JButton placeholderButton = new JButton("Placeholder");
    
    private JLabel didYouLabel = new JLabel("Did you study today?");
    private JLabel methodLabel = new JLabel("Study method:");
    private JLabel courseLabel = new JLabel("Course:");
    private JLabel timeLabel = new JLabel("Time:");
    
    private DefaultComboBoxModel<String> methodModel = new DefaultComboBoxModel<>();
    private JComboBox<String> methodCombo = new JComboBox<>(methodModel);
    private DefaultComboBoxModel<Course> courseModel = new DefaultComboBoxModel<>();
    private JComboBox<Course> courseCombo = new JComboBox<>(courseModel);

    private JPanel pomodoroDetailsPanel = new JPanel();
    private JPanel makeFlashcardsDetailsPanel = new JPanel();
    private JPanel reviewFlashcardsDetailsPanel = new JPanel();
    private JPanel pastPaperDetailsPanel = new JPanel();
    
    private JSpinner hourSpinner = new JSpinner(new SpinnerNumberModel(12, 0, 23, 1));
    private JSpinner minuteSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
    
    private JSpinner pomodoroSessionsSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));
    private JSpinner pomodoroLengthSpinner = new JSpinner(new SpinnerNumberModel(25, 10, 500, 5));
    private JSpinner pomodoroFailedSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 20, 1));
    
    private JSpinner mkfcNumSpinner = new JSpinner(new SpinnerNumberModel(10, 1, 100, 1));
    
    private JSpinner rvfcNumSpinner = new JSpinner(new SpinnerNumberModel(10, 1, 500, 1));
    private JSpinner rvfcSuccessSpinner = new JSpinner(new SpinnerNumberModel(10, 1, 500, 1));
    private JSpinner rvfcFailedSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 500, 1));
    
    private JSpinner ppQuestionsSpinner = new JSpinner(new SpinnerNumberModel(3, 1, 100, 1));
    private JSpinner ppGradeSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 5));
    private JSpinner ppPaperSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 5));
	
	public StudyPage() {
		initWindow();
		setLayouts();
		createStructure();
		createSizing();
		fillCombobox();
		initDetailsPanels();
		formatFields();
		addListeners();
		
		this.setVisible(true);
	}
	
	private void initWindow() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
	}
	
	private void createStructure() {
		this.add(mainPanel, BorderLayout.CENTER);
		mainPanel.add(leftPanel, BorderLayout.WEST);
		mainPanel.add(rightPanel, BorderLayout.CENTER);
		leftPanel.add(pomodoroPanel, BorderLayout.NORTH);
		leftPanel.add(detailsPanel, BorderLayout.CENTER);
		pomodoroPanel.add(pomodoroButton);
		detailsPanel.add(didYouLabel);
		detailsPanel.add(methodPanel);
		detailsPanel.add(coursePanel);
		detailsPanel.add(timePanel);
		methodPanel.add(methodLabel);
		methodPanel.add(methodCombo);
		coursePanel.add(courseLabel);
		coursePanel.add(courseCombo);
		timePanel.add(timeLabel);
		timePanel.add(hourSpinner);
		timePanel.add(minuteSpinner);
		detailsPanel.add(detailsSectionPanel);
		detailsPanel.add(submitDetailsButton);
		detailsSectionPanel.add(pomodoroDetailsPanel);
		rightPanel.add(placeholderButton, BorderLayout.CENTER);
	}
	
	private void createSizing() {
		pomodoroButton.setPreferredSize(new Dimension(300, 100));
		placeholderButton.setPreferredSize(new Dimension(300, 100));
	}
	
	private void setLayouts() {
		this.setLayout(new BorderLayout(0, 0));
		mainPanel.setLayout(new BorderLayout(60, 0));
		rightPanel.setLayout(new BorderLayout());
		leftPanel.setLayout(new BorderLayout(0, 30));
		detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
		
		pomodoroDetailsPanel.setLayout(new BoxLayout(pomodoroDetailsPanel, BoxLayout.Y_AXIS));
		makeFlashcardsDetailsPanel.setLayout(new BoxLayout(makeFlashcardsDetailsPanel, BoxLayout.Y_AXIS));
		reviewFlashcardsDetailsPanel.setLayout(new BoxLayout(reviewFlashcardsDetailsPanel, BoxLayout.Y_AXIS));
		pastPaperDetailsPanel.setLayout(new BoxLayout(pastPaperDetailsPanel, BoxLayout.Y_AXIS));
	}
	
	private void fillCombobox() {
		methodCombo.addItem("Pomodoro");
		methodCombo.addItem("Make Flashcards");
		methodCombo.addItem("Review Flashcards");
		methodCombo.addItem("Past Paper");
		
		courseCombo.addItem(new Course("Functional Programming", LocalDate.now(), LocalDate.of(2050, 10, 29)));
		courseCombo.addItem(new Course("Advanced Systems Programming", LocalDate.now(), LocalDate.of(2050, 10, 29)));
		courseCombo.addItem(new Course("Computer Architecture", LocalDate.now(), LocalDate.of(2050, 10, 29)));
	}
	
	private void formatFields() {
		hourSpinner.setEditor(new JSpinner.NumberEditor(hourSpinner, "00"));
		minuteSpinner.setEditor(new JSpinner.NumberEditor(minuteSpinner, "00"));
	}
	
	private void addListeners() {
		methodCombo.addActionListener(this);
		submitDetailsButton.addActionListener(this);
	}
	
	private void initDetailsPanels() {
		pomodoroDetailsPanel.add(new JLabel("Number of Sessions:"));
		pomodoroDetailsPanel.add(pomodoroSessionsSpinner);
		pomodoroDetailsPanel.add(new JLabel("Session Length:"));
		pomodoroDetailsPanel.add(pomodoroLengthSpinner);
		pomodoroDetailsPanel.add(new JLabel("Sessions Failed:"));
		pomodoroDetailsPanel.add(pomodoroFailedSpinner);
		
		makeFlashcardsDetailsPanel.add(new JLabel("Number of Flashcards:"));
		makeFlashcardsDetailsPanel.add(mkfcNumSpinner);
		
		reviewFlashcardsDetailsPanel.add(new JLabel("Number of Flashcards:"));
		reviewFlashcardsDetailsPanel.add(rvfcNumSpinner);
		reviewFlashcardsDetailsPanel.add(new JLabel("Number Successful:"));
		reviewFlashcardsDetailsPanel.add(rvfcSuccessSpinner);
		reviewFlashcardsDetailsPanel.add(new JLabel("Number Failed:"));
		reviewFlashcardsDetailsPanel.add(rvfcFailedSpinner);
		
		pastPaperDetailsPanel.add(new JLabel("Number of Questions:"));
		pastPaperDetailsPanel.add(ppQuestionsSpinner);
		pastPaperDetailsPanel.add(new JLabel("Percentage of Grade:"));
		pastPaperDetailsPanel.add(ppGradeSpinner);
		pastPaperDetailsPanel.add(new JLabel("Percentage of Paper Attempted:"));
		pastPaperDetailsPanel.add(ppPaperSpinner);
	}
	
	private void resetInputs() {
		pomodoroSessionsSpinner.setValue(1);
		pomodoroLengthSpinner.setValue(25);
		pomodoroFailedSpinner.setValue(0);
		
		mkfcNumSpinner.setValue(10);
		
		rvfcNumSpinner.setValue(10);
		rvfcSuccessSpinner.setValue(10);
		rvfcFailedSpinner.setValue(0);
		
		ppQuestionsSpinner.setValue(3);
		ppGradeSpinner.setValue(0);
		ppPaperSpinner.setValue(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == methodCombo) {
			switch (methodCombo.getSelectedIndex()) {
			case 0:
				detailsSectionPanel.removeAll();
				detailsSectionPanel.add(pomodoroDetailsPanel);
				detailsSectionPanel.revalidate();
				break;
			case 1:
				detailsSectionPanel.removeAll();
				detailsSectionPanel.add(makeFlashcardsDetailsPanel);
				detailsSectionPanel.revalidate();
				break;
			case 2:
				detailsSectionPanel.removeAll();
				detailsSectionPanel.add(reviewFlashcardsDetailsPanel);
				detailsSectionPanel.revalidate();
				break;
			case 3:
				detailsSectionPanel.removeAll();
				detailsSectionPanel.add(pastPaperDetailsPanel);
				detailsSectionPanel.revalidate();
				break;
			default:
				break;
			}
		} else if(source == submitDetailsButton) {
			switch (methodCombo.getSelectedIndex()) {
			case 0:
				Course course = (Course) courseCombo.getSelectedItem();
				int hour = (int)hourSpinner.getValue();
				int minute = (int)minuteSpinner.getValue();
				course.newStudySession(LocalDateTime.of(LocalDate.now(), LocalTime.of(hour, minute)), 
						LocalDateTime.of(LocalDate.now(), LocalTime.of(hour + 1, minute)), StudyMethod.POMODORO, 
						new PomodoroDetails((int) pomodoroSessionsSpinner.getValue(), 
								(int) pomodoroLengthSpinner.getValue(), (int) pomodoroFailedSpinner.getValue()));
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
			}
			resetInputs();
		}
	}
}
