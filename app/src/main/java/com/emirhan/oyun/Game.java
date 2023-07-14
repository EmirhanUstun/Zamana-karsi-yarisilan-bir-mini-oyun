package com.emirhan.oyun;

import android.content.Context;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private OyunTipi oyunTipi;
    private String soru;
    private String cevap;

    public String getSoru() {
        return soru;
    }

    public String getCevap() {
        return cevap;
    }

    public Game(ArrayList<Button> butonlar, Context context){
        oyunTipi = Util.oyunTipiUret();
        ArrayList <Integer> numbers = new ArrayList<>();
        ArrayList <Integer> colors = Util.randomList(1, 6);

        for (int i = 0; i <6 ; i++) {
            int color = Util.findColorr(colors.get(i), context);
            butonlar.get(i).setBackgroundColor(color);
            
        }

        if (oyunTipi == OyunTipi.COLOR){
            numbers = Util.randomList(1,6);

            for (int i = 0; i <6 ; i++) {
                String colorName = Util.findColor(numbers.get(i), context);
                butonlar.get(i).setText(colorName);

            }

            int rastgeleCevap = Util.sayiUret(0,5);
            cevap = butonlar.get(rastgeleCevap).getText().toString();
            soru = cevap + " Yazısını Bulunuz";

        }
        else
        {
            numbers = Util.randomList(5999,6799);
            for (int i = 0; i <6 ; i++) {
                butonlar.get(i).setText(numbers.get(i).toString());

            }
            if (oyunTipi == OyunTipi.MIN){
                cevap ="" + Collections.min(numbers);
                soru = "En Küçük Sayıyı Bulunuz";

            }
            else if (oyunTipi == OyunTipi.MAX){
                cevap ="" + Collections.max(numbers);
                soru = "En Büyük Sayıyı Bulunuz";

            }
        }

    }

}
