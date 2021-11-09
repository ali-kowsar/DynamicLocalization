package com.kowsar.dynamiclocalization;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;

import com.kowsar.dynamiclocalization.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ICommunication{
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setClickHandler(new HandleClickEvents(this));
    }

    @Override
    public void updateUI(Context context) {
        binding.localizeText.setText(context.getResources().getText(R.string.localize_text));
    }
}