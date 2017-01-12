package com.example.androidsp.appgplx.BtnDethi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.androidsp.appgplx.R;

import java.util.ArrayList;

import static com.example.androidsp.appgplx.BtnDethi.PlaceholderFragment.tongdapandung;

public class MainOver_Activity extends AppCompatActivity{
    private long TIMER = 0;
    private TextView tv_timer, tv_dat, tv_khongdat, tv_index_ques;

    //private int tongdapandung = 0;

    public ArrayList<String> dsDapanchon = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_over);

        //Log.d("Test","Tổng Đáp án đúng khi truyền dữ liệu là: "+tongdapandung);
        TIMER = getIntent().getLongExtra("time",0);
        findViewById();
        setupData();
    }

    private void setupData() {

        tv_index_ques.setText(tongdapandung + "/" + 20);

        if (tongdapandung >= 16) {
            tv_dat.setVisibility(View.VISIBLE);
            tv_khongdat.setVisibility(View.GONE);
        } else {
            tv_dat.setVisibility(View.GONE);
            tv_khongdat.setVisibility(View.VISIBLE);
        }

    }


    private void findViewById() {
        tv_timer = (TextView) findViewById(R.id.tv_timer);
        tv_dat = (TextView) findViewById(R.id.tv_dat);
        tv_khongdat = (TextView) findViewById(R.id.tv_khongdat);
        tv_index_ques = (TextView) findViewById(R.id.tv_index_ques);

        int minutes = (int) (TIMER / 1000 / 60);
        int seconds = (int) ((TIMER / 1000) % 60);
        String Minutes = String.format("%02d", minutes);
        String Seconds = String.format("%02d", seconds);

        tv_timer.setText(Minutes + ":" + Seconds);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
