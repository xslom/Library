package com.example.recycler;

import android.content.Intent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


import android.text.method.LinkMovementMethod;

public class InfoActivity extends AppCompatActivity {
    private static final String TAG = "InfoActivity";
TextView Desc,url;
ImageView imageView,icon;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        Log.d(TAG, "onCreate: Started");
        Intent intent=getIntent();
        icon=findViewById(R.id.logo);
        Desc=findViewById(R.id.desc);
        url=findViewById(R.id.Price);
        imageView=findViewById(R.id.image2);
        String descrption=intent.getSerializableExtra("Descrption").toString();
        String urll=intent.getSerializableExtra("Link").toString();
        String logo=intent.getSerializableExtra("icon").toString();
        String pic=intent.getSerializableExtra("image").toString();

        Spanned formattedText = Html.fromHtml("Click  <br />" +
                "<a href='"+urll+"'>Here</a> to visit the website");
// or getString(R.string.htmlFormattedText);

        url.setMovementMethod(LinkMovementMethod.getInstance());
        url.setText(formattedText);
        Desc.setText(descrption);
        Glide.with(this).load(pic)
                .apply(RequestOptions.centerInsideTransform()).into(imageView);
        Glide.with(this).load(logo)
                .apply(RequestOptions.centerInsideTransform()).into(icon);
    }
}
