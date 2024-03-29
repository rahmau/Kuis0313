package com.example.sharedpreferences.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    private static SharedPref INSTANCE;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private final String SP_NAME = "loginsession";
    public static final String SP_NAMA = "mUsername";

    private SharedPref (Context context){
        sharedPreferences = context
                .getApplicationContext()
                .getSharedPreferences("com.example.sharedpreferences",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public static SharedPref getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = new SharedPref(context);
        }
        return INSTANCE;
    }
    public SharedPreferences Pref (){return sharedPreferences;}

    public Boolean isLogin(){return sharedPreferences.getBoolean("isLogin",false);}

    public void setLogin (boolean isCall){
        sharedPreferences.edit().putBoolean("isLogin",isCall).apply();
    }

    public void setName (String spName){
        sharedPreferences.edit().putString("SP_NAMA", spName).apply();
    }

    public String getName(){
        return sharedPreferences.getString("SP_NAMA", "");}
}
