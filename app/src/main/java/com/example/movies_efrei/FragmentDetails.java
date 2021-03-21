package com.example.movies_efrei;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentDetails extends Fragment {
    public static final String TAG = "MovieDetails";

    private Movie movie;
    private Call<Page> pageCall;
    private Call<Images> imageCall;

    private RecyclerView recyclerViewGallery;
    private TextView textViewTitle;
    private TextView textViewOverview;

    private RecyclerView.LayoutManager galleryLayoutManager;
    private GalleryAdapter galleryAdapter;


    public FragmentDetails() {
    }

    public FragmentDetails(Movie movie){
        this.movie = movie;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_details, container, false);

        recyclerViewGallery = view.findViewById(R.id.recyclerView_Details_Gallery);
        textViewTitle = view.findViewById(R.id.textView_Details_Title);
        textViewOverview = view.findViewById(R.id.textView_Details_Overview);

        textViewTitle.setText(movie.getTitle());
        textViewOverview.setText(movie.getOverview());

        Button B_Add = view.findViewById(R.id.button_Details_Save);
        B_Add.setOnClickListener(v -> {
            Log.i("MyActivity", "buttonPressed");
            Snackbar mySnackbar = Snackbar.make(view, "Film ajouté !", 3000);
            mySnackbar.show();
        });


        getImages();
        return view;
    }

    private void getImages(){
        GetQueries getQuery = RetrofitObject.getRetrofit().create(GetQueries.class);

        imageCall = getQuery.getImages(movie.getId(), RetrofitObject.KEY);

        imageCall.enqueue(new Callback<Images>() {
            @Override
            public void onResponse(Call<Images> call, Response<Images> response) {
                if (galleryAdapter == null) {
                    galleryLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                    galleryAdapter = new GalleryAdapter(response.body(), getContext());
                    recyclerViewGallery.setLayoutManager(galleryLayoutManager);
                    recyclerViewGallery.setAdapter(galleryAdapter);
                } else {
                    galleryAdapter.updateImages(response.body());
                    galleryAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Images> call, @NotNull Throwable t) {

            }
        });
    }
}
