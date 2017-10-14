package com.example.basma.idocproject;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;


public class MessageFragment extends Fragment {

    View v;
  // ArrayList<String> arr2;
    private ChatMessageAdapter adp;
    //ArrayList<ChatMessage> arr;
    private ListView list;
    private EditText chatText;
    private ImageButton send;
    Intent intent;
    private boolean side = false;
    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         v=inflater.inflate(R.layout.fragment_message, container, false);



        send = (ImageButton)v.findViewById(R.id.sendMessageButton);
        list = (ListView)v.findViewById(R.id.msgListView);
        adp = new ChatMessageAdapter(getContext(), R.layout.simple_list_chat_txt_item_1);

        chatText = (EditText)v.findViewById(R.id.messageEditText);

       chatText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode ==
                        KeyEvent.KEYCODE_ENTER)) {

                    return sendChatMessage();
                }
                return false;
            }
        });
     //   arr=new ArrayList<ChatMessage>();


        list.setAdapter(adp);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                sendChatMessage();

              //  arr.add(new ChatMessage(chatText.getText().toString(),R.drawable.profimg,"666"));
               // adp=new ChatMessageAdapter(getContext(),R.layout.simple_list_chat_txt_item_1,arr);

            }
        });
        list.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        list.setAdapter(adp);
        adp.registerDataSetObserver(new DataSetObserver() {
            public void OnChanged(){
                super.onChanged();
                list.setSelection(adp.getCount() -1);
            }
        });


        return v;
    }

    private boolean sendChatMessage(){
        adp.add(new ChatMessage(chatText.getText().toString(),R.drawable.profimg,"4.45"));
        chatText.setText("");
        side = !side;
        return true;
    }
}
