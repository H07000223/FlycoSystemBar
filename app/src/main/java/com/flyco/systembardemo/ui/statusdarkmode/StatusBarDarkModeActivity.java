package com.flyco.systembardemo.ui.statusdarkmode;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.flyco.systembar.SystemBarHelper;
import com.flyco.systembardemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class StatusBarDarkModeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusbar_darkmode);
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (SystemBarHelper.isMIUI6Later() || SystemBarHelper.isFlyme4Later() || Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                SystemBarHelper.setStatusBarDarkMode(this);
                SystemBarHelper.tintStatusBar(this, Color.parseColor("#eaeaea"), 0);
            } else {
                SystemBarHelper.tintStatusBar(this, Color.parseColor("#bbbbbb"), 0);
            }
        }
    }

    @OnClick(R.id.back)
    public void back() {
        onBackPressed();
    }
}
