package com.varun.propertyguidance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class searchint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchint);
        search();
    }
    ListView listView;
    public void search(){
        listView=(ListView) findViewById(R.id.lsearch);
        listView.setClickable(true);
        DatabaseAccess d=DatabaseAccess.getInstance(getApplicationContext());
        d.open();
        ArrayList<searchadapter> a=d.st();
        d.close();
        searchad adapter1=new searchad(searchint.this,R.layout.search,a);
        listView.setAdapter(adapter1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv=(TextView)view.findViewById(R.id.txtst);
                String st=tv.getText().toString();
                String name=st.toUpperCase();
                Intent intent = new Intent(getApplicationContext(), searchres.class);
                intent.putExtra("state",name);
                startActivity(intent);
            }
        });
    }
}
