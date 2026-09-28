package com.example.quizzaplikacja;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button buttonNastepne;
    RadioButton radioButtonA, radioButtonB, radioButtonC;
    RadioGroup radioGroup;
    TextView textViewTresc;
    List<Pytanie> listaPytanInternetowych;

    int numerPytania;
    int punkty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        buttonNastepne = findViewById(R.id.buttonNastepne);
        radioButtonA = findViewById(R.id.radioButtonA);
        radioButtonB = findViewById(R.id.radioButtonB);
        radioButtonC = findViewById(R.id.radioButtonC);
        textViewTresc = findViewById(R.id.trescPytaniaTxt);
        radioGroup = findViewById(R.id.radioGroup);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/JC354R/QuizServer/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
        Call<List<Pytanie>> call = jsonPlaceHolder.getPytania();
        call.enqueue(new Callback<List<Pytanie>>() {
            @Override
            public void onResponse(Call<List<Pytanie>> call, Response<List<Pytanie>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                listaPytanInternetowych = response.body();
                textViewTresc.setText("Pytanie: " + listaPytanInternetowych.get(0).getTrescPytania());
                wypiszPytanie(0);
            }

            @Override
            public void onFailure(Call<List<Pytanie>> call, Throwable t) {

            }
        });
        buttonNastepne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sprawczCzyDobrze(numerPytania);
                numerPytania++;

                if(numerPytania<listaPytanInternetowych.size()){
                    wypiszPytanie(numerPytania);
                }else{
                    //koniec testu
                    Toast.makeText(MainActivity.this, "Liczba punktow: " + punkty, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
        
        private boolean sprawczCzyDobrze(int numerPytania){
            int kliknieteId = radioGroup.getCheckedRadioButtonId();
            int indeksPoprawny = listaPytanInternetowych.get(numerPytania).getPoprawna();
            int[] indeksy = new int[]{
                    R.id.radioButtonA,
                    R.id.radioButtonB,
                    R.id.radioButtonC,
            };

            if(kliknieteId == indeksy[indeksPoprawny]){
                punkty++;
                return true;
            }
            return false;
        }
        
        private void wypiszPytanie(int numerPytania){
            radioGroup.clearCheck();
            textViewTresc.setText(listaPytanInternetowych.get(numerPytania).getTrescPytania());
            radioButtonA.setText(listaPytanInternetowych.get(numerPytania).getOdpowiedzA());
            radioButtonB.setText(listaPytanInternetowych.get(numerPytania).getOdpowiedzB());
            radioButtonC.setText(listaPytanInternetowych.get(numerPytania).getOdpowiedzC());
        }

    }
