import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class Employee {
	
	int employee_id;
	String first_name;
	String last_name;
	String email;
	String phone_number;
	int actual_truck_id;
	int salary;
	
	public Employee(int id , String fname, String lname, String mail, String phone, int tid, int sal){
		employee_id = id;
		first_name = fname;
		last_name = lname;
		email = mail;
		phone_number = phone;
		actual_truck_id = tid;
		salary = sal;
	}

	public Employee(){

	}

	public Employee(String fname, String lname, String mail, String phone, int id,int sal){
		first_name = fname;
		last_name = lname;
		email = mail;
		actual_truck_id = id;
		phone_number = phone;
		salary = sal;
	}
	

	public static Employee find(int id) throws SQLException {
		Connection c = DBContext.getConnection();
		PreparedStatement s = c.prepareStatement("SELECT * FROM employees WHERE employee_id = ?");
		s.setInt(1, id);
		ResultSet r = s.executeQuery();
		if (r.next() == false) return null;
		Employee employee = new Employee(r.getInt("employee_id"),r.getString("first_name"),r.getString("last_name"),
							r.getString("email"),r.getString("phone_number"),r.getInt("actual_truck_id"),r.getInt("salary"));
		r.close(); s.close();
		return employee;
	}

	public static ArrayList<Employee> findAll() throws SQLException{
		Connection c = DBContext.getConnection();
		ArrayList<Employee> collec = new ArrayList<>();
		PreparedStatement s = c.prepareStatement("SELECT * FROM employees");
		ResultSet r = s.executeQuery();
		if (r.next() == false) return null;
		Employee employee = new Employee();
		employee = employee.find(r.getInt("employee_id"));
		collec.add(employee);
		while (r.next()){
			employee = new Employee(r.getInt("employee_id"),r.getString("first_name"),r.getString("last_name"),
					r.getString("email"),r.getString("phone_number"),r.getInt("actual_truck_id"),r.getInt("salary"));
			collec.add(employee);
		}


		r.close(); s.close();
		return collec;

	}

	void insert() throws SQLException {
		Connection c = DBContext.getConnection();
		PreparedStatement s;
		if(actual_truck_id == 0){
			s = c.prepareStatement("INSERT INTO employees" +
					"(first_name, last_name, email ,phone_number, salary)"+
					"VALUES (?, ?, ?, ?, ?)");
			s.setString(1, first_name);
			s.setString(2, last_name);
			s.setString(3, email);
			s.setString(4, phone_number);
			s.setInt(5, salary);
		}else{
			System.out.print("toto");
			s = c.prepareStatement("INSERT INTO employees" +
					"(first_name, last_name, email ,phone_number,actual_truck_id , salary)"+
					"VALUES (?, ?, ?, ?, ?, ?)");
			s.setString(1, first_name);
			s.setString(2, last_name);
			s.setString(3, email);
			s.setString(4, phone_number);
			s.setInt(5, actual_truck_id);
			s.setInt(6, salary);
		}

		System.out.print(s.toString());
		s.executeUpdate();
	}
	
	void update() throws SQLException{
		PreparedStatement s;
		Connection c = DBContext.getConnection();
		if(actual_truck_id == 0){
			s = c.prepareStatement("UPDATE employees SET "+
					"first_name = ?, last_name = ?, email = ? ,actual_truck_id = NULL, phone_number = ?  , salary = ? "+
					"WHERE employee_id = ?");
			s.setInt(6, employee_id);
			s.setString(1, first_name);
			s.setString(2, last_name);
			s.setString(3, email);
			s.setString(4, phone_number);
			s.setInt(5, salary);
		}else{
			s = c.prepareStatement("UPDATE employees SET "+
					"first_name = ?, last_name = ?, email = ? , phone_number = ? ,actual_truck_id = ? , salary = ? "+
					"WHERE employee_id = ?");
			s.setInt(7, employee_id);
			s.setString(1, first_name);
			s.setString(2, last_name);
			s.setString(3, email);
			s.setString(4, phone_number);
			s.setInt(5, actual_truck_id);
			s.setInt(6, salary);
		}
		try {
			s.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}

		
	}
	
	void delete() throws SQLException{
		Connection c = DBContext.getConnection();
		PreparedStatement s = c.prepareStatement("DELETE FROM employees WHERE employee_id = ?");
		s.setInt(1, employee_id);
		s.executeUpdate();
		
	}
	
	
	
}
	



