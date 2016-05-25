package com.flyco.systembardemo.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyco.systembardemo.R;
import com.flyco.systembardemo.entity.DemoPager;
import com.flyco.systembardemo.ui.common.adapter.SingleTypeAdapter;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class HomeFragment extends Fragment {
    @Bind(R.id.recycler_view) RecyclerView mRecyclerView;
    @Bind(R.id.navigation) LinearLayout mNavigation;
    private Context mContext;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getActivity();

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showUi(Arrays.asList(DemoPager.values()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void showUi(List<DemoPager> demoPagers) {
        mNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = getActivity();
                if (activity instanceof HomeActivity) {
                    ((HomeActivity) activity).toggleDrawer();
                }
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(new SingleTypeAdapter<DemoPager>(demoPagers, R.layout.item_home_fragment) {
            @Override
            public void bindView(final ViewHolder holder, int position, View itemView) {
                TextView item = ButterKnife.findById(itemView, R.id.item);
                DemoPager demoPager = getDataList().get(holder.getAdapterPosition());
                item.setText(demoPager.mItem);
            }

            @Override
            public void handleClick(final ViewHolder holder) {
//                TextView item = ButterKnife.findById(holder.getItemView(), R.id.item);
//                item.setHandleClickListener(new View.OnClickListener() {
                holder.getItemView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DemoPager pager = getDataList().get(holder.getAdapterPosition());
                        startActivity(new Intent(getActivity(), pager.mClazz));
                    }
                });
            }
        });
    }
}
