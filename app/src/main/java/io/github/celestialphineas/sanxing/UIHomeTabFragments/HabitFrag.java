package io.github.celestialphineas.sanxing.UIHomeTabFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.github.celestialphineas.sanxing.R;
import io.github.celestialphineas.sanxing.sxObject.Habit;
import io.github.celestialphineas.sanxing.sxObjectManager.HabitManager;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HabitFrag#newInstance} factory method to
 * create an instance of this fragment.
 */

public class HabitFrag extends Fragment {

    private HabitManager habitManager;

    public HabitFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */

    public HabitFrag newInstance(HabitManager habitManager) {

        HabitFrag fragment = new HabitFrag();
        fragment.habitManager = habitManager;
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.task_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        if (habitManager !=null)
            recyclerView.setAdapter(new HabitRecyclerAdapter(habitManager.getObjectList()));
        else recyclerView.setAdapter(new HabitRecyclerAdapter());
        return view;
    }

}
