import java.io.*;

public class App {
	public static void main (String [] args) {
		IO stdio = new IO();

		stdio.printArt();
		stdio.printLogin();
		String option = stdio.propmpt("Option");
		switch(Integer.parseInt(option)) {
		case 1:
			// Aqui se har‡ el login con la base de datos.
			break;
		case 2:
			start("GUEST");

		}
	}

	public static void start(String MODE) {
		if(MODE.equals("GUEST")) {
			int level = Integer.parseInt(new IO().propmpt("Level (1-3)"));
			
			System.out.println(level);

			Questions qs = new Questions(level);

			int RUN = 1;
			int index = 0;
			while(RUN == 1) {
				new IO().printQuestion(qs.questionList[index]);
				String response = new IO().propmpt("answer");
				
				if(qs.questionList[index].correct == Integer.parseInt(response)) {
					index++;
				}
			}

		}
	}


}
