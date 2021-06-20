package studySystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ViewPage extends JFrame implements ActionListener {
	private MainPage ancestor;
//	private List<BasicStudySession> sessions;
	private StudySystem studySystem;
	
	private JPanel mainPanel = new JPanel();
	
	private JLabel titleLabel = new JLabel("View Previous Sessions");
	
	private JTextArea sessionsTA = new JTextArea();
	private JScrollPane sessionsPane = new JScrollPane(sessionsTA);
	
	private JButton backButton = new JButton("Back");
	
	public ViewPage(MainPage ancestor, StudySystem studySystem) {
		this.ancestor = ancestor;
//		this.sessions = sessions;
		this.studySystem = studySystem;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        mainPanel.setLayout(new BorderLayout());
        
        this.add(mainPanel);
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(sessionsPane, BorderLayout.CENTER);
        mainPanel.add(backButton, BorderLayout.SOUTH);
        
        backButton.addActionListener(this);
        
        sessionsTA.setText(studySystem.getSessionsText());
        sessionsPane.setPreferredSize(new Dimension(200, 200));
        sessionsTA.setEditable(false);
        
        this.setVisible(true);
	}
	
//	private String getSessionsText() {
//		if(this.sessions == null || this.sessions.isEmpty())
//			return "";
//		StringBuilder textBuilder = new StringBuilder();
//		for(BasicStudySession session : sessions) {
//			textBuilder.append(session);
//			textBuilder.append("\n");
//		}
//		return textBuilder.toString();
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == backButton) {
			this.dispose();
			ancestor.setVisible(true);
		}
	}
}
