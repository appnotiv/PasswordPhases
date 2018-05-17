package com.testlibsmy;

import android.content.Context;
import android.widget.Toast;

public class TestClass {
    public static void initMain(Context mContext, String msg){
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
