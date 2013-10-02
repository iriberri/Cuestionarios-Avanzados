import java.util.Hashtable;

public class Questions {
	int level;
	Question [] questionList = new Question[3];
	
	public Questions (int level) {
		loadQuestions(level);
	}
	
	void loadQuestions(int level) {
		// En el futuro aqu� se har� una conexion con la base de datos
		switch (level) {
		case 1:
			this.questionList[0]= new Question(
					"�Cu�l es la capital de Espa�a?",
					"Berl�n",
					"Madrid",
					"Amsterdam",
					"Roma",
					"el kulo tuyo",
					1
					);
			this.questionList[1] = new Question(
					"�Qu� es verde por fuera y blanco por dentro?",
					"Una pera",
					"Una manzana roja",
					"Un mel�n",
					"Tu corason",
					"el kulo tuyo",
					0
					);
			this.questionList[2] = new Question(
					"�Cu�l es la mejor carrera para estudiar?",
					"Magisterio",
					"Pol�tica",
					"FP",
					"Teleco",
					"el kulo tuyo",
					3
					);
		}
	}
}