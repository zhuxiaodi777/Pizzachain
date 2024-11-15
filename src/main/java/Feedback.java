import java.util.Date;

/**
 * Represents customer feedback for an order or service.
 */
class Feedback {
	private int rating;
	private String comments;
	private Date date;
	private String feedbackCategory;

	// Constructor
	public Feedback(int rating, String comments, String feedbackCategory) {
		this.rating = rating;
		this.comments = comments;
		this.date = new Date();
		this.feedbackCategory = feedbackCategory;
	}

	// Get feedback information
	public String getFeedbackInfo() {
		return "Rating: " + rating + ", Comments: " + comments + ", Date: " + date + ", Category: " + feedbackCategory;
	}

	// Analyze feedback based on category
	public void analyzeFeedback() {
		System.out.println("Analyzing feedback...");
		if (rating >= 4) {
			System.out.println("Positive feedback in category: " + feedbackCategory);
		} else {
			System.out.println("Negative feedback in category: " + feedbackCategory);
		}
	}

	// Check if feedback is positive
	public boolean isPositiveFeedback() {
		return rating >= 4;
	}

	// Getters
	public int getRating() {
		return rating;
	}

	public String getComments() {
		return comments;
	}

	public Date getDate() {
		return date;
	}

	public String getFeedbackCategory() {
		return feedbackCategory;
	}

	// Set feedback category
	public void setFeedbackCategory(String feedbackCategory) {
		this.feedbackCategory = feedbackCategory;
	}

	// Display feedback details
	public void displayFeedback() {
		System.out.println("Feedback Details:");
		System.out.println("Rating: " + rating);
		System.out.println("Comments: " + comments);
		System.out.println("Date: " + date);
		System.out.println("Category: " + feedbackCategory);
	}
}
