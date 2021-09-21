package com.example.quizme.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.quizme.Model.QuestionModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class QuestionRepository {


    private FirebaseFirestore firebaseFirestore;
    private String quizId;
    private onQuestionLoad onQuestionLoad;

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public QuestionRepository(onQuestionLoad onQuestionLoad) {
        firebaseFirestore = FirebaseFirestore.getInstance();
        this.onQuestionLoad = onQuestionLoad;


    }

    public void getQuestions() {
        firebaseFirestore.collection("Quiz").document(quizId).collection("questions")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()) {
                    onQuestionLoad.onLoad(task.getResult().toObjects(QuestionModel.class));
                } else {
                   onQuestionLoad.onError(task.getException());
                }
            }
        });
    }

    public interface onQuestionLoad{
        void onLoad(List<QuestionModel> questionModels);
        void onError(Exception e);

    }
}
