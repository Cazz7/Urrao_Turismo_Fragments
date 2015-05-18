package com.example.cristian.practica_5_2;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class FragmentListView extends ListFragment {

    private String[] item = {"Hoteles","Bares","Sitios",
            "Información"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //return super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_list_view, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(), "Usted ha pulsado " + item[position],
                Toast.LENGTH_SHORT).show();

            showDetails(position);

        }

    void showDetails(int index) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

            switch (index) {

                case 0:

                    fragmentHotels fHotels = new fragmentHotels();
                    fragmentTransaction.replace(R.id.fragmentDetail, fHotels);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;

                case 1:

                    BarFragment fBar = new BarFragment();
                    fragmentTransaction.replace(R.id.fragmentDetail, fBar);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case 2:
                    fragmentTourism fTourism = new fragmentTourism();
                    fragmentTransaction.replace(R.id.fragmentDetail, fTourism);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case 3:
                    fragmentInfo fInfo = new fragmentInfo();
                    fragmentTransaction.replace(R.id.fragmentDetail, fInfo);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;

            }


        } else {
            switch (index) {
                case 0:
                    fragmentHotels fHotels = new fragmentHotels();
                    fragmentTransaction.replace(android.R.id.content, fHotels);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case 1:
                    BarFragment fBar = new BarFragment();
                    fragmentTransaction.replace(android.R.id.content, fBar);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case 2:
                    fragmentTourism fTourism = new fragmentTourism();
                    fragmentTransaction.replace(android.R.id.content, fTourism);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case 3:
                    fragmentInfo fInfo = new fragmentInfo();
                    fragmentTransaction.replace(android.R.id.content, fInfo);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, item));
    }
}
