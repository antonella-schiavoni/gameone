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

    private int number1;
    private int number2;
    private int number3;
    private int number4;
    private int number5;
    private int number6;


    private List options;

    public MathOperation(ArrayList<Integer> pyramidNumbers){
        this.setNumber1(pyramidNumbers.get(0));
        this.setNumber2(pyramidNumbers.get(1));
        this.setNumber3(pyramidNumbers.get(2));
        this.setNumber4(pyramidNumbers.get(3));
        this.setNumber5(pyramidNumbers.get(4));
        this.setNumber6(pyramidNumbers.get(5));
        this.setResult1(calculateResultOfOperation(0,2,pyramidNumbers));
        this.setResult2(calculateResultOfOperation(2,4,pyramidNumbers));
        this.setResult3(calculateResultOfOperation(4,5,pyramidNumbers));
        this.setOptions(generateListOfOptions(pyramidNumbers));
    }

    private int calculateResultOfOperation(int firstIndex,int lastIndex,ArrayList<Integer> pyramidNumbers){
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


    public ArrayList<Integer> getNumbers() {
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

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getNumber3() {
        return number3;
    }

    public void setNumber3(int number3) {
        this.number3 = number3;
    }

    public int getNumber4() {
        return number4;
    }

    public void setNumber4(int number4) {
        this.number4 = number4;
    }

    public int getNumber5() {
        return number5;
    }

    public void setNumber5(int number5) {
        this.number5 = number5;
    }

    public int getNumber6() {
        return number6;
    }

    public void setNumber6(int number6) {
        this.number6 = number6;
    }

    public List getOptions() {
        return options;
    }

    public void setOptions(List options) {
        this.options = options;
    }
}
