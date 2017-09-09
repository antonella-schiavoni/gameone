package guessme.ppc2017.unnoba.edu.ar.gameone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by anton on 9/4/2017.
 */

public class MathOperation {

    private int result1;
    private int result2;
    private int result3;

    private List options;

    public MathOperation(ArrayList<Integer> pyramidNumbers){
        this.setResult1(calculateResultOfOperation(2,pyramidNumbers));
        this.setResult2(calculateResultOfOperation(4,pyramidNumbers));
        this.setResult3(calculateResultOfOperation(5,pyramidNumbers));
        this.setOptions(generateListOfOptions(pyramidNumbers));
    }

    private int calculateResultOfOperation(int lastIndex,ArrayList<Integer> pyramidNumbers){
        int result = 0;
        switch (lastIndex){
            case 2 :
                result = pyramidNumbers.get(0) + pyramidNumbers.get(1) +pyramidNumbers.get(2);
                break;
            case 4:
                result = pyramidNumbers.get(2) +pyramidNumbers.get(3) + pyramidNumbers.get(4);
                break;
            case 5:
                result = pyramidNumbers.get(4) + pyramidNumbers.get(5) +pyramidNumbers.get(0);
                break;
        }
        return result;
    }

    //This method creates options for the user to choose, and among this options, there are the four correct answers and some fake ass well.
    private List generateListOfOptions(ArrayList<Integer> pyramidNumbers){
        List<Integer> options = new ArrayList<>();
        options.add(pyramidNumbers.get(1));
        options.add(pyramidNumbers.get(3));
        options.add(pyramidNumbers.get(4));
        options.add(pyramidNumbers.get(5));

        //Generate random numbers beetween 0 and 19
        options.add((int) (Math.random() * 15));
        options.add((int) (Math.random() * 15));

        // Shuffling the list
        long seed = System.nanoTime();
        Collections.shuffle(options, new Random(seed));

        return options;
    }

    public int getResult1() {
        return result1;
    }

    public void setResult1(int result1) {
        this.result1 = result1;
    }

    public int getResult2() {
        return result2;
    }

    public void setResult2(int result2) {
        this.result2 = result2;
    }

    public int getResult3() {
        return result3;
    }

    public void setResult3(int result3) {
        this.result3 = result3;
    }

    public List getOptions() {
        return options;
    }

    public void setOptions(List options) {
        this.options = options;
    }
}
