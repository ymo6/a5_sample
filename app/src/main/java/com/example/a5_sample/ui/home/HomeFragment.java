package com.example.a5_sample.ui.home;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.a5_sample.MainActivity;
import com.example.a5_sample.NewPark;
import com.example.a5_sample.Park;
import com.example.a5_sample.ParkAdapter;
import com.example.a5_sample.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class HomeFragment extends Fragment {
    private ListView myList;
    private MainActivity myact;

    public static final int MENU_ITEM_EDITVIEW = Menu.FIRST;
    public static final int MENU_ITEM_DELETE = Menu.FIRST + 1;

    Context cntx;
 //   Park current;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // NOTE: HomeViewModel elements eliminated from original template

        // Inflate the layout for this fragment
        View myview = inflater.inflate(R.layout.fragment_home, container, false);

        cntx = getActivity().getApplicationContext();
        myact = (MainActivity) getActivity();

        myList = (ListView) myview.findViewById(R.id.mylist);
        myList.setAdapter(myact.pa);
        myact.pa.notifyDataSetChanged();

        FloatingActionButton fab = (FloatingActionButton) myview.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launch = new Intent(myact, NewPark.class);
                startActivity(launch);
            }
        });

        return myview;
    }

}