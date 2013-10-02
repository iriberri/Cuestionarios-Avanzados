public class User {
	int id;
	String email;
	String password;
	boolean su;
	Statistic stat;
	
	public User (String email, String password) {
		setEmail(email);
		setPassword(password);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSu() {
		return su;
	}

	public void setSu(boolean su) {
		this.su = su;
	}

	public Statistic getStat() {
		return stat;
	}

	public void setStat(Statistic stat) {
		this.stat = stat;
	}
	
	
}
