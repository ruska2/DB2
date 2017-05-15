import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CrudView {

    static int last_truckid = 0;
    int last_trailerid = 0;
    int last_employeeid = 0;

    public CrudView(){



        CrudController cd = new CrudController();
        Stage Stage = new Stage();
        Pane pane = new Pane();
        Stage.setTitle("DB_Project_Transactions");
        Stage.setScene(new Scene(pane,800,600));
        Stage.show();


        Rectangle back = new Rectangle(0,0,800,600);
        back.setStrokeWidth(5);
        back.setStroke(Color.BLACK);
        back.setFill(Color.CADETBLUE);
        pane.getChildren().add(back);


        //delete
        TextField t1 = new TextField();
        t1.setMaxWidth(30);
        t1.setLayoutX(150);
        t1.setLayoutY(30);

        pane.getChildren().add(t1);

        Text l1 = new Text("truck id :");
        l1.setLayoutX(80);
        l1.setLayoutY(50);
        pane.getChildren().add(l1);

        Button rtr = new Button();
        rtr.setText("Remove Truck");
        rtr.setLayoutY(35);
        rtr.setLayoutX(200);
        pane.getChildren().add(rtr);

        TextField t2 = new TextField();
        t2.setMaxWidth(30);
        t2.setLayoutX(150);
        t2.setLayoutY(90);

        pane.getChildren().add(t2);

        Text l2 = new Text("trailer id :");
        l2.setLayoutX(70);
        l2.setLayoutY(110);
        pane.getChildren().add(l2);

        Button rtt = new Button();
        rtt.setText("Remove Trailer");
        rtt.setLayoutY(95);
        rtt.setLayoutX(200);
        pane.getChildren().add(rtt);


        Text l3 = new Text("employee id:");
        l3.setLayoutX(60);
        l3.setLayoutY(170);
        pane.getChildren().add(l3);

        TextField t3 = new TextField();
        t3.setMaxWidth(30);
        t3.setMaxHeight(1);
        t3.setLayoutX(150);
        t3.setLayoutY(150);

        pane.getChildren().add(t3);


        Button re = new Button();
        re.setText("RemoveEmployee");
        re.setLayoutX(200);
        re.setLayoutY(150);
        pane.getChildren().add(re);



        //select
        TextField t4 = new TextField();
        t4.setMaxWidth(30);
        t4.setMaxHeight(1);
        t4.setLayoutX(580);
        t4.setLayoutY(335);

        pane.getChildren().add(t4);

        Text l4 = new Text("truck id :");
        l4.setLayoutX(530);
        l4.setLayoutY(350);
        pane.getChildren().add(l4);

        Button rtr4 = new Button();
        rtr4.setText("SelectTruck");
        rtr4.setLayoutY(335);
        rtr4.setLayoutX(630);
        pane.getChildren().add(rtr4);

        TextField t5 = new TextField();
        t5.setMaxWidth(30);
        t5.setMaxHeight(1);
        t5.setLayoutX(380);
        t5.setLayoutY(335);

        pane.getChildren().add(t5);

        Text l5 = new Text("trailer id :");
        l5.setLayoutX(320);
        l5.setLayoutY(350);
        pane.getChildren().add(l5);

        Button rtt5 = new Button();
        rtt5.setText("SelectTrailer");
        rtt5.setLayoutY(335);
        rtt5.setLayoutX(420);
        pane.getChildren().add(rtt5);


        Text l6 = new Text("employee id:");
        l6.setLayoutX(40);
        l6.setLayoutY(350);
        pane.getChildren().add(l6);

        TextField t6 = new TextField();
        t6.setMaxWidth(30);
        t6.setMaxHeight(1);
        t6.setLayoutX(120);
        t6.setLayoutY(335);

        pane.getChildren().add(t6);


        Button re6 = new Button();
        re6.setText("SelectEmployee");
        re6.setLayoutX(170);
        re6.setLayoutY(335);
        pane.getChildren().add(re6);

        rtr.setOnAction(event -> {
            cd.truck_delete(Integer.parseInt(t1.getText()));
            System.out.print("Deleted");
        });

        rtt.setOnAction(event -> {
            cd.trailer_delete(Integer.parseInt(t2.getText()));
            System.out.println("Trailer Deleted");
        });

        re.setOnAction(event -> {
            cd.employee_delete(Integer.parseInt(t3.getText()));
            System.out.println("Employee_deleted");
        });

        //employee update

        Label lastlabel = new Label();
        lastlabel.setLayoutY(400);
        lastlabel.setLayoutX(30);
        lastlabel.setText("LastName:");
        pane.getChildren().add(lastlabel);

        TextField lastname = new TextField();
        lastname.setLayoutX(90);
        lastname.setLayoutY(400);
        pane.getChildren().add(lastname);

        Label firstlabel = new Label();
        firstlabel.setLayoutY(430);
        firstlabel.setLayoutX(30);
        firstlabel.setText("FirstName:");
        pane.getChildren().add(firstlabel);

        TextField firstname = new TextField();
        firstname.setLayoutX(90);
        firstname.setLayoutY(430);
        pane.getChildren().add(firstname);

        Label emaillabel = new Label();
        emaillabel.setLayoutY(460);
        emaillabel.setLayoutX(30);
        emaillabel.setText("Email:");
        pane.getChildren().add(emaillabel);

        TextField email = new TextField();
        email.setLayoutX(90);
        email.setLayoutY(460);
        pane.getChildren().add(email);

        Label phonelabel = new Label();
        phonelabel.setLayoutY(490);
        phonelabel.setLayoutX(30);
        phonelabel.setText("Phone:");
        pane.getChildren().add(phonelabel);

        TextField phone = new TextField();
        phone.setLayoutX(90);
        phone.setLayoutY(490);
        pane.getChildren().add(phone);

        Label truckidlabel = new Label();
        truckidlabel.setLayoutY(520);
        truckidlabel.setLayoutX(30);
        truckidlabel.setText("ActuturalTruck:");
        pane.getChildren().add(truckidlabel);

        TextField aid = new TextField();
        aid.setLayoutX(120);
        aid.setMaxWidth(30);
        aid.setLayoutY(520);
        pane.getChildren().add(aid);

        Label salarylabel = new Label();
        salarylabel.setLayoutY(550);
        salarylabel.setLayoutX(30);
        salarylabel.setText("Salary:");
        pane.getChildren().add(salarylabel);

        TextField salary = new TextField();
        salary.setLayoutX(90);
        salary.setMaxWidth(100);
        salary.setLayoutY(550);
        pane.getChildren().add(salary);

        re6.setOnAction(event -> {
            Employee x = new Employee();
            try {
                x = x.find(Integer.parseInt(t6.getText()));
                lastname.setText(x.last_name);
                firstname.setText(x.first_name);
                email.setText(x.email);
                phone.setText(x.phone_number);
                salary.setText(Integer.toString(x.salary));
                aid.setText(Integer.toString(x.actual_truck_id));
                System.out.print("Uspesne vybrany zamestnanec");
                last_employeeid = x.employee_id;
                last_truckid = x.actual_truck_id;

            }catch (Exception e){
                System.out.print("Neuspesne vybrany zamestnanec");
            }

        });

        Button adde = new Button();
        adde.setText("AddEmployee");
        adde.setLayoutX(190);
        adde.setLayoutY(520);
        pane.getChildren().add(adde);

        adde.setOnAction(event -> {

            try{
                int id ;
                if(aid.getText().equals("")){
                    id = 0;
                }
                else{
                    System.out.println(aid.getText());
                    id =  Integer.parseInt(aid.getText());
                }
                Employee e = new Employee(firstname.getText(),lastname.getText(),email.getText(),phone.getText(),
                       id,Integer.parseInt(salary.getText()));
                Job j = new Job(Integer.parseInt(salary.getText()));
                e.insert();
                j.insert();
                System.out.print("pouzivatel uspesne pridany");
            }catch (Exception d){
                System.out.print("pouzivatel neuspesne pridany");
                d.printStackTrace();
            }
        });

        Button upe = new Button();
        upe.setText("UpdateEmployee");
        upe.setLayoutX(210);
        upe.setLayoutY(550);
        pane.getChildren().add(upe);

        upe.setOnAction(event -> {
            try{
                int id ;
                if(aid.getText().equals("")){
                    id = 0;
                }
                else{
                    System.out.println(aid.getText());
                    id =  Integer.parseInt(aid.getText());
                }
                Employee e = new Employee(Integer.parseInt(t6.getText()),firstname.getText(),lastname.getText(),email.getText(),
                        phone.getText(),id,Integer.parseInt(salary.getText()));
                Truck t = new Truck();
                t = t.find(last_truckid);
                if(id == 0){
                    t.employee_id = 0;
                    t.update();
                }
                e.update();
                System.out.println("Uspesny Update");
            }catch (Exception x){
                x.printStackTrace();
                System.out.println("Neuspesny Update");
            }
        });


        //trailer

        Label truckidlabel2 = new Label();
        truckidlabel2.setLayoutY(380);
        truckidlabel2.setLayoutX(300);
        truckidlabel2.setText("TruckId:");
        pane.getChildren().add(truckidlabel2);

        TextField truckid2 = new TextField();
        truckid2.setLayoutX(350);
        truckid2.setLayoutY(380);
        pane.getChildren().add(truckid2);

        Label typelabel = new Label();
        typelabel.setLayoutY(410);
        typelabel.setLayoutX(300);
        typelabel.setText("Type:");
        pane.getChildren().add(typelabel);

        TextField type = new TextField();
        type.setLayoutX(350);
        type.setLayoutY(410);
        pane.getChildren().add(type);

        Label statlabel = new Label();
        statlabel.setLayoutY(440);
        statlabel.setLayoutX(300);
        statlabel.setText("Stat:");
        pane.getChildren().add(statlabel);

        TextField stat = new TextField();
        stat.setLayoutX(350);
        stat.setLayoutY(440);
        pane.getChildren().add(stat);

        rtt5.setOnAction(event -> {
            try{
                Trailer t = new Trailer();
                t = t.find(Integer.parseInt(t5.getText()));
                last_truckid = t.truck_id;
                last_trailerid = t.trailer_id;

                stat.setText(t.trailer_stat);
                type.setText(Integer.toString(t.trailer_type));
                truckid2.setText(Integer.toString(t.truck_id));

            }catch (Exception e){
                e.printStackTrace();

            }
        });

        Button addtr = new Button();
        addtr.setText("AddTrailer");
        addtr.setLayoutX(350);
        addtr.setLayoutY(470);
        pane.getChildren().add(addtr);

        Button uptr = new Button();
        uptr.setText("UpdateTrailer");
        uptr.setLayoutX(350);
        uptr.setLayoutY(500);
        pane.getChildren().add(uptr);

        addtr.setOnAction(event -> {
            try{
                Trailer t = new Trailer();
                int id ;
                if(truckid2.getText().equals("")){
                    id = 0;
                }
                else{
                    id =  Integer.parseInt(truckid2.getText());
                }

                t.truck_id = id;
                t.trailer_stat = stat.getText();
                t.trailer_type = Integer.parseInt(type.getText());
                t.insert();

                if(id != 0){
                    Truck tr = new Truck();
                    tr = tr.find(last_truckid);
                    tr.trailer_id = t.trailer_id;
                    tr.update();
                }

                System.out.print("Done");



            }catch (Exception e){
                e.printStackTrace();
            }

        });

        uptr.setOnAction(event -> {
            try{
                Trailer t = new Trailer();
                t = t.find(last_trailerid);

                int id ;
                if(truckid2.getText().equals("")){
                    id = 0;
                }
                else{
                    id =  Integer.parseInt(truckid2.getText());
                }

                t.trailer_type = Integer.parseInt(type.getText());
                t.trailer_stat = stat.getText();
                t.truck_id = id;

                if(id == 0){
                    Truck q = new Truck();
                    q.find(last_truckid);
                    q.trailer_id = 0;
                    q.update();
                }else {
                    t.update();
                    Truck q = new Truck();
                    q.find(id);
                    q.trailer_id = id;
                    q.update();
                }

                System.out.println("Update Done");



            }catch (Exception e){
                e.printStackTrace();
            }

        });

        Label eidl = new Label();
        eidl.setText("EmployeeId:");
        eidl.setLayoutX(550);
        eidl.setLayoutY(380);
        pane.getChildren().add(eidl);

        TextField eid = new TextField();
        eid.maxWidth(20);
        eid.setLayoutX(630);
        eid.setLayoutY(380);
        pane.getChildren().add(eid);


        Label tidl = new Label();
        tidl.setText("TrailerId:");
        tidl.setLayoutX(550);
        tidl.setLayoutY(410);
        pane.getChildren().add(tidl);

        TextField tid = new TextField();
        tid.maxWidth(20);
        tid.setLayoutX(630);
        tid.setLayoutY(410);
        pane.getChildren().add(tid);

        Label ttpl = new Label();
        ttpl.setText("TruckType:");
        ttpl.setLayoutX(550);
        ttpl.setLayoutY(440);
        pane.getChildren().add(ttpl);

        TextField ttp = new TextField();
        ttp.maxWidth(20);
        ttp.setLayoutX(630);
        ttp.setLayoutY(440);
        pane.getChildren().add(ttp);

        Label agel = new Label();
        agel.setText("Age:");
        agel.setLayoutX(550);
        agel.setLayoutY(470);
        pane.getChildren().add(agel);

        TextField age = new TextField();
        age.maxWidth(20);
        age.setLayoutX(630);
        age.setLayoutY(470);
        pane.getChildren().add(age);

        Label statl = new Label();
        statl.setText("TruckStat:");
        statl.setLayoutX(550);
        statl.setLayoutY(500);
        pane.getChildren().add(statl);

        TextField stat1 = new TextField();
        stat1.maxWidth(20);
        stat1.setLayoutX(630);
        stat1.setLayoutY(500);
        pane.getChildren().add(stat1);

        Button addtruck = new Button();
        addtruck.setText("AddTruck");
        addtruck.setLayoutY(530);
        addtruck.setLayoutX(550);
        pane.getChildren().add(addtruck);


        Button updatetruck = new Button();
        updatetruck.setText("UpdateTruck");
        updatetruck.setLayoutY(560);
        updatetruck.setLayoutX(550);
        pane.getChildren().add(updatetruck);

        rtr4.setOnAction(event -> {
            try{
                Truck t = new Truck();
                t = t. find(Integer.parseInt(t4.getText()));
                eid.setText(Integer.toString(t.employee_id));
                tid.setText(Integer.toString(t.trailer_id));
                ttp.setText(Integer.toString(t.truck_type));
                age.setText(Integer.toString(t.age));
                stat1.setText(t.truck_stat);

                last_truckid = t.truck_id;
                last_trailerid = t.trailer_id;
                last_employeeid = t.employee_id;

            }catch (Exception e){
                e.printStackTrace();
            }
        });

        addtruck.setOnAction(event -> {
            try{
                Truck t = new Truck();
                Trailer tr = new Trailer();
                Employee em = new Employee();
                if(eid.getText().equals("")){
                    t.employee_id = 0;
                }else {
                    t.employee_id = Integer.parseInt(eid.getText());
                    em = em.find(last_employeeid);
                    em.actual_truck_id = 0;
                }


                t.age = Integer.parseInt(age.getText());
                t.truck_type = Integer.parseInt(ttp.getText());
                t.truck_stat = stat1.getText();
                t.insert();

                if(t.trailer_id != 0){
                    tr.update();
                }

                if(t.employee_id != 0){
                    em.update();
                }

                System.out.print("TruckAdded Succesfully");


            }catch (Exception e){
                e.printStackTrace();
            }

        });

        updatetruck.setOnAction(event -> {
            try{
                Truck t = new Truck();
                Employee em = new Employee();
                Trailer tr = new Trailer();

                t = t.find(Integer.parseInt(t4.getText()));

                if(eid.getText().equals("")){
                    t.employee_id = 0;
                }else{
                    t.employee_id = Integer.parseInt(eid.getText());
                }

                if (tid.getText().equals("")){
                    t.trailer_id = 0;
                }else {
                    t.trailer_id = Integer.parseInt(tid.getText());
                }

                t.truck_type = Integer.parseInt(ttp.getText());
                t.age = Integer.parseInt(age.getText());
                t.truck_stat = stat1.getText();

                System.out.println(stat1.getText());

                if(t.employee_id != 0){
                    em = em.find(t.employee_id);
                    em.actual_truck_id = 0;
                }

                if(t.trailer_id != 0) {
                    tr = tr.find(t.trailer_id);
                    tr.truck_id = 0;
                }

                t.update();
                System.out.println("updated");

                if(t.employee_id != 0){
                    em.update();
                }

                if(t.trailer_id != 0){
                    tr.update();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });

    }

}
