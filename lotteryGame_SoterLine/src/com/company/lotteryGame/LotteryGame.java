package com.company.lotteryGame;

import com.company.LotteryNumbers;

public class LotteryGame {

    public LotteryGame(){
    }

    public int[] play(LotteryNumbers myTicket, int numberOfWeeks){
        int[] hits = new int[numberOfWeeks];
        for (int i = 0; i < numberOfWeeks; i++) {
            LotteryNumbers weeklyWinningNumbers = new LotteryNumbers(LotteryFillingType.AutomaticGeneration);
            hits[i] = checkLotteryHits(myTicket, weeklyWinningNumbers);
            System.out.println("You have " + hits[i] + " hits in week No." + (i+1) +".");
        }
        return hits;
    }

    public static int checkLotteryHits(LotteryNumbers playedNumbers, LotteryNumbers generatedNumbers){

        int hit = 0;
        for (int i = 0; i < playedNumbers.getLength(); i++) {
            int actualNumber = playedNumbers.getNumber(i);
            for (int j = 0; j < generatedNumbers.getLength(); j++) {
                int winningNumber = generatedNumbers.getNumber(j);
                if (actualNumber == winningNumber){
                    ++hit;
                }
            }
        }
        return hit;
    }
}
