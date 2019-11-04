package com.delta.newassignment2.util;

import android.app.Activity;

import com.google.android.material.snackbar.Snackbar;

public class CommonUti {
    public static void showSnackBar(Activity activity, String message){
        Snackbar.make(activity.getWindow().getDecorView().getRootView(), message, Snackbar.LENGTH_LONG).show();

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    }

}
