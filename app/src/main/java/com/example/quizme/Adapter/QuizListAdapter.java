package com.example.quizme.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quizme.Model.QuizListModel;
import com.example.quizme.R;

import java.util.List;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.QuizListViewHolder> {

        private List<QuizListModel> quizListModels;
        private onItemClickedListener onItemClickedListener;

    public void setQuizListModels(List<QuizListModel> quizListModels) {
        this.quizListModels = quizListModels;
    }

    @NonNull
    @Override
    public QuizListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_quiz,parent,false);
        return new QuizListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizListViewHolder holder, int position) {
    QuizListModel model = quizListModels.get(position);
    holder.title.setText(model.getTitle());
    Glide.with(holder.itemView).load(model.getImage()).into(holder.quizImage);
    }

    @Override
    public int getItemCount() {

        if(quizListModels == null) {
            return 0;
        }

        return quizListModels.size();
    }


    public QuizListAdapter(onItemClickedListener onItemClickedListener){
        this.onItemClickedListener = onItemClickedListener;
    }
    public class QuizListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title;
        private ImageView quizImage;
        private ConstraintLayout constraintLayout;



        public QuizListViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.quizTitleList);
            quizImage= itemView.findViewById(R.id.quizImageList);
            constraintLayout = itemView.findViewById(R.id.consraintLayout);
            constraintLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickedListener.onItemClick(getAdapterPosition());
        }
    }

    public interface  onItemClickedListener {
        void onItemClick(int position);
    }
}


