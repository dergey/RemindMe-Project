package com.zhuravlev.sergey.auction.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhuravlev.sergey.auction.R;
import com.zhuravlev.sergey.auction.adapter.LotListAdapter;
import com.zhuravlev.sergey.auction.dto.Lot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_home;

    //TODO REFACTOR THIS SHIT
    private List<Lot> data;
    private LotListAdapter listAdapter;


    public static HomeFragment getInstance(Context context) {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_home));

        return fragment;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        data = new ArrayList<>();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        listAdapter = new LotListAdapter(data);
        recyclerView.setAdapter(listAdapter);
        return view;
    }

    public void setLotList(List<Lot> lot){
        data.addAll(lot);
        listAdapter.notifyDataSetChanged();
    }

}
