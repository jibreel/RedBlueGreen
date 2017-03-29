package com.jibreelpowell.redbluegreen;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jibreelpowell.redbluegreen.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private static final String KEY_RED_VALUE = "red";
    private static final String KEY_BLUE_VALUE = "blue";
    private static final String KEY_GREEN_VALUE = "green";

    private static final String RED_ACTION = "com.jibreelpowell.redbluegreen.RED";
    private static final String GREEN_ACTION = "com.jibreelpowell.redbluegreen.GREEN";
    private static final String BLUE_ACTION = "com.jibreelpowell.redbluegreen.BLUE";
    private static final String USER_COLOR_ACTION = "com.jibreelpowell.redbluegreen.USER_COLOR";

    ActivityMainBinding binding;

    public static Intent newIntent(int r, int g, int b, Context context) {
        Intent intent = new Intent();
        intent.setClass(context, MainActivity.class);
        intent.setAction(USER_COLOR_ACTION);
        intent.putExtra(KEY_RED_VALUE, r);
        intent.putExtra(KEY_GREEN_VALUE, g);
        intent.putExtra(KEY_BLUE_VALUE, b);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MainActivityViewModel viewModel = new MainActivityViewModel(binding, this);
        MainActivityEventHandler eventHandler = new MainActivityEventHandler(viewModel, binding);
        binding.setEventHandler(eventHandler);

        Intent intent = getIntent();
        String action = intent.getAction();

        switch (action) {
            case RED_ACTION :
                viewModel.setColor(Color.RED);
                binding.redValue.setText("255");
                binding.blueValue.setText("0");
                binding.greenValue.setText("0");
                break;
            case GREEN_ACTION :
                binding.redValue.setText("0");
                binding.blueValue.setText("0");
                binding.greenValue.setText("255");
                viewModel.setColor(Color.GREEN);
                break;
            case BLUE_ACTION :
                binding.redValue.setText("0");
                binding.blueValue.setText("255");
                binding.greenValue.setText("0");
                viewModel.setColor(Color.BLUE);
                break;
            case USER_COLOR_ACTION:
                int r = intent.getIntExtra(KEY_RED_VALUE, 0);
                int g = intent.getIntExtra(KEY_GREEN_VALUE, 0);
                int b = intent.getIntExtra(KEY_BLUE_VALUE, 0);
                binding.redValue.setText(String.valueOf(r));
                binding.greenValue.setText(String.valueOf(g));
                binding.greenValue.setText(String.valueOf(b));
                viewModel.setColor(r, g, b);
                break;
        }
    }
}
