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
    private ArrayList<Integer> piramidNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vamos a crear los 6 numeros aleatorios entre 1 y 9

        Random random = new Random();
        piramidNumbers = new ArrayList<Integer>();
        piramidNumbers.add(number1 = random.nextInt(50));
        piramidNumbers.add(number2 = random.nextInt(50));
        piramidNumbers.add(number3 = random.nextInt(50));
        piramidNumbers.add(number4 = random.nextInt(50));
        piramidNumbers.add(number5 = random.nextInt(50));
        piramidNumbers.add(number6 = random.nextInt(50));
        piramidNumbers.add(number7 = random.nextInt(50));
    }

}
