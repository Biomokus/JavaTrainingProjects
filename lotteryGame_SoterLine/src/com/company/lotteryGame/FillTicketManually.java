package com.company.lotteryGame;

import java.util.Scanner;

public class FillTicketManually extends CheckIfNumberAlreadyGenerated {

    public static boolean invalidLotteryNumber(int givenNumber){
        if(givenNumber >=1 && givenNumber <= 90){
            return false;
        }
        return true;
    }

    public static int[] fill(){
        Scanner sc = new Scanner(System.in);
        int[] tempNumbers = new int[5];
        for (int i = 0; i <= 4; i++) {
            System.out.println("Please type a lottery number from 1 to 90!");
            tempNumbers[i] = sc.nextInt();
            if(invalidLotteryNumber(tempNumbers[i]) || numberAlreadyCreated(tempNumbers, i)){
                System.out.println("Please type a proper number!");
                --i;
            }
        }
        return tempNumbers;
    }
}
