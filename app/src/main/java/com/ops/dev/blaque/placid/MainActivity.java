package com.ops.dev.blaque.placid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


        if (savedInstanceState == null) {
            // on first time to display view for first navigation item based on the number
            MenuItem homeItem = (MenuItem) findViewById(R.id.home);
            Fragment myFragment = null;
            Class fragmentClass = null;
            fragmentClass = Home.class;

            try{
                myFragment = (Fragment)fragmentClass.newInstance();
            }
            catch (Exception e){
                e.printStackTrace();
            }

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content,myFragment).commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Fragment myFragment = null;
        Class fragmentClass = null;

        if (id == R.id.home){
            fragmentClass = Home.class;
            Toast.makeText(this, "This is home", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.aboutUs){
            fragmentClass = AboutUs.class;
            Toast.makeText(this, "This is about us", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.events){
            fragmentClass = Events.class;
            Toast.makeText(this, "This is events", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.gallery){
            fragmentClass = Gallery.class;
            Toast.makeText(this, "This is gallery", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.myProfile){
            fragmentClass = MyProfile.class;
            Toast.makeText(this, "This is my profile", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.socialNetworks){
            fragmentClass = SocialNetworks.class;
            Toast.makeText(this, "This is social networks", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.contactUs){
            fragmentClass = ContactUs.class;
            Toast.makeText(this, "This is contact us", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.logout){
            fragmentClass = Home.class;
            Toast.makeText(this, "This is logout", Toast.LENGTH_SHORT).show();
        }


        try{
            myFragment = (Fragment)fragmentClass.newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content,myFragment).commit();


        mDrawerLayout.closeDrawers();

        return false;
    }
}
