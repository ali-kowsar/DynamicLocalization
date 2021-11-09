package com.kowsar.dynamiclocalization;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.Locale;

public class HandleClickEvents {
    private ICommunication comm;

    private Context cntext;

    public HandleClickEvents( Context context) {
        cntext = context;
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void  onButtonClick( View view){
        Toast.makeText(cntext, "Button clicked", Toast.LENGTH_SHORT).show();
        String language=null;
        switch (view.getId()){
            case R.id.button_en:
                language = "en";
                break;
            case R.id.button_hi:
                language = "hi";
                break;
            case R.id.button_ch:
                language = "zh";
                break;
            case R.id.button_arabic:
                language = "ar";
                break;
        }
        setLocale(language);

    }

    private void setLocale(String hindi) {
        Context context =LocaleHelper.setLocale(cntext, hindi);
        if (cntext instanceof ICommunication){
            comm = (ICommunication) cntext;
            comm.updateUI(context);
        }

    }
}
