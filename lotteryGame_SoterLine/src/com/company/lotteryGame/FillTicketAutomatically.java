package com.company.lotteryGame;

import java.util.Random;

public class FillTicketAutomatically extends CheckIfNumberAlreadyGenerated {

    public static int[] generateLotteryNumbers(){
        Random random = new Random();
        int[] tempNumbers = new int[5];
        for (int i = 0; i <= 4; i++) {
            int newNumber = random.nextInt(90)+1;
            tempNumbers[i] = newNumber;
            if(numberAlreadyCreated(tempNumbers, i)){
                --i;
            }
        }
        return tempNumbers;
    }

}
