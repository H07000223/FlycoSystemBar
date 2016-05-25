package com.flyco.systembardemo.ui.statusimmersive;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.flyco.systembar.SystemBarHelper;
import com.flyco.systembardemo.R;
import com.flyco.systembardemo.ui.common.adapter.SingleTypeAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StatusBarImmersive2Activity extends AppCompatActivity {
    private Context mContext = this;
    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.recycler_view) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusbar_immersive_2);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("H07000223");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //method 1
        SystemBarHelper.immersiveStatusBar(this);
        SystemBarHelper.setHeightAndPadding(this, mToolbar);

        //method 2,分别处理4.4调用SystemBarHelper方法,5.0以上使用系统方法
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//            SystemBarHelper.immersiveStatusBar(this);
//            SystemBarHelper.setHeightAndPadding(this, mToolbar);
//        }

        ArrayList<String> mNames = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mNames.add("状态栏沉浸");
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(new SingleTypeAdapter<String>(mNames, R.layout.item_home_fragment) {
            @Override
            public void bindView(ViewHolder holder, int position, View itemView) {
                TextView mItem = ButterKnife.findById(itemView, R.id.item);
                mItem.setText(getDataList().get(holder.getAdapterPosition()) + "-" + holder.getAdapterPosition());
            }
        });
    }
}
