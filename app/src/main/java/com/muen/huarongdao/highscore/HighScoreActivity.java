package com.muen.huarongdao.highscore;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.muen.huarongdao.R;

import java.util.List;


public class HighScoreActivity extends AppCompatActivity {

    private RecyclerView mHighScoreRecView;
    private HighScoreAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        mAdapter = new HighScoreAdapter();

        mHighScoreRecView = findViewById(R.id.rv);
        mHighScoreRecView.setLayoutManager(new LinearLayoutManager(this));
        mHighScoreRecView.setAdapter(mAdapter);

        loadData();
    }

    private static final String TAG = "HighScoreActivity";

    private void loadData() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String highScoreListJson = pref.getString(getString(R.string.pref_key_high_score), "");
        Log.d(TAG, "loadData: " + highScoreListJson);
        if (highScoreListJson.length() == 0) {
            return;
        }
        Gson gson = new Gson();
        List<HighScore> highScoreList = gson.fromJson(highScoreListJson, new TypeToken<List<HighScore>>() {
        }.getType());
        mAdapter.setData(highScoreList);
    }
}
