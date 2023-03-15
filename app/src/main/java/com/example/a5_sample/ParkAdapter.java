package com.example.a5_sample;

import android.widget.ArrayAdapter;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ParkAdapter extends ArrayAdapter<Park> {
    int resource;
    MainActivity myact;
    public ParkAdapter(Context ctx, int res, List<Park> parks)
    {
        super(ctx, res, parks);
        resource = res;
        myact = (MainActivity) ctx;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout itemView;
        Park p = getItem(position);

        if (convertView == null) {
            itemView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(inflater);
            vi.inflate(resource, itemView, true);
        } else {
            itemView = (LinearLayout) convertView;
        }

        TextView name = (TextView) itemView.findViewById(R.id.park_name);
        name.setText(p.getname());
        TextView size = (TextView) itemView.findViewById(R.id.park_num);
        size.setText("" + p.getnumber());
        Button checkin = (Button) itemView.findViewById(R.id.checkin);
        String availText = p.getchecked_in() ? "Check out" : "Check in";
        checkin.setText(availText);

        checkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkin.getText() == "Check out") {
                    checkin.setText("Check in");
                    myact.current = null; // no longer checked in anywhere
        // TODO: add code to update the status of park p and display the updated number of occupants
                }
                else {
        // TODO: update code to fully check into park p, but only if not currently in one
                    checkin.setText("Check out");
                }
            }
        });

        return itemView;
    }
}


