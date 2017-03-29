package com.jibreelpowell.redbluegreen;


import android.content.Intent;

import com.jibreelpowell.redbluegreen.databinding.ActivityMainBinding;

/**
 * Created by jibreel on 3/27/17.
 */

public class MainActivityEventHandler {

    private final MainActivityViewModel viewModel;
    private final ActivityMainBinding binding;


    MainActivityEventHandler(MainActivityViewModel viewModel, ActivityMainBinding binding) {
        this.viewModel = viewModel;
        this.binding = binding;
    }

    public void onClick() {

        int r = Integer.decode(binding.redValue.getText().toString());
        int g = Integer.decode(binding.greenValue.getText().toString());
        int b = Integer.decode(binding.blueValue.getText().toString());
        viewModel.setColor(r, g, b);
    }
}
