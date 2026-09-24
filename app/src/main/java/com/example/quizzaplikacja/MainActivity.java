package com.example.quizzaplikacja;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button buttonNastepne;
    RadioButton radioButtonA, radioButtonB, radioButtonC;
    RadioGroup radioGroup;
    TextView textViewTresc;

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

    }
}