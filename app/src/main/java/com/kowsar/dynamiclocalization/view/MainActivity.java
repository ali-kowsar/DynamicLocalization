package com.kowsar.dynamiclocalization.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import com.kowsar.dynamiclocalization.HandleClickEvents;
import com.kowsar.dynamiclocalization.R;
import com.kowsar.dynamiclocalization.databinding.ActivityMainBinding;
import com.kowsar.dynamiclocalization.viewmodel.LocaleViewModel;

public class MainActivity extends AppCompatActivity implements ICommunication {
    private ActivityMainBinding binding;
    private LocaleViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setClickHandler(new HandleClickEvents(this));
        viewModel = ViewModelProviders.of(this).get(LocaleViewModel.class);
        viewModel.init();
        viewModel.getGDriveLocaleFile("");
    }

    @Override
    public void updateUI(Context context) {
        binding.localizeText.setText(context.getResources().getText(R.string.localize_text));
    }
}