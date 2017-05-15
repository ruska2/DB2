

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Calendar;
import java.util.ArrayList;

public class Transactions {

    static void truckchange(int id1, int id2) throws SQLException{
        Connection c = DBContext.getConnection();
        c.setAutoCommit(false);
        try {
            Employee one = new Employee();
            one = one.find(id1);
            if(one.actual_truck_id == 0) throw new Exception();

            Employee two = new Employee();
            two = two.find(id2);
            if(two.actual_truck_id == 0) throw new Exception();

            int save1 = one.actual_truck_id;
            int save2 = two.actual_truck_id;

            one.actual_truck_id = 0;
            two.actual_truck_id = 0;


            one.update();
            two.update();
            System.out.print("ok");

            one.actual_truck_id = save2;
            two.actual_truck_id = save1;

            one.update();
            two.update();
            c.commit();

        }catch (Exception e){
            if (c != null){
                try {
                    c.rollback();
                    System.out.println("ROLLBACKED TRANSACTION");
                }catch (Exception f){
                    f.printStackTrace();
                }
            }else{
                System.out.print("WRONG CONNECTION");
            }
        }
    }

    static  void salaryes_by_fuel() throws SQLException{
        ArrayList<Employee> list;
        list = Employee.findAll();
        for(Employee e: list){
            salary_by_fuel(e.employee_id);
        }
    }

    static void salary_by_fuel(int id) throws  SQLException{
        Connection c = DBContext.getConnection();
        CrudController cd = new CrudController();
        try{
            c.setAutoCommit(false);

            double percent = cd.getpercent(id);
            Employee e = new Employee();
            e = e.find(id);

            if (percent < 1.5){
                e.salary = (int) (e.salary * 0.90);
                e.update();
                boolean q = cd.getamount(id);
                if(q == true){
                    throw new Exception();
                }
            }
            else {
                e.salary = (int) (e.salary * 1.10);
                e.update();
            }


            java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

            Job j = new Job();
            j = j.find(id);
            if (j.last_salary_update.getMonth() == date.getMonth()){
                c.rollback();
                System.out.println("ROLLBACKED TRANSACTION");

            }
            j.last_salary_update = date;
            j.update();

            c.commit();
        }catch (Exception e){
            if (c != null){
                try {
                    c.rollback();
                    System.out.println("ROLLBACKED TRANSACTION");
                }catch (Exception f){
                    f.printStackTrace();
                }
            }else{
                System.out.print("WRONG CONNECTION");
            }
        }
    }
}
