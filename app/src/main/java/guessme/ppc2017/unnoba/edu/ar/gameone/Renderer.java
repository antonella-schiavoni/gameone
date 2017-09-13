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
    private TextView[] numbers = new TextView[6];

    private TextView[] results = new TextView[3];

    //All the six options available.
    private TextView[] options = new TextView[6];

    private Typeface font;

    public void render(final MathOperation mathOperation, ArrayList<Integer> pyramidNumbers, Activity activity){
        // Primero asociamos los elemntos de la vista con las variables de este objeto
        linkElementsWithView(activity);
        setFont(Typeface.createFromAsset(activity.getAssets(), "adam handwriting test.ttf"));
        realRender(mathOperation,pyramidNumbers,activity);
    }

    private void linkElementsWithView(Activity activity) {
        numbers[0] = (TextView) activity.findViewById(R.id.number1);
        numbers[1] = (TextView) activity.findViewById(R.id.number2);
        numbers[2] = (TextView) activity.findViewById(R.id.number3);
        numbers[3] = (TextView) activity.findViewById(R.id.number4);
        numbers[4] = (TextView) activity.findViewById(R.id.number5);
        numbers[5] = (TextView) activity.findViewById(R.id.number6);

        results[0] = ((TextView) activity.findViewById(R.id.result1));
        results[1] = ((TextView) activity.findViewById(R.id.result2));
        results[2] = ((TextView) activity.findViewById(R.id.result3));

        options[0] = (TextView) activity.findViewById(R.id.option0);
        options[1] = (TextView) activity.findViewById(R.id.option1);
        options[2] = (TextView) activity.findViewById(R.id.option2);
        options[3] = (TextView) activity.findViewById(R.id.option3);
        options[4] = (TextView) activity.findViewById(R.id.option4);
        options[5] = (TextView) activity.findViewById(R.id.option5);
    }

    private void realRender(MathOperation mathOperation, ArrayList<Integer> pyramidNumber,Activity activity) {
       Typeface font = Typeface.createFromAsset(activity.getAssets(), "adam handwriting test.ttf");

        // Setteamos la fuente custom a los operandos y el resultado
        setFont(numbers, font);
        setFont(options, font);
        setFont(results, font);

        // Here I set the values of the corner of the pyramid.
        setPyramidNumbers(pyramidNumber);

        //Here I set the final result of the 3 digits sum.
        setFinalResults(mathOperation);

        // Por cada una de las opciones (vista) tenemos que hacer lo siguiente:
        for (int i = 0; i < options.length; i++) {
            // Settearle el numero a mostrar, que se encuentra dentro de mathOperation
            options[i].setText(mathOperation.getOptions().get(i).toString());
            // Settearle nuestro OnTouchListener custom, el cual recibe la posicion i como parametro
            options[i].setOnTouchListener(new OptionsOnTouchListener(i));
        }
    }

    private void setFont(TextView[] textViews, Typeface font){
        for(TextView textView : textViews){
            textView.setTypeface(font);
        }
    }

    private void setPyramidNumbers(ArrayList<Integer> pyramidNumbers){
        int j = 0;
        for (int i = 0 ; i < 3; i++){
            getNumbers()[j].setText(String.valueOf(pyramidNumbers.get(j)));
            j = j+2;
        }

    }

    private void setFinalResults(MathOperation mathOperation){
        int[] auxResults = mathOperation.getResults();
        for (int i = 0; i < 3; i++ ){
            getResults()[i].setText(String.valueOf(auxResults[i]));
        }
    }



    public TextView[] getOptions() {
        return options;
    }

    public void setFont(Typeface font) {
        this.font = font;
    }

    public TextView[] getNumbers() {
        return numbers;
    }

    public TextView[] getResults() {
        return results;
    }
}
