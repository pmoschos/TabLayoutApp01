package gr.aueb.cf.tablayoutapp01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private TabItem chatTI, statusTI, callsTI;
    private ViewPager2 viewPager2;
    private MyPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        chatTI = findViewById(R.id.chatTI);
        statusTI = findViewById(R.id.statusTI);
        callsTI = findViewById(R.id.callsTI);
        viewPager2 = findViewById(R.id.viewPager2);

        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), getLifecycle(), tabLayout.getTabCount());

        viewPager2.setAdapter(pagerAdapter);

        // changes the viewPager properly when i click on specific tab
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // changes properly the selected tab when i slide between fragments using pagerView
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout = (TabLayout) findViewById(R.id.tabLayout);
                TabLayout.Tab tab = tabLayout.getTabAt(position);
                tab.select();
            }
        });



    }
}