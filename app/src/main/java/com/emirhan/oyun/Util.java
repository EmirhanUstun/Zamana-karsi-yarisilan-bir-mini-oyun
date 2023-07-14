package com.emirhan.oyun;

import android.content.Context;

import java.util.ArrayList;

public class Util {

    public static int sayiUret(int first, int end) {

        return first + (int)(Math.random() * ((end-first) +1 ));

    }


    public static OyunTipi oyunTipiUret () {

        int uretilen = sayiUret(1,3);
        switch (uretilen) {
            case 1:
                return OyunTipi.MIN;
            case 2:
                return OyunTipi.MAX;
            default:
                return OyunTipi.COLOR;

        }

    }


    public static ArrayList<Integer> randomList(int first, int end){

        ArrayList<Integer> numbers = new ArrayList<>();

        while(numbers.size()<6) {
            int uretilen = sayiUret(first, end);
            if (!numbers.contains(uretilen)) {

                numbers.add(uretilen);
            }
            else {
                continue;
            }

        }
        return numbers;
    }

    public static String findColor(int index, Context context){

        switch(index){
            case 1:
                return context.getResources().getString(R.string.red);
            case 2:
                return context.getResources().getString(R.string.blue);
            case 3:
                return context.getResources().getString(R.string.orange);
            case 4:
                return context.getResources().getString(R.string.yellow);
            case 5:
                return context.getResources().getString(R.string.purple);
            default:
                return context.getResources().getString(R.string.green);
        }

    }

    public static int findColorr(int index, Context context){

        switch(index){
            case 1:
                return context.getResources().getColor(R.color.red);
            case 2:
                return context.getResources().getColor(R.color.blue);
            case 3:
                return context.getResources().getColor(R.color.orange);
            case 4:
                return context.getResources().getColor(R.color.yellow);
            case 5:
                return context.getResources().getColor(R.color.purple);
            default:
                return context.getResources().getColor(R.color.green);
        }

    }

}
