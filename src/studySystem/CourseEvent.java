package studySystem;

import java.time.LocalDateTime;

enum CourseEventType {
	LECTURE, LAB, QUIZ, ASSIGNMENT, EXAM
}

public class CourseEvent {
	private CourseEventType type;
	private LocalDateTime endDateTime;
	private LocalDateTime startDateTime;
	private int creditPercentage;
	private int achievedPercentage;
	
	public CourseEvent(CourseEventType type, LocalDateTime endDateTime, LocalDateTime startDateTime, int creditPercentage) {
		this.type = type;
		this.endDateTime = endDateTime;
		this.startDateTime = startDateTime;
		this.creditPercentage = creditPercentage;
	}

	public CourseEventType getType() {
		return type;
	}

	public void setType(CourseEventType type) {
		this.type = type;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public int getCreditPercentage() {
		return creditPercentage;
	}

	public void setCreditPercentage(int creditPercentage) {
		this.creditPercentage = creditPercentage;
	}

	public int getAchievedPercentage() {
		return achievedPercentage;
	}

	public void setAchievedPercentage(int achievedPercentage) {
		this.achievedPercentage = achievedPercentage;
	}
}
