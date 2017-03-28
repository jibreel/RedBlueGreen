package jibreelpowell.com.redbluegreen;

import android.graphics.Color;

import jibreelpowell.com.redbluegreen.databinding.ActivityMainBinding;

/**
 * Created by jibreel on 3/24/17.
 */

public class MainActivityViewModel {

    private final ActivityMainBinding binding;

    public MainActivityViewModel(ActivityMainBinding binding) {
        this.binding = binding;
    }

    public void setColor(int r, int g, int b) {

        r = Math.min(r, 255);
        g = Math.min(g, 255);
        b = Math.min(b, 255);
        binding.canvas.setBackgroundColor(Color.rgb(r, g, b));
    }
}
