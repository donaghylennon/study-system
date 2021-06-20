package studySystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudySystem {
	List<BasicStudySession> sessions;
	
	public StudySystem() {
		sessions = new ArrayList<>();
		readFromFile();
	}
	
	public void addSession(int dateY, int dateM, int dateD, int startTimeH, int startTimeM, int endTimeH, int endTimeM) {
		sessions.add(new BasicStudySession(
				LocalDate.of(dateY, dateM, dateD), 
				LocalTime.of(startTimeH, startTimeM), 
				LocalTime.of(endTimeH, endTimeM)));
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
	
	public String toCsv() {
		if(this.sessions == null || this.sessions.isEmpty())
			return "";
		StringBuilder result = new StringBuilder();
		for(BasicStudySession session : sessions) {
			result.append(session.toCsv());
			result.append("\n");
		}
		return result.toString();
	}
	
	public void saveToFile() {
		FileWriter fw;
		try {
			fw = new FileWriter("data/data.csv");
			fw.write(toCsv());
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
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				sessions.add(BasicStudySession.fromCsv(line));
			}
		} catch (FileNotFoundException e) {
			System.err.println("Couldn't read from file: ");
			e.printStackTrace();
		} finally {
			if(sc != null)
				sc.close();
		}
	}
}
