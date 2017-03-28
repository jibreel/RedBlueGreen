package com.jibreelpowell.redbluegreen;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jibreelpowell.redbluegreen.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private static final String RED_ACTION = "com.jibreelpowell.redbluegreen.RED";
    private static final String GREEN_ACTION = "com.jibreelpowell.redbluegreen.GREEN";
    private static final String BLUE_ACTION = "com.jibreelpowell.redbluegreen.BLUE";

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MainActivityViewModel viewModel = new MainActivityViewModel(binding);
        MainActivityEventHandler eventHandler = new MainActivityEventHandler(viewModel, binding);
        binding.setEventHandler(eventHandler);


        String action = getIntent().getAction();

        switch (action) {
            case RED_ACTION :
                viewModel.setColor(Color.RED);
                break;
            case GREEN_ACTION :
                viewModel.setColor(Color.GREEN);
                break;
            case BLUE_ACTION :
                viewModel.setColor(Color.BLUE);
                break;
        }
    }
}
