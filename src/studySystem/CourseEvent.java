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
}
