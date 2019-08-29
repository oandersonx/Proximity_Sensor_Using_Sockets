package com.example.pasid.trabalhosdsensores;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.PrintWriter;

import java.net.Socket;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private static Socket socket;
    //private static ServerSocket ssocket;
    private static InputStreamReader inputSR;
    private static BufferedReader br;
    private static PrintWriter printWriter;

    //Sensor acelerometro;
    Sensor mProx;
    SensorManager sensorManager;
    TextView sensorprox;

    boolean power;

    String dlog="", esp="\n";

    String message = "Deu certo!";
    private String ip = "192.168.43.174";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //sensorManager.registerListener(new ProxSensor(), mProx, SensorManager.SENSOR_DELAY_UI);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mProx = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensorManager.registerListener(this, mProx, SensorManager.SENSOR_DELAY_FASTEST);//SENSOR_DELAY_UI
        //power=true;
        Toast.makeText(getApplicationContext(), "Iniciou", Toast.LENGTH_LONG).show();


    }

    @Override
    public void onSensorChanged(SensorEvent event) {

            if (event.values[0] == 0) {
                dlog="Proximo";
                getWindow().getDecorView().setBackgroundColor(Color.RED);
                myTask task = new myTask();
                task.execute();
                Toast.makeText(getApplicationContext(), "Finalizou "+event.values[0], Toast.LENGTH_LONG).show();

            } else {
                dlog="n";
                getWindow().getDecorView().setBackgroundColor(Color.GREEN);
            }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public class myTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                socket = new Socket(ip, 7003);
                printWriter = new PrintWriter(socket.getOutputStream());
                printWriter.write(dlog); //Envio

                printWriter.flush();
                printWriter.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
