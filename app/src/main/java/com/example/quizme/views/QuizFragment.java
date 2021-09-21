package com.example.quizme.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.quizme.R;
import com.example.quizme.viewmodel.QuestionViewModel;
import com.example.quizme.viewmodel.QuizListViewModel;


public class QuizFragment extends Fragment {


    private QuestionViewModel viewModel;
    private NavController navController;
    private ProgressBar progressBar;
    private Button option1Btn,option2Btn,option3Btn, nextQueBtn;
    private TextView questionTv, ansFeedBackTv, questionNumberTv, timerCountTv;
    private ImageView close_quiz_btn;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity()
                .getApplication())).get(QuestionViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }
}