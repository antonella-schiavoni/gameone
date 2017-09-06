package guessme.ppc2017.unnoba.edu.ar.gameone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private int number1;
    private int number2;
    private int number3;
    private int number4;
    private int number5;
    private int number6;
    private int number7;
    private ArrayList<Integer> pyramidNumbers;
    private MathOperation mathOperation;
    private Renderer renderer = new Renderer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vamos a crear los 6 numeros aleatorios entre 1 y 9

        Random random = new Random();
        pyramidNumbers = new ArrayList<Integer>();
        pyramidNumbers.add(number1 = random.nextInt(50));
        pyramidNumbers.add(number2 = random.nextInt(50));
        pyramidNumbers.add(number3 = random.nextInt(50));
        pyramidNumbers.add(number4 = random.nextInt(50));
        pyramidNumbers.add(number5 = random.nextInt(50));
        pyramidNumbers.add(number6 = random.nextInt(50));
        pyramidNumbers.add(number7 = random.nextInt(50));

        mathOperation = new MathOperation(pyramidNumbers);
        renderer.render(mathOperation,this);


    }

}
