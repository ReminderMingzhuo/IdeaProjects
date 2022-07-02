package com.itheima.socketdemo2;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class CS570Test {
    public static void main(String[] args) {
        //Input
        int[][] manPref = {{1,0,2},   //manPref[0][] for John, 0 is John's index, {Eva, Luna, Mia}, he like Eva most, and then Luna, Mia is the last
                           {0,2,1},   //manPref[1][] for Jack, 1 is Jack's index
                           {1,2,0}};   //manPref[2][] for Tom,  2 is Tom's index
        int[][] womanPref = {{0,1,2}, //womanPref[0][] for Luna, 0 is Luna's index, {John, Jack, Tom} she like John most, and then Jack, Tom is the last
                            {2,0,1}, //womanPref[1][] for Eva, 1 is Luna's index, {Tom, John, Jack} Eva like Tom most, and then John, Jack is the last
                            {1,0,2}}; //womanPref[2][] for Mia, 2 is Luna's index
        String[] men = {"John","Jack","Tom"};
        String[] women = {"Luna","Eva","Mia"};
        //Step one preparation
        Queue<Integer> menList = new ConcurrentLinkedDeque<>();
        for(int i = 0; i < men.length;i++){
            menList.add(i);
        }
        //Step two preparation
        int[] curBestForHimRank = new int[men.length]; //initial value is 0, from top 1 in men's heart
        //Step three preparation
        int[] womenEngaged = new int[women.length];//if 0, not engaged; if 1, already engaged
        int[] theirCurMen = new int[women.length];
        //Step four preparation
        int[][] womanPref2 = new int[womanPref.length][womanPref[0].length];
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
        //start algorithm
        int iteration = 0;
        while(!menList.isEmpty()){
            System.out.println("----------------------"+iteration+"th iteration--------------------------------");
            int ppMan = menList.poll();
            if(womenEngaged[manPref[ppMan][curBestForHimRank[ppMan]]] == 0){ //if she has no mate
                theirCurMen[manPref[ppMan][curBestForHimRank[ppMan]]] = ppMan;
                womenEngaged[manPref[ppMan][curBestForHimRank[ppMan]]] = 1;
            }else { //okay, she already has someone, let her pick one to stay, loser go back to queue
                while (curBestForHimRank[ppMan] < men.length && !MatchNext(ppMan, manPref[ppMan][curBestForHimRank[ppMan]], theirCurMen, men, women, womanPref, womanPref2, menList)) {
                    curBestForHimRank[ppMan]++;
                }
            }
            iteration++;
        }
        for(int i = 0;i<theirCurMen.length;i++){
            System.out.println(women[i]+" engaged with "+men[theirCurMen[i]]);
        }
    }
    static boolean MatchNext(int ppMan, int ppedWoman, int[] theirCurMen,String[] men, String[] women, int[][] womanPref, int[][] womanPref2,Queue<Integer> queue){
        //Tom propos to Eva. John is her current mate. Who will stay engaging with Eva?
//        int ppMan = 2; //Tom is the man that proposing on this turn of iteration
//        int ppedWoman = 1; //Eva is the woman be proposed
//        int theirCurMen = 0; //John is current guy with Eva
        int herPreMan = theirCurMen[ppedWoman];
        System.out.println(women[ppedWoman]+" engaged with "+men[herPreMan]+" before this iteration");
        System.out.println("In this iteration, "+men[ppMan]+" propose to "+women[ppedWoman]);
        System.out.println("The best(smallest) rank in Eva's list is "+Math.min(womanPref2[ppedWoman][ppMan],womanPref2[ppedWoman][herPreMan]));
        System.out.println("That best guy's index is "+womanPref[ppedWoman][Math.min(womanPref2[ppedWoman][ppMan],womanPref2[ppedWoman][herPreMan])]);
        theirCurMen[ppedWoman] = womanPref[ppedWoman][Math.min(womanPref2[ppedWoman][ppMan],womanPref2[ppedWoman][herPreMan])];
        System.out.println("So after this interation, "+women[ppedWoman]+" engage "+men[herPreMan]+" now.");
        if(theirCurMen[ppedWoman] == ppMan){
            queue.add(herPreMan);
            return true;
        }
        return false;
    }
}
