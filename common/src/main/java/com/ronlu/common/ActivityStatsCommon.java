package com.ronlu.common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;

public abstract class ActivityStatsCommon extends AppCompatActivity {

    private RecyclerView stats_RSV_view;
    private TextView stats_LBL_balance, stats_LBL_tableTitle;
    private List<Data> myData;

    protected abstract List<Data> getAppData(List<Data> newData);
    protected abstract String getAppBalance(List<Data> myData);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_common);

        findViews();
        updateUI();
    }

    private void findViews() {
        stats_RSV_view = findViewById(R.id.stats_RSV_view);
        stats_LBL_balance = findViewById(R.id.stats_LBL_balance);
        stats_LBL_tableTitle = findViewById(R.id.stats_LBL_tableTitle);
    }
    private void updateUI() {
        myData = getAppData(this.getIntent().getExtras().getParcelableArrayList(ActivityMainCommon.KEY_DATA));
        stats_LBL_balance.setText(getAppBalance(myData));
        stats_RSV_view.setLayoutManager(new LinearLayoutManager(this));
        stats_RSV_view.setAdapter(new StatsAdapter(this, myData));

    }

}