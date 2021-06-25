package studySystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BasicStudySession {
	private int id;
	private Course course;
	private LocalDate date;
	private LocalTime timeStart;
	private LocalTime timeEnd;
	
	private static DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("HH:mm");
	
	public BasicStudySession(Course course, LocalDate date, LocalTime timeStart, LocalTime timeEnd) {
		this.course = course;
		this.date = date;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}
	
	public BasicStudySession(int id, Course course, LocalDate date, LocalTime timeStart, LocalTime timeEnd) {
		this.id = id;
		this.course = course;
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
		return course.getName() + "," + date.format(dateFmt) + "," + timeStart.format(timeFmt) + "," + timeEnd.format(timeFmt) + "\n";
	}
	
	public static BasicStudySession fromCsv(String csv, List<Course> courseList) {
		String[] values = csv.split(",");
		Course c = Course.NONE;
		for(Course course : courseList)
			if(course.getName().equals(values[0])) {
				c = course;
				break;
			}
		LocalDate d = LocalDate.parse(values[1], dateFmt);
		LocalTime s = LocalTime.parse(values[2], timeFmt);
		LocalTime e = LocalTime.parse(values[3], timeFmt);
		return new BasicStudySession(c, d, s, e);
	}

	@Override
	public String toString() {
		return "Study Session [" + course + " "+ date.format(dateFmt) + ": From " + timeStart.format(timeFmt) + " To " + timeEnd.format(timeFmt) + "]";
	}
}
