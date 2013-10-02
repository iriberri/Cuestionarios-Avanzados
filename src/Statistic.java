public class Statistic {
	private int correct;
	int incorrect;
	int level;
	int correctMean;
	int incorrectMean;
	
	public Statistic () {
		setCorrect(0);
		setIncorrect(0);
		setLevel(0);
	}
	
	public Statistic (int correct, int incorrect, int level) {
		setCorrect(0);
		setIncorrect(0);
		setLevel(0);
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}
	
	public int getIncorrect() {
		return incorrect;
	}

	public void setIncorrect(int incorrect) {
		this.incorrect = incorrect;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCorrectMean() {
		return correctMean;
	}

	public void setCorrectMean(int correctMean) {
		this.correctMean = correctMean;
	}

	public int getIncorrectMean() {
		return incorrectMean;
	}

	public void setIncorrectMean(int incorrectMean) {
		this.incorrectMean = incorrectMean;
	}

}
