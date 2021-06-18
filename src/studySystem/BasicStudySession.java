package studySystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

	@Override
	public String toString() {
		DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("HH:mm");
		return "Study Session [" + date.format(dateFmt) + ": From " + timeStart.format(timeFmt) + " To " + timeEnd.format(timeFmt) + "]";
	}
}
