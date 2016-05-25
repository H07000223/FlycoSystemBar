package com.flyco.systembardemo.ui.statusimmersive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.flyco.systembar.SystemBarHelper;
import com.flyco.systembardemo.R;

public class StatusBarImmersive1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusbar_immersive_1);
        SystemBarHelper.immersiveStatusBar(this);
    }
}
