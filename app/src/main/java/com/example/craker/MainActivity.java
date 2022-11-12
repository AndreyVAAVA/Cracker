package com.example.craker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.craker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, ProductsFragment.class, null)
                    .commit();
        }
        setContentView(view);
        binding.bottomNavBar.setBackground(null);
        binding.bottomNavBar.getMenu().getItem(1).setEnabled(false);
        binding.bottomNavBar.setOnItemSelectedListener(item -> {
            if (R.id.foods == (item.getItemId())) {
                launchNewFragment(ProductsFragment.class);
                return true;
            } else if (R.id.chart == (item.getItemId())) {
                launchNewFragment(StatisticFragment.class);
                return true;
            } else if (R.id.diary == item.getItemId()) {
                launchNewFragment(DiaryFragment.class);
                return true;
            } else if (R.id.settings == item.getItemId()) {
                launchNewFragment(SettingsFragment.class);
                return true;
            }
            return false;
        });
    }
    private void launchNewFragment(Class item) {
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container_view, item, null)
                .commit();
    }
}