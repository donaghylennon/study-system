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
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner.NumberEditor;

public class CoursePage extends JFrame implements ActionListener {
	private MainPage ancestor;
	private StudySystem studySystem;
	
	private JPanel mainPanel = new JPanel();
	private JPanel inputPanel = new JPanel();
	private JPanel dateStartPanel = new JPanel();
	private JPanel dateEndPanel = new JPanel();
	
	private JLabel titleLabel = new JLabel("Add a new course");
	
	private JButton addButton = new JButton("Add Course");
	private JButton backButton = new JButton("Back");
	
	private JTextField nameTF = new JTextField();
	
	private JSpinner dayStartSpinner = new JSpinner(new SpinnerNumberModel(LocalDate.now().getDayOfMonth(), 1, LocalDate.now().lengthOfMonth(), 1));
	private JSpinner monthStartSpinner = new JSpinner(new SpinnerNumberModel(LocalDate.now().getMonthValue(), 1, 12, 1));
	private JSpinner yearStartSpinner = new JSpinner(new SpinnerNumberModel(LocalDate.now().getYear(), 2000, LocalDate.MAX.getYear(), 1));
	private JSpinner dayEndSpinner = new JSpinner(new SpinnerNumberModel(LocalDate.now().getDayOfMonth(), 1, LocalDate.now().lengthOfMonth(), 1));
	private JSpinner monthEndSpinner = new JSpinner(new SpinnerNumberModel(LocalDate.now().getMonthValue(), 1, 12, 1));
	private JSpinner yearEndSpinner = new JSpinner(new SpinnerNumberModel(LocalDate.now().getYear(), 2000, LocalDate.MAX.getYear(), 1));
	
	public CoursePage(MainPage ancestor, StudySystem studySystem) {
		this.ancestor = ancestor;
		this.studySystem = studySystem;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        this.add(mainPanel);
        mainPanel.add(titleLabel);
        mainPanel.add(inputPanel);
        mainPanel.add(addButton);
        mainPanel.add(backButton);
        inputPanel.add(nameTF);
        inputPanel.add(dateStartPanel);
        inputPanel.add(dateEndPanel);
        dateStartPanel.add(dayStartSpinner);
        dateStartPanel.add(monthStartSpinner);
        dateStartPanel.add(yearStartSpinner);
        dateEndPanel.add(dayEndSpinner);
        dateEndPanel.add(monthEndSpinner);
        dateEndPanel.add(yearEndSpinner);
        
        nameTF.setPreferredSize(new Dimension(100, 20));
        
        dayStartSpinner.setEditor(new JSpinner.NumberEditor(dayStartSpinner, "00"));
        monthStartSpinner.setEditor(new JSpinner.NumberEditor(monthStartSpinner, "00"));
        yearStartSpinner.setEditor(new JSpinner.NumberEditor(yearStartSpinner, "0000"));
        dayEndSpinner.setEditor(new JSpinner.NumberEditor(dayEndSpinner, "00"));
        monthEndSpinner.setEditor(new JSpinner.NumberEditor(monthEndSpinner, "00"));
        yearEndSpinner.setEditor(new JSpinner.NumberEditor(yearEndSpinner, "0000"));
        
        addButton.addActionListener(this);
        backButton.addActionListener(this);
        
        this.setVisible(true);
	}
	
	private void resetInputs() {
		nameTF.setText("");
		dayStartSpinner.setValue(LocalDate.now().getDayOfMonth());
		monthStartSpinner.setValue(LocalDate.now().getMonthValue());
		yearStartSpinner.setValue(LocalDate.now().getYear());
		dayEndSpinner.setValue(LocalDate.now().getDayOfMonth());
		monthEndSpinner.setValue(LocalDate.now().getMonthValue());
		yearEndSpinner.setValue(LocalDate.now().getYear());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == addButton) {
			studySystem.addCourse(
					nameTF.getText(), 
					(int) yearStartSpinner.getValue(), 
					(int) monthStartSpinner.getValue(), 
					(int) dayStartSpinner.getValue(), 
					(int) yearEndSpinner.getValue(),
					(int) monthEndSpinner.getValue(), 
					(int) dayEndSpinner.getValue());
			resetInputs();
		} else if(source == backButton) {
			this.dispose();
			ancestor.setVisible(true);
		}
	}
}
