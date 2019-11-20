package com.manishbsta.esoftwarica.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.manishbsta.esoftwarica.R;
import com.manishbsta.esoftwarica.adapters.StudentAdapter;
import com.manishbsta.esoftwarica.ui.add_student.AddStudentFragment;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private ImageView imgDelete;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = root.findViewById(R.id.rvStudentList);

        StudentAdapter studentAdapter = new StudentAdapter(AddStudentFragment.studentList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(layoutManager);

        imgDelete = root.findViewById(R.id.imgDelete);

        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return root;
    }
}