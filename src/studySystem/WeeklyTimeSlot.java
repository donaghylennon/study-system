package studySystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class WeeklyTimeSlot {
	private CourseEventType type;
	private DayOfWeek day;
	private LocalTime timeStart;
	private LocalTime timeEnd;
	// slotStart and slotEnd should correspond to the first 
	// and last days on which this event occurs
	private LocalDate slotStart;
	private LocalDate slotEnd;
	
	public WeeklyTimeSlot(CourseEventType type, DayOfWeek day, LocalTime timeStart, LocalTime timeEnd,
			LocalDate slotStart, LocalDate slotEnd) {
		this.type = type;
		this.day = day;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.slotStart = slotStart;
		this.slotEnd = slotEnd;
	}
	
	public CourseEventType getType() {
		return type;
	}
	public void setType(CourseEventType type) {
		this.type = type;
	}
	public DayOfWeek getDay() {
		return day;
	}
	public void setDay(DayOfWeek day) {
		this.day = day;
	}
	public LocalTime getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(LocalTime timeStart) {
		this.timeStart = timeStart;
	}
	public LocalTime getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(LocalTime timeEnd) {
		this.timeEnd = timeEnd;
	}
	public LocalDate getSlotStart() {
		return slotStart;
	}
	public void setSlotStart(LocalDate slotStart) {
		this.slotStart = slotStart;
	}
	public LocalDate getSlotEnd() {
		return slotEnd;
	}
	public void setSlotEnd(LocalDate slotEnd) {
		this.slotEnd = slotEnd;
	}
}
