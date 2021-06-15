package studySystem;

public class PomodoroDetails extends StudyDetails {
	private int numSessions;
	private int sessionLength;
	private int failedSessions;
	
	public PomodoroDetails(int numSessions, int sessionLength, int failedSessions) {
		this.numSessions = numSessions;
		this.sessionLength = sessionLength;
		this.failedSessions = failedSessions;
	}
}
