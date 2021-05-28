package studySystem;

import java.time.LocalDateTime;

enum StudyMethod {
	POMODORO, MAKE_FLASHCARDS, REVIEW_FLASHCARDS, PAST_PAPER
}

public class StudySession {
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private StudyMethod method;
	private StudyDetails details;
	
	public StudySession(StudyMethod method, StudyDetails details) {
		this.startTime = LocalDateTime.now();
		this.method = method;
		this.details = details;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public StudyMethod getMethod() {
		return method;
	}

	public void setMethod(StudyMethod method) {
		this.method = method;
	}

	public StudyDetails getDetails() {
		return details;
	}

	public void setDetails(StudyDetails details) {
		this.details = details;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
}
