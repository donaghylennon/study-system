package studySystem;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class StudyPage extends JFrame implements ActionListener {
	private JFrame ancestor;
	private Calendar calendar = Calendar.getInstance();
	
	private JPanel mainPanel = new JPanel();
	private JPanel inputPanel = new JPanel();
	private JPanel datePanel = new JPanel();
	private JPanel timePanel = new JPanel();
	
	private JLabel titleLabel = new JLabel("Enter details of session:");
	
	private JButton submitButton = new JButton("Submit");
	private JButton backButton = new JButton("Back");
	
	private JSpinner daySpinner = new JSpinner(new SpinnerNumberModel(LocalDate.now().getDayOfMonth(), 1, LocalDate.now().lengthOfMonth(), 1));
	private JSpinner monthSpinner = new JSpinner(new SpinnerNumberModel(LocalDate.now().getMonthValue(), 1, 12, 1));
	private JSpinner yearSpinner = new JSpinner(new SpinnerNumberModel(LocalDate.now().getYear(), 2000, LocalDate.MAX.getYear(), 1));
	private JSpinner hourSpinner = new JSpinner(new SpinnerNumberModel(12, 0, 23, 1));
    private JSpinner minuteSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
	
	public StudyPage(MainPage ancestor) {
		this.ancestor = ancestor;
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
		inputPanel.add(timePanel);
		datePanel.add(daySpinner);
		datePanel.add(monthSpinner);
		datePanel.add(yearSpinner);
		timePanel.add(hourSpinner);
		timePanel.add(minuteSpinner);
		
		backButton.addActionListener(this);
		
		yearSpinner.setEditor(new JSpinner.NumberEditor(yearSpinner, "0000"));
		hourSpinner.setEditor(new JSpinner.NumberEditor(hourSpinner, "00"));
		minuteSpinner.setEditor(new JSpinner.NumberEditor(minuteSpinner, "00"));
		
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
