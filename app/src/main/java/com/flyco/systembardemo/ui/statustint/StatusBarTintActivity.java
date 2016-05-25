package com.flyco.systembardemo.ui.statustint;

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

public class StatusBarTintActivity extends AppCompatActivity {
    private Context mContext = this;
    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.recycler_view) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusbar_tint);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("状态栏着色");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        SystemBarHelper.tintStatusBar(this, getResources().getColor(R.color.colorPrimary));

        ArrayList<String> mNames = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mNames.add("状态栏着色");
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
