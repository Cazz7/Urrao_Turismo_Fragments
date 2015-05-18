package com.example.cristian.practica_5_2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class guiaTuristica extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.urrao_main_menu);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_guia_turistica, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        int id = item.getItemId();

        if (id==R.id.hotel_menu){
            fragmentHotels fHotels = new fragmentHotels();
            fragmentTransaction.replace(android.R.id.content,fHotels);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        if (id==R.id.bars_menu){
            BarFragment fBar = new BarFragment();
            fragmentTransaction.replace(android.R.id.content,fBar);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        if (id==R.id.tourism_menu){
           fragmentTourism fTourism = new fragmentTourism();
           fragmentTransaction.replace(android.R.id.content,fTourism);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        if (id==R.id.info_menu){
            fragmentInfo fInfo = new fragmentInfo();
            fragmentTransaction.replace(android.R.id.content,fInfo);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        if (id==R.id.about){
            fragmentAbout fAbout = new fragmentAbout();
            fragmentTransaction.replace(android.R.id.content,fAbout);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount()==0)
        {
            this.finish();
        }else{
            getFragmentManager().popBackStack();
        }

    }
}
