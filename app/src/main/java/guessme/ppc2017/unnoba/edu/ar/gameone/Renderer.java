package guessme.ppc2017.unnoba.edu.ar.gameone;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by anton on 9/5/2017.
 */

public class Renderer {
    //initial numbers that must be displayed.
    private TextView number1;
    private TextView number3;
    private TextView number6;

    private TextView result1;
    private TextView result2;
    private TextView result3;


    //All the six options available.
    private TextView[] options = new TextView[6];

    private Typeface font;

    public void render(final MathOperation mathOperation, Activity activity){
        // Primero asociamos los elemntos de la vista con las variables de este objeto
        linkElementsWithView(activity);
        setFont(Typeface.createFromAsset(activity.getAssets(), "adam handwriting test.ttf"));
        realRender(mathOperation);
    }

    private void linkElementsWithView(Activity activity) {
        setNumber1((TextView)activity.findViewById(R.id.number1));
        setNumber3((TextView) activity.findViewById(R.id.number3));
        setNumber6((TextView) activity.findViewById(R.id.number6));

        result1 = (TextView) activity.findViewById(R.id.result1);
        result2 = (TextView) activity.findViewById(R.id.result2);
        result3 = (TextView) activity.findViewById(R.id.result3);

        getOptions()[0] = (TextView) activity.findViewById(R.id.option0);
        getOptions()[1] = (TextView) activity.findViewById(R.id.option1);
        getOptions()[2] = (TextView) activity.findViewById(R.id.option2);
        getOptions()[3] = (TextView) activity.findViewById(R.id.option3);
        getOptions()[4] = (TextView) activity.findViewById(R.id.option4);
        getOptions()[5] = (TextView) activity.findViewById(R.id.option5);
    }

    private void realRender(MathOperation mathOperation) {

        // Setteamos la fuente custom a los operandos y el resultado
        getNumber1().setTypeface(getFont());
        getNumber3().setTypeface(getFont());
        getNumber6().setTypeface(getFont());

        // Por cada una de las opciones (vista) tenemos que hacer lo siguiente:
        for (int i = 0; i < getOptions().length; i++) {
            // Settearle la fuente custom
            getOptions()[i].setTypeface(getFont());
            // Settearle el numero a mostrar, que se encuentra dentro de mathOperation
            getOptions()[i].setText(mathOperation.getOptions().get(i).toString());
            // Settearle nuestro OnTouchListener custom, el cual recibe la posicion i como parametro
            getOptions()[i].setOnTouchListener(new OptionsOnTouchListener(i));
        }
    }

    public TextView getNumber1() {
        return number1;
    }

    public void setNumber1(TextView number1) {
        this.number1 = number1;
    }

    public TextView getNumber3() {
        return number3;
    }

    public void setNumber3(TextView number3) {
        this.number3 = number3;
    }

    public TextView getNumber6() {
        return number6;
    }

    public void setNumber6(TextView number6) {
        this.number6 = number6;
    }

    public TextView[] getOptions() {
        return options;
    }

    public void setOptions(TextView[] options) {
        this.options = options;
    }

    public Typeface getFont() {
        return font;
    }

    public void setFont(Typeface font) {
        this.font = font;
    }
}
