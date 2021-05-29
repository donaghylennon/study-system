package studySystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;

public class StudyFrame extends JFrame {
	public StudyFrame() {
		this.setLayout(new BorderLayout());
		
//		JSplitPane split = new JSplitPane();
		JPanel topPanel = new JPanel();
		Box topBox = new Box(BoxLayout.Y_AXIS);
		JPanel bottomPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel studyMethodPanel = new JPanel();
		JPanel studyDetailsPanel = new JPanel();
		JPanel pomodoroDetailsPanel = new JPanel();
		JPanel mkFlashcardsDetailsPanel = new JPanel();
		JPanel rvFlashcardsDetailsPanel = new JPanel();
		JPanel pastPaperDetailsPanel = new JPanel();
		JLabel questionLabel = new JLabel("Did you study today?");
		JLabel studyMethodLabel = new JLabel("Study method: ");
		JComboBox<String> studyMethodCBox = new JComboBox<String>(new DefaultComboBoxModel<String>());
		JScrollPane studyDetailsScrollPane = new JScrollPane(studyDetailsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JButton pomodoroButton = new JButton("Start Pomodoro");
//		pomodoroButton.setSize(new Dimension(50, 25));
		
		pomodoroButton.setFocusable(false);
		
		studyMethodCBox.addItem("Pomodoro");
		studyMethodCBox.addItem("Make Flashcards");
		studyMethodCBox.addItem("Review Flashcards");
		studyMethodCBox.addItem("Past Paper");
		studyDetailsPanel.add(pomodoroDetailsPanel);
		pomodoroDetailsPanel.add(new JLabel("Number of Sessions:"));
		pomodoroDetailsPanel.add(new JSpinner(new SpinnerNumberModel(1, 1, 20, 1)));
		pomodoroDetailsPanel.add(new JLabel("Session Length:"));
		pomodoroDetailsPanel.add(new JSpinner(new SpinnerNumberModel(25, 10, 500, 5)));
		pomodoroDetailsPanel.add(new JLabel("Sessions Failed:"));
		pomodoroDetailsPanel.add(new JSpinner(new SpinnerNumberModel(0, 0, 20, 1)));
		
		studyMethodCBox.addActionListener(e -> {
			switch(studyMethodCBox.getSelectedIndex()) {
			case 0:
				studyDetailsPanel.remove(0);
				studyDetailsPanel.add(pomodoroDetailsPanel);
				break;
			case 1:
				studyDetailsPanel.remove(0);
				studyDetailsPanel.add(mkFlashcardsDetailsPanel);
				break;	
			case 2:
				studyDetailsPanel.remove(0);
				studyDetailsPanel.add(rvFlashcardsDetailsPanel);
				break;
			case 3:
				studyDetailsPanel.remove(0);
				studyDetailsPanel.add(pastPaperDetailsPanel);
				break;
			}
		});
		
		pomodoroButton.setAlignmentX(CENTER_ALIGNMENT);
		questionLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		questionLabel.setFont(new Font(questionLabel.getFont().getName(), questionLabel.getFont().getStyle(), 20));
		
		
		topPanel.setPreferredSize(new Dimension(250, 150));
//		topBox.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		topPanel.setBackground(new Color(40, 80, 220));
		bottomPanel.setBackground(new Color(40, 80, 220));
		rightPanel.setBackground(new Color(40, 80, 220));
		studyMethodPanel.setBackground(new Color(40, 80, 220));
		studyDetailsPanel.setBackground(new Color(40, 80, 220));
		
		leftPanel.setLayout(new BorderLayout());
		topPanel.setLayout(new BorderLayout());
		bottomPanel.setLayout(new BorderLayout());
		
		studyMethodPanel.add(studyMethodLabel);
		studyMethodPanel.add(studyMethodCBox);
		topBox.add(Box.createVerticalGlue());
		topBox.add(pomodoroButton);
		topBox.add(Box.createVerticalGlue());
		topBox.add(questionLabel);
		topPanel.add(topBox, BorderLayout.CENTER);
//		bottomPanel.add(questionLabel, BorderLayout.NORTH);
		bottomPanel.add(studyMethodPanel, BorderLayout.NORTH);
		bottomPanel.add(studyDetailsScrollPane, BorderLayout.CENTER);
		leftPanel.add(topPanel, BorderLayout.NORTH);
		leftPanel.add(bottomPanel, BorderLayout.CENTER);
//		split.setLeftComponent(leftPanel);
//		split.setRightComponent(rightPanel);
//		this.add(split);
		this.add(leftPanel, BorderLayout.CENTER);
		this.add(rightPanel, BorderLayout.EAST);
		
		this.setTitle("Study System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		ImageIcon logo = new ImageIcon("res/StudySystem2.png");
		this.setIconImage(logo.getImage());
		this.getContentPane().setBackground(new Color(40, 80, 220));
		this.setVisible(true);
	}
}
