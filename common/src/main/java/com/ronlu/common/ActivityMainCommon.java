package com.ronlu.common;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ActivityMainCommon extends AppCompatActivity {

    private TextInputEditText main_EDT_value;
    private MaterialButton main_BTN_stats, main_BTN_submit;
    private TextView main_LBL_title, main_LBL_deviceID;
    public static final String KEY_DATA = "KEY_DATA";

    private ArrayList<Data> newData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_common);
        findViews();
        initViews();
    }

    private void findViews() {
        main_EDT_value = findViewById(R.id.main_EDT_value);
        main_LBL_title = findViewById(R.id.main_LBL_title);
        main_LBL_deviceID = findViewById(R.id.main_LBL_deviceID);
        main_BTN_stats = findViewById(R.id.main_BTN_stats);
        main_BTN_submit = findViewById(R.id.main_BTN_submit);

    }
    private void initViews() {
        newData = new ArrayList<>();

        main_LBL_deviceID.setText("Device ID: " + AppCommon.deviceID);
        main_EDT_value.setText("");

        main_BTN_submit.setOnClickListener(view -> submitValue());
        main_BTN_stats.setOnClickListener(view -> openStatsActivity());
    }

    private void submitValue(){
        // validate input
        if(main_EDT_value.getText().toString().equals("")){
            showToast("Invalid Input");
            return;
        }
        if(AppCommon.AppPurpose.equals(AppCommon.COUNTER))
            if (!validateBalance(main_EDT_value.getText() + "")){
                showToast("Invalid Input");
                return;
            }
        // save input
        newData.add(new Data(main_EDT_value.getText()+"", generateShortDate()));
        main_EDT_value.setText("");
        showToast("Submitted");

    }

    private void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    private boolean validateBalance(String input){
        return input.matches("[+,-]{0,1}\\d+[.]{0,1}\\d*");
    }

    private String generateShortDate() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("HH:mm  dd/MM/yy");
        return formatter.format(new Date());
    }

    private void openStatsActivity() {
        Intent intent = new Intent(this, AppCommon.statsClass);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(KEY_DATA, newData);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

}