
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StatisticsView {

    public StatisticsView(){

        Stage Stage = new Stage();
        Pane pane = new Pane();
        Stage.setTitle("DB_Project_Statistics");
        Stage.setScene(new Scene(pane,300,200));
        Stage.show();


        Rectangle back = new Rectangle(0,0,300,200);
        back.setStrokeWidth(5);
        back.setStroke(Color.BLACK);
        back.setFill(Color.CADETBLUE);
        pane.getChildren().add(back);

        ChoiceBox<String> cb = new ChoiceBox<>(FXCollections.observableArrayList(
                "kolko kilometrov presiel zanestnanec odkedy pracuje a kolkokrat sa mu pokazil motor",
                "kolko kamionov a trailerov pouzil zamestnanec , kolkokrat pouzil trailer s kaimonom  a kamion  s trailerom",
                "vypis najlepsich zamestnancov podla distance/fuel"));

        cb.setLayoutY(20);
        cb.setMaxWidth(250);
        cb.setLayoutX(20);
        pane.getChildren().add(cb);

        Button showstatistic = new Button();
        showstatistic.setText("ShowStatistics");
        showstatistic.setLayoutX(100);
        showstatistic.setLayoutY(70);
        pane.getChildren().add(showstatistic);



        showstatistic.setOnAction(event -> {
            Statistics s = new Statistics();
           try {
               String str = "";
               switch (cb.getValue()){
                   case "kolko kilometrov presiel zanestnanec odkedy pracuje a kolkokrat sa mu pokazil motor" : str = s.s1;
                       break;
                   case "kolko kamionov a trailerov pouzil zamestnanec , kolkokrat pouzil trailer s kaimonom  a kamion  s trailerom" : str = s.s2;
                       break;
                   case "vypis najlepsich zamestnancov podla distance/fuel" : str = s.s3;
                       break;
                   default: str = "";
                       break;
               }
               ResultSet q = s.first(str);

               JFrame frame = new JFrame();
               JPanel panel = new JPanel();
               JTable table = new JTable(buildTableModel(q));
               JScrollPane sptable = new JScrollPane(table);
               panel.add(sptable);
               frame.getContentPane().add(panel);
               frame.pack();
               frame.setVisible(true);

           }catch (Exception e){
               e.printStackTrace();
           }
        });



    }

    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }
}
