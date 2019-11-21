package com.manishbsta.esoftwarica.ui.add_student;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.manishbsta.esoftwarica.R;
import com.manishbsta.esoftwarica.model.Student;

import java.util.ArrayList;
import java.util.List;

public class AddStudentFragment extends Fragment {

    public static List<Student> studentList = new ArrayList<>();
    private Button btnSave;
    private EditText etName, etAddress, etAge;
    private RadioGroup rgGender;
    private String name, age, address, gender;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_addstudent, container, false);

        btnSave = root.findViewById(R.id.btnSave);
        etName = root.findViewById(R.id.etFullName);
        etAge= root.findViewById(R.id.etAge);
        etAddress = root.findViewById(R.id.etAddress);
        rgGender = root.findViewById(R.id.rgGender);

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbMale){
                    gender = "Male";
                }

                if(checkedId == R.id.rbFemale){
                    gender = "Female";
                }

                if(checkedId == R.id.rbOther){
                    gender = "Other";
                }
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etName.getText().toString().trim();
                age = etAge.getText().toString().trim();
                address = etAddress.getText().toString().trim();

                if(validation()) {
                    studentList.add(new Student(name, age, gender, address));
                    Toast.makeText(getContext(), "New Student Added!", Toast.LENGTH_SHORT).show();
                }

                etName.setText("");
                etAge.setText("");
                etAddress.setText("");
                rgGender.clearCheck();
            }
        });

        return root;
    }

    private boolean validation(){
        if(TextUtils.isEmpty(name)){
            etName.setError("Name can not be left empty!");
            etName.requestFocus();
            return false;
        }

        if(TextUtils.isEmpty(age)){
            etAge.setError("Age can not be left empty!");
            etAge.requestFocus();
            return false;
        }

        if(TextUtils.isEmpty(gender)){
            Toast.makeText(getContext(), "Please select your gender!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(TextUtils.isEmpty(address)){
            etAddress.setError("Address can not be left empty!");
            etAddress.requestFocus();
            return false;
        }

        return true;
    }
}