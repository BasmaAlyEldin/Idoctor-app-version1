package com.example.basma.idocproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class chatlist_Fragm extends Fragment {

    View v;
    private ListView list;
    ArrayList<chatlist_item> arr;
   chatlist_itemAdapter adp;
    public chatlist_Fragm() {
        // Required empty public constructor
    }

   public listener setlistener=new listener() {
       @Override
       public void ifclicked(boolean b) {

       }
   };

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);


        try {
            setlistener= (listener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement listener");
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       v=inflater.inflate(R.layout.fragment_chatlist_, container, false);
        chatlist_item ch2=new chatlist_item("Doctor Name ","hello new mesg",R.drawable.profimg,"4.30 pm");
        chatlist_item ch3=new chatlist_item("Doctor2 Name2 ","hello new mesg",R.drawable.profimg,"5 am");

        arr=new ArrayList<chatlist_item>();
        arr.add(ch2);
        arr.add(ch3);


        adp=new chatlist_itemAdapter(getContext(),R.layout.simple_list_chat_item_1,arr);

        list=v.findViewById(R.id.chatListView);
list.setAdapter(adp);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               if(setlistener!=null)
               {
                   setlistener.ifclicked(true);
               }

              //  Toast.makeText(getContext(),"hello",Toast.LENGTH_LONG).show(); //works
           //this opened frag in frag
           /*    FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_main, new MessageFragment());
                ft.commit(); */

            }
        });
        return v ;
    }


}
