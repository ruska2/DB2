import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class AddRouteView {

    AddRouteView(){
        CrudController cd = new CrudController();
        Stage Stage = new Stage();
        Pane pane = new Pane();
        Stage.setTitle("DB_Project_Addroute");
        Stage.setScene(new Scene(pane,300,400));
        Stage.show();


        Rectangle back = new Rectangle(0,0,300,400);
        back.setStrokeWidth(5);
        back.setStroke(Color.BLACK);
        back.setFill(Color.CADETBLUE);
        pane.getChildren().add(back);

        Label truckidla = new Label();
        truckidla.setLayoutY(100);
        truckidla.setLayoutX(30);
        truckidla.setText("TruckId:");
        pane.getChildren().add(truckidla);

        TextField truckid = new TextField();
        truckid.setLayoutX(90);
        truckid.setLayoutY(100);
        pane.getChildren().add(truckid);

        Label firstlabel = new Label();
        firstlabel.setLayoutY(130);
        firstlabel.setLayoutX(30);
        firstlabel.setText("TrailerId:");
        pane.getChildren().add(firstlabel);

        TextField trailerid = new TextField();
        trailerid.setLayoutX(90);
        trailerid.setLayoutY(130);
        pane.getChildren().add(trailerid);

        Label emaillabel = new Label();
        emaillabel.setLayoutY(160);
        emaillabel.setLayoutX(30);
        emaillabel.setText("EmployeeId:");
        pane.getChildren().add(emaillabel);

        TextField eid = new TextField();
        eid.setLayoutX(110);
        eid.setLayoutY(160);
        pane.getChildren().add(eid);

        Label phonelabel = new Label();
        phonelabel.setLayoutY(190);
        phonelabel.setLayoutX(30);
        phonelabel.setText("UsedFuel:");
        pane.getChildren().add(phonelabel);

        TextField fuel = new TextField();
        fuel.setLayoutX(90);
        fuel.setLayoutY(190);
        pane.getChildren().add(fuel);

        Label truckidlabel = new Label();
        truckidlabel.setLayoutY(220);
        truckidlabel.setLayoutX(30);
        truckidlabel.setText("Distance:");
        pane.getChildren().add(truckidlabel);

        TextField distance = new TextField();
        distance.setLayoutX(90);
        distance.setLayoutY(220);
        pane.getChildren().add(distance);

        Button add = new Button();
        add.setText("AddRoute");
        add.setLayoutX(120);
        add.setLayoutY(260);
        pane.getChildren().add(add);
        add.setOnAction(event -> {
            try{
                cd.add_route(Integer.parseInt(truckid.getText()),Integer.parseInt(trailerid.getText()),Integer.parseInt(eid.getText()),
                        Integer.parseInt(fuel.getText()),Integer.parseInt(distance.getText()));
                System.out.print("Cesta Pridana");
            }catch (Exception e){
                e.printStackTrace();
            }

        });
    }
}
