package com.manishbsta.esoftwarica.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.manishbsta.esoftwarica.R;
import com.manishbsta.esoftwarica.model.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> studentList;
    Student student;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_student_list, parent,false);
        StudentViewHolder viewHolder = new StudentViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, final int position) {
        student = studentList.get(position);
        holder.txtName.setText(student.getFullname());
        holder.txtAge.setText(student.getAge());
        holder.txtAddress.setText(student.getAddress());
        holder.txtGender.setText(student.getGender());

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentList.remove(position);
                notifyItemRemoved(position);
            }
        });

        if(student.getGender().equals("Male")){
            holder.imgStudent.setImageResource(R.drawable.icon_male);
        } else if(student.getGender().equals("Female")){
            holder.imgStudent.setImageResource(R.drawable.icon_female);
        }
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout detailsHolder;
        TextView txtName, txtAge, txtAddress, txtGender;
        ImageView imgDelete, imgStudent;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            detailsHolder = itemView.findViewById(R.id.detailsHolder);
            txtName = itemView.findViewById(R.id.txtName);
            txtAge = itemView.findViewById(R.id.txtAge);
            txtAddress = itemView.findViewById(R.id.txtAddress);
            txtGender = itemView.findViewById(R.id.txtGender);
            imgStudent = itemView.findViewById(R.id.imgStudent);
            imgDelete = itemView.findViewById(R.id.imgDelete);
        }
    }
}
