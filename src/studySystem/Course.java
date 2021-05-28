package studySystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private int noFlashcards;
	private List<WeeklyTimeSlot> weeklies;
	private List<StudySession> studySessions;
	
	public Course(String name, LocalDate startDate, LocalDate endDate) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.noFlashcards = 0;
		studySessions = new ArrayList<>();
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
