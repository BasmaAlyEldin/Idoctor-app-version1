package com.example.basma.idocproject;

/**
 * Created by basma on 16/09/2017.
 */
public class chatlist_item {

    public String username;
    public String messagetxt;
    public String duration;

    //  public String imgurl;
  public int imgurl;


    public chatlist_item(String username , String messagetxt,int imgurl ,String duration) {
        // TODO Auto-generated constructor stub
        super();
        this.username=username;
        this.messagetxt = messagetxt;
        this.imgurl=imgurl;
        this.duration=duration;
    }


}
