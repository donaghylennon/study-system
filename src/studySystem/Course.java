package studySystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Course {
	private int id;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	
	private static DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static Course NONE = new Course("None", LocalDate.EPOCH, LocalDate.EPOCH);
	
	public Course(String name, LocalDate startDate, LocalDate endDate) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Course(int id, String name, LocalDate startDate, LocalDate endDate) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String toCsv() {
		if(this.equals(NONE))
			return "";
		if(startDate == null || endDate == null) {
			return name + ",None,None";
		}
		return name + "," + startDate.format(dateFmt) + "," + endDate.format(dateFmt) + "\n";
	}
	
	public static Course fromCsv(String csv) {
		String[] values = csv.split(",");
		String name = values[0];
		LocalDate sd = LocalDate.parse(values[1], dateFmt);
		LocalDate ed = LocalDate.parse(values[2], dateFmt);
		Course result = new Course(name, sd, ed);
		if(result.equals(Course.NONE))
			return Course.NONE;
		return result;
	}
	
//	public static Course fromId(int id) {
//		String query = "SELECT * FROM course WHERE course_id == " + id + ";";
//		try(Connection c = DriverManager.getConnection("jdbc:sqlite:data/study.db");
//				Statement st = c.createStatement()) {
//			ResultSet rs = st.executeQuery(query);
//			rs.next();
//			String name = rs.getString("name");
//			LocalDate sd = LocalDate.ofEpochDay(rs.getInt("start_date"));
//			LocalDate ed = LocalDate.ofEpochDay(rs.getInt("end_date"));
//			return new Course(id, name, sd, ed);
//		} catch(SQLException e) {
//			System.err.println("Error connecting to database:");
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
}
