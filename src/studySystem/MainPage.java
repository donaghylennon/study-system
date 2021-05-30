package studySystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame implements ActionListener {
    private JPanel mainPanel = new JPanel();
//    private Box leftBox = Box.createVerticalBox();//new Box(BoxLayout.Y_AXIS);
//    private Box rightBox = Box.createVerticalBox();//new Box(BoxLayout.Y_AXIS);
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

//        leftBox.setPreferredSize(new Dimension(300, 500));
        setSizing();
        rightPanel.setBackground(new Color(0x4973AA));

        // Setting visibility to help me see how the panels I'm using for structure are actually laid out
//        leftBox.setBackground(new Color(0x09375E));
//        leftBox.setOpaque(true);
//        optionPanel.setBackground(new Color(0x35D0A0));

//        studyButton.setAlignmentX(JFrame.CENTER_ALIGNMENT);
//        optionPanel.setAlignmentX(JFrame.CENTER_ALIGNMENT);

        this.setVisible(true);
    }

    private void initWindow() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(800, 600));
    }

    private void createStructure() {
        // Arranging panels and boxes in order to display my components in the structure I want
        this.add(mainPanel);
        mainPanel.add(leftPanel, leftPanelGbc);
        mainPanel.add(rightPanel);
        leftPanel.add(studyPanel, studyBtnGbc);
        leftPanel.add(optionPanel, optionsGbc);
        studyPanel.add(studyButton, BorderLayout.CENTER);
        optionPanel.add(courseButton);
        optionPanel.add(calendarButton);
        optionPanel.add(settingsButton);
        rightPanel.add(placeHolderButton, BorderLayout.CENTER);
    }

    private void setSizing() {
        studyPanel.setPreferredSize(new Dimension(300, 100));
        studyButton.setPreferredSize(new Dimension(300, 100));
        courseButton.setPreferredSize(new Dimension(300, 100));
        calendarButton.setPreferredSize(new Dimension(300, 100));
        settingsButton.setPreferredSize(new Dimension(300, 100));
    }

    private void setLayouts() {
        mainPanel.setLayout(new GridBagLayout());
        leftPanel.setLayout(new GridBagLayout());
        rightPanel.setLayout(new BorderLayout());
        studyPanel.setLayout(new BorderLayout());
        optionPanel.setLayout(new GridLayout(3,1));
        leftPanelGbc.anchor = GridBagConstraints.WEST;
        leftPanelGbc.weightx = 1;
        leftPanelGbc.insets = new Insets(0, 20, 0, 20);
        rightPanelGbc.anchor = GridBagConstraints.CENTER;
        rightPanelGbc.weightx = 1;
        studyBtnGbc.anchor = GridBagConstraints.NORTH;
        studyBtnGbc.weighty = 1;
        studyBtnGbc.insets = new Insets(20, 0, 40, 0);
        optionsGbc.anchor = GridBagConstraints.CENTER;
        optionsGbc.weighty = 1;
        optionsGbc.gridy = 1;
        optionsGbc.gridheight = 2;
        optionsGbc.fill = GridBagConstraints.BOTH;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
