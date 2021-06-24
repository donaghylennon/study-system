package studySystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudySystem {
	List<Course> courses;
	List<BasicStudySession> sessions;
	
	public StudySystem() {
		initDatabase();
		courses = new ArrayList<>();
		courses.add(Course.NONE);
		sessions = new ArrayList<>();
		readFromFile();
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(String name, int startDateY, int startDateM, int startDateD, int endDateY, int endDateM, int endDateD) {
		courses.add(new Course(name, 
				LocalDate.of(startDateY, startDateM, startDateD), 
				LocalDate.of(endDateY, endDateM, endDateD)));
		saveToFile();
	}
	
	public void addSession(Course course, int dateY, int dateM, int dateD, int startTimeH, int startTimeM, int endTimeH, int endTimeM) {
		sessions.add(new BasicStudySession(
				course,
				LocalDate.of(dateY, dateM, dateD), 
				LocalTime.of(startTimeH, startTimeM), 
				LocalTime.of(endTimeH, endTimeM)));
		saveToFile();
	}
	
	public String getCoursesText() {
		if(this.courses == null || this.courses.isEmpty())
			return "";
		StringBuilder textBuilder = new StringBuilder();
		for(Course course : courses) {
			if(course.equals(Course.NONE))
				continue;
			textBuilder.append(course);
			textBuilder.append("\n");
		}
		return textBuilder.toString();
	}
	
	public String getSessionsText() {
		if(this.sessions == null || this.sessions.isEmpty())
			return "";
		StringBuilder textBuilder = new StringBuilder();
		for(BasicStudySession session : sessions) {
			textBuilder.append(session);
			textBuilder.append("\n");
		}
		return textBuilder.toString();
	}
	
	private String coursesToCsv() {
		if(this.courses == null || this.courses.isEmpty())
			return "";
		StringBuilder result = new StringBuilder();
		for(Course course : courses) {
			result.append(course.toCsv());
		}
		return result.toString();
	}
	
	private String sessionsToCsv() {
		if(this.sessions == null || this.sessions.isEmpty())
			return "";
		StringBuilder result = new StringBuilder();
		for(BasicStudySession session : sessions) {
			result.append(session.toCsv());
		}
		return result.toString();
	}
	
	public void saveToFile() {
		FileWriter fw;
		try {
			fw = new FileWriter("data/data.csv");
			fw.write("Courses:\n");
			fw.write(coursesToCsv());
			fw.write("Sessions:\n");
			fw.write(sessionsToCsv());
			fw.close();
		} catch (IOException e) {
			System.err.println("Couldn't write to file: ");
			e.printStackTrace();
		}
	}
	
	public void readFromFile() {
		File file = new File("data/data.csv");
		if(!file.exists())
			return;
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			if(sc.hasNextLine() && sc.nextLine().equals("Courses:")) {
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					if(line.equals("Sessions:"))
						break;
					courses.add(Course.fromCsv(line));
				}
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					sessions.add(BasicStudySession.fromCsv(line, courses));
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Couldn't read from file: ");
			e.printStackTrace();
		} finally {
			if(sc != null)
				sc.close();
		}
	}
	
	private void initDatabase() {
		File file = new File("data/study.db");
		if(!file.exists()) {
			String query = "CREATE TABLE course"
					+ "(	course_id 	INTEGER PRIMARY KEY NOT NULL,"
					+ "		name 		TEXT NOT NULL,"
					+ "		start_date	TEXT,"
					+ "		end_date	TEXT"
					+ "); "
					+ "CREATE TABLE session"
					+ "(	session_id	INTEGER PRIMARY KEY NOT NULL,"
					+ "		course_id	INTEGER,"
					+ "		date		TEXT NOT NULL,"
					+ "		start_time	TEXT NOT NULL,"
					+ "		end_time	TEXT NOT NULL,"
					+ "		FOREIGN KEY(course_id) REFERENCES course(course_id) ON DELETE SET NULL ON UPDATE CASCADE"
					+ ");";
			
			try(Connection c = DriverManager.getConnection("jdbc:sqlite:data/study.db");
					Statement st = c.createStatement()) {
				st.executeUpdate(query);
			} catch(SQLException e) {
				System.err.println("Error connecting to database:");
				e.printStackTrace();
			}
		}
	}
}
