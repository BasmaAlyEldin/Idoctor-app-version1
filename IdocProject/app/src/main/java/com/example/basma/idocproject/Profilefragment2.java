package com.example.basma.idocproject;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.method.KeyListener;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;


public class Profilefragment2 extends Fragment {

    View v;
    //CircleImageView profileimg;
    DataWeb dw;
    private String encoded_string, image_name;
    private Bitmap bitmap;
    TextView dr,drname;
    Uri selectedImg;
    String picturePath;
    private static final int SELECT_PICTURE = 0;
    private static int RESULT_LOAD_IMAGE = 1;
    private static int IMAGE_PICKER_SELECT=1;
    KeyListener variableinf,variableloc;
    ImageView profileimg;
    Button editimg,saveimg,cancelimg,editinfo,saveinfo,cancelinfo,editloc,saveloc,cancelloc,savesp ;
    ImageButton  star0,star1,star2,star3,star4,star5,star6;
   boolean b1=false,b2=false,b3=false,b4=false,b5=false;
    ProgressDialog pDialog;
    String image;
    EditText spectialist,editinfotxt ,editloctxt;
   TextView info;

    public Profilefragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_profilefragment2, container, false);
        profileimg = (CircleImageView) v.findViewById(R.id.profimg);
        info = (TextView) v.findViewById(R.id.info);
        dr = (TextView) v.findViewById(R.id.dr);
        drname = (TextView) v.findViewById(R.id.drname);
        editimg = (Button) v.findViewById(R.id.etimg);
        saveimg = (Button) v.findViewById(R.id.saveimg);
        cancelimg = (Button) v.findViewById(R.id.cancelimg);
        editinfo = (Button) v.findViewById(R.id.editinfo);
        saveinfo = (Button) v.findViewById(R.id.saveinfo);
        cancelinfo = (Button) v.findViewById(R.id.cancelinfo);
        editloc = (Button) v.findViewById(R.id.editloc);
        saveloc = (Button) v.findViewById(R.id.saveloc);
        cancelloc = (Button) v.findViewById(R.id.cancelloc);
        savesp=(Button)v.findViewById(R.id.sv_sp);
        spectialist=(EditText)v.findViewById(R.id.sp);
        editinfotxt = (EditText) v.findViewById(R.id.infotxt);
        editloctxt = (EditText) v.findViewById(R.id.loclink);
        editinfotxt=(EditText)v.findViewById(R.id.infotxt);

        variableinf=editinfotxt.getKeyListener();
        editinfotxt.setKeyListener(null);

        variableloc=editloctxt.getKeyListener();
        editloctxt.setKeyListener(null);

        dw=new DataWeb(getContext());


        savesp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dw.execute(spectialist.getText().toString());

            }
        });


        editinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editinfotxt.setKeyListener(variableinf);
                saveinfo.setVisibility(view.VISIBLE);
                cancelinfo.setVisibility(view.VISIBLE);
            }
        });

        editloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editloctxt.setKeyListener(variableloc);
                saveloc.setVisibility(view.VISIBLE);
                cancelloc.setVisibility(view.VISIBLE);
                //editloctxt.setEnabled(true);
            }
        });


        star0 = (ImageButton) v.findViewById(R.id.rate6);
        star1 = (ImageButton) v.findViewById(R.id.rate5);
        star2 = (ImageButton) v.findViewById(R.id.rate);
        star3 = (ImageButton) v.findViewById(R.id.rate2);
        star4 = (ImageButton) v.findViewById(R.id.rate3);
        star5 = (ImageButton) v.findViewById(R.id.rate4);




        editimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                Log.d("On click listnet=r", "From inside click");
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);
                saveimg.setVisibility(view.VISIBLE);
                cancelimg.setVisibility(view.VISIBLE);

            }

        });


        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (b1 == false) {

                    star1.setImageResource(R.drawable.ic_grade_black_24dp);
                    star2.setImageResource(R.drawable.ic_grade_black_24dp);
                    star3.setImageResource(R.drawable.ic_grade_black_24dp);
                    star4.setImageResource(R.drawable.ic_grade_black_24dp);
                    star5.setImageResource(R.drawable.ic_grade_black_24dp);
                    b1 = true;
                } else {
                    star1.setImageResource(R.drawable.ic_star_border_black_24dp);
                    star2.setImageResource(R.drawable.ic_star_border_black_24dp);
                    star3.setImageResource(R.drawable.ic_star_border_black_24dp);
                    star4.setImageResource(R.drawable.ic_star_border_black_24dp);
                    star5.setImageResource(R.drawable.ic_star_border_black_24dp);
                    b1 = false;
                }


            }
        });

        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b2 == false) {

                    star2.setImageResource(R.drawable.ic_grade_black_24dp);
                    star3.setImageResource(R.drawable.ic_grade_black_24dp);
                    star4.setImageResource(R.drawable.ic_grade_black_24dp);
                    star5.setImageResource(R.drawable.ic_grade_black_24dp);
                    star1.setImageResource(R.drawable.ic_star_border_black_24dp);
                    b2 = true;
                } else {
                    star2.setImageResource(R.drawable.ic_star_border_black_24dp);
                    star3.setImageResource(R.drawable.ic_star_border_black_24dp);
                    star4.setImageResource(R.drawable.ic_star_border_black_24dp);
                    star5.setImageResource(R.drawable.ic_star_border_black_24dp);
                    b2 = false;
                }

            }
        });

        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (b3 == false) {
                    star3.setImageResource(R.drawable.ic_grade_black_24dp);
                    star4.setImageResource(R.drawable.ic_grade_black_24dp);
                    star5.setImageResource(R.drawable.ic_grade_black_24dp);
                    star1.setImageResource(R.drawable.ic_star_border_black_24dp);
                    star2.setImageResource(R.drawable.ic_star_border_black_24dp);

                    b3 = true;

                } else {
                    star3.setImageResource(R.drawable.ic_star_border_black_24dp);
                    star4.setImageResource(R.drawable.ic_star_border_black_24dp);
                    star5.setImageResource(R.drawable.ic_star_border_black_24dp);
                    b3 = false;
                }

            }
        });

        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b4 == false) {
                    star4.setImageResource(R.drawable.ic_grade_black_24dp);
                    star5.setImageResource(R.drawable.ic_grade_black_24dp);
                    star1.setImageResource(R.drawable.ic_star_border_black_24dp);
                    star2.setImageResource(R.drawable.ic_star_border_black_24dp);
                    star3.setImageResource(R.drawable.ic_star_border_black_24dp);
                    b4 = true;
                } else {

                    star4.setImageResource(R.drawable.ic_star_border_black_24dp);
                    star5.setImageResource(R.drawable.ic_star_border_black_24dp);

                    b4 = false;
                }

            }
        });

        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b5 == false) {
                    star5.setImageResource(R.drawable.ic_grade_black_24dp);
                    star1.setImageResource(R.drawable.ic_star_border_black_24dp);
                    star2.setImageResource(R.drawable.ic_star_border_black_24dp);
                    star3.setImageResource(R.drawable.ic_star_border_black_24dp);
                    star4.setImageResource(R.drawable.ic_star_border_black_24dp);
                    b5 = true;
                } else {
                    star5.setImageResource(R.drawable.ic_grade_black_24dp);
                    b5 = false;
                }

            }
        });




        return v;
    }

   @Override

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap;
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data)
        {
           selectedImg = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor =getActivity().getContentResolver().query(selectedImg, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);

            //Log.d("onActivityResult",picturePath);

            profileimg=(CircleImageView)v.findViewById(R.id.profimg);

            profileimg.setImageBitmap(BitmapFactory.decodeFile(picturePath));

          //  new Encode_image().execute();

            cursor.close();

            /*

            // Log.d("onActivityResultBitmap",String.valueOf(BitmapFactory.decodeFile(picturePath)));
        //for convert image into bitmap
            try {
                bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(selectedImg));
                Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 500, 500, false);
                image = ConvertBitmapToString(resizedBitmap);

                //Upload();

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } */
        }

    }

    //method to convert the selected image to base64 encoded string

   /* public static String ConvertBitmapToString(Bitmap bitmap){
        String encodedImage = "";

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        try {
            encodedImage= URLEncoder.encode(Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return encodedImage;
    } */




/*
private class Encode_image extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... voids) {

        bitmap = BitmapFactory.decodeFile(picturePath);//fileuri.getpath
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        bitmap.recycle();

        byte[] array = stream.toByteArray();
        encoded_string = Base64.encodeToString(array, 0);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        makeRequest();
    }
}

    private void makeRequest() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, "http://192.168.1.70:89/tutorial3/connection.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map = new HashMap<>();
                map.put("encoded_string",encoded_string);
                map.put("image_name",image_name);

                return map;
            }
        };
        requestQueue.add(request);
    } */
}

//dont forget when doctor login ,app will get username,profileimg ,drInfo from server