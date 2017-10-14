package com.example.basma.idocproject;

/**
 * Created by basma on 15/09/2017.
 */
public class ChatMessage {

    public boolean left;
    public String message;
    public String duration;
    public int imgprof;

    public ChatMessage(String message ,int imgprof ,String duration) {
        // TODO Auto-generated constructor stub
        super();
       // this.left=left;
        this.message = message;
        this.imgprof=imgprof;
        this.duration=duration;
    }

}
