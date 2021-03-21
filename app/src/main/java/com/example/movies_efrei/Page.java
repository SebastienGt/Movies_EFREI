package com.example.movies_efrei;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

public class Page implements Serializable {

    private ArrayList<Movie> results;

    public Page(ArrayList<Movie> results) {

        this.results = results;
    }


    public ArrayList<Movie> getResults() {
        return results;
    }

}
