import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;


public class RepairView {
    RepairView()
    {

        CrudController cd = new CrudController();
        Stage Stage = new Stage();
        Pane pane = new Pane();
        Stage.setTitle("DB_Project_REPAIR");
        Stage.setScene(new Scene(pane, 300, 400));
        Stage.show();


        Rectangle back = new Rectangle(0, 0, 300, 400);
        back.setStrokeWidth(5);
        back.setStroke(Color.BLACK);
        back.setFill(Color.CADETBLUE);
        pane.getChildren().add(back);

        Label vidl = new Label();
        vidl.setLayoutY(100);
        vidl.setLayoutX(30);
        vidl.setText("VehicleId:");
        pane.getChildren().add(vidl);

        TextField vid = new TextField();
        vid.setLayoutX(90);
        vid.setLayoutY(100);
        pane.getChildren().add(vid);

        Label firstlabel = new Label();
        firstlabel.setLayoutY(130);
        firstlabel.setLayoutX(30);
        firstlabel.setText("EmployeeId:");
        pane.getChildren().add(firstlabel);

        TextField eid = new TextField();
        eid.setLayoutX(90);
        eid.setLayoutY(130);
        pane.getChildren().add(eid);

        Label emaillabel = new Label();
        emaillabel.setLayoutY(160);
        emaillabel.setLayoutX(30);
        emaillabel.setText("FaultsType:");
        pane.getChildren().add(emaillabel);

        TextField type = new TextField();
        type.setLayoutX(110);
        type.setLayoutY(160);
        pane.getChildren().add(type);

        Label phonelabel = new Label();
        phonelabel.setLayoutY(190);
        phonelabel.setLayoutX(30);
        phonelabel.setText("Cost:");
        pane.getChildren().add(phonelabel);

        TextField cost = new TextField();
        cost.setLayoutX(90);
        cost.setLayoutY(190);
        pane.getChildren().add(cost);

        Button add = new Button();
        add.setText("AddFault");
        add.setLayoutX(120);
        add.setLayoutY(260);
        pane.getChildren().add(add);

        final ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton("Truck");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);

        RadioButton rb2 = new RadioButton("Trailer");
        rb2.setToggleGroup(group);

        pane.getChildren().add(rb1);
        pane.getChildren().add(rb2);

        rb1.setLayoutX(30);
        rb1.setLayoutY(30);

        rb2.setLayoutX(200);
        rb2.setLayoutY(30);

        add.setOnAction(event -> {
            try{
                if(rb1.isSelected()){
                    cd.add_truck_repair(Integer.parseInt(vid.getText()),Integer.parseInt(eid.getText()),type.getText(),Integer.parseInt(cost.getText()));
                    System.out.print("Truck repair added");
                }

                else if (rb2.isSelected()){
                    cd.add_trailer_repair(Integer.parseInt(vid.getText()),Integer.parseInt(eid.getText()),type.getText(),Integer.parseInt(cost.getText()));
                    System.out.print("Trailer repair added");
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        });

        Label tid = new Label();
        tid.setText("RepairID:");
        tid.setLayoutX(40);
        tid.setLayoutY(325);
        pane.getChildren().add(tid);

        TextField tx = new TextField();
        tx.setLayoutX(100);
        tx.setLayoutY(320);
        tx.setMaxWidth(50);

        Button setrepair = new Button();
        setrepair.setText("SetRepair");
        setrepair.setLayoutX(170);
        setrepair.setLayoutY(320);
        pane.getChildren().add(setrepair);
        pane.getChildren().add(tx);

        setrepair.setOnAction(event -> {
            try {
                if(rb1.isSelected()){
                    cd.finalize_truck_repair(Integer.parseInt(tx.getText()));
                    System.out.print("Truck repair finish added");
                }

                else if (rb2.isSelected()){
                    cd.finalize_trailer_repair(Integer.parseInt(tx.getText()));
                    System.out.print("Trailer repair finish added");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });

    }
}
