package com.example.quizme.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizme.Model.QuestionModel;
import com.example.quizme.repository.QuestionRepository;

import java.util.List;

public class QuestionViewModel extends ViewModel implements QuestionRepository.onQuestionLoad {

    private MutableLiveData<List<QuestionModel>> questionMutableLiveData;
    private QuestionRepository repository;

    private QuestionViewModel() {
        questionMutableLiveData = new MutableLiveData<>();
        repository = new QuestionRepository(this);
    }

    public void setQuizId(String quizId) {
        repository.setQuizId(quizId);
    }

    @Override
    public void onLoad(List<QuestionModel> questionModels) {
            questionMutableLiveData.setValue(questionModels);
    }

    @Override
    public void onError(Exception e) {
        Log.d("Quiz Error", "onError: " + e.getMessage());
    }
}
