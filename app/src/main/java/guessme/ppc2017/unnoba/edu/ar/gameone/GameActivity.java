package guessme.ppc2017.unnoba.edu.ar.gameone;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private int numberOfHits = 0;

    private Sounds sounds;
    private ArrayList<Integer> pyramidNumbers;
    private MathOperation mathOperation;
    private Renderer renderer = new Renderer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creamos los sonidos del sistema (success y error) para este (this) context
        sounds = new Sounds(this);

        //Llamamos a
        ArrayList<Integer> pyramidNumbers = buildPyramidNumbers();
        mathOperation = new MathOperation(pyramidNumbers);
        renderer.render(mathOperation, pyramidNumbers, this);

        // Creamos las tres respuestas, una por cada lado de la piramide
        new Answer(this, renderer.getNumber2(), pyramidNumbers.get(1), renderer, sounds);

    }

    /**
     * Este metodo se encarga de llenar el array con los numerso necesarios para
     * @return pyramidNumbers
     */
    public ArrayList<Integer> buildPyramidNumbers(){
        //Vamos a crear los 6 numeros aleatorios entre 1 y 9
        pyramidNumbers = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i <= 6 ; i++){
            pyramidNumbers.add(random.nextInt(10));
        }
        return pyramidNumbers;
    }

    /**
     * Cada vez que una respuesta (Answer) haya sido bien respondida, se llamara a este metodo,
     * el cual verifica si fue llamado por primera, segunda o tercera vez. Si fue llamado por
     * tercera vez, significa que ya fueron bien respondidas las 3 casillas, por lo cual
     * espera 3 segundos, cierra el activity actual y abre uno nuevo
     */
    public void evaluateAllAnswers() {
        // Incrementamos el numero de aciertos
        numberOfHits += 1;
        switch ( numberOfHits ) {
            case 1:
                // Dado que la primer casilla fue bien respondida, creamos la segunda
                new Answer(this, renderer.getNumber4(), pyramidNumbers.get(3), renderer, sounds);
                break;
            case 2:
                // Dado que la segunda casilla fue bien respondida, creamos la tercera
                new Answer(this, renderer.getNumber6(), pyramidNumbers.get(5), renderer, sounds);
                break;
            case 3:
                // Si estamos aqui, es porque ya fueron bien respondidas las 3 casillas

                // Dentro del metodo run de nuestro runnable guardamos el codigo que queremos
                // ejecutar (pero aun no lo hacemos)
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        // Crea un nuevo intent
                        Intent intent = getIntent();
                        // Finaliza el activity actual
                        finish();
                        // Abre el nuevo activity
                        startActivity(intent);
                    }
                };
                Handler handler = new Handler();
                // Ejecuta el codigo que esta en run() dentro de runnable luego de 3000 milisegundos
                handler.postDelayed(runnable, 3000);
                break;
        }
    }

}
