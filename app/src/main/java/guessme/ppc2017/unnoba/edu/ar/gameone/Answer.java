package guessme.ppc2017.unnoba.edu.ar.gameone;

/**
 * Created by anton on 9/7/2017.
 */

import android.os.Handler;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Esta clase maneja lo relacionado a la respuesta, es decir, tendremos un elemento de la vista,
 * que espera un determinado resultado, si se le arrastra el resultado correcto emitira el sonido
 * de success y avisara a GameActivity que ya fue bien respondido. Si fue mal respondido, emitira
 * el sonido de error.
 */
public class Answer {
    private TextView uiElement; // Elemento de la vista
    private int expectedNumber; // Respuesta esperada para este elemento
    private Sounds sounds;
    private Renderer renderer;
    private GameActivity gameActivity;

    /**
     * Constructor que hace el setteo inicial y agrega un OnDragListener para realizar la evaluacion.
     */
    public Answer(GameActivity gameActivity, TextView uiElement, int expectedNumber, final Renderer renderer, Sounds sounds) {
        // Setteo de los valores pasados como parametros.
        this.uiElement = uiElement;
        this.expectedNumber = expectedNumber;
        this.sounds = sounds;
        this.renderer = renderer;
        this.gameActivity = gameActivity;

        // Al elemento de la vista uiElement, le asignamos un OnDragListener
        this.uiElement.setOnDragListener(new View.OnDragListener() {

            @Override
            public boolean onDrag(View v, DragEvent event) {
               if (event.getAction() == DragEvent.ACTION_DROP) {
                    // Obtenemos los datos guardados en dicho evento (dentro del clipData)
                    // Ver OptionOnTouchListener para recordar
                    String chosenTag = event.getClipData().getItemAt(0).getText().toString();
                    // El dato alamcenado era la posicion de la opcion, la parseamos a integer
                    int chosenIndex = Integer.parseInt(chosenTag);
                    // Evaluamos si en esa posicion esta la opcion correcta
                    evaluate(chosenIndex);
                }
                return true;
            }
        });
    }

    /**
     * Evalua si la opcion que esta en la vista, en la posicion chosenIndex, contiene el valor
     * esperado, y actua acorde.
     */
    private void evaluate(int chosenIndex) {
        // Aca aparece la necesidad de renderer, solo para obtener todas las opciones (TextView)
        TextView[] options = renderer.getOptions();
        // De dichas opciones, obtenemos solo la que esta en la posicion chosenIndex
        TextView option = options[chosenIndex];
        // Obtenemos el valor de dicha opcion
        String stringChosenNumber = option.getText().toString();
        // Parseamos a int el valor de dicha opcion, y nos queda asi nuestro numero elegido
        int chosenNumber = Integer.parseInt(stringChosenNumber);

        // Verificamos si el numero elegido es igual al esperado
        if (chosenNumber == expectedNumber) {
            // Emitimos sonido de exito
            sounds.emitSuccessSound();
            // A nuestra casilla le setteamos el valor correcto (stringChosenNumber)
            uiElement.setText(stringChosenNumber);
            // A la opcion (vista) la dejamos vacia
            option.setText("");
            // Eliminamos el OnDragListener de este elemento, asi no se pueden seguir arrastrando
            // mas elementos sobre el
            uiElement.setOnDragListener(null);
            // Eliminamos el OnTouchListener de la opcion (vista) asi no se puede arrastrar una opcion vacia
            option.setOnTouchListener(null);
            // Llamamos a la funcion evaluateAllAnswers() de gameActivity para ver si ya respondimos
            // todas las casillas bien
            gameActivity.evaluateAllAnswers();
        } else {
            // Si elegimos la opcion equivocada, emitimos un sonido de error
            sounds.emitErrorSound();
            // Y mostramos una imagen de "ERROR"
            renderer.getWrongAnswerButton().setVisibility(View.VISIBLE);
            Runnable runnable = new Runnable() {
                public void run() {
                    renderer.getWrongAnswerButton().setVisibility(View.GONE);
                }
            };
            Handler handler1 = new Handler();
            // Ejecuta el codigo que esta en run() dentro de runnable luego de 2000 milisegundos
            handler1.postDelayed(runnable, 2000);
        }
    }

}
