package jrbprojects.vxmanager2018;

import java.util.Random;

/**
 * Created by Jack on 23/05/2017.
 * Contains functions to be used within app.
 */

public class Utilities {

    //random function initialisation
    Random rand = new Random();



    //produces a random number between 0.1 and 1
    public double random() {
        double max = 1;
        double min = 0.1;

        double randomNumber = rand.nextDouble();
        double result = min+(randomNumber*(max-min));

        return result;
    }

    //produces a random penalty value for a quarter based off of the
    //foul probability.
    public double randomPenalty(int foulProbability) {
        double rand = random();
        double randPenFactor = rand*30;

        double rawValueD = ((foulProbability/100)*randPenFactor)*(GlobalVars.getPenaltyPoints());
        int rawValueI = round(rawValueD);

        int realValue = roundThree(rawValueI);

        return realValue;
    }

    //rounds the inputted double into a integer.
    public int round(double number) {
        int a = (int)Math.round(number);
        return a;
    }

    //rounds the inputted integer to the nearest multiple of 3
    public int roundThree(int num) {
        int temp = num%3;
        if (temp<2)
            return num-temp;
        else
            return num+3-temp;
    }

}
