package com.kowsar.dynamiclocalization;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;

import java.util.Locale;

public class LocaleHelper {
    private final static  String TAG=LocaleHelper.class.getSimpleName();

    public static Context setLocale(Context context,String language){
        Log.d(TAG, "setLocale(): language="+language);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
             return updateLocale(context, language);
        } else {
            return updateLocaleLegacy(context, language);
        }
    }

    @SuppressWarnings("deprecation")
    private static Context updateLocaleLegacy(Context context, String language) {
        Log.d(TAG, "updateLocaleLegacy(): language="+language);
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources resources = context.getResources();

        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLayoutDirection(locale);
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }

    @TargetApi(Build.VERSION_CODES.N)
    private static Context updateLocale(Context context, String language) {
        Log.d(TAG, "updateLocale(): language="+language);
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
//        configuration.setLayoutDirection(locale);
         return context.createConfigurationContext(configuration);

    }
}
