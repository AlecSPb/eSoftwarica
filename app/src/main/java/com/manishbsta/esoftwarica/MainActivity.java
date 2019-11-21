package com.manishbsta.esoftwarica;

import android.os.Bundle;
import android.view.KeyEvent;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.manishbsta.esoftwarica.model.Student;
import com.manishbsta.esoftwarica.ui.add_student.AddStudentFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddStudentFragment.studentList.add(new Student("Manish Bista", "22", "Male", "Kathmandu"));
        AddStudentFragment.studentList.add(new Student("Kritik Ranjit", "20", "Male", "Kathmandu"));
        AddStudentFragment.studentList.add(new Student("Kushal Shrestha", "23", "Male", "Kathmandu"));


        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_addstudent, R.id.navigation_aboutus)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);


    }

}
