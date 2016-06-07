package com.sodo.kumail.prayerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    static FragmentManager fragmentManager;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.toolbar);


        drawerLayout= (DrawerLayout) findViewById(R.id.drawer);


        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setTabTextColors(getResources().getColorStateList(R.color.colorAccent));

        viewPager=(ViewPager)findViewById(R.id.pager);
        fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("PrayerApp");

        actionBarDrawerToggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();
            }
        });
    }

    public void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        actionBarDrawerToggle.syncState();
    }
    class MyAdapter extends FragmentStatePagerAdapter
    {
        public MyAdapter(FragmentManager fragmentManager)
        {
            super(fragmentManager);
        }
        public Fragment getItem(int pos)
        {
            Fragment fragment=null;

            if(pos==0)
            {
                fragment= new FragmentA();
            }
            if(pos==1)
            {
                fragment=new FragmentB();
            }
            return fragment;
        }
        public int getCount()
        {
            return 2;
        }
        public CharSequence getPageTitle(int p)
        {
            if(p==0)
                return "TIMINGS";
            if(p==1)
                return "QIBLA";

            return "";
        }
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater=getMenuInflater();

        menuInflater.inflate(R.menu.menu_scrolling,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menu)
    {

        int id=menu.getItemId();

        if(id==R.id.action_settings)
        {
            Intent intent= new Intent(this,SettingsActivity.class);
            startActivity(intent);


        }
        if(id==R.id.method) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            MethodDialog methodDialog = new MethodDialog();
            methodDialog.show(fragmentManager, "School of Thought");
           Toast.makeText(this,MethodDialog.selected_id+","+MethodDialog.selected_text,Toast.LENGTH_SHORT).show();
        }


        return true;
    }






}
