package studySystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BasicStudySession {
	private LocalDate date;
	private LocalTime timeStart;
	private LocalTime timeEnd;
	
	private static DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("HH:mm");
	
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
	
	public String toCsv() {
		return date.format(dateFmt) + "," + timeStart.format(timeFmt) + "," + timeEnd.format(timeFmt);
	}
	
	public static BasicStudySession fromCsv(String csv) {
		String[] values = csv.split(",");
		LocalDate d = LocalDate.parse(values[0], dateFmt);
		LocalTime s = LocalTime.parse(values[1], timeFmt);
		LocalTime e = LocalTime.parse(values[2], timeFmt);
		return new BasicStudySession(d, s, e);
	}

	@Override
	public String toString() {
		return "Study Session [" + date.format(dateFmt) + ": From " + timeStart.format(timeFmt) + " To " + timeEnd.format(timeFmt) + "]";
	}
}
