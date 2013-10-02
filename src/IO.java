import java.io.*;

public class IO {
	public String propmpt(String prompt) {
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
		System.out.println("2.Guest");
	}
	
	public void printQuestion(Question q) {
		System.out.println("Q: " +q.question);
		for(int i=0; i<5; i++) {
			System.out.println(i +": " +q.answers[i]);
		}
	}
}
