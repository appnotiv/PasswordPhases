package com.passwordphases;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


@SuppressWarnings("ALL")
public class ImportAccountActivity extends AppCompatActivity {

    ImageView importBack;
    TextView importDone;
    EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_account);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        init();
    }

    private void init() {
        importBack = (ImageView) findViewById(R.id.import_account_back);
        edtText = (EditText) findViewById(R.id.import_txt_edt);
        importDone = (TextView) findViewById(R.id.import_import);
        setClickEvent();
    }

    private void setClickEvent() {
        importBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        importDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtText.getText().toString().trim().equalsIgnoreCase("")) {
                    Toast.makeText(ImportAccountActivity.this, "Please enter Password Phrase", Toast.LENGTH_SHORT).show();
                } else {
                    String[] splited = edtText.getText().toString().trim().split(" ");

                    if (splited.length != 12) {
                        Toast.makeText(ImportAccountActivity.this, "Please enter 12 words", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Toast.makeText(ImportAccountActivity.this, "Check From Server valid or not ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}