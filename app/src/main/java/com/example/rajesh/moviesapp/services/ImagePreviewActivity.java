package com.example.rajesh.moviesapp.services;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.rajesh.moviesapp.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class ImagePreviewActivity extends Activity {
    private ImageView ivPreview;
    Bitmap bmp;

    ImageView imageview;
    Bitmap bitmap;
    View view;
    ByteArrayOutputStream bytearrayoutputstream;
    File file;
    FileOutputStream fileoutputstream;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_image_view);
        bmp = getIntent().getParcelableExtra("bitmap");
        //Bitmap bitmap= Bitmap.createScaledBitmap(bmp,bmp.getHeight(),bmp.getWidth(),false);
        ivPreview = (ImageView) findViewById(R.id.ivPreview);
        ivPreview.setImageBitmap(bmp);
        button=(Button)findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }




    public void save() {


        if (ContextCompat.checkSelfPermission(ImagePreviewActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale
                    (ImagePreviewActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                ActivityCompat.requestPermissions(ImagePreviewActivity.this, new String[]
                        {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                Toast.makeText(this,"hi 1",Toast.LENGTH_LONG).show();
               // savedata();
            } else {
                ActivityCompat.requestPermissions(ImagePreviewActivity.this, new String[]
                        {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                Toast.makeText(this,"hi 2",Toast.LENGTH_LONG).show();

            }



        }
       else {
           savedata();
       }


    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    savedata();


                } else {

                }
                return;
            }


        }
    }

    public void savedata() {

        // TODO Auto-generated method stub

        bytearrayoutputstream = new ByteArrayOutputStream();
        Drawable drawable = getResources().getDrawable(R.drawable.sd);

        bmp = ((BitmapDrawable) drawable).getBitmap();

        bmp.compress(Bitmap.CompressFormat.PNG, 60, bytearrayoutputstream);

        file = new File(Environment.getExternalStorageDirectory() + "/Sample.png");

        try

        {
            file.createNewFile();

            fileoutputstream = new FileOutputStream(file);

            fileoutputstream.write(bytearrayoutputstream.toByteArray());

            fileoutputstream.close();

        } catch (Exception e)

        {

            e.printStackTrace();

        }

        Toast.makeText(ImagePreviewActivity.this, "Image Saved Successfully", Toast.LENGTH_LONG).show();

    }
}






