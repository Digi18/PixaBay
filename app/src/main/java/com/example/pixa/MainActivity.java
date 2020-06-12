package com.example.pixa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapters.PhotoAdapter;
import Model.Hit;
import ViewModels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    ProgressBar progress;
    RecyclerView recyclerView;
    GridLayoutManager layoutManager;
    PhotoAdapter adapter;
    MainViewModel viewModel;
    List<Hit> lists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container),true);
        fade.excludeTarget(android.R.id.statusBarBackground,true);
        fade.excludeTarget(android.R.id.navigationBarBackground,true);

        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        progress = findViewById(R.id.progress);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this,1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.getlAllPhotos().observe(this, new Observer<List<Hit>>() {
            @Override
            public void onChanged(List<Hit> hits) {

                if(hits.size() > 0){

                    progress.setVisibility(View.INVISIBLE);

                    lists = hits;
                    adapter = new PhotoAdapter(lists,MainActivity.this,layoutManager);
                    recyclerView.setAdapter(adapter);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Nothing to show",Toast.LENGTH_SHORT).show();
                }
            }
        });

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder target, int direction) {

                int position = target.getAdapterPosition();
                lists.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        helper.attachToRecyclerView(recyclerView);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menus,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch(id){

            case R.id.one:
                layoutManager.setSpanCount(1);
                break;

            case R.id.three:
                layoutManager.setSpanCount(3);
                break;

            case R.id.four:
                layoutManager.setSpanCount(4);
                break;

            case R.id.five:
                layoutManager.setSpanCount(5);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}