package com.varun.propertyguidance;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.text.InputType.TYPE_TEXT_FLAG_CAP_WORDS;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);
        final SearchView sv=(SearchView) menu.findItem(R.id.search_bar).getActionView();
        SearchManager sm=(SearchManager) getSystemService(Context.SEARCH_SERVICE);
        sv.setSearchableInfo(sm.getSearchableInfo(getComponentName()));
        sv.setQueryHint("Search a State for its stats");
        sv.setInputType(TYPE_TEXT_FLAG_CAP_WORDS);
        try {
            sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    //create instance of database class and open connection
                    DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                    databaseAccess.open();
                    String name = query.toUpperCase();
                    databaseAccess.run("select State from land where upper(land.state) like '%" + name + "%'");
                    if (databaseAccess.c.moveToFirst()) {
                        databaseAccess.close();
                        Intent intent = new Intent(getApplicationContext(), searchint.class);
                        intent.putExtra("state", name);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "State not found", Toast.LENGTH_SHORT).show();
                    }
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG);
        }
        return true;
    }

    public void gcost(View view) {
        Intent i=new Intent(getApplicationContext(),result.class);
        i.putExtra("key",1);
        startActivity(i);
    }

    public void gcomp(View view) {
        Intent i=new Intent(getApplicationContext(),result.class);
        i.putExtra("key",2);
        startActivity(i);
    }

    public void gsc(View view) {
        Intent i=new Intent(getApplicationContext(),result.class);
        i.putExtra("key",3);
        startActivity(i);
    }

    public void glc(View view) {
        Intent i=new Intent(getApplicationContext(),result.class);
        i.putExtra("key",4);
        startActivity(i);
    }

    public void gmp(View view) {
        Intent i=new Intent(getApplicationContext(),result.class);
        i.putExtra("key",5);
        startActivity(i);
    }

    public void gtr(View view) {
        Intent i=new Intent(getApplicationContext(),result.class);
        i.putExtra("key",6);
        startActivity(i);
    }
}
