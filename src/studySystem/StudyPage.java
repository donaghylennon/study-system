package studySystem;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class StudyPage extends JFrame implements ActionListener {
	private MainPage ancestor;
//	private List<BasicStudySession> sessions;
	private StudySystem studySystem;
	
	private JPanel mainPanel = new JPanel();
	private JPanel inputPanel = new JPanel();
	private JPanel datePanel = new JPanel();
	private JPanel timeStartPanel = new JPanel();
	private JPanel timeEndPanel = new JPanel();
	
	private JLabel titleLabel = new JLabel("Enter details of session:");
	
	private JButton submitButton = new JButton("Submit");
	private JButton backButton = new JButton("Back");
	
	private JSpinner daySpinner = new JSpinner(new SpinnerNumberModel(LocalDate.now().getDayOfMonth(), 1, LocalDate.now().lengthOfMonth(), 1));
	private JSpinner monthSpinner = new JSpinner(new SpinnerNumberModel(LocalDate.now().getMonthValue(), 1, 12, 1));
	private JSpinner yearSpinner = new JSpinner(new SpinnerNumberModel(LocalDate.now().getYear(), 2000, LocalDate.MAX.getYear(), 1));
	private JSpinner hourStartSpinner = new JSpinner(new SpinnerNumberModel(12, 0, 23, 1));
    private JSpinner minuteStartSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
    private JSpinner hourEndSpinner = new JSpinner(new SpinnerNumberModel(12, 0, 23, 1));
    private JSpinner minuteEndSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
	
	public StudyPage(MainPage ancestor, StudySystem studySystem) {
		this.ancestor = ancestor;
//		this.sessions = sessions;
		this.studySystem = studySystem;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
		
		this.add(mainPanel);
		mainPanel.add(titleLabel);
		mainPanel.add(inputPanel);
		mainPanel.add(submitButton);
		mainPanel.add(backButton);
		inputPanel.add(datePanel);
		inputPanel.add(timeStartPanel);
		inputPanel.add(timeEndPanel);
		datePanel.add(daySpinner);
		datePanel.add(monthSpinner);
		datePanel.add(yearSpinner);
		timeStartPanel.add(hourStartSpinner);
		timeStartPanel.add(minuteStartSpinner);
		timeEndPanel.add(hourEndSpinner);
		timeEndPanel.add(minuteEndSpinner);
		
		backButton.addActionListener(this);
		submitButton.addActionListener(this);
		
		daySpinner.setEditor(new JSpinner.NumberEditor(daySpinner, "00"));
		monthSpinner.setEditor(new JSpinner.NumberEditor(monthSpinner, "00"));
		yearSpinner.setEditor(new JSpinner.NumberEditor(yearSpinner, "0000"));
		hourStartSpinner.setEditor(new JSpinner.NumberEditor(hourStartSpinner, "00"));
		minuteStartSpinner.setEditor(new JSpinner.NumberEditor(minuteStartSpinner, "00"));
		hourEndSpinner.setEditor(new JSpinner.NumberEditor(hourEndSpinner, "00"));
		minuteEndSpinner.setEditor(new JSpinner.NumberEditor(minuteEndSpinner, "00"));
		
		this.setVisible(true);
	}
	
	private void resetInputs() {
		daySpinner.setValue(LocalDate.now().getDayOfMonth());
		monthSpinner.setValue(LocalDate.now().getMonthValue());
		yearSpinner.setValue(LocalDate.now().getYear());
		hourStartSpinner.setValue(12);
		minuteStartSpinner.setValue(0);
		hourEndSpinner.setValue(12);
		minuteEndSpinner.setValue(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == backButton) {
			this.dispose();
			ancestor.setVisible(true);
		} else if(source == submitButton) {
//			sessions.add(new BasicStudySession(
//					LocalDate.of((int)yearSpinner.getValue(), (int)monthSpinner.getValue(), (int)daySpinner.getValue()), 
//					LocalTime.of((int)hourStartSpinner.getValue(), (int)minuteStartSpinner.getValue()), 
//					LocalTime.of((int)hourEndSpinner.getValue(), (int)minuteEndSpinner.getValue()))
//					);
			studySystem.addSession((int)yearSpinner.getValue(), (int)monthSpinner.getValue(), (int)daySpinner.getValue(),
					(int)hourStartSpinner.getValue(), (int)minuteStartSpinner.getValue(), 
					(int)hourEndSpinner.getValue(), (int)minuteEndSpinner.getValue());
			resetInputs();
		}
	}
}
