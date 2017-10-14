package com.example.basma.idocproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class ChatMessageAdapter extends  ArrayAdapter<ChatMessage> {

    private TextView chatText;
    private TextView duration;
    private CircleImageView img;
    private List<ChatMessage> MessageList = new ArrayList<ChatMessage>();
    private LinearLayout layout;


    public ChatMessageAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }
    public void add(ChatMessage object) {

        // TODO Auto-generated method stub

        MessageList.add(object);
        super.add(object);
    }


    public int getCount()
    {
        return this.MessageList.size();
    }

    public ChatMessage getItem(int index){

        return this.MessageList.get(index);
    }

    public View getView(int position,View ConvertView, ViewGroup parent){

        View v = ConvertView;
        if(v==null){

            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v =inflater.inflate(R.layout.simple_list_chat_txt_item_1, parent,false);

        }

        layout = (LinearLayout)v.findViewById(R.id.Message1);
        ChatMessage messageobj = getItem(position);
        chatText =(TextView)v.findViewById(R.id.SingleMessagetxt);
        duration=(TextView)v.findViewById(R.id.duration);
        img=(CircleImageView)v.findViewById(R.id.profimg);
        img.setImageResource(messageobj.imgprof);
        chatText.setText(messageobj.message);
        duration.setText(messageobj.duration);
        // chatText.setBackgroundResource(messageobj.left ? R.drawable.shape_bg_outgoing_bubble:R.drawable.bg_bubble);
        // layout.setGravity(messageobj.left?Gravity.LEFT: Gravity.RIGHT);
        return v;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}





    /*
    BaseAdapter
    Context context;
    private TextView duration;
    private int layoutResourceId;
    List<ChatMessage> ArrayOfData =new ArrayList<>();
    LayoutInflater inflater;


    public ChatMessageAdapter(Context context, int layoutResourceId,ArrayList ArrayOfData) {

        this.context= context;
        this.ArrayOfData=ArrayOfData;
        this.layoutResourceId = layoutResourceId;
    }


    @Override
    public int getCount() {
        return ArrayOfData.size();
    }

    @Override
    public ChatMessage getItem(int i) {
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
        TextView mesg;
        ChatMessage object=ArrayOfData.get(i);
        if(v==null)
        {
            inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            v= inflater.inflate(R.layout.simple_list_chat_txt_item_1,null);
        }


        profimg=(CircleImageView)v.findViewById(R.id.profimg);
        mesg=(TextView)v.findViewById(R.id.mesgtxt);
        duration=(TextView)v.findViewById(R.id.duration);


        //String url="http://image.tmdb.org/t/p/w185"+ArrayOfData.get(i);

        //Picasso.with(context).load(url).into(img);
        profimg.setImageResource(object.imgprof);
        mesg.setText(object.message);
        duration.setText(object.duration);
        return v;
    }

} */


