import java.util.Hashtable;

public class Questions {
	int level;
	Question [] questionList = new Question[3];
	
	public Questions (int level) {
		loadQuestions(level);
	}
	
	void loadQuestions(int level) {
		// En el futuro aquí se hará una conexion con la base de datos
		switch (level) {
		case 1:
			this.questionList[0]= new Question(
					"¿Cuál es la capital de España?",
					"Berlín",
					"Madrid",
					"Amsterdam",
					"Roma",
					"el kulo tuyo",
					1
					);
			this.questionList[1] = new Question(
					"¿Qué es verde por fuera y blanco por dentro?",
					"Una pera",
					"Una manzana roja",
					"Un melón",
					"Tu corason",
					"el kulo tuyo",
					0
					);
			this.questionList[2] = new Question(
					"¿Cuál es la mejor carrera para estudiar?",
					"Magisterio",
					"Política",
					"FP",
					"Teleco",
					"el kulo tuyo",
					3
					);
		}
	}
}