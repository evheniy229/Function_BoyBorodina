package sample;

public class Formula {

    float Y_formula(float x, int a){
        if (a ==0){
            return (float) (Math.pow(2,x) + 5);
        }
        if (a==1){
            return (float) (Math.pow(x,3)-Math.pow(x,2)+5);
        }
        if(a==2){
            return (float) (Math.pow(x,2)+2*x-7);
        }
        if(a==3){
            return (float)(Math.pow(x,2));
        }
        if(a==4){
            return (float)(x + x);
        }
        else {
            return (float) (Math.pow(x,2));
        }

    }
    float Y_Sin_formula(float x, int a){
        if(a==1){
            return (float)(Math.sin(x));
        }
        else {
            return (float) (Math.sin(x));
        }
    }
    float Y_Tan_formula(float x, int a){
        if(a==1){
            return (float)(Math.tan(x));
        }
        else {
            return (float) (Math.tan(x));
        }
    }
}
