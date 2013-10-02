
import java.io.*;

public class App {
	public static void main (String [] args) {
		IO io = new IO();
		Database db = new Database();
		db.connect();

		io.printArt();
		io.printLogin();
		String option = io.prompt("Option");
		switch(Integer.parseInt(option)) {
		case 1:
			int auth = 0;
			while (auth == 0) {
				String email 		= io.prompt("email");
				String pass 		= io.prompt("pass");
				User user 			= db.loadUser(email, pass);
				if(user != null) {
					auth 			= 1;
					if(user.equals("admin")) {
						io.printAdminMenu();
						int opt = Integer.parseInt(io.prompt("option"));
						switch(opt) {
						case 1:
							int difficulty 	= Integer.parseInt(io.prompt("difficulty"));
							String question = io.prompt("question");
							String a1 		= io.prompt("answer 1");
							String a2 		= io.prompt("answer 2");
							String a3 		= io.prompt("answer 3");
							String a4 		= io.prompt("answer 4");
							String a5 		= io.prompt("answer 5");
							int correct 	= Integer.parseInt(io.prompt("correct answer"));
							
							db.addQuestion(difficulty, question, a1, a2, a3, a4, a5, correct);
							
						}
					}
					start("KNOWN_USER", user);
				}
				else {
					System.out.println("Wrong user/pass. Try again.");
				}
			}
			break;
		case 2:
			String email 		= io.prompt("email");
			String pass 		= io.prompt("pass");
			db.addUser(email, pass);
			break;
		case 3:
			start("GUEST", null);
			break;
		}
	}

	public static void start(String MODE, User user) {
		if(MODE.equals("GUEST")) {
			int level = Integer.parseInt(new IO().prompt("Level (1-3)"));

			Questions qs = new Questions(level);

			int RUN = 1;
			int index = 0;
			while(RUN == 1) {
				new IO().printQuestion(qs.questionList[index]);
				String response = new IO().prompt("answer");

				if(qs.questionList[index].correct == Integer.parseInt(response)) {
					index++;
				}
			}

		}
		else if (MODE.equals("KNOWN_USER")) {
			Questions qs = new Questions(user.getStat().getLevel());

			int RUN = 1;
			int index = 0;
			while(RUN == 1) {
				new IO().printQuestion(qs.questionList[index]);
				String response = new IO().prompt("answer");

				if(qs.questionList[index].correct == Integer.parseInt(response)) {
					index++;
				}
			}
		}
	}


}
