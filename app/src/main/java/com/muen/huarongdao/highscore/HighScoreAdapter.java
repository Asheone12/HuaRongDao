package com.muen.huarongdao.highscore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muen.huarongdao.R;
import com.muen.huarongdao.util.TimeUtil;

import java.util.ArrayList;
import java.util.List;

public class HighScoreAdapter extends RecyclerView.Adapter<HighScoreAdapter.HighScoreViewHolder> {
    private List<HighScore> mHighScores = new ArrayList<>();

    @NonNull
    @Override
    public HighScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_high_score, parent, false);
        HighScoreViewHolder holder = new HighScoreViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HighScoreViewHolder holder, int position) {
        HighScore score = mHighScores.get(position);
        holder.tvName.setText(score.name);
        holder.tvUseTime.setText(TimeUtil.format("%.2f秒", score.useTime / 1000.0));
        holder.tvUseStep.setText(String.valueOf(score.useStep));
    }

    @Override
    public int getItemCount() {
        return mHighScores.size();
    }

    public void setData(List<HighScore> data) {
        if (data == null) {
            return;
        }
        mHighScores.clear();
        mHighScores.addAll(data);
        notifyDataSetChanged();
    }

    class HighScoreViewHolder extends RecyclerView.ViewHolder {
        private View itemView;
        TextView tvName;
        TextView tvUseTime;
        TextView tvUseStep;

        public HighScoreViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvName = findViewById(R.id.name);
            tvUseTime = findViewById(R.id.useTime);
            tvUseStep = findViewById(R.id.useStep);
        }

        private <T extends View> T findViewById(int id) {
            return itemView.findViewById(id);
        }
    }
}
