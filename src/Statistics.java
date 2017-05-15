import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Statistics {

    //kolko kilometrov presli odkedy pracuju a kolkokrat sa im pokazil motor
    static String s1 = "SELECT e.last_name,e.first_name,sum(distance) as DISTANCE ,t.employee_id ,(SELECT count(employee_id) from truck_repair_history as q \n" +
            "\n" +
            "            where faults_type = 'ENGINE' and q.employee_id = r.employee_id\n" +
            "             GROUP BY employee_id) as ENGINE_FAULT\n" +
            "            from routes as r\n" +
            "            join truck_repair_history as t on r.employee_id = t. employee_id\n" +
            "            join employees as e on e.employee_id = r.employee_id\n" +
            "            WHERE r.employee_id = t. employee_id and t.faults_type = 'ENGINE'\n" +
            "            GROUP BY r.employee_id,t.employee_id,e.employee_id\n" +
            "            ORDER by sum(distance) DESC";

    //kolko kamienov a trailer pouzil dany zamestnanec kolkokrat pouzil trailer kaimon a kamion trailer
    static String s2 = "SELECT employee_id,trailer_id,truck_id,count(DISTINCT trailer_id) as trailer_count , count(DISTINCT truck_id) as truck_count,\n" +
            " GROUPING(employee_id) as g_e,\n" +
            " GROUPING (truck_id) as g_truck,\n" +
            " GROUPING (trailer_id) as g_trailer\n" +
            "            FROM routes\n" +
            "            GROUP BY GROUPING SETS(employee_id,truck_id,trailer_id)";

    //vypis najlepsich zamestnancov podla distance/fuel
    static String s3 = "WITH \n" +
            "\tfirst as (SELECT employee_id,sum(distance) as distance , sum(fuel) as fuel from routes\n" +
            "\tGROUP BY EMPLOYEE_ID\n" +
            "\tORDER BY fuel),\n" +
            "\n" +
            "\tsecond as (SELECT e.employee_id,e.last_name,e.first_name,e.email,e.actual_truck_id,distance,fuel from first join employees as e on e.employee_id = first.employee_id),\n" +
            "\t\n" +
            "\tthird as (SELECT employee_id, CAST(sum(distance)as float) / CAST(sum(fuel) as float) AS percent from routes GROUP BY employee_id)\n" +
            "SELECT * from second\n" +
            "join third as t on second.employee_id = t.employee_id ORDER BY percent DESC";

    public static ResultSet first (String sql) throws  SQLException{
        Connection c = DBContext.getConnection();
        PreparedStatement s = c.prepareStatement(sql);
        ResultSet r = s.executeQuery();
        ResultSetMetaData rmd = r.getMetaData();

       /* int numberOfColumns = rmd.getColumnCount();

        for (int i = 1; i <= numberOfColumns; i++) {
            if (i > 1) System.out.print(",  ");
            String columnName = rmd.getColumnName(i);
            System.out.print(columnName);
        }

        System.out.println("");

        while (r.next()) {
            for (int i = 1; i <= numberOfColumns; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = r.getString(i);
                System.out.print(columnValue);
            }
            System.out.println("");
        }*/
        return r;
    }

}
