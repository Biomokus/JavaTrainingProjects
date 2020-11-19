package com.company;

import com.company.lotteryGame.FillTicketManually;
import com.company.lotteryGame.LotteryFillingType;
import com.company.lotteryGame.FillTicketAutomatically;

public class LotteryNumbers {

    private int[] givenNumbers = null;

    public LotteryNumbers(LotteryFillingType generation){
        if (generation == LotteryFillingType.AutomaticGeneration){
            givenNumbers = FillTicketAutomatically.generateLotteryNumbers();
        } else if (generation == LotteryFillingType.ManualGeneration){
            givenNumbers = FillTicketManually.fill();
        }
    }

    @Override
    public String toString() {
        String lotteryNumbers = "";
        for (int i = 0; i < givenNumbers.length; i++) {
            lotteryNumbers += "Lotterynumber " + (i+1) + " is: " + givenNumbers[i] + System.lineSeparator();
        }
        return lotteryNumbers;
    }

    public int getLength(){
        return givenNumbers.length;
    }

    public int getNumber(int index){
        return givenNumbers[index];
    }
}

