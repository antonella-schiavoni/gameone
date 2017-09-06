package guessme.ppc2017.unnoba.edu.ar.gameone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by anton on 9/4/2017.
 */

public class MathOperation {
    // Addition constant. As it is a pyramid of sums, the only operator we have is addition.
    private ArrayList<Integer> numbers;
    private int result1;
    private int result2;
    private int result3;
    private List options;

    public MathOperation(ArrayList<Integer> pyramidNumbers){
        setNumbers(new ArrayList<Integer>());
        this.setNumbers(pyramidNumbers);
        this.setResult1(calculateResultOfOperation(0,2));
        this.setResult1(calculateResultOfOperation(2,5));
        this.setResult1(calculateResultOfOperation(5,6));
        this.setOptions(generateListOfOptions());
    }

    private int calculateResultOfOperation(int firstIndex,int lastIndex){
        int result = 0;
        switch (lastIndex){
            case 2 :
                result = getNumbers().get(0) + getNumbers().get(1) + getNumbers().get(2);
                break;
            case 5:
                result = getNumbers().get(2) + getNumbers().get(3) + getNumbers().get(4) + getNumbers().get(5);
                break;
            case 6:
                result = getNumbers().get(5) + getNumbers().get(6) + getNumbers().get(0);
                break;
        }
        return result;
    }

    //This method creates options for the user to choose, and among this options, there are the four correct answers and some fake ass well.
    private List generateListOfOptions(){
        List<Integer> options = new ArrayList<>();
        options.add(getNumbers().get(1));
        options.add(getNumbers().get(3));
        options.add(getNumbers().get(4));
        options.add(getNumbers().get(5));

        //Generate random numbers beetween 0 and 19
        options.add((int) (Math.random() * 20));
        options.add((int) (Math.random() * 20));

        // Shuffling the list
        long seed = System.nanoTime();
        Collections.shuffle(options, new Random(seed));

        return options;
    }


    private ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
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
