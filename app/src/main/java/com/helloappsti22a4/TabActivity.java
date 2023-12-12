package com.helloappsti22a4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Halaman Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        tabLayout=findViewById(R.id.tab);
        viewPager=findViewById(R.id.viewpager);

        Adapter=new Halaman(getApplicationContext(),getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(Adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
class Halaman extends FragmentStatePagerAdapter{
    Context context;
    int jumlah_tab;

    Halaman(Context context, FragmentManager fm, int jml_tab)
    {
        super(fm);
        this.context=context;
        this.jumlah_tab=jml_tab;
    }

    @NonNull
    @Override
    public Fragment getItem(int posisition){
        switch (posisition){
            case 0:return new Tabfragment1Activity();
            case 1:return new Tabfragment2Activity();
            case 2:return new Tabfragment3Activity();
        }
        return null;
    }

    @Override
    public int getCount(){
        return jumlah_tab;
    }
}


