
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application{

    public void start(Stage PrimaryStage) throws Exception{
        Pane pane = new Pane();
        PrimaryStage.setTitle("DB_Project");
        PrimaryStage.setScene(new Scene(pane,300,275));
        PrimaryStage.show();


        Rectangle back = new Rectangle(0,0,300,275);
        back.setStrokeWidth(5);
        back.setStroke(Color.BLACK);
        back.setFill(Color.CADETBLUE);
        pane.getChildren().add(back);

        Button crud = new Button();
        crud.setText("CRUD Operations");
        crud.setLayoutX(100);
        crud.setLayoutY(20);
        pane.getChildren().add(crud);

        Button statistic = new Button();
        statistic.setText("Statistics");
        statistic.setLayoutX(120);
        statistic.setLayoutY(70);
        pane.getChildren().add(statistic);

        Button transactions = new Button();
        transactions.setText("Transactions");
        transactions.setLayoutX(110);
        transactions.setLayoutY(120);
        pane.getChildren().add(transactions);

        transactions.setOnAction(event -> {
            TransactionsView tr = new TransactionsView();
        });

        statistic.setOnAction(event -> {
            StatisticsView st = new StatisticsView();
        });

        crud.setOnAction(event -> {
            CrudView cv = new CrudView();
        });

        Button addroute = new Button();
        addroute.setText("AddRoute");
        addroute.setLayoutX(115);
        addroute.setLayoutY(170);
        pane.getChildren().add(addroute);

        addroute.setOnAction(event -> {
            AddRouteView aw = new AddRouteView();
        });

        Button repairs = new Button();
        repairs.setText("Repairs");
        repairs.setLayoutX(125);
        repairs.setLayoutY(210);
        pane.getChildren().add(repairs);

        repairs.setOnAction(event -> {
            RepairView rp = new RepairView();
        });



    }

    public static void main(String[] args) {
        launch(args);
    }







}
