package studySystem;

import java.time.LocalDate;
import java.time.LocalTime;

public class BasicStudySession {
	private LocalDate date;
	private LocalTime timeStart;
	private LocalTime timeEnd;
	
	public BasicStudySession(LocalDate date, LocalTime timeStart, LocalTime timeEnd) {
		this.date = date;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalTime getTimeStart() {
		return timeStart;
	}

	public LocalTime getTimeEnd() {
		return timeEnd;
	}
}
