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


class testadapter1 extends ArrayAdapter<testadapter> {

    private Context mcontext;
    private int mresource;
    private int lastpos=-1;

    static class ViewHolder{
        TextView state;
        TextView prop;
        TextView val;
    }

    public testadapter1(Context context, int resource, ArrayList<testadapter> objects){
        super(context,resource,objects);
        mcontext=context;
        mresource=resource;
    }
    @Override
    public View getView(int pos, View convertView, ViewGroup parent){
        String state=getItem(pos).getState();
        String prop=getItem(pos).getProp();
        String val=getItem(pos).getVal();

        testadapter ta=new testadapter(state,prop,val);

        final View result;

        ViewHolder holder;
        if (convertView==null){
            LayoutInflater inflater=LayoutInflater.from(mcontext);
            convertView=inflater.inflate(mresource,parent,false);
            holder=new ViewHolder();
            holder.state=(TextView)convertView.findViewById(R.id.st);
            holder.prop=(TextView)convertView.findViewById(R.id.tv1);
            holder.val=(TextView)convertView.findViewById(R.id.tv2);

            result=convertView;

            convertView.setTag(holder);

        }
        else {
            holder=(ViewHolder)convertView.getTag();
            result=convertView;
        }


        /*Animation animation= AnimationUtils.loadAnimation(mcontext,
                (pos > lastpos) ? R.anim.scroll_down : R.anim.scroll_up );
        result.startAnimation(animation);
        lastpos=pos;*/

        holder.state.setText(state);
        holder.prop.setText(prop);
        holder.val.setText(val);

        return convertView;
    }
}
