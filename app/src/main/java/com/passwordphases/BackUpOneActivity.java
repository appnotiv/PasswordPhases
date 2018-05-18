package com.passwordphases;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


@SuppressWarnings("ALL")
public class BackUpOneActivity extends AppCompatActivity {

    ImageView imgBack;
    TextView txtGotIt;
    TextView txtOne;
    TextView txtTwo;
    TextView txtThree;
    TextView txtFour;
    TextView txtFive;
    TextView txtSix;
    TextView txtSeven;
    TextView txtEight;
    TextView txtNine;
    TextView txtTen;
    TextView txtElevan;
    TextView txtTwelve;
    String walletId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup_one);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        init();
    }

    private void init() {

        imgBack = (ImageView) findViewById(R.id.backup_one_back);
        txtGotIt = (TextView) findViewById(R.id.txt_ok);
        txtOne = (TextView) findViewById(R.id.backup_one_txt);
        txtTwo = (TextView) findViewById(R.id.backup_two_txt);
        txtThree = (TextView) findViewById(R.id.backup_three_txt);
        txtFour = (TextView) findViewById(R.id.backup_four_txt);
        txtFive = (TextView) findViewById(R.id.backup_five_txt);
        txtSix = (TextView) findViewById(R.id.backup_six_txt);
        txtSeven = (TextView) findViewById(R.id.backup_seven_txt);
        txtEight = (TextView) findViewById(R.id.backup_eight_txt);
        txtNine = (TextView) findViewById(R.id.backup_nine_txt);
        txtTen = (TextView) findViewById(R.id.backup_ten_txt);
        txtElevan = (TextView) findViewById(R.id.backup_elevan_txt);
        txtTwelve = (TextView) findViewById(R.id.backup_twelve_txt);

        walletId = "123456789";
        String[] splited = "Hello Hi Good Morning Testing Backup Account Please Check This Account Info".split(" ");

        txtOne.setText("" + splited[0]);
        txtTwo.setText("" + splited[1]);
        txtThree.setText("" + splited[2]);
        txtFour.setText("" + splited[3]);
        txtFive.setText("" + splited[4]);
        txtSix.setText("" + splited[5]);
        txtSeven.setText("" + splited[6]);
        txtEight.setText("" + splited[7]);
        txtNine.setText("" + splited[8]);
        txtTen.setText("" + splited[9]);
        txtElevan.setText("" + splited[10]);
        txtTwelve.setText("" + splited[11]);

//        doGetWallet();
        setClickEvent();

    }

    private void setClickEvent() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        txtGotIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (walletId != null && !walletId.equalsIgnoreCase("")) {
                    Intent intent = new Intent(BackUpOneActivity.this, BackupSecondActivity.class);
                    intent.putExtra("txtOne", txtOne.getText().toString());
                    intent.putExtra("txtTwo", txtTwo.getText().toString());
                    intent.putExtra("txtThree", txtThree.getText().toString());
                    intent.putExtra("txtFour", txtFour.getText().toString());
                    intent.putExtra("txtFive", txtFive.getText().toString());
                    intent.putExtra("txtSix", txtSix.getText().toString());
                    intent.putExtra("txtSeven", txtSeven.getText().toString());
                    intent.putExtra("txtEight", txtEight.getText().toString());
                    intent.putExtra("txtNine", txtNine.getText().toString());
                    intent.putExtra("txtTen", txtTen.getText().toString());
                    intent.putExtra("txtElevan", txtElevan.getText().toString());
                    intent.putExtra("txtTwelve", txtTwelve.getText().toString());
                    intent.putExtra("walletId", walletId);
                    startActivity(intent);
                }
            }
        });
    }
}