package studySystem;

public class FlashcardReviewDetails extends StudyDetails {
	private int numFlashcards;
	private int numSuccessful;
	private int numFailed;
	
	public FlashcardReviewDetails(int numFlashcards, int numSuccessful, int numFailed) {
		this.numFlashcards = numFlashcards;
		this.numSuccessful = numSuccessful;
		this.numFailed = numFailed;
	}
}
