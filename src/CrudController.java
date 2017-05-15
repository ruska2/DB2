import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CrudController {

    public static void employee_delete(int id){
        try{
            Job j = new Job();
            j = j.find(id);


            Employee f = new Employee();
            f = f.find(id);

            System.out.println(f.employee_id);

            Truck t = new Truck();
            t = t.find(f.actual_truck_id);
            t.employee_id = 0;
            f.actual_truck_id = 0;
            f.update();
            t.update();

            j.delete();
            f.delete();
        }catch (Exception x){
            x.printStackTrace();
        }
    }

    public static void  truck_update_test(){
        try{
            Truck t = new Truck();
            t = t.find(302);
            System.out.print(t.truck_type);
            t.employee_id = 155;
            t.trailer_id = 5;
            System.out.print(t.truck_type);
            t.update();


            Employee e = new Employee();
            e = e.find(t.employee_id);
            if(t.employee_id != 0){
                e.actual_truck_id = 302;
            }else{
                e.actual_truck_id = 0;
            }
            e.update();

            Trailer tr = new Trailer();
            tr = tr.find(t.trailer_id);
            if(t.trailer_id != 0){
                tr.truck_id = 302;
            }else{
                tr.truck_id = 0;
            }
            tr.update();
        }catch (Exception x){
            x.printStackTrace();
        }
    }


    public static void truck_delete(int id){
        try{
            Truck t = new Truck();
            t = t.find(id);

            Trailer f = new Trailer();
            f = f.find(t.trailer_id);

            if(f.truck_id != 0){
                f.truck_id = 0;
            }
            f.update();
            t.trailer_id = 0;


            Employee e = new Employee();
            e = e.find(t.employee_id);
            if(e.actual_truck_id != 0){
                e.actual_truck_id = 0;
            }
            e.update();
            t.employee_id = 0;
            t.update();
            t.delete();

        }catch (Exception x){
            x.printStackTrace();
        }
    }

    public static void trailer_delete(int id){
        try{
            Trailer t = new Trailer();
            t = t.find(id);

            Truck f = new Truck();
            f = f.find(t.truck_id);

            if(f.trailer_id != 0){
                f.trailer_id = 0;
                f.update();
            }
            t.update();
            t.delete();

        }catch (Exception x){
            x.printStackTrace();
        }
    }

    public static void add_route(int truck_id,int trailer_id,int employee_id, int fuel, int distance) throws SQLException {
        Connection c = DBContext.getConnection();
        PreparedStatement s;
        s = c.prepareStatement("INSERT INTO routes" +
                "(truck_id,trailer_id,employee_id,fuel,distance,date)"+
                "VALUES (?, ?, ?, ?, ?, current_date)");
        s.setInt(1, truck_id);
        s.setInt(2, trailer_id);
        s.setInt(3, employee_id);
        s.setInt(4, fuel);
        s.setInt(5, distance);
        s.executeUpdate();

    }

    public static void add_truck_repair(int truck_id,int employee_id, String faults_type, int repair_cost) throws SQLException {
        Connection c = DBContext.getConnection();
        PreparedStatement s;
        s = c.prepareStatement("INSERT INTO truck_repair_history" +
                "(truck_id,employee_id,faults_type,faults_date,repair_cost)"+
                "VALUES (?, ?, ?, current_date,?)");
        s.setInt(1, truck_id);
        s.setInt(2, employee_id);
        s.setString(3, faults_type);
        s.setInt(4, repair_cost);
        s.executeUpdate();

    }

    public static void add_trailer_repair(int trailer_id,int employee_id, String faults_type, int repair_cost) throws SQLException {
        Connection c = DBContext.getConnection();
        PreparedStatement s;
        s = c.prepareStatement("INSERT INTO trailer_repair_history" +
                "(trailer_id,employee_id,faults_type,faults_date,repair_cost)"+
                "VALUES (?, ?, ?, current_date, ?)");
        s.setInt(1, trailer_id);
        s.setInt(2, employee_id);
        s.setString(3, faults_type);
        s.setInt(4, repair_cost);
        s.executeUpdate();

    }

    public static void finalize_truck_repair(int idr) throws SQLException{
        Connection c = DBContext.getConnection();
        PreparedStatement s;
        s = c.prepareStatement("UPDATE truck_repair_history SET "+
                "repair_date = CURRENT_DATE"+
                " WHERE id = ?");
        s.setInt(1, idr);
        System.out.print(s.toString());
        s.executeUpdate();
    }

    public static void finalize_trailer_repair(int id ) throws SQLException{
        Connection c = DBContext.getConnection();
        PreparedStatement s;
        s = c.prepareStatement("UPDATE trailer_repair_history SET "+
                "repair_date = CURRENT_DATE"+
                " WHERE id = ?");
        s.setInt(1, id);
        s.executeUpdate();
    }

    public static double getpercent(int id) throws SQLException{
        Connection c = DBContext.getConnection();
        PreparedStatement s = c.prepareStatement("SELECT CAST(sum(distance)as float) / CAST(sum(fuel) as float) AS percent from routes where employee_id = ? and "+
                "extract('month' from date) = extract('month' from current_date) and extract('year' from date) = extract('year' from current_date)");
        s.setInt(1, id);
        ResultSet r = s.executeQuery();
        r.next();
        double percent = r.getDouble("percent");
        r.close(); s.close();
        return percent;
    }

    public static boolean getamount(int id) throws SQLException{
        Connection c = DBContext.getConnection();
        PreparedStatement s;
        s = c.prepareStatement("SELECT extract ('year' from current_date) - extract('year' from start_date) > 10 as hod FROM job WHERE employee_id = ?" );
        s.setInt(1,id);
        ResultSet r = s.executeQuery();
        r.next();
        boolean q = r.getBoolean(1);
        r.close(); s.close();
        return q;
    }

}
