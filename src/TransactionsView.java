import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class TransactionsView {

    public TransactionsView(){
        Stage Stage = new Stage();
        Pane pane = new Pane();
        Stage.setTitle("DB_Project_Transactions");
        Stage.setScene(new Scene(pane,370,300));
        Stage.show();


        Rectangle back = new Rectangle(0,0,370,300);
        back.setStrokeWidth(5);
        back.setStroke(Color.BLACK);
        back.setFill(Color.CADETBLUE);
        pane.getChildren().add(back);

        TextArea t1 = new TextArea();
        t1.setMaxWidth(10);
        t1.setMaxHeight(1);
        t1.setLayoutX(150);
        t1.setLayoutY(30);

        pane.getChildren().add(t1);

        Text l1 = new Text("first employee id :");
        l1.setLayoutX(70);
        l1.setLayoutY(50);
        pane.getChildren().add(l1);

        TextArea t2 = new TextArea();
        t2.setMaxWidth(10);
        t2.setMaxHeight(1);
        t2.setLayoutX(150);
        t2.setLayoutY(90);

        pane.getChildren().add(t2);

        Text l2 = new Text("second employee id :");
        l2.setLayoutX(60);
        l2.setLayoutY(110);
        pane.getChildren().add(l2);

        Transactions t = new Transactions();
        Button switc = new Button();
        switc.setText("SwitchTrucks");
        switc.setLayoutX(100);
        switc.setLayoutY(150);
        pane.getChildren().add(switc);

        switc.setOnAction(event -> {

            try {
                t.truckchange(Integer.parseInt(t1.getText()),Integer.parseInt(t2.getText()));
                System.out.print("Change Done!");
            }catch (Exception e){
                e.printStackTrace();
            }

        });


        Text l3 = new Text("Update by salary by fuel (once / month):");
        l3.setLayoutX(10);
        l3.setLayoutY(200);
        pane.getChildren().add(l3);


        Button upd = new Button();
        upd.setText("UpdateSalariesByFuel");
        upd.setLayoutX(230);
        upd.setLayoutY(180);
        pane.getChildren().add(upd);

        upd.setOnAction(event -> {
            try{
                t.salaryes_by_fuel();
                System.out.print("Salaries updated succesfully");
            }catch (Exception e){
                e.printStackTrace();
            }

        });
    }


}
