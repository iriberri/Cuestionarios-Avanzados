import java.io.*;

public class IO {
	final char [] question_indices = {'a', 'b', 'c', 'd', 'e'};
	public String prompt(String prompt) {
		System.out.print(prompt + ":>");
		String input = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			input = br.readLine();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return input;
	}

	public void printArt() {
		System.out.print("********************************************************************\n");
		System.out.print("********************************************************************\n");
		System.out.print("********************************************************************\n");
		System.out.print("********************************************************************\n");
		System.out.print("*****************************************-------------------------**\n");
		System.out.print("*****************************************|CUESTIONARIOS AVANZADOS|**\n");
		System.out.print("*****************************************-------------------|v1.0|**\n");
		System.out.print("************************************************************------**\n");
		System.out.print("********************************************************************\n");
		System.out.print("\n\n");
	}
	
	public void printLogin() {
		System.out.println("Login:");
		System.out.println("1.Known User");
		System.out.println("2.New User");
		System.out.println("3.Guest");
	}
	
	public void printQuestion(Question q) {
		System.out.println("Q: " +q.question);
		for(int i=0; i<5; i++) {
			System.out.println(question_indices[i] +": " +q.answers[i]);
		}
	}
	
	public void printAdminMenu() {
		System.out.println("Admin Menu:");
		System.out.println("1.Add question");
		System.out.println("2.Remove User:");
	}
}
