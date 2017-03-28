package jibreelpowell.com.redbluegreen;

import android.view.View;

import jibreelpowell.com.redbluegreen.databinding.ActivityMainBinding;

/**
 * Created by jibreel on 3/27/17.
 */

public class MainActivityEventHandler {

    private final MainActivityViewModel viewModel;
    private final ActivityMainBinding binding;

    public MainActivityEventHandler(MainActivityViewModel viewModel, ActivityMainBinding binding) {
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
