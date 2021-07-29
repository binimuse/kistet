package com.example.binim.kistetevent;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by binim on 10/03/2020.
 */

public class SharedPrefManager  {


    private static SharedPrefManager sharedPrefManager;
    private static Context ctx;
    private static final String SHARED_PREF_NAME = "spm_name_login";
    private static final String KEY_USER_NAME = "user_name";



    private SharedPrefManager(Context context){
        ctx = context;
      //  return getSharedPreferences(ctx).getString(PREF_USER_NAME, "");
    }
    public boolean userLogin(String user_name){

        SharedPreferences preferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();


        editor.putString(KEY_USER_NAME, user_name);

        editor.apply();
        return true;
    }



    public boolean isLoggedIn(){
        SharedPreferences preferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if (preferences.getString(KEY_USER_NAME, null) != null){
            return true;
        }
        return false;
    }

    public boolean logout(){

        SharedPreferences preferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();


        editor.clear();
        editor.apply();

        return true;
    }


}
