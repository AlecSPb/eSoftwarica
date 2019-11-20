package com.manishbsta.esoftwarica.ui.add_student;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddStudentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AddStudentViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}