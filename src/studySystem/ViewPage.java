package studySystem;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;

public class ViewPage extends JFrame {
	private MainPage ancestor;
	private List<BasicStudySession> sessions;
	
	public ViewPage(MainPage ancestor, List<BasicStudySession> sessions) {
		this.ancestor = ancestor;
		this.sessions = sessions;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        this.setVisible(true);
	}
}
