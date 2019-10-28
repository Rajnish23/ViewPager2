package com.android.viewpager2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String[] tabName = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static final int[] tabColors = {R.color.tab_1, R.color.tab_2, R.color.tab_3, R.color.tab_4, R.color.tab_5,
            R.color.tab_6, R.color.tab_7, R.color.tab_8, R.color.tab_9};

    private static String language = "en";
    private TabLayout tabLayout;
    private ViewPager2 pager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabs);
        pager2 = findViewById(R.id.view_pager);
        setUpViewPager();


    }

    private void setUpViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        pager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, pager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tabName[position]);
            }
        }).attach();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_language) {
            if (language.equals("en")) {
                language = "ar";
            } else {
                language = "en";
            }
            Locale locale = new Locale(language);
            Configuration configuration = getResources().getConfiguration();
            configuration.setLocale(locale);
            getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
            finish();
            startActivity(getIntent());

        }


        return super.onOptionsItemSelected(item);
    }
}
