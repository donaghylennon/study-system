package studySystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Course {
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private int noFlashcards;
	private List<WeeklyTimeSlot> weeklies;
	private List<CourseEvent> events;
	private List<StudySession> studySessions;
	
	public Course(String name, LocalDate startDate, LocalDate endDate) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.noFlashcards = 0;
		studySessions = new ArrayList<>();
		events = new ArrayList<>();
		studySessions = new ArrayList<>();
	}
	
	public void newWeekly(CourseEventType type, DayOfWeek day, LocalTime timeStart, 
			LocalTime timeEnd, LocalDate slotStart, LocalDate slotEnd, int creditPerWeek) {
		WeeklyTimeSlot slot = new WeeklyTimeSlot(type, day, timeStart, timeEnd, slotStart, slotEnd);
		weeklies.add(slot);
		
		Period length = Period.between(slotStart, slotEnd);
		int weeks = length.getDays() / 7 + 1;
		
		for(int i = 0; i < weeks; i++) {
			events.add(new CourseEvent(type, slotStart.plusWeeks(weeks).atTime(timeStart), 
					slotStart.plusWeeks(weeks).atTime(timeEnd), creditPerWeek));
		}
	}
	
	public void newEvent(CourseEventType type, LocalDateTime endDateTime, LocalDateTime startDateTime, int creditPercentage) {
		events.add(new CourseEvent(type, endDateTime, startDateTime, creditPercentage));
	}
	
	public void newStudySession(StudyMethod method, StudyDetails details) {
		studySessions.add(new StudySession(method, details));
	}
	
	public void newStudySession(LocalDateTime startTime, LocalDateTime endTime, StudyMethod method, StudyDetails details) {
		studySessions.add(new StudySession(startTime, endTime, method, details));
	}
	
	public String getName() {
		return name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getNoFlashcards() {
		return noFlashcards;
	}

	public void setNoFlashcards(int noFlashcards) {
		this.noFlashcards = noFlashcards;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StudySession> getStudySessions() {
		return studySessions;
	}

	public void setStudySessions(List<StudySession> studySessions) {
		this.studySessions = studySessions;
	}

	public List<WeeklyTimeSlot> getWeeklies() {
		return weeklies;
	}

	public void setWeeklies(List<WeeklyTimeSlot> weeklies) {
		this.weeklies = weeklies;
	}

	@Override
	public String toString() {
		return name;
	}
}
