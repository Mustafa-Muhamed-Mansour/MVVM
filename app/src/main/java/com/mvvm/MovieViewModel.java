package com.mvvm;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MovieViewModel extends ViewModel
{

    public MutableLiveData<String> movieNameMutableLiveData = new MutableLiveData<>();

    private MovieModel getMovieFromDatabase()
    {
        return new MovieModel(1, "Spider Man", "16-08-2021", "Spider Man Gamed Gdn & Awy B2a");
    }

    public void getMovieName()
    {
        String movieName = getMovieFromDatabase().getName();
        movieNameMutableLiveData.setValue(movieName);
    }
}
