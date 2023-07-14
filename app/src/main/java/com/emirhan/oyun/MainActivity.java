package com.emirhan.oyun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txt_soru, txt_sure, txt_puan;
    Button btn1, btn2, btn3, btn4, btn5, btn6;
    ArrayList<Button> butonlar = new ArrayList<>();
    Game game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oyunuKur();
    }

    private void oyunuKur(){
        txt_puan = findViewById(R.id.txt_puan);
        txt_soru = findViewById(R.id.txt_soru);
        txt_sure = findViewById(R.id.txt_sure);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);

        butonlar.add(btn1);
        butonlar.add(btn2);
        butonlar.add(btn3);
        butonlar.add(btn4);
        butonlar.add(btn5);
        butonlar.add(btn6);

        for (Button btn : butonlar) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(btn.getText().equals(game.getCevap())){
                        puanArttır();
                        soruGonder();
                    }
                    else{
                        soruGonder();
                    }

                }
            });
            
        }
        soruGonder();
        sayac.start();

    }

    private  void soruGonder(){
        game = new Game(butonlar, getApplicationContext());
        txt_soru.setText(game.getSoru());

    }

    private  void sureAzalt(){
        int suan = Integer.parseInt(txt_sure.getText().toString());
        suan--;
        txt_sure.setText("" + suan);

    }

    private  void puanArttır(){
        int puan = Integer.parseInt(txt_puan.getText().toString());
        puan++;
        txt_puan.setText("" + puan);

    }

    CountDownTimer sayac = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long l) {
            sureAzalt();

        }

        @Override
        public void onFinish() {
            Toast.makeText(MainActivity.this, "Oyun Bitti Puanınız " + txt_puan.getText().toString(), Toast.LENGTH_SHORT).show();
            finish();

        }
    };

}