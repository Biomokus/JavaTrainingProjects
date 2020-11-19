package com.company.lotteryGame;

public abstract class CheckIfNumberAlreadyGenerated {

    protected static boolean numberAlreadyCreated(int[] givenNumbers, int toThisPoint){
        for (int j = 0; j < toThisPoint ; j++) {
            if (givenNumbers[j] == givenNumbers[toThisPoint]) {
                System.out.println("This number has been already used, please create a new random number!");
                return true;
            }
        }
        return false;
    }
}
