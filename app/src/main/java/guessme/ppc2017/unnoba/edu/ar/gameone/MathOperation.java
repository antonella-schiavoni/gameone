package guessme.ppc2017.unnoba.edu.ar.gameone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by anton on 9/4/2017.
 */

public class MathOperation {

    private int[] results = new int[3];

    private List options;

    public MathOperation(ArrayList<Integer> pyramidNumbers){
        getResults()[0] = calculateResultOfOperation(2,pyramidNumbers);
        getResults()[1] = calculateResultOfOperation(4,pyramidNumbers);
        getResults()[2] = calculateResultOfOperation(5,pyramidNumbers);
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
        options.add(pyramidNumbers.get(5));

        int maxRandom = Configuration.getConfig().getUpperLimit();

        options.add((int) (Math.random() * maxRandom));
        options.add((int) (Math.random() * maxRandom));
        options.add((int) (Math.random() * maxRandom));

        // Shuffling the list
        long seed = System.nanoTime();
        Collections.shuffle(options, new Random(seed));

        return options;
    }

    public List getOptions() {
        return options;
    }

    public void setOptions(List options) {
        this.options = options;
    }

    public int[] getResults() {
        return results;
    }
}
