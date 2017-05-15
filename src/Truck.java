import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Truck {
	
	int truck_id;
	int employee_id;
	int trailer_id;
	int truck_type;
	int age;
	String truck_stat;
	Date last_repair;
	
	public Truck(int tid , int eid, int trid,int typ, int ag, String stat, Date lr){
		employee_id = eid;
		truck_id = tid;
		trailer_id = trid;
		truck_type = typ;
		age = ag;
		truck_stat = stat;
		last_repair = lr;
		
	}

	public Truck(){

	}

	public Truck(int typ, int ag, String stat){
		truck_type = typ;
		age = ag;
		truck_stat = stat;
	}
	

	public Truck find(int id) throws SQLException {
		Connection c = DBContext.getConnection();
		PreparedStatement s = c.prepareStatement("SELECT * FROM trucks WHERE truck_id = ?");
		s.setInt(1, id);
		ResultSet r = s.executeQuery();
		if (r.next() == false) return null;
		Truck truck = new Truck(r.getInt("truck_id"),r.getInt("employee_id"),r.getInt("trailer_id"),
							r.getInt("truck_type"),r.getInt("age"),r.getString("truck_stat"),r.getDate("last_repair"));
		r.close(); s.close();
		return truck;
	}
	
	void insert() throws SQLException {
		Connection c = DBContext.getConnection();
		PreparedStatement s = c.prepareStatement("INSERT INTO trucks" +
						"(truck_type, age,truck_stat)"+
						"VALUES (?, ?, ?)");

		s.setInt(1,  truck_type);
		s.setInt(2, age);
		s.setString(3, truck_stat);
		s.executeUpdate();
	}
	
	void update() throws SQLException{
		Connection c = DBContext.getConnection();
		PreparedStatement s;
		if(employee_id == 0 && trailer_id == 0){
			s = c.prepareStatement("UPDATE trucks SET " +
					"employee_id = NULL, trailer_id = NULL,truck_type = ?, age = ? ,truck_stat = ? ,  last_repair= ? " +
					"WHERE truck_id = ?");
			s.setInt(5, truck_id);
			s.setInt(1, truck_type);
			s.setInt(2, age);
			s.setString(3, truck_stat);
			s.setDate(4, last_repair);
			s.executeUpdate();

		}
		else if(trailer_id == 0 && employee_id != 0){
			System.out.print("totot");
				s = c.prepareStatement("UPDATE trucks SET " +
						"employee_id = ?, trailer_id = NULL ,truck_type = ?, age = ? ,truck_stat = ? ,  last_repair= ? " +
						"WHERE truck_id = ?");
				s.setInt(6, truck_id);
				s.setInt(1, employee_id);
				s.setInt(2, truck_type);
				s.setInt(3, age);
				s.setString(4, truck_stat);
				s.setDate(5, last_repair);
				s.executeUpdate();
		}
		else if(employee_id == 0 && trailer_id != 0){
				s = c.prepareStatement("UPDATE trucks SET " +
						"employee_id = NULL, trailer_id = ? ,truck_type = ?, age = ? ,truck_stat = ? ,  last_repair= ? " +
						"WHERE truck_id = ?");
				s.setInt(6, truck_id);
				s.setInt(1, trailer_id);
				s.setInt(2, truck_type);
				s.setInt(3, age);
				s.setString(4, truck_stat);
				s.setDate(5, last_repair);
				s.executeUpdate();
		}else {
			s = c.prepareStatement("UPDATE trucks SET " +
					"employee_id = ?, trailer_id = ? ,truck_type = ?, age = ? ,truck_stat = ? ,  last_repair= ? " +
					"WHERE truck_id = ?");
			s.setInt(7, truck_id);
			s.setInt(1,employee_id);
			s.setInt(2, trailer_id);
			s.setInt(3, truck_type);
			s.setInt(4, age);
			s.setString(5, truck_stat);
			s.setDate(6, last_repair);
			s.executeUpdate();
		}



		
	}
	
	void delete() throws SQLException{
		Connection c = DBContext.getConnection();
		PreparedStatement s = c.prepareStatement("DELETE FROM trucks WHERE truck_id = ?");
		s.setInt(1, truck_id);
		s.executeUpdate();
		
	}
	
	
	
}
	



