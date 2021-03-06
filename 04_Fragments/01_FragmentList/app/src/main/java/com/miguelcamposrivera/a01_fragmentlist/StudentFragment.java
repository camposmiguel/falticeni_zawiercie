package com.miguelcamposrivera.a01_fragmentlist;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguelcamposrivera.a01_fragmentlist.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment {

    private int mColumnCount = 1;
    private List<Student> studentList;

    public StudentFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            studentList = new ArrayList<>();
            studentList.add(new Student("Andrei",17,"Harvard","https://d3iw72m71ie81c.cloudfront.net/male-77.jpg"));
            studentList.add(new Student("Ionut",17,"Standford University","https://d3iw72m71ie81c.cloudfront.net/male-5.jpg"));
            studentList.add(new Student("Karol",18,"MIT","https://d3iw72m71ie81c.cloudfront.net/male-83.jpg"));
            studentList.add(new Student("Ilinca",17,"Oxford","https://d3iw72m71ie81c.cloudfront.net/female-72.jpg"));

            MyStudentRecyclerViewAdapter adapter = new MyStudentRecyclerViewAdapter(
                    getActivity(),
                    R.layout.fragment_student,
                    studentList
            );

            recyclerView.setAdapter(adapter);
        }
        return view;
    }

}
