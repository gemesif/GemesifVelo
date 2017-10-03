package com.product.gemesif.gemesifvelo;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
// import android.support.v7.app.ActionBarActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    String DEBUG_TAG = "gemesifLogAB";

    FragmentStatePagerAdapter adapterViewPager;

    private Toolbar toolbar;
    private DrawerLayout mDrawer;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;

    // ActionBarDrawerToggle toggle;
    private boolean mToolBarNavigationListenerIsRegistered = false;

    private InputStream inputStream;
    private BufferedReader reader;
    private String line;
    private StringBuilder out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        LockableViewPager vpPager = (LockableViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        // vpPager.setCurrentItem(2);   // AAA
        vpPager.setOffscreenPageLimit(3);

        vpPager.addOnPageChangeListener(new LockableViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Log.d("gemesifLog", "onPageScrolled");
            }

            @Override
            public void onPageSelected(int position) {
                // Log.d("gemesifLog", "onPageSelected " + position);       // AAA
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Log.d("gemesifLog", "onPageScrollStateChanged");
            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();

        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);

        // Log.d("gemesifLog", "vpPager.getCurrentItem() " + vpPager.getCurrentItem());

        // showBackButton(true); // showBackButton(false);

        // hideToolbar(true);

        AssetManager assetManager = getAssets();

        try {
            inputStream = assetManager.open("tmp.txt");
            reader = new BufferedReader(new InputStreamReader(inputStream));
            out = new StringBuilder();

            // Log.d("gemesifLog", "Open tmp.txt");

            while ((line = reader.readLine()) != null) {
                out.append(line);
                // Log.d("gemesifLog", "line: " + line);
            }

            // Log.d("gemesifLog", "file: " + out.toString());

        } catch (IOException e) {
            // Log.d("gemesifLog", "NOT Open tmp.txt");
            // Log.d("gemesifLog", "IOException" + Log.getStackTraceString(e));
            // e.printStackTrace();
        }
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    public void onBackPressed() {

        Log.d(DEBUG_TAG, "on Back Pressed");

        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);       // AAA doksit megnezni
        } else {
            super.onBackPressed();
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
        // navigationView.getMenu().getItem(0).setChecked(true);
    }

    public void selectDrawerItem(MenuItem menuItem) {

        Log.d(DEBUG_TAG, "on Navigation Item Seleced");

        int id = menuItem.getItemId();

        if (id == R.id.nav_first_fragment) {
            Log.d(DEBUG_TAG, "on Navigation Item Seleced first_fragment");
        } else if (id == R.id.nav_second_fragment) {
            Log.d(DEBUG_TAG, "on Navigation Item Seleced second_fragment");
        } else if (id == R.id.nav_third_fragment) {
            Log.d(DEBUG_TAG, "on Navigation Item Seleced third_fragment");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                //
                // NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Log.d(DEBUG_TAG, "onOptionsItemSelected action_settings");
            return true;
        } else if (id == R.id.action_settings_1) {
            Log.d(DEBUG_TAG, "onOptionsItemSelected action_settings 1");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private static class MyPagerAdapter extends FragmentStatePagerAdapter {
    // private static class MyPagerAdapter extends FragmentStatePagerAdapter {
        private static int NUM_ITEMS = 3;

        private MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            // Log.d("gemesifLog", "getItem " + position);
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return FragmentSpeed.newInstance(0, "Page # 1");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return FragmentOne.newInstance(1, "Page # 2");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return FragmentTwo.newInstance(2, "Page # 3");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // Log.d("gemesifLog", "instantiateItem " + position);
            return super.instantiateItem(container, position);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = MotionEventCompat.getActionMasked(event);

        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                // Log.d(DEBUG_TAG, "Action was DOWN");
                return true;
            case (MotionEvent.ACTION_MOVE):
                // Log.d(DEBUG_TAG, "Action was MOVE");
                return true;
            case (MotionEvent.ACTION_UP):
                // Log.d(DEBUG_TAG, "Action was UP");
                return true;
            case (MotionEvent.ACTION_CANCEL):
                // Log.d(DEBUG_TAG, "Action was CANCEL ");
                return true;
            case (MotionEvent.ACTION_OUTSIDE):
                // Log.d(DEBUG_TAG, "Movement occurred outside bounds " + "of current screen element");
                return true;
            default:
                // Log.d(DEBUG_TAG, "Action was default");
                return super.onTouchEvent(event);
        }
    }

    public void hideToolbar(boolean yesNo) {

        if (yesNo == true) {
            getSupportActionBar().hide();
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        } else {
            getSupportActionBar().show();
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }
    }

    private void showBackButton(boolean show) {

        // To keep states of ActionBar and ActionBarDrawerToggle synchronized,
        // when you enable on one, you disable on the other.
        // And as you may notice, the order for this operation is disable first, then enable - VERY VERY IMPORTANT.
        if(show) {
            // Remove hamburger
            Log.d(DEBUG_TAG, "Remove hamburger, Show back button");
            drawerToggle.setDrawerIndicatorEnabled(false);
            // Show back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            // when DrawerToggle is disabled i.e. setDrawerIndicatorEnabled(false), navigation icon
            // clicks are disabled i.e. the UP button will not work.
            // We need to add a listener, as in below, so DrawerToggle will forward
            // click events to this listener.
            if(!mToolBarNavigationListenerIsRegistered) {
                Log.d(DEBUG_TAG, "add a listener");
                drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Doesn't have to be onBackPressed
                        onBackPressed();
                    }
                });

                mToolBarNavigationListenerIsRegistered = true;
            }

        } else {
            // Remove back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            // Show hamburger
            drawerToggle.setDrawerIndicatorEnabled(true);
            // Remove the/any drawer toggle listener
            drawerToggle.setToolbarNavigationClickListener(null);
            mToolBarNavigationListenerIsRegistered = false;
        }
    }
}