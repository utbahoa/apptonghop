package com.example.application_b7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.view.View;
import java.util.ArrayList;
import android.widget.Toast;
import android.widget.AdapterView;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class customlist extends AppCompatActivity {

    ListView lv;
    ListViewBaseAdapter datamodals;
    ArrayList<modal> datamodal;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlist);
        lv = (ListView) findViewById(R.id.listview);
        datamodal = new ArrayList<modal>();
        datamodal.add(new modal(R.drawable.aatrox, "Aatrox"));
        datamodal.add(new modal(R.drawable.anine, "Anine"));
        datamodal.add(new modal(R.drawable.ashe, "Ashe"));
        datamodal.add(new modal(R.drawable.pyke, "Pyke"));
        datamodal.add(new modal(R.drawable.riven, "Riven"));
        datamodal.add(new modal(R.drawable.yasuo, "Yasuo"));
        datamodals = new ListViewBaseAdapter(datamodal,this);
        lv.setAdapter(datamodals);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <? > parent, View view, int position, long id)
            {
                modal data= datamodal.get(position);
                Toast.makeText(customlist.this, data.getLangName() , Toast.LENGTH_SHORT).show();
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.main_nav);
        bottomNavigationView.setSelectedItemId(R.id.customlist_);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home_:
                        startActivity(new Intent(getApplicationContext(),signin.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.customlist_:
                        return true;
                    case R.id.profile_:
                        startActivity(new Intent(getApplicationContext(),profile.class));
                        overridePendingTransition(0,0);
                        return true;
                    default:  return false;
                }
            }
        });
    }

}