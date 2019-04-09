package com.example.recycler;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.recycler.API.Books;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.AViewHolder> {
    private  List<Books> itemlist;
     Context mContext;
     OnbookListen_ mOnbookListen_;
     class AViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
          ImageView imageView;
          TextView textView;
          OnbookListen_ onbookListen_;
         AViewHolder(@NonNull View itemView,OnbookListen_ onbookListen_) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image1);
            textView=itemView.findViewById(R.id.text1);
            this.onbookListen_=onbookListen_;
            imageView.setOnClickListener(this);

        }
         void bind(int listIndex){
            textView.setText(itemlist.get(listIndex).getTitle());
            Glide.with(mContext).load(itemlist.get(listIndex).getImage())
                    .apply(RequestOptions.centerInsideTransform()).into(imageView);
        }

         @Override
         public void onClick(View v) {
        onbookListen_.onBookclick(getAdapterPosition());
         }
     }


    public void setItemlist(List<Books> itemlist) {
        this.itemlist = itemlist;
        notifyDataSetChanged();
    }

    public LibraryAdapter( Context mContext,List<Books> itemlist,OnbookListen_ onbookListen_) {
        this.itemlist = itemlist;
        this.mContext = mContext;
        mOnbookListen_=onbookListen_;
    }



    @NonNull
    @Override
    public AViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        int layoutIdForListItem = R.layout.item;
        LayoutInflater inflater = LayoutInflater.from(mContext);

        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
        AViewHolder viewHolder=new AViewHolder(view,mOnbookListen_);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AViewHolder aViewHolder, int i) {

        aViewHolder.bind(i);


     }

    @Override
    public int getItemCount() {
        if(itemlist != null){
            return itemlist.size();
        }
        return 0;
    }
    public interface OnbookListen_{
         void onBookclick(int postion);

    }
}
