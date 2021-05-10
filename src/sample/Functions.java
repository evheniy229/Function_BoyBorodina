package sample;

import javafx.scene.chart.XYChart;

public class Functions {
    XYChart.Series<Float, Float> series = new XYChart.Series<>();
    void parabola_usual(){
        float xmin=-5,xmax=5,h=(float)0.01,x,y;
        for (x=xmin;x<=xmax;x+=h)
        {
            y= (float) (x*x);

            series.getData().add(new XYChart.Data<>(x, y));

        }
        series.setName("Обычная парабола");
    }
    void parabola_X_Y(float X,float Y, float xmin, float xmax, int a){
        System.out.println("Паробала с использованием x и y");
        float h=(float)0.01,x=0, y=0;
        for (x=xmin;x<=xmax;x+=h)
        {

            Formula formula = new Formula();
            y = formula.Y_formula(x,a);
            series.getData().add(new XYChart.Data<>(x+X, y+Y));
        }
        series.setName("Парабола");
        // сформированный массив точек, передаем графику для отображения
    }
    void Sinusoid_X_Y(float X,float Y, float xmin, float xmax, int a){
        System.out.println("Синусоида с использованием x и y");

        float h=(float)0.01,x=0,y=0;
        for (x=xmin;x<=xmax;x+=h)
        {

            Formula formula = new Formula();
            y = formula.Y_Sin_formula(x,a);

            series.getData().add(new XYChart.Data<>(x+X, y+Y));

        }
        series.setName("Парабола");
    }
    void Tangens_X_Y(float X,float Y, float xmin, float xmax, int a){
        System.out.println("Синусоида с использованием x и y");

        float h=(float)0.01,x=0,y=0;
        for (x=xmin;x<=xmax;x+=h)
        {

            Formula formula = new Formula();
            y = formula.Y_Tan_formula(x,a);

            series.getData().add(new XYChart.Data<>(x+X, y+Y));

        }
        series.setName("Тангенс");
    }

}
