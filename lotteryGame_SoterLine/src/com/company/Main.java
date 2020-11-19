package com.company;

import com.company.lotteryGame.LotteryGame;
import com.company.lotteryGame.LotteryFillingType;
import com.company.lotteryGame.Statistics;

public class Main {

    public static void main(String[] args) {

        LotteryNumbers lottoTicket = new LotteryNumbers(LotteryFillingType.AutomaticGeneration);
        System.out.println(lottoTicket);

        LotteryGame lotteryGame = new LotteryGame();
        int[] hits = lotteryGame.play(lottoTicket, 4);

        Statistics lottoStat = new Statistics(hits);
        System.out.println("Ratio of winning anything: " + lottoStat.ratioOfWinning());
    }
}
