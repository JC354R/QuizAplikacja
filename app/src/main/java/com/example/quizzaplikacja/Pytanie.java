package com.example.quizzaplikacja;

import com.google.gson.annotations.SerializedName;

public class Pytanie {
    @SerializedName("tresc")
    private String trescPytania;

    @SerializedName("odpA")
    private String odpowiedzA;

    @SerializedName("odpB")
    private String odpowiedzB;

    @SerializedName("odpC")
    private String odpowiedzC;

    private int poprawna;
}
