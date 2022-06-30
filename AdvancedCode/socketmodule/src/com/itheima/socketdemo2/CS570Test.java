package com.itheima.socketdemo2;

import java.util.Arrays;

public class CS570Test {
    public static void main(String[] args) {
        int[][] manPref = {{1,0,2},   //manPref[0][] for John, 0 is John's index, {Eva, Luna, Mia}, he like Eva most, and then Luna, Mia is the last
                           {0,2,1},   //manPref[1][] for Jack, 1 is Jack's index
                           {2,0,1}};   //manPref[2][] for Tom,  2 is Tom's index
        int[][] womanPref = {{0,1,2}, //womanPref[0][] for Luna, 0 is Luna's index, {John, Jack, Tom} she like John most, and then Jack, Tom is the last
                            {2,0,1}, //womanPref[1][] for Eva, 1 is Luna's index, {Tom, John, Jack} Eva like Tom most, and then John, Jack is the last
                            {0,2,1}}; //womanPref[2][] for Mia, 2 is Luna's index
        String[] men = {"John","Jack","Tom"};
        String[] women = {"Luna","Eva","Mia"};

        int[][] womanPref2 = new int[womanPref.length][womanPref[0].length];
//Preparation
        System.out.println(Arrays.deepToString(womanPref2));
        for(int i = 0; i < womanPref.length ; i++) {
            for(int j = 0; j < womanPref[0].length; j++){
                womanPref2[i][womanPref[i][j]] = j; // i is the woman's index, womanPref[i][j] is man's index that she jth like, j is the rank of the man in woman i's mind
            }
        }
        System.out.println("womanPref:");
        System.out.println(Arrays.deepToString(womanPref));
        System.out.println("womanPref2:");
        System.out.println(Arrays.deepToString(womanPref2));

        //Tom propos to Eva. John is her current mate. Who will stay engaging with Eva?
        int ppMan = 2; //Tom is the man that proposing on this turn of iteration
        int ppedWoman = 1; //Eva is the woman be proposed
        int curEvaMan = 0; //John is current guy with Eva
        System.out.println(women[ppedWoman]+" engaged with "+men[curEvaMan]+" before this iteration");
        System.out.println("In this iteration, "+men[ppMan]+" propose to "+women[ppedWoman]);
        System.out.println("The best(smallest) rank in Eva's list is "+Math.min(womanPref2[ppedWoman][ppMan],womanPref2[ppedWoman][curEvaMan]));
        System.out.println("That best guy's index is "+womanPref[ppedWoman][Math.min(womanPref2[ppedWoman][ppMan],womanPref2[ppedWoman][curEvaMan])]);
        curEvaMan = womanPref[ppedWoman][Math.min(womanPref2[ppedWoman][ppMan],womanPref2[ppedWoman][curEvaMan])];
        System.out.println("So after this interation, "+women[ppedWoman]+" engage "+men[curEvaMan]+" now.");
    }

}
