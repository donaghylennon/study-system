package studySystem;

import java.util.List;

public class PastPaperDetails extends StudyDetails {
	private int numQuestions;
	private int gradePercentage;
	private int paperPercentage;
	private List<Integer> confidenceInAnswers;
	
	public PastPaperDetails(int numQuestions, int gradePercentage, int paperPercentage,
			List<Integer> confidenceInAnswers) {
		this.numQuestions = numQuestions;
		this.gradePercentage = gradePercentage;
		this.paperPercentage = paperPercentage;
		this.confidenceInAnswers = confidenceInAnswers;
	}
}
