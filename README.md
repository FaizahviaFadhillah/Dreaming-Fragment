

`Nama   : Faizah Via Fadhillah`

`NIM    : 312210460`

`Kelas  : TI.22.A.4`

`Matkul : Pemrograman Mobile 1`


# Dreaming-Fragment

## activity_tab.xml

Script :

```xml
<?xml version="1.0" encoding="utf-8"?>
    <LinearLayout
        android:orientation="vertical"
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".TabActivity">

        <androidx.appcompat.widget.Toolbar
            android:background="@color/midnight"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">
            <TextView
                android:layout_marginRight="18sp"
                android:textColor="@color/white"
                android:text="Dreaming Movie"
                android:textSize="25dp"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"/>
        </androidx.appcompat.widget.Toolbar>
        <com.google.android.material.tabs.TabLayout
            android:id="@+id/tab"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">
            <com.google.android.material.tabs.TabItem
                android:text="Action"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"/>
            <com.google.android.material.tabs.TabItem
                android:text="Fantasy"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"/>
            <com.google.android.material.tabs.TabItem
                android:text="Romantic"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"/>
        </com.google.android.material.tabs.TabLayout>
        <androidx.viewpager.widget.ViewPager
            android:id="@+id/viewpager"
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>
    </LinearLayout>
```


## TabActivity.java

Script :

```java
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
```


## tab_fragment_1.xml

Script :

[Tab_Fragment_1.xml](app/src/main/res/layout/tab_fragment_1.xml)


## Tabfragment1Activity.java

Script :

[Tabfragment1Activity.java](app/src/main/java/com/helloappsti22a4/Tabfragment1Activity.java)


## tab_fragment_2.xml

Script :

[Tab_Fragment_2.xml](app/src/main/res/layout/tab_fragment_2.xml)


## Tabfragment2Activity.java

Script :

[Tabfragment2Activity.java](app/src/main/java/com/helloappsti22a4/Tabfragment2Activity.java)


## tab_fragment_3.xml

Script :

[Tab_Fragment_3.xml](app/src/main/res/layout/tab_fragment_3.xml)


## Tabfragment3Activity.java

Script :

[Tabfragment3Activity.java](app/src/main/java/com/helloappsti22a4/Tabfragment3Activity.java)


# Demo Apps

![output](gambar/demo.gif)
