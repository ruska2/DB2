import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Job {
	
	int employee_id;
	Date start_date;
	int best_salary;
	Date last_salary_update;
	
	public Job(int id , Date start, int bs, Date salup){
		employee_id = id;
		start_date = start;
		best_salary = bs;
		last_salary_update = salup;
	}

	public Job(){

	}

	public Job(int s){
		best_salary = s;
	}
	

	public Job find(int id) throws SQLException {
		Connection c = DBContext.getConnection();
		PreparedStatement s = c.prepareStatement("SELECT * FROM job WHERE employee_id = ?");
		s.setInt(1, id);
		ResultSet r = s.executeQuery();
		if (r.next() == false) return null;
		Job EmployeeJob = new Job(r.getInt("employee_id"),r.getDate("start_date"),r.getInt("best_salary"),
							r.getDate("last_salary_update"));
		r.close(); s.close();
		return EmployeeJob;
	}
	
	void insert() throws SQLException {
		Connection c = DBContext.getConnection();
		PreparedStatement s = c.prepareStatement("INSERT INTO job" +
						"(start_date, best_salary, last_salary_update)"+
						"VALUES (CURRENT_DATE, ?, CURRENT_DATE)");
		s.setInt(1, best_salary);
		s.executeUpdate();
	}
	
	void update() throws SQLException{
		Connection c = DBContext.getConnection();
		PreparedStatement s = c.prepareStatement("UPDATE job SET "+
						"best_salary = ?, last_salary_update = ? "+
						"WHERE employee_id = ?");
		s.setInt(3, employee_id);
		s.setInt(1, best_salary);
		s.setDate(2, last_salary_update);
		s.executeUpdate();
		
	}
	
	void delete() throws SQLException{
		Connection c = DBContext.getConnection();
		PreparedStatement s = c.prepareStatement("DELETE FROM job WHERE employee_id = ?");
		s.setInt(1, employee_id);
		s.executeUpdate();
		
	}
	
	
	
}
	



