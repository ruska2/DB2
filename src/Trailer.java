import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Trailer {
	
	int trailer_id;
	int truck_id;
	int trailer_type;
	String trailer_stat;
	Date last_repair;
	
	public Trailer(int trid , int tid,int typ,  String stat, Date lr){
		truck_id = tid;
		trailer_id = trid;
		trailer_type = typ;
		trailer_stat = stat;
		last_repair = lr;
		
	}

	public Trailer(){

	}

	public Trailer(int typ,  String stat){
		trailer_type = typ;
		trailer_stat = stat;
	}
	

	static Trailer find(int id) throws SQLException {
		Connection c = DBContext.getConnection();
		PreparedStatement s = c.prepareStatement("SELECT * FROM trailers WHERE trailer_id = ?");
		s.setInt(1, id);
		ResultSet r = s.executeQuery();
		if (r.next() == false) return null;
		Trailer trailer = new Trailer(r.getInt("trailer_id"),r.getInt("truck_id"),
							r.getInt("trailer_type"),r.getString("trailer_stat"),r.getDate("last_repair"));
		r.close(); s.close();
		return trailer;
	}
	
	void insert() throws SQLException {
		Connection c = DBContext.getConnection();
		if(truck_id == 0){
			PreparedStatement s = c.prepareStatement("INSERT INTO trailers" +
					"(trailer_type,trailer_stat)"+
					"VALUES (?,?)");
			s.setInt(1, trailer_type);
			s.setString(2,trailer_stat);
			s.executeUpdate();
		}else {
			PreparedStatement s = c.prepareStatement("INSERT INTO trailers" +
					"(trailer_type,trailer_stat,truck_id)"+
					"VALUES (?,?, ?)");
			s.setInt(1, trailer_type);
			s.setString(2,trailer_stat);
			s.setInt(3,truck_id);
			s.executeUpdate();
		}

	}
	
	void update() throws SQLException{
		Connection c = DBContext.getConnection();
		PreparedStatement s;
		if(truck_id == 0){
			s = c.prepareStatement("UPDATE trailers SET "+
					"truck_id = NULL , trailer_type = ?, trailer_stat = ? ,  last_repair= CURRENT_DATE "+
					"WHERE trailer_id = ?");
			s.setInt(3, trailer_id);
			s.setInt(1, trailer_type);
			s.setString(2,trailer_stat);
		}else {
			s = c.prepareStatement("UPDATE trailers SET "+
					"truck_id = ? ,trailer_type = ?, trailer_stat = ? ,  last_repair= CURRENT_DATE "+
					"WHERE trailer_id = ?");
			s.setInt(1, truck_id);
			s.setInt(4, trailer_id);
			s.setInt(2, trailer_type);
			s.setString(3,trailer_stat);
		}

		s.executeUpdate();
		
	}
	
	void delete() throws SQLException{
		Connection c = DBContext.getConnection();
		PreparedStatement s = c.prepareStatement("DELETE FROM trailers WHERE trailer_id = ?");
		s.setInt(1, trailer_id);
		s.executeUpdate();
		
	}
	
	
	
}
	



