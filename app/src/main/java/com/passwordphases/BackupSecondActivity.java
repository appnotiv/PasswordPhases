package com.passwordphases;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaofeng.flowlayoutmanager.FlowLayoutManager;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class BackupSecondActivity extends AppCompatActivity implements SecondAdapter.clickSecondView, MainAdapter.clickMainView {

    RecyclerView rvMain, rvSecond;
    ArrayList<TitleModel> listMain, listSecond;
    SecondAdapter adapterSecond;
    MainAdapter adapterMain;
    ImageView txtConfirm;
    ImageView imgBack;

    String mainStr = "";
    String walletId = "";

    LinearLayout lvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup_second);
        getSupportActionBar().hide();

        init();
    }

    private void init() {
        imgBack = (ImageView) findViewById(R.id.backup_two_back);
        rvMain = (RecyclerView) findViewById(R.id.recyclerView_Main);
        rvSecond = (RecyclerView) findViewById(R.id.recyclerView_Second);
        txtConfirm = (ImageView) findViewById(R.id.backup_second_confirm);

        rvMain.setLayoutManager(new FlowLayoutManager());
        rvSecond.setLayoutManager(new FlowLayoutManager());

        lvData = (LinearLayout) findViewById(R.id.linear_Data);

        listMain = new ArrayList<TitleModel>();

        listSecond = new ArrayList<TitleModel>();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String txtOne = bundle.getString("txtOne");
            String txtTwo = bundle.getString("txtTwo");
            String txtThree = bundle.getString("txtThree");
            String txtFour = bundle.getString("txtFour");
            String txtFive = bundle.getString("txtFive");
            String txtSix = bundle.getString("txtSix");
            String txtSeven = bundle.getString("txtSeven");
            String txtEight = bundle.getString("txtEight");
            String txtNine = bundle.getString("txtNine");
            String txtTen = bundle.getString("txtTen");
            String txtElevan = bundle.getString("txtElevan");
            String txtTwelve = bundle.getString("txtTwelve");

            walletId = bundle.getString("walletId");

            listSecond.add(new TitleModel("" + txtSeven, 0));
            listSecond.add(new TitleModel("" + txtNine, 1));
            listSecond.add(new TitleModel("" + txtThree, 2));
            listSecond.add(new TitleModel("" + txtEight, 3));
            listSecond.add(new TitleModel("" + txtFive, 4));
            listSecond.add(new TitleModel("" + txtElevan, 5));
            listSecond.add(new TitleModel("" + txtFour, 6));
            listSecond.add(new TitleModel("" + txtTwelve, 7));
            listSecond.add(new TitleModel("" + txtSix, 8));
            listSecond.add(new TitleModel("" + txtOne, 9));
            listSecond.add(new TitleModel("" + txtTwo, 10));
            listSecond.add(new TitleModel("" + txtTen, 11));
        }


        adapterSecond = new SecondAdapter(BackupSecondActivity.this, listSecond, this);
        rvSecond.setAdapter(adapterSecond);

        adapterMain = new MainAdapter(BackupSecondActivity.this, listMain, this);
        rvMain.setAdapter(adapterMain);

        txtConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainStr = "";
                for (int i = 0; i < listMain.size(); i++) {
                    mainStr = mainStr + listMain.get(i).getTitle() + " ";
                }
                mainStr = mainStr.trim();

                Toast.makeText(BackupSecondActivity.this, "Send to server", Toast.LENGTH_SHORT).show();
//                doCheckString(mainStr);
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void clickSecond(int position) {
        if (!listSecond.get(position).getTitle().trim().equalsIgnoreCase("")) {
            listMain.add(listSecond.get(position));
            adapterMain.notifyDataSetChanged();

            listSecond.set(position, new TitleModel("    ", position));
            adapterSecond.notifyDataSetChanged();

            String stFlag = "";
            for (int i = 0; i < listSecond.size(); i++) {
                if (!listSecond.get(i).getTitle().trim().equalsIgnoreCase("")) {
                    stFlag = "test";
                }
            }

            if (stFlag.equalsIgnoreCase("")) {
                lvData.setVisibility(View.GONE);
            } else {
                lvData.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void clickMain(int position) {
        for (int i = 0; i < listMain.size(); i++) {
            if (listMain.get(i).getPosition() == position) {
                listSecond.set(position, new TitleModel(listMain.get(i).getTitle(), listMain.get(i).getPosition()));
                listMain.remove(i);
            }
        }

        adapterMain.notifyDataSetChanged();
        adapterSecond.notifyDataSetChanged();

        String stFlag = "";
        for (int i = 0; i < listSecond.size(); i++) {
            if (!listSecond.get(i).getTitle().trim().equalsIgnoreCase("")) {
                stFlag = "test";
            }
        }

        if (stFlag.equalsIgnoreCase("")) {
            lvData.setVisibility(View.GONE);
        } else {
            lvData.setVisibility(View.VISIBLE);
        }
    }


    /*public void doCheckString(String strrr) {
        if (AppGlobal.isNetwork(BackupSecondActivity.this)) {

            AppGlobal.showProgressDialog(BackupSecondActivity.this);
            Map<String, String> optioMap = new HashMap<>();
            optioMap.put("RegisterId", AppGlobal.getStringPreference(BackupSecondActivity.this, WsConstant.SP_REGISTER_ID));
            optioMap.put("WalletKey", strrr);

            new RestClient(BackupSecondActivity.this).getInstance().get().checkWalletKey(optioMap)
                    .enqueue(new Callback<RegistrationResponse>() {
                        @Override
                        public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                            AppGlobal.hideProgressDialog(BackupSecondActivity.this);
                            if (response.body() != null) {
                                if (response.body().getSuccess() == 1) {
                                    openDialogForSecurity();
                                    Log.e("message", ":" + response.body().getMsg());
                                } else {
                                    Toast.makeText(BackupSecondActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(BackupSecondActivity.this, "server is down please try again later!!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                            try {
                                AppGlobal.hideProgressDialog(BackupSecondActivity.this);
                                Toast.makeText(BackupSecondActivity.this, getString(R.string.network_time_out_error), Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {

                            }
                        }
                    });
        } else {
            Toast.makeText(BackupSecondActivity.this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }
    }*/


    private void openDialogForSecurity() {
        final Dialog dialogWallet = new Dialog(BackupSecondActivity.this);
        dialogWallet.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialogWallet.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        dialogWallet.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogWallet.setCancelable(true);

        View vi = getLayoutInflater().inflate(R.layout.dialog_backed_up, null, false);
        dialogWallet.setContentView(vi);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = dialogWallet.getWindow();

        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        window.setAttributes(lp);

        final TextView txtOhk = (TextView) dialogWallet.findViewById(R.id.screenshot_ok);

        txtOhk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BackupSecondActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                dialogWallet.dismiss();
            }
        });

        dialogWallet.show();
    }
}
