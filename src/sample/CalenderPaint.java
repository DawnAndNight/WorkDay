package sample;

import javafx.scene.layout.Pane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.util.Calendar;

public class CalenderPaint extends Pane{
    private int year;
    private int month;
    private int day;
    private int firstDayOfWeek;
    private int totalDayOfMonth;

    public CalenderPaint(String[] arrayWorkTerm) {
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        totalDayOfMonth = calendar.getActualMaximum(Calendar.DATE);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        paint(arrayWorkTerm);
    }



    public void paint(String[] arrayWorkTerm){
        GridPane cp = new GridPane();
        String[] week = new String[]{"日","一", "二", "三", "四", "五", "六"};
        cp.setPadding(new Insets(30, 30, 10, 10));
        Text text1 = new Text(year + "年" + month + "月" +day + "日");
        text1.setFont(Font.font(null, FontWeight.BOLD, 32));
        cp.add(text1, 0, 0);
        GridPane.setColumnSpan(text1, 8); // 设置列
        GridPane.setHalignment(text1, HPos.CENTER);
        for(int i = 0; i < 7; i++){
            Label label = new Label(week[i]);
            if(i == 0 || i == 6) label.setTextFill(Color.RED);
            cp.add(label, i, 1);
            cp.getColumnConstraints().add(new ColumnConstraints(30));
            GridPane.setHalignment(label, HPos.CENTER);
        }
        for(int j = 0; j < totalDayOfMonth; j++){
            Label label = new Label(j + 1 +"" +"\n"+arrayWorkTerm[firstDayOfWeek+j]);
            if(arrayWorkTerm[firstDayOfWeek+j].equals("休")) label.setTextFill(Color.BLUE);
            if (j + 1 == day) {
                label.setTextFill(Color.GREEN);
                label.setFont(Font.font(null, FontWeight.BOLD, 15));
            }
            int k = firstDayOfWeek + j;
            cp.add(label, k % 7, 2 + k / 7);//设置位置
            GridPane.setHalignment(label, HPos.RIGHT);
        }
        getChildren().add(cp);
    }
}