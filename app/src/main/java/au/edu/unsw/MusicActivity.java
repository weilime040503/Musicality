package au.edu.unsw;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MusicActivity  extends AppCompatActivity {

    private String TAG = "MusicActivity";
    private RecyclerView recyclerview;
    private MusicAdapter adapter;
    private List<Cloud> list = new ArrayList<>();

    @Override
    //create the recyclerview to contains the item for clicking
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        recyclerview =findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MusicAdapter(this,list);
        recyclerview.setAdapter(adapter);
        getCloud();
        adapter.setOnItemClickListener(new MusicAdapter.ItemClickListener() {
            @Override
            // navigate to the music playing in api
            public void setOnItemClickListener(int position) {
                Cloud music = list.get(position);
                Intent intent= new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(music.getUrl());
                intent.setData(content_url);
                startActivity(intent);
            }
        });
    }
    // get online resources from "https://api.mixcloud.com/"
    private void getCloud(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mixcloud.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.show();
        final MixCloudService service = retrofit.create(MixCloudService.class);
        Call<CloudResponse> call = service.getCloud();
        call.enqueue(new Callback<CloudResponse>() {
            @Override
            public void onResponse(Call<CloudResponse> call, Response<CloudResponse> response) {
                dialog.dismiss();
                if (response.isSuccessful()){
                    try {
                        CloudResponse cloudResponse = response.body();
                        Log.e(TAG,"onResponse  is "+cloudResponse);
                        List<Cloud> dataList = cloudResponse.getData();
                        list.clear();
                        list.addAll(dataList);
                        adapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(TAG,"Exception ");
                    }
                }else{
                    Log.e(TAG,"onResponse error is "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<CloudResponse> call, Throwable t) {
                dialog.dismiss();
                Log.e(TAG,"onFailure "+t.getLocalizedMessage());
            }
        });
    }
}
