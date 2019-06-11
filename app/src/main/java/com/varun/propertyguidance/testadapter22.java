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


class testadapter22 extends ArrayAdapter<testadapter2> {

    private Context mcontext;
    private int mresource;
    private int lastpos=-1;

    static class ViewHolder{
        TextView state;
        TextView prop1;
        TextView val1;
        TextView prop2;
        TextView val2;
    }

    public testadapter22(Context context, int resource, ArrayList<testadapter2> objects){
        super(context,resource,objects);
        mcontext=context;
        mresource=resource;
    }
    @Override
    public View getView(int pos, View convertView, ViewGroup parent){
        String state=getItem(pos).getState();
        String prop1=getItem(pos).getProp1();
        String val1=getItem(pos).getVal1();
        String prop2=getItem(pos).getProp2();
        String val2=getItem(pos).getVal2();

        testadapter2 ta=new testadapter2(state,prop1,val1,prop2,val2);

        final View result;

        ViewHolder holder;
        if (convertView==null){
            LayoutInflater inflater=LayoutInflater.from(mcontext);
            convertView=inflater.inflate(mresource,parent,false);
            holder=new ViewHolder();
            holder.state=(TextView)convertView.findViewById(R.id.st);
            holder.prop1=(TextView)convertView.findViewById(R.id.textView1);
            holder.val1=(TextView)convertView.findViewById(R.id.textView2);
            holder.prop2=(TextView)convertView.findViewById(R.id.textView3);
            holder.val2=(TextView)convertView.findViewById(R.id.textView4);

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
        holder.prop1.setText(prop1);
        holder.val1.setText(val1);
        holder.prop2.setText(prop2);
        holder.val2.setText(val2);

        return convertView;
    }
}
