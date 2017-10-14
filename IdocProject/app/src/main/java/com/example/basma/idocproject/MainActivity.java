package com.example.basma.idocproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,listener
{

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    String mesg ,Profile,home,aboutus,setting,call;

    // toolbar titles respected to selected nav menu item
   // private String[] activityTitles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        chatlist_Fragm a=new chatlist_Fragm();
        a.onAttach(this);

        //language
            android.content.res.Resources res = getResources();
             mesg = res.getString(R.string.mesg);
             Profile = res.getString(R.string.nav_profile);
             home=res.getString(R.string.nav_home);
             aboutus=res.getString(R.string.nav_about_us);
             setting=res.getString(R.string.nav_settings);
             call=res.getString(R.string.nav_call);
             toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

      //  activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

        setfragment(new HomeFragment());
            // load toolbar titles from string resources
         //   activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

            viewPager = (ViewPager) findViewById(R.id.pager);
            setupViewPager(viewPager);
            tabLayout = (TabLayout) findViewById(R.id.tab_layout);
            // This method setup all required method for TabLayout with Viewpager
            tabLayout.setupWithViewPager(viewPager);
            tabLayout.setVisibility(View.GONE);
            viewPager.setVisibility(View.GONE);


        }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        // adapter.addFragment(new NotificationsFragment(), "Notifications");
      //  adapter.addFragment(new MessageFragment(), "Messages");
        adapter.addFragment(new chatlist_Fragm(), mesg);

        adapter.addFragment(new Profilefragment2(), Profile);

        adapter.addFragment(new MessageFragment(), mesg);



        viewPager.setAdapter(adapter);
    }

    @Override
    public void ifclicked(boolean b) {

        tabLayout.setVisibility(View.GONE);
        viewPager.setVisibility(View.GONE);
        setfragment(new MessageFragment());

    }

    public static class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {


            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {


            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {


        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            tabLayout.setVisibility(View.GONE);
            viewPager.setVisibility(View.GONE);
            getSupportActionBar().setTitle(home);

            setfragment(new HomeFragment());

            // Handle the camera action
        } else if (id == R.id.nav_call) {
            tabLayout.setVisibility(View.GONE);
            viewPager.setVisibility(View.GONE);
            getSupportActionBar().setTitle(call);
            setfragment(new Call_UsFragment());
        }
            else if (id == R.id.nav_profile) {
                //for tablayout
                tabLayout.setVisibility(View.VISIBLE);
                viewPager.setVisibility(View.VISIBLE);
                setfragment(new ProfileFragment());
            getSupportActionBar().setTitle(Profile);


            }
         else if (id == R.id.nav_about_us) {
            tabLayout.setVisibility(View.GONE);
            viewPager.setVisibility(View.GONE);
            getSupportActionBar().setTitle(aboutus);
            setfragment(new AboutUs());

        }  else if (id == R.id.nav_settings) {
            tabLayout.setVisibility(View.GONE);
            viewPager.setVisibility(View.GONE);
            getSupportActionBar().setTitle(setting);
            setfragment(new SettingsFragment());

        } else if (id == R.id.nav_privacy_policy) {
            startActivity(new Intent(MainActivity.this, PrivacyPolicyActivity.class));
        }


        return true;
    }


    //for tablayout
    public void setfragment(Fragment fragment) {
        if (fragment != null) {
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.commit();


        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    /**
     * Created by basma on 27/08/2017.
     */


}
