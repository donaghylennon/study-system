package studySystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPage extends JFrame implements ActionListener {
    private JPanel mainPanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JPanel studyPanel = new JPanel();
    private JPanel optionPanel = new JPanel();

    private JButton studyButton = new JButton("Study");
    private JButton courseButton = new JButton("Courses");
    private JButton calendarButton = new JButton("Calendar");
    private JButton settingsButton = new JButton("Settings");

    private JButton placeHolderButton = new JButton("Placeholder");

    private GridBagConstraints leftPanelGbc = new GridBagConstraints();
    private GridBagConstraints rightPanelGbc = new GridBagConstraints();
    private GridBagConstraints studyBtnGbc = new GridBagConstraints();
    private GridBagConstraints optionsGbc = new GridBagConstraints();

    public MainPage() {
        initWindow();
        setLayouts();
        createStructure();
        addCallbacks();
        createSizing();

        this.setVisible(true);
    }

    private void initWindow() {
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void createStructure() {
        // Arranging panels and boxes in order to display my components in the structure I want
        this.add(mainPanel, BorderLayout.CENTER);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);
        leftPanel.add(studyPanel, studyBtnGbc);
        leftPanel.add(optionPanel, optionsGbc);
        studyPanel.add(studyButton, BorderLayout.CENTER);
        optionPanel.add(courseButton);
        optionPanel.add(calendarButton);
        optionPanel.add(settingsButton);
        rightPanel.add(placeHolderButton, BorderLayout.CENTER);
    }

    private void createSizing() {
        studyPanel.setPreferredSize(new Dimension(300, 100));
        studyButton.setPreferredSize(new Dimension(300, 100));
        courseButton.setPreferredSize(new Dimension(300, 100));
        calendarButton.setPreferredSize(new Dimension(300, 100));
        settingsButton.setPreferredSize(new Dimension(300, 100));
    }

    private void setLayouts() {
    	this.setLayout(new BorderLayout(40, 40));
    	mainPanel.setLayout(new BorderLayout(40, 20));
        leftPanel.setLayout(new GridBagLayout());
        rightPanel.setLayout(new BorderLayout());
        studyPanel.setLayout(new BorderLayout());
        optionPanel.setLayout(new GridLayout(3,1));
        leftPanelGbc.anchor = GridBagConstraints.WEST;
        leftPanelGbc.weightx = 1;
        leftPanelGbc.insets = new Insets(0, 20, 0, 0);
        leftPanelGbc.gridheight = 1;
        leftPanelGbc.gridwidth = 1;
        leftPanelGbc.gridx = 0;
        leftPanelGbc.gridy = 0;
        leftPanelGbc.fill = GridBagConstraints.VERTICAL;
        rightPanelGbc.anchor = GridBagConstraints.EAST;
        rightPanelGbc.weightx = 1;
        rightPanelGbc.fill = GridBagConstraints.BOTH;
        rightPanelGbc.gridheight = 1;
        rightPanelGbc.gridwidth = 2;
        rightPanelGbc.gridx = 1;
        rightPanelGbc.gridy = 0;
        studyBtnGbc.anchor = GridBagConstraints.NORTH;
        studyBtnGbc.weighty = 1;
        studyBtnGbc.insets = new Insets(0, 0, 40, 0);
        optionsGbc.anchor = GridBagConstraints.CENTER;
        optionsGbc.weighty = 1;
        optionsGbc.gridy = 1;
        optionsGbc.gridheight = 2;
        optionsGbc.fill = GridBagConstraints.BOTH;
    }
    
    private void addCallbacks() {
    	studyButton.addActionListener(this);;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    	Object source = actionEvent.getSource();
    	
    	if(source == studyButton) {
    		new StudyPage();
    		this.dispose();
    	}
    }
}
