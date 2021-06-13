package com.company;

public class PourWater {

    public PourWater() {

    }

    //  You are also given two integers volume and k. volume units of water will fall at index k
    public int[] pourWater(int[] heights, int volume, int k) {
        int size = heights.length;
        // starting index is k
        // will need to pour water == volume

        int[] water = new int[size];

        int waterRemaining = volume;


        while(waterRemaining>0) {
            // start from k
            int pos = k;
            // go to left first
            while(pos-1>=0 && heights[pos-1]+water[pos-1]<=heights[pos]+water[pos]) {
                pos-=1;
            }
            // then go to right
            while(pos+1<size && heights[pos+1]+water[pos+1]<=heights[pos]+water[pos]) {
                pos+=1;
            }
            // go back to as close as to k
            while(pos>k && pos-1>=0 && heights[pos-1]+water[pos-1]<=heights[pos]+water[pos]) {
                pos-=1;
            }
            water[pos] +=1;
            waterRemaining-=1;
        }
        // to print the result
        print(heights, water);

        int[] res = new int[size];
        for(int i=0; i<size; i++) {
            res[i] = heights[i]+water[i];
        }
        return heights;
    }

    public void print(int[] heights, int[] water) {
        int maxHeight = heights[0]+water[0];
        int size = water.length;
        for(int i=1; i<size; i++){
            maxHeight = Math.max(maxHeight, heights[i]+water[i]);
        }

        for(int curHeight=maxHeight; curHeight>0; curHeight--) {
            for(int j=0; j<size; j++) {
                if(curHeight<=heights[j]) {
                    System.out.print("+");
                } else if(curHeight>heights[j] && curHeight<=heights[j]+water[j]) {
                    System.out.print("W");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
