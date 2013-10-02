import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Database {
	String url  	= "jdbc:mysql://localhost:3306/cuestionarios_avanzados";
	String user 	= "ca_app";
	String password = "software2013";

	public void addUser (String email, String pass) {
		Connection conn 			= null;
		PreparedStatement pstate 	= null;
		Statement state 			= null;
		ResultSet rs 				= null;

		try {
			conn 					= DriverManager.getConnection(url, user, password);
			
			state 					= conn.createStatement();
			rs 						= state.executeQuery("SELECT * FROM users WHERE email='" +email +"'");
			if(!rs.next()) {
				pstate 					= conn.prepareStatement("INSERT INTO users VALUES (?,?)");
				pstate.setString	(1, email);
				pstate.setString	(2, pass);
				pstate.executeUpdate();
				
				pstate 					= conn.prepareStatement("INSERT INTO statistics VALUES (?,?,?,?)");
				pstate.setString	(1, email);
				pstate.setInt		(2, 0);
				pstate.setInt		(3, 0);
				pstate.setInt		(4, 0);
				pstate.executeUpdate();
			}else {
				System.out.println("User already exists.");
			}

		} catch (SQLException sqle) {
			Logger log 	= Logger.getLogger(Database.class.getName());
			log.log(Level.SEVERE, sqle.getMessage(), sqle);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstate != null) {
					pstate.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException sqle) {
				Logger lgr = Logger.getLogger(Database.class.getName());
				lgr.log(Level.WARNING, sqle.getMessage(), sqle);
			}
		}
	}

	public User loadUser (String email, String pass) {
		Connection conn 			= null;
		Statement state 			= null;
		ResultSet rs 				= null;

		try {
			conn 					= DriverManager.getConnection(url, user, password);

			state 					= conn.createStatement();
			rs 						= state.executeQuery("SELECT * FROM users WHERE email = '" +email +"' AND pass ='" +pass +"'");
			if(rs.next()) {
				System.out.println("User Authed");
				
				state 					= conn.createStatement();
				rs 						= state.executeQuery("SELECT * FROM statistics WHERE email = '" +email +"'");
				rs.next();
				int correct 			= rs.getInt(2);
				int incorrect 			= rs.getInt(3);
				int level 				= rs.getInt(4);
				
				User usr 			= new User(email, pass, new Statistic(correct, incorrect, level));
				
				return usr;
			}else {
				
			}
			

		} catch (SQLException sqle) {
			Logger log 	= Logger.getLogger(Database.class.getName());
			log.log(Level.SEVERE, sqle.getMessage(), sqle);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (state != null) {
					state.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException sqle) {
				Logger lgr = Logger.getLogger(Database.class.getName());
				lgr.log(Level.WARNING, sqle.getMessage(), sqle);
			}
		}

		return null;
	}

	public void connect () {
		Connection conn = null;
		Statement state = null;
		ResultSet rs 	= null;



		try {
			conn 		= DriverManager.getConnection(this.url, this.user, this.password);
			state 		= conn.createStatement();
			rs 			= state.executeQuery("SELECT VERSION()");

			if(rs.next()) {
				System.out.println(rs.getString(1));
			}

		} catch (SQLException sqle) {
			Logger log 	= Logger.getLogger(Database.class.getName());
			log.log(Level.SEVERE, sqle.getMessage(), sqle);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (state != null) {
					state.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException sqle) {
				Logger lgr = Logger.getLogger(Database.class.getName());
				lgr.log(Level.WARNING, sqle.getMessage(), sqle);
			}
		}
	}
	
	public void addQuestion (int difficulty, String question, String a1, String a2, String a3, String a4, String a5, int correct) {
		Connection conn 			= null;
		PreparedStatement pstate 	= null;
		Statement state 			= null;
		ResultSet rs 				= null;

		try {
			conn 					= DriverManager.getConnection(url, user, password);
			
			state 					= conn.createStatement();
			rs 						= state.executeQuery("SELECT * FROM questions WHERE question='" +question +"'");
			if(!rs.next()) {
				pstate 					= conn.prepareStatement("INSERT INTO questions VALUES (?,?,?,?,?,?,?,?,)");
				pstate.setInt 		(1, difficulty);
				pstate.setString	(2, question);
				pstate.setString	(3, a1);
				pstate.setString	(4, a2);
				pstate.setString	(5, a3);
				pstate.setString	(6, a4);
				pstate.setString	(7, a5);
				pstate.setInt		(8, correct);
				pstate.executeUpdate();
			}else {
				System.out.println("Question already exists.");
			}

		} catch (SQLException sqle) {
			Logger log 	= Logger.getLogger(Database.class.getName());
			log.log(Level.SEVERE, sqle.getMessage(), sqle);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstate != null) {
					pstate.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException sqle) {
				Logger lgr = Logger.getLogger(Database.class.getName());
				lgr.log(Level.WARNING, sqle.getMessage(), sqle);
			}
		}
	}
}