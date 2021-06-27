package studySystem;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class StudySystem {
	private String databaseAddress = "jdbc:sqlite:data/study.db";
	
	public StudySystem() {
		initDatabase();
	}
	
	public void addCourse(String name, int startDateY, int startDateM, int startDateD, int endDateY, int endDateM, int endDateD) {
		LocalDate startDate = LocalDate.of(startDateY, startDateM, startDateD);
		LocalDate endDate = LocalDate.of(endDateY, endDateM, endDateD);
		
		String query = "INSERT INTO course(name,start_date,end_date) VALUES(\'" + name + "\',"
		+ startDate.toEpochDay() + "," + endDate.toEpochDay() + ");";
		try(Connection c = DriverManager.getConnection(databaseAddress);
				Statement st = c.createStatement()) {
			st.executeUpdate(query);
		} catch(SQLException e) {
			System.err.println("Error connecting to database:");
			e.printStackTrace();
		}
	}
	
	public void addSession(Course course, int dateY, int dateM, int dateD, int startTimeH, int startTimeM, int endTimeH, int endTimeM) {
		LocalDate date = LocalDate.of(dateY, dateM, dateD);
		LocalTime startTime = LocalTime.of(startTimeH, startTimeM);
		LocalTime endTime = LocalTime.of(endTimeH, endTimeM);

		String query = "INSERT INTO session(course_id,date,start_time,end_time) VALUES(" + course.getId() + ","
				+ date.toEpochDay() + "," + startTime.toSecondOfDay() + "," + endTime.toSecondOfDay() + ");";
		try(Connection c = DriverManager.getConnection(databaseAddress);
				Statement st = c.createStatement()) {
			st.executeUpdate(query);
		} catch(SQLException e) {
			System.err.println("Error connecting to database:");
			e.printStackTrace();
		}
	}
	
	public String getCoursesText() {
		List<Course> courselist = getCourses();
		if(courselist == null || courselist.isEmpty())
			return "";
		StringBuilder textBuilder = new StringBuilder();
		for(Course course : courselist) {
			if(course.equals(Course.NONE))
				continue;
			textBuilder.append(course);
			textBuilder.append("\n");
		}
		return textBuilder.toString();
	}
	
	public String getSessionsText() {
		List<BasicStudySession> sessionlist = getSessions();
		if(sessionlist == null || sessionlist.isEmpty())
			return "";
		StringBuilder textBuilder = new StringBuilder();
		for(BasicStudySession session : sessionlist) {
			textBuilder.append(session);
			textBuilder.append("\n");
		}
		return textBuilder.toString();
	}
	
	private void initDatabase() {
		File file = new File("data/study.db");
		if(!file.exists()) {
			String query = "CREATE TABLE course"
					+ "(	course_id 	INTEGER PRIMARY KEY NOT NULL,"
					+ "		name 		TEXT NOT NULL,"
					+ "		start_date	INTEGER,"
					+ "		end_date	INTEGER"
					+ "); "
					+ "CREATE TABLE session"
					+ "(	session_id	INTEGER PRIMARY KEY NOT NULL,"
					+ "		course_id	INTEGER,"
					+ "		date		INTEGER NOT NULL,"
					+ "		start_time	INTEGER NOT NULL,"
					+ "		end_time	INTEGER NOT NULL,"
					+ "		FOREIGN KEY(course_id) REFERENCES course(course_id) ON DELETE SET NULL ON UPDATE CASCADE"
					+ ");";
			
			try(Connection c = DriverManager.getConnection(databaseAddress);
					Statement st = c.createStatement()) {
				st.executeUpdate(query);
			} catch(SQLException e) {
				System.err.println("Error connecting to database:");
				e.printStackTrace();
			}
		}
	}
	
	public List<Course> getCourses() {
		List<Course> courselist = new ArrayList<>();
		String query = "SELECT * FROM course;";
		try(Connection c = DriverManager.getConnection(databaseAddress);
				Statement st = c.createStatement()) {
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt("course_id");
				String name = rs.getString("name");
				LocalDate sd = LocalDate.ofEpochDay(rs.getInt("start_date"));
				LocalDate ed = LocalDate.ofEpochDay(rs.getInt("end_date"));
				courselist.add(new Course(id, name, sd, ed));
			}
		} catch(SQLException e) {
			System.err.println("Error connecting to database:");
			e.printStackTrace();
		}
		return courselist;
	}
	
	private Course getCourseById(int id) {
		String query = "SELECT * FROM course WHERE course_id == " + id + ";";
		try(Connection c = DriverManager.getConnection(databaseAddress);
				Statement st = c.createStatement()) {
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String name = rs.getString("name");
			LocalDate sd = LocalDate.ofEpochDay(rs.getInt("start_date"));
			LocalDate ed = LocalDate.ofEpochDay(rs.getInt("end_date"));
			return new Course(id, name, sd, ed);
			
		} catch(SQLException e) {
			System.err.println("Error connecting to database:");
			e.printStackTrace();
		}
		return null;
	}
	
	private List<BasicStudySession> getSessions() {
		List<BasicStudySession> sessionlist = new ArrayList<>();
		String query = "SELECT * FROM session;";
		try(Connection c = DriverManager.getConnection(databaseAddress);
				Statement st = c.createStatement()) {
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt("session_id");
				Course course = getCourseById(rs.getInt("course_id"));
				LocalDate d = LocalDate.ofEpochDay(rs.getInt("date"));
				LocalTime start = LocalTime.ofSecondOfDay(rs.getInt("start_time"));
				LocalTime end = LocalTime.ofSecondOfDay(rs.getInt("end_time"));
				sessionlist.add(new BasicStudySession(id, course, d, start, end));
			}
		} catch(SQLException e) {
			System.err.println("Error connecting to database:");
			e.printStackTrace();
		}
		return sessionlist;
	}
}
