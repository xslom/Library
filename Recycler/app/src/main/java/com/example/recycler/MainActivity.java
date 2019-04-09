package com.example.recycler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.recycler.API.APIGuy;
import com.example.recycler.API.APIINTERFACE;
import com.example.recycler.API.Books;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements LibraryAdapter.OnbookListen_ {


    RecyclerView recyclerView;

    RecyclerView.LayoutManager LayoutManager;
    List<Books> Itemlist;
    private LibraryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.RECV);

        LayoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(LayoutManager);
        mAdapter=new LibraryAdapter(getApplicationContext(),Itemlist,this);
        recyclerView.setAdapter(mAdapter);










        APIINTERFACE apiService = APIGuy.getClient().create(APIINTERFACE.class);
        Call<List<Books>> call=apiService.getBooks();
        call.enqueue(new Callback<List<Books>>() {
            @Override
            public void onResponse(Call<List<Books>> call, Response<List<Books>> response) {
                Itemlist = response.body();
                Log.d("TAG","Response = "+Itemlist);
                mAdapter.setItemlist(Itemlist);
            }
            @Override
            public void onFailure(Call<List<Books>> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
            }
        });



    }


    @Override
    public void onBookclick(int postion) {

        Intent intent =new Intent(this,InfoActivity.class);
        intent.putExtra("image",Itemlist.get(postion).getImage());
        intent.putExtra("Descrption",Itemlist.get(postion).getHave().getDesc());
        intent.putExtra("icon",Itemlist.get(postion).getHave().getLogo());
        intent.putExtra("Link",Itemlist.get(postion).getHave().getLink());

        startActivity(intent);
    }
}
