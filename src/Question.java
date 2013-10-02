
public class Question {
	String question;
	String [] answers = new String[5];
	int correct;
	
	public Question (String question, String a0, String a1, String a2, String a3, String a4, int correct) {
		this.question 	= question;
		this.answers[0] = a0;
		this.answers[1] = a1;
		this.answers[2] = a2;
		this.answers[3] = a3;
		this.answers[4] = a4;
		this.correct 	= correct;
	}
}
