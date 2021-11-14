package com.kowsar.dynamiclocalization.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.kowsar.dynamiclocalization.HandleClickEvents;
import com.kowsar.dynamiclocalization.R;
import com.kowsar.dynamiclocalization.databinding.ActivityMainBinding;
import com.kowsar.dynamiclocalization.viewmodel.LocaleViewModel;

public class MainActivity extends AppCompatActivity implements ICommunication {
    private  final String TAG = this.getClass().getSimpleName();
    private ActivityMainBinding binding;
    private LocaleViewModel viewModel;
    private final String FILE_NAME= "locale_response.json";
    ProgressDialog progressDialog;
    private Handler mHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setClickHandler(new HandleClickEvents(this));
        viewModel = ViewModelProviders.of(this).get(LocaleViewModel.class);
        mHandler = new Handler();
        getSupportActionBar().setTitle(getResources().getString(R.string.page_title));
        viewModel.init();
        initPD();
        showDialog("Downloading Locale file from Google Drive", true);
        viewModel.getGDriveLocaleFile();
        viewModel.getResponseLiveddata().observe(this, responseLocale -> {
            Log.d(TAG,"onCreate(): responseLocale="+responseLocale);
            //dismiss progress dialog
            showDialog(null, false);
        });
    }

    private void initPD() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Downloading Locale file from Google Drive");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setGravity(Gravity.CENTER);
    }

    public void showDialog(String msg, boolean isShow) {
        Log.d(TAG, "showDialog(): isShow="+isShow);
        if (isShow) {
            if (!progressDialog.isShowing()){
                progressDialog.setMessage(msg);
                progressDialog.show();
                mHandler.postDelayed(timeOutRunnable, 20000);
            }
        } else {
            mHandler.removeCallbacksAndMessages (null);
            progressDialog.dismiss();
        }
    }

    // if response not received progress dialog close after 20 secs
    Runnable timeOutRunnable = () -> {
        Log.d(TAG, " Progress bar not shwoimng. Return...is shwoing="+progressDialog.isShowing());
        if (!progressDialog.isShowing()){
            Log.d(TAG, " Progress bar not shwoimng. Return...");
            return;
        }
        showDialog(null, false);
        Toast.makeText(this, "Data not fetch data due to Network error!!! Please try again", Toast.LENGTH_LONG).show();
    };


    @Override
    public void updateUI(Context context, String locale) {
        // just pass string res id and get localise string from localise file
        String resString = viewModel.getLocaleString(locale,"localize_text");
        Log.d(TAG, "updateUI(): resString="+resString);
        if (resString!=null){
            binding.localizeText.setText(resString);
        }else {
            //if res id is not available then set text from res folder.
            binding.localizeText.setText(context.getResources().getText(R.string.localize_text));
        }
    }
}