package com.company.lotteryGame;

public class Statistics {
    private int[] hits;

    public Statistics(int[] hits) {
        this.hits = hits;
    }

    public double ratioOfWinning(){
        double totalRatioOfWinning = 0;
        for (int hit : hits) {
            if (hit > 0) {
                ++totalRatioOfWinning;
            }
        }
        totalRatioOfWinning /= hits.length;
        return totalRatioOfWinning;
    }
}
