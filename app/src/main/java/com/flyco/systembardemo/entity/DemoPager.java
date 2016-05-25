package com.flyco.systembardemo.entity;

import android.support.v7.app.AppCompatActivity;

import com.flyco.systembardemo.ui.statusdarkmode.StatusBarDarkModeActivity;
import com.flyco.systembardemo.ui.statusimmersive.StatusBarImmersive2Activity;
import com.flyco.systembardemo.ui.statusimmersive.StatusBarImmersive1Activity;
import com.flyco.systembardemo.ui.statusimmersive.StatusBarImmersive3Activity;
import com.flyco.systembardemo.ui.statustint.StatusBarTintActivity;

import java.io.Serializable;

public enum DemoPager implements Serializable {
    STATUSBAR_TINT("状态栏着色", StatusBarTintActivity.class),
    STATUSBAR_IMMERSIVE_1("沉浸式状态栏1", StatusBarImmersive1Activity.class),
    STATUSBAR_IMMERSIVE_2("沉浸式状态栏2", StatusBarImmersive2Activity.class),
    STATUSBAR_IMMERSIVE_3("沉浸式状态栏3", StatusBarImmersive3Activity.class),
    STATUSBAR_DARKMODE("状态栏DarkMode(黑色字体icon)\n支持MIUI6+,Flyme4+,Android6.0+", StatusBarDarkModeActivity.class),;

    public String mItem;
    public Class<? extends AppCompatActivity> mClazz;

    DemoPager(String item, Class<? extends AppCompatActivity> clazz) {
        mItem = item;
        mClazz = clazz;
    }
}
