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

    //constructor
    public Pytanie(String trescPytania, String odpowiedzA, String odpowiedzB, String odpowiedzC, int poprawna) {
        this.trescPytania = trescPytania;
        this.odpowiedzA = odpowiedzA;
        this.odpowiedzB = odpowiedzB;
        this.odpowiedzC = odpowiedzC;
        this.poprawna = poprawna;
    }

    //getter


    public String getTrescPytania() {
        return trescPytania;
    }

    public String getOdpowiedzA() {
        return odpowiedzA;
    }

    public String getOdpowiedzB() {
        return odpowiedzB;
    }

    public String getOdpowiedzC() {
        return odpowiedzC;
    }

    public int getPoprawna() {
        return poprawna;
    }

    //setter

    public void setTrescPytania(String trescPytania) {
        this.trescPytania = trescPytania;
    }

    public void setOdpowiedzA(String odpowiedzA) {
        this.odpowiedzA = odpowiedzA;
    }

    public void setOdpowiedzB(String odpowiedzB) {
        this.odpowiedzB = odpowiedzB;
    }

    public void setOdpowiedzC(String odpowiedzC) {
        this.odpowiedzC = odpowiedzC;
    }

    public void setPoprawna(int poprawna) {
        this.poprawna = poprawna;
    }
}
