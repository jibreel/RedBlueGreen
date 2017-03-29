package com.jibreelpowell.redbluegreen;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Color;
import android.graphics.drawable.Icon;

import com.jibreelpowell.redbluegreen.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by jibreel on 3/24/17.
 */

public class MainActivityViewModel {

    private final ActivityMainBinding binding;
    private final Activity activity;

    public MainActivityViewModel(ActivityMainBinding binding, Activity activity) {
        this.binding = binding;
        this.activity = activity;
    }

    public void setColor(int r, int g, int b) {
        r = Math.min(r, 255);
        g = Math.min(g, 255);
        b = Math.min(b, 255);
        addShortcut(r, g, b);
        setColor(Color.rgb(r, g, b));
    }

    public void setColor(int color) {
        binding.canvas.setBackgroundColor(color);
    }

    public void addShortcut(int r, int g, int b) {
        ShortcutManager shortcutManager = activity.getSystemService(ShortcutManager.class);

        String label = String.format("(%s, %s, %s)", r, b, g);

        ShortcutInfo shortcutInfo = new ShortcutInfo.Builder(activity, "custom_shortcut")
                .setShortLabel(label)
                .setLongLabel("Show me " + label)
                .setIntent(MainActivity.newIntent(r, g, b, activity))
                .setIcon(Icon.createWithResource(activity, R.drawable.ic_brush_black_24dp))
                .build();

        shortcutManager.setDynamicShortcuts(Arrays.asList(shortcutInfo));
        shortcutManager.enableShortcuts(Arrays.asList("custom_shortcut"));
    }
}
