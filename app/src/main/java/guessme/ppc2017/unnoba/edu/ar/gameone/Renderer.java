package guessme.ppc2017.unnoba.edu.ar.gameone;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by anton on 9/5/2017.
 */

public class Renderer {
    //initial numbers that must be displayed.
    private TextView number1;
    private TextView number2;
    private TextView number3;
    private TextView number5;
    private TextView number4;
    private TextView number6;

    private TextView result1;
    private TextView result2;
    private TextView result3;

    //All the six options available.
    private TextView[] options = new TextView[6];

    private Typeface font;

    public void render(final MathOperation mathOperation, ArrayList<Integer> pyramidNumbers, Activity activity){
        // Primero asociamos los elemntos de la vista con las variables de este objeto
        linkElementsWithView(activity);
        setFont(Typeface.createFromAsset(activity.getAssets(), "adam handwriting test.ttf"));
        realRender(mathOperation,pyramidNumbers);
    }

    private void linkElementsWithView(Activity activity) {
        setNumber1((TextView) activity.findViewById(R.id.number1));
        setNumber2((TextView) activity.findViewById(R.id.number2));
        setNumber3((TextView) activity.findViewById(R.id.number3));
        setNumber4((TextView) activity.findViewById(R.id.number4));
        setNumber5((TextView) activity.findViewById(R.id.number5));
        setNumber6((TextView) activity.findViewById(R.id.number6));

        setResult1((TextView) activity.findViewById(R.id.result1));
        setResult2((TextView) activity.findViewById(R.id.result2));
        setResult3((TextView) activity.findViewById(R.id.result3));

        getOptions()[0] = (TextView) activity.findViewById(R.id.option0);
        getOptions()[1] = (TextView) activity.findViewById(R.id.option1);
        getOptions()[2] = (TextView) activity.findViewById(R.id.option2);
        getOptions()[3] = (TextView) activity.findViewById(R.id.option3);
        getOptions()[4] = (TextView) activity.findViewById(R.id.option4);
        getOptions()[5] = (TextView) activity.findViewById(R.id.option5);
    }

    private void realRender(MathOperation mathOperation, ArrayList<Integer> pyramidNumber) {

        // Setteamos la fuente custom a los operandos y el resultado
        getNumber1().setTypeface(getFont());
        getNumber2().setTypeface(getFont());
        getNumber3().setTypeface(getFont());
        getNumber4().setTypeface(getFont());
        getNumber5().setTypeface(getFont());
        getNumber6().setTypeface(getFont());
        getResult1().setTypeface(getFont());
        getResult2().setTypeface(getFont());
        getResult3().setTypeface(getFont());
        // Here I set the values of the corner of the pyramid.
        getNumber1().setText(String.valueOf(pyramidNumber.get(0)));
        getNumber3().setText(String.valueOf(pyramidNumber.get(2)));
        getNumber5().setText(String.valueOf(pyramidNumber.get(4)));
//Here I set the final result of the 3 digits sum.
        getResult1().setText(String.valueOf(mathOperation.getResult1()));
        getResult2().setText(String.valueOf(mathOperation.getResult2()));
        getResult3().setText(String.valueOf(mathOperation.getResult3()));

        // Por cada una de las opciones (vista) tenemos que hacer lo siguiente:
        for (int i = 0; i < options.length; i++) {
            // Settearle la fuente custom
            options[i].setTypeface(getFont());
            // Settearle el numero a mostrar, que se encuentra dentro de mathOperation
            options[i].setText(mathOperation.getOptions().get(i).toString());
            // Settearle nuestro OnTouchListener custom, el cual recibe la posicion i como parametro
            options[i].setOnTouchListener(new OptionsOnTouchListener(i));
        }
    }


    public void setNumber1(TextView number1) {
        this.number1 = number1;
    }

    public TextView getNumber1() {
        return number1;
    }

    public TextView getNumber3() {
        return number3;
    }

    public void setNumber3(TextView number3) {
        this.number3 = number3;
    }

    public TextView getNumber5() {
        return number5;
    }

    public void setNumber5(TextView number5) {
        this.number5 = number5;
    }

    public TextView getNumber2() {
        return number2;
    }

    public void setNumber2(TextView number2) {
        this.number2 = number2;
    }

    public TextView getNumber4() {
        return number4;
    }

    public void setNumber4(TextView number4) {
        this.number4 = number4;
    }

    public TextView getNumber6() {
        return number6;
    }

    public void setNumber6(TextView number6) {
        this.number6 = number6;
    }

    public TextView getResult1() {
        return result1;
    }

    public void setResult1(TextView result1) {
        this.result1 = result1;
    }

    public TextView getResult2() {
        return result2;
    }

    public void setResult2(TextView result2) {
        this.result2 = result2;
    }

    public TextView getResult3() {
        return result3;
    }

    public void setResult3(TextView result3) {
        this.result3 = result3;
    }

    public TextView[] getOptions() {
        return options;
    }

    public Typeface getFont() {
        return font;
    }

    public void setFont(Typeface font) {
        this.font = font;
    }
}
