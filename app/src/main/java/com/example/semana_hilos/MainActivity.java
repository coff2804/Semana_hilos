package com.example.semana_hilos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean is_start = false;
    private int contador = 0;
    private TextView tvContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvContador = findViewById(R.id.tvContador);
    }

    public void onClickHiloPrincipal(View view) {
        is_start = true;
        while (is_start) {
            contador++;
            tvContador.setText(String.valueOf(tvContador));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void onClickHiloSecundario(View view) {
        is_start = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (is_start) {
                    contador++;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvContador.setText(String.valueOf(contador));
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    public void onClickHiloSecundarioFinal(View view) {
        if (!is_start) {

            is_start = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (is_start) {
                        contador++;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvContador.setText(String.valueOf(contador));
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}