package studySystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class StudySystem {
	List<BasicStudySession> sessions;
	
	public StudySystem() {
		sessions = new ArrayList<>();
	}
	
	public void addSession(int dateY, int dateM, int dateD, int startTimeH, int startTimeM, int endTimeH, int endTimeM) {
		sessions.add(new BasicStudySession(
				LocalDate.of(dateY, dateM, dateD), 
				LocalTime.of(startTimeH, startTimeM), 
				LocalTime.of(endTimeH, endTimeM)));
	}
	
	public String getSessionsText() {
		if(this.sessions == null || this.sessions.isEmpty())
			return "";
		StringBuilder textBuilder = new StringBuilder();
		for(BasicStudySession session : sessions) {
			textBuilder.append(session);
			textBuilder.append("\n");
		}
		return textBuilder.toString();
	}
	
	public String toCsv() {
		return "";
	}
}
