package com.varun.propertyguidance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        fun();
    }

    ListView lv;
    public void fun(){
        try{
        Bundle b1=getIntent().getExtras();
        int ch=b1.getInt("key");
        lv=(ListView) findViewById(R.id.lresult);
        lv.setClickable(true);
        final DatabaseAccess db=DatabaseAccess.getInstance(getApplicationContext());
        db.open();
        switch (ch){
            case 1:db.run("select State,Avg_Land_Rate from land");
                ArrayList<testadapter> a=db.st("Avg Land Rate(Rs./Sqft)");
                db.close();
                testadapter1 adapter1=new testadapter1(result.this,R.layout.litem,a);
                lv.setAdapter(adapter1);
                break;
            case 2:db.run("select State,No_of_Companies from company");
                ArrayList<testadapter> b=db.st("Total No. of Companies");
                db.close();
                testadapter1 adapter2=new testadapter1(result.this,R.layout.litem,b);
                lv.setAdapter(adapter2);
                break;
            case 3:db.run("select State,No_of_Schools,No_of_Colleges from land,education where land.State_code=education.State_code");
                ArrayList<testadapter2> c=db.st("Total No. of Schools","Total No. of Colleges");
                db.close();
                testadapter22 adapter3=new testadapter22(result.this,R.layout.litem1,c);
                lv.setAdapter(adapter3);
                break;
            case 4:db.run("select State,Literacy_rate_inPercent,Rank_in_Crime_Rate from land,people where land.State_code=people.State_code");
                ArrayList<testadapter2> d=db.st("Literacy Rate(%)","Rank in Crime Rate");
                db.close();
                testadapter22 adapter4=new testadapter22(result.this,R.layout.litem1,d);
                lv.setAdapter(adapter4);
                break;
            case 5:db.run("select State,No_of_Malls,No_of_Pubs from land,recreation where land.State_short_code=recreation.State_short_code");
                ArrayList<testadapter2> e=db.st("Total No of Malls","No of Pubs/Bars");
                db.close();
                testadapter22 adapter5=new testadapter22(result.this,R.layout.litem1,e);
                lv.setAdapter(adapter5);
                break;
            case 6:db.run("select State,Annual_Avg_Temp_inC,annual_avg_rain_inCm from land,weather where land.State_short_code=weather.State_short_code");
                ArrayList<testadapter2> f=db.st("Annual Avg Temp(ºC)","Annual Avg Rain(cm)");
                db.close();
                testadapter22 adapter6=new testadapter22(result.this,R.layout.litem1,f);
                lv.setAdapter(adapter6);
                break;
        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv=(TextView)view.findViewById(R.id.st);
                String st=tv.getText().toString();
                String name=st.toUpperCase();
                Intent intent = new Intent(getApplicationContext(), searchres.class);
                intent.putExtra("state",name);
                startActivity(intent);
            }
        });
        }catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public void filteritems(View view) {
        try {
            Bundle b1 = getIntent().getExtras();
            int ch = b1.getInt("key");
            lv = (ListView) findViewById(R.id.lresult);
            final DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
            db.open();
            EditText et1 = (EditText) findViewById(R.id.editText);
            EditText et2 = (EditText) findViewById(R.id.editText2);
            String min = et1.getText().toString();
            String max = et2.getText().toString();
            String query = null;
            if (TextUtils.isEmpty(min) && TextUtils.isEmpty(max)) {
                Toast.makeText(getApplicationContext(), "Enter values for filtering", Toast.LENGTH_LONG).show();
            } else {
                if (TextUtils.isEmpty(max)) {
                    query = " >= " + min;
                } else if (TextUtils.isEmpty(min)) {
                    query = " <= " + max;
                } else {
                    query = " between " + min + " and " + max;
                }
                switch (ch) {
                    case 1:
                        db.run("select State,Avg_Land_Rate from land where Avg_Land_Rate" + query);
                        ArrayList<testadapter> a = db.st("Avg Land Rate(Rs./Sqft)");
                        db.close();
                        testadapter1 adapter1 = new testadapter1(result.this, R.layout.litem, a);
                        lv.setAdapter(adapter1);
                        break;
                    case 2:
                        db.run("select State,No_of_Companies from company where No_of_Companies" + query);
                        ArrayList<testadapter> b = db.st("Total No. of Companies");
                        db.close();
                        testadapter1 adapter2 = new testadapter1(result.this, R.layout.litem, b);
                        lv.setAdapter(adapter2);
                        break;
                    case 3:
                        db.run("select State,No_of_Schools,No_of_Colleges from land,education where land.State_code=education.State_code " +
                                "and No_of_Schools + No_of_Colleges" + query);
                        ArrayList<testadapter2> c = db.st("Total No. of Schools", "Total No. of Colleges");
                        db.close();
                        testadapter22 adapter3 = new testadapter22(result.this, R.layout.litem1, c);
                        lv.setAdapter(adapter3);
                        break;
                    case 4:
                        db.run("select State,Literacy_rate_inPercent,Rank_in_Crime_Rate from land,people where land.State_code=people.State_code " +
                                "and Literacy_rate_inPercent" + query);
                        ArrayList<testadapter2> d = db.st("Literacy Rate(%)", "Rank in Crime Rate");
                        db.close();
                        testadapter22 adapter4 = new testadapter22(result.this, R.layout.litem1, d);
                        lv.setAdapter(adapter4);
                        break;
                    case 5:
                        db.run("select State,No_of_Malls,No_of_Pubs from land,recreation where land.State_short_code=recreation.State_short_code " +
                                "and No_of_Malls + No_of_Pubs" + query);
                        ArrayList<testadapter2> e = db.st("Total No of Malls", "No of Pubs/Bars");
                        db.close();
                        testadapter22 adapter5 = new testadapter22(result.this, R.layout.litem1, e);
                        lv.setAdapter(adapter5);
                        break;
                    case 6:
                        db.run("select State,Annual_Avg_Temp_inC,annual_avg_rain_inCm from land,weather where land.State_short_code=weather.State_short_code " +
                                "and Annual_Avg_Temp_inC" + query);
                        ArrayList<testadapter2> f = db.st("Annual Temp(ºC)", "Annual Rain(cm)");
                        db.close();
                        testadapter22 adapter6 = new testadapter22(result.this, R.layout.litem1, f);
                        lv.setAdapter(adapter6);
                        break;
                }
            }
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TextView tv = (TextView) view.findViewById(R.id.st);
                    String st = tv.getText().toString();
                    String name = st.toUpperCase();
                    Intent intent = new Intent(getApplicationContext(), searchres.class);
                    intent.putExtra("state", name);
                    startActivity(intent);
                }
            });
        }catch (Exception f){
            Toast.makeText(this,f.getMessage(),Toast.LENGTH_LONG).show();
        }

    }


}
