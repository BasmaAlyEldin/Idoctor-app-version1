package com.example.basma.idocproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class chatlist_itemAdapter extends BaseAdapter
{
    Context context;
    private TextView duration;
    private int layoutResourceId;
    List<chatlist_item> ArrayOfData =new ArrayList<>();
    LayoutInflater inflater;


    public chatlist_itemAdapter(Context context, int layoutResourceId,ArrayList ArrayOfData) {

        this.context= context;
        this.ArrayOfData=ArrayOfData;
        this.layoutResourceId = layoutResourceId;
    }


    @Override
    public int getCount() {
        return ArrayOfData.size();
    }

    @Override
    public chatlist_item getItem(int i) {
        return ArrayOfData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v=view;
        CircleImageView profimg;
        TextView username;
        TextView mesg;
       chatlist_item object=ArrayOfData.get(i);
        if(v==null)
        {
            inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            v= inflater.inflate(R.layout.simple_list_chat_item_1,null);
        }


        profimg=(CircleImageView)v.findViewById(R.id.profimg);
        username=(TextView)v.findViewById(R.id.username);
        mesg=(TextView)v.findViewById(R.id.mesgtxt);
        duration=(TextView)v.findViewById(R.id.duration);


        //String url="http://image.tmdb.org/t/p/w185"+ArrayOfData.get(i);

        //Picasso.with(context).load(url).into(img);
profimg.setImageResource(object.imgurl);
username.setText(object.username);
 mesg.setText(object.messagetxt);
duration.setText(object.duration);
        return v;
    }

}
