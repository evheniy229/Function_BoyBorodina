package sample;

import java.io.Closeable;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button getBringOut;
    @FXML
    private Button getClear;
    @FXML
    private ComboBox<String> getVariant;
    @FXML
    private ComboBox<String> getFormula;
    @FXML
    private TextField GetX;
    @FXML
    private TextField GetY;
    @FXML
    private TextField GetMinX;
    @FXML
    private TextField GetMaxX;
    @FXML
    private TextField GetInterval;
    @FXML
    private BubbleChart BringOutChart;

    @FXML
    private AreaChart areaChart;

    public Controller() {
    }


    @FXML
    void initialize() {
        //Вставляем выбор графика
        ObservableList<String> items = FXCollections.observableArrayList(
                "Парабола",
                "Синусоида",
                "Тангенс"
        );
        getVariant.setItems(items);//Вставляем его значения
        getVariant.setOnAction(event-> {//По нажатию выбранного графика появляется выбор его функции
            Functions();//функция
        });
        getBringOut.setOnAction(event-> {
            vibor();
            Functions();
        });
//        System.exit(1)
        getClear.setOnAction(event-> System.exit(1));
    }
    void vibor(){//Условие проверки выбора графика и вызов этого графика
        if (getVariant.getValue() == "Парабола"){
            Parabola(0);
        }
        else if (getVariant.getValue() == "Синусоида"){
            Sinsuoida(0);
        }
        else if (getVariant.getValue() == "Тангенс"){
            Tangens(0);
        }
        else{
            JOptionPane.showMessageDialog(null, "Выберите график", "Дальнейшая работа прекращена", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Сам график Пароболы
    void Parabola(int a)
    {
        Functions functions = new Functions();//Создается объект клкасса функции
        if(GetX.getText() == "" && GetY.getText()=="" && getFormula.getValue() == null){//Проверка на выбор обычного графика
            functions.parabola_usual();
        }
        else{//Необычный график
            int x = 0,y = 0;
            float xmin = -5, xmax = 5;
            String TextFieldX = GetX.getText();
            String TextFieldY = GetY.getText();
            String TextFieldGetMinX = GetMinX.getText();
            String TextFieldGetMaxX = GetMaxX.getText();
            if (TextFieldX != "") {
                x = Integer.parseInt(TextFieldX);
            }
            if (TextFieldY != "") {
                y = Integer.parseInt(TextFieldY);
            }
            if(TextFieldGetMinX != ""){
                xmin = Float.parseFloat(TextFieldGetMinX);
            }

            if(TextFieldGetMaxX != ""){
                xmax = Float.parseFloat(TextFieldGetMaxX);
            }

            functions.parabola_X_Y(x,y, xmin, xmax,a);
        }
        areaChart.getData().setAll(functions.series);
    }
    void Sinsuoida(int a){
        Functions functions = new Functions();//Создается объект клкасса функции
        int x = 0,y = 0;
        float xmin = -5, xmax = 5;
        String TextFieldX = GetX.getText();
        String TextFieldY = GetY.getText();
        String TextFieldGetMinX = GetMinX.getText();
        String TextFieldGetMaxX = GetMaxX.getText();
        if (TextFieldX != "") {
            x = Integer.parseInt(TextFieldX);
        }
        if (TextFieldY != "") {
            y = Integer.parseInt(TextFieldY);
        }
        if(TextFieldGetMinX != ""){
            xmin = Float.parseFloat(TextFieldGetMinX);
        }

        if(TextFieldGetMaxX != ""){
            xmax = Float.parseFloat(TextFieldGetMaxX);
        }
        functions.Sinusoid_X_Y(x,y, xmin, xmax, a);
        areaChart.getData().setAll(functions.series);
    }
    void Tangens (int a){
        Functions functions = new Functions();//Создается объект клкасса функции
        int x = 0,y = 0;
        float xmin = -5, xmax = 5;
        String TextFieldX = GetX.getText();
        String TextFieldY = GetY.getText();
        String TextFieldGetMinX = GetMinX.getText();
        String TextFieldGetMaxX = GetMaxX.getText();
        if (TextFieldX != "") {
            x = Integer.parseInt(TextFieldX);
        }
        if (TextFieldY != "") {
            y = Integer.parseInt(TextFieldY);
        }
        if(TextFieldGetMinX != ""){
            xmin = Float.parseFloat(TextFieldGetMinX);
        }

        if(TextFieldGetMaxX != ""){
            xmax = Float.parseFloat(TextFieldGetMaxX);
        }
        functions.Tangens_X_Y(x,y, xmin, xmax, a);
        areaChart.getData().setAll(functions.series);
    }
    void Functions(){//Выбор функции для определенного графика
        //Заполнение выбором функции


        Functions function = new Functions();
        Formula formula = new Formula();
        if (getVariant.getValue() == "Парабола"){
            ObservableList<String> functions = FXCollections.observableArrayList(
                    "y=2^x + 5",
                    "y=x^3-x^2+5",
                    "y=x^2+2*x-7",
                    "y=x^2",
                    "y = x + x"
            );
            getFormula.setItems(functions);

            int a;
            String element = getFormula.getValue();
            if (element == "y=2^x + 5"){
                a = 0;
                Parabola(a);
            }
            if (element == "y=x^3-x^2+5"){
                a = 1;
                Parabola(a);
            }
            if (element == "y=x^2+2*x-7"){
                a = 2;
                Parabola(a);
            }
            if(element == "y=x^2"){
                a=3;
                Parabola(a);
            }
            if(element == "y = x + x"){
                a = 4;
                Parabola(a);
            }
            else {
            }


        }
        if (getVariant.getValue() == "Синусоида"){
            ObservableList<String> functions = FXCollections.observableArrayList(
                    "y=Sin(x)"
            );
            getFormula.setItems(functions);

            int a;
            String element = getFormula.getValue();
            if (element == "y=Sin(x)"){
                a = 1;
                Sinsuoida(a);
            }

            else {
            }
        }
        if (getVariant.getValue() == "Тангенс"){
            ObservableList<String> functions = FXCollections.observableArrayList(
                    "y = x + x + x"
            );
            getFormula.setItems(functions);

            int a;
            String element = getFormula.getValue();
            if(element == "y = x + x + x"){
                a = 1;
                Tangens(a);
            }
        }
    }
}
