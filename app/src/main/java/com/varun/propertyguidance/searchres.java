package com.varun.propertyguidance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class searchres extends AppCompatActivity {
    TextView st1;
    TextView st22;
    TextView st33;
    TextView st44;
    TextView st55;
    TextView st66;
    TextView st77;
    TextView st88;
    TextView st99;
    TextView st110;
    TextView st121;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchres);
        st1=(TextView)findViewById(R.id.textView1);
        st22=(TextView)findViewById(R.id.textView22);
        st33=(TextView)findViewById(R.id.textView33);
        st44=(TextView)findViewById(R.id.textView44);
        st55=(TextView)findViewById(R.id.textView55);
        st66=(TextView)findViewById(R.id.textView66);
        st77=(TextView)findViewById(R.id.textView77);
        st88=(TextView)findViewById(R.id.textView88);
        st99=(TextView)findViewById(R.id.textView99);
        st110=(TextView)findViewById(R.id.textView110);
        st121=(TextView)findViewById(R.id.textView121);
        Bundle b=getIntent().getExtras();
        String name=b.getString("state");
        //create instance of database class and open connection
        DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        databaseAccess.run("select land.State,Avg_Land_Rate,Annual_Avg_Temp_inC,No_of_Companies,annual_avg_rain_inCm,No_of_Schools," +
                "No_of_Malls,No_of_Colleges,No_of_Pubs,Literacy_rate_inPercent,Rank_in_Crime_Rate from land,company,education,people,recreation,weather where upper(land.state)='"+name+"' and land.State=company.State and " +
                "land.State_code=education.State_code and land.State_code=people.State_code and land.State_short_code=recreation.State_short_code " +
                "and land.State_short_code=weather.State_short_code");
        ArrayList<String> d=databaseAccess.getdetails();
        st1.setText(d.get(0).toString());
        //op=databaseAccess.getcost();
        st22.setText(d.get(1).toString());
        //op=databaseAccess.gettemp();
        st33.setText(d.get(2).toString());
        //op=databaseAccess.getcomp();
        st44.setText(d.get(3).toString());
        //op=databaseAccess.getrain();
        st55.setText(d.get(4).toString());
        //op=databaseAccess.getschool();
        st66.setText(d.get(5).toString());
        //op=databaseAccess.getmall();
        st77.setText(d.get(6).toString());
        //op=databaseAccess.getcollege();
        st88.setText(d.get(7).toString());
        //op=databaseAccess.getpub();
        st99.setText(d.get(8).toString());
        //op=databaseAccess.getrate();
        st110.setText(d.get(9).toString());
        //op=databaseAccess.getcrime();
        st121.setText(d.get(10).toString());
        databaseAccess.close();
    }
}
