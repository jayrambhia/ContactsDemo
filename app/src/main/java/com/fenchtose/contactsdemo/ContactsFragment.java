package com.fenchtose.contactsdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fenchtose.contactsdemo.adapter.SpeedDialAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay Rambhia on 11/06/15.
 */
public class ContactsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<String> items;

    private final String SAVED_ITEMS = "saved_items";

    public static ContactsFragment newInstance() {
        return new ContactsFragment();
    }

    public ContactsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstaceState) {
        mRecyclerView = (RecyclerView)inflater
                .inflate(R.layout.fragment_speeddial_layout, parent, false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return mRecyclerView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            items = savedInstanceState.getStringArrayList(SAVED_ITEMS);
        }

        SpeedDialAdapter mAdapter = new SpeedDialAdapter(getActivity(), getItems());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (items != null) {
            outState.putStringArrayList(SAVED_ITEMS, new ArrayList<String>(items));
        }
    }

    private List<String> getItems() {

        if (items == null) {
            items = new ArrayList<>();

            for (char c = 'A'; c <= 'Z'; c++) {
                items.add(String.valueOf(c));
            }
        }

        return items;
    }
}
