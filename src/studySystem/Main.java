package studySystem;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
//		new MainPageOLD();
//		ArrayList<BasicStudySession> sessions = new ArrayList<>();
		StudySystem studySystem = new StudySystem();
		new MainPage(studySystem);
	}

}
