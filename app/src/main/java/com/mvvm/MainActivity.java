package com.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{

    MovieViewModel movieViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        movieViewModel.movieNameMutableLiveData.observe(this, new Observer<String>()
        {
            @Override
            public void onChanged(String s)
            {
                binding.textView.setText(s);
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                movieViewModel.getMovieName();
            }
        });



    }
}