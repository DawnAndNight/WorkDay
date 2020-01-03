package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Calendar;

import static javafx.stage.StageStyle.TRANSPARENT;

public class Main extends Application {

    private Calender calenderNow = new Calender();
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.initStyle(TRANSPARENT);
        primaryStage.setX(1640);
        primaryStage.setY(750);
        xlsToArray xls = new xlsToArray();
        calenderNow.MakeArrayDay();
        calenderNow.setArrayWorkTerm(xls.ChangeXls(calenderNow.getArrayWorkTerm(),calenderNow.getTheFirstDayOfWeek(),calenderNow.getArrayCount()));

        StackPane nt = new StackPane();
        CalenderPaint caPa = new CalenderPaint(calenderNow.getArrayWorkTerm());
        BorderPane bp = new BorderPane();

        bp.setCenter(caPa);
        bp.setBottom(nt);
        Scene scene = new Scene(bp, 240, 254);
        EventHandler<ActionEvent> eventHandler = e ->{
        };
        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        primaryStage.setTitle("Perpetual calendar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
