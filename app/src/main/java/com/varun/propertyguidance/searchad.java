package com.varun.propertyguidance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class searchad extends ArrayAdapter<searchadapter> {
    private Context mcontext;
    private int mresource;
    private int lastpos=-1;

    static class ViewHolder{
        TextView state;
    }

    public searchad(Context context, int resource, ArrayList<searchadapter> objects){
        super(context,resource,objects);
        mcontext=context;
        mresource=resource;
    }
    @Override
    public View getView(int pos, View convertView, ViewGroup parent){
        String state=getItem(pos).getSt();
        searchadapter sa=new searchadapter(state);

        final View result;

        searchad.ViewHolder holder;
        if (convertView==null){
            LayoutInflater inflater=LayoutInflater.from(mcontext);
            convertView=inflater.inflate(mresource,parent,false);
            holder=new searchad.ViewHolder();
            holder.state=(TextView)convertView.findViewById(R.id.txtst);
            result=convertView;

            convertView.setTag(holder);

        }
        else {
            holder=(searchad.ViewHolder)convertView.getTag();
            result=convertView;
        }


        /*Animation animation= AnimationUtils.loadAnimation(mcontext,
                (pos > lastpos) ? R.anim.scroll_down : R.anim.scroll_up );
        result.startAnimation(animation);
        lastpos=pos;*/

        holder.state.setText(state);
        return convertView;
    }
}
