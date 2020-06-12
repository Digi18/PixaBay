package Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pixa.DetailActivity;
import com.example.pixa.R;

import java.util.ArrayList;
import java.util.List;

import Model.Hit;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    List<Hit> photoList = new ArrayList();
    Activity context;
    GridLayoutManager mlayoutManager;

    public static final int SPAN_COUNT_THREE = 3;
    public static final int SPAN_COUNT_FOUR = 4;
    public static final int SPAN_COUNT_FIVE = 5;

    private static final int VIEW_THREE = 3;
    private static final int VIEW_FOUR = 4;
    private static final int VIEW_FIVE = 5;

    @Override
    public int getItemViewType(int position) {

        int  spanCount = mlayoutManager.getSpanCount();
        if(spanCount == SPAN_COUNT_THREE){
            return VIEW_THREE;
        }
        else if(spanCount == SPAN_COUNT_FOUR){
            return VIEW_FOUR;
        }
        else{
            return VIEW_FIVE;
        }
    }

    public PhotoAdapter(List<Hit> photoList, Context context, GridLayoutManager layoutManager) {
        this.photoList = photoList;
        this.context = (Activity) context;
        mlayoutManager = layoutManager;
    }


    @NonNull
    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        if(viewType == VIEW_THREE){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_three,parent,false);
        }
        else if(viewType == VIEW_FOUR){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_four,parent,false);
        }
        else if(viewType == VIEW_FIVE){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_five,parent,false);
        }
        else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_row_layout,parent,false);
        }

        return new ViewHolder(view,viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull final PhotoAdapter.ViewHolder holder, final int position) {

        final Hit hitModel = photoList.get(position);

        String str1 = hitModel.getLargeImageURL();

        RequestOptions requestOptions = new RequestOptions();

        if(getItemViewType(position) == VIEW_THREE){
            Glide.with(context).load(str1).apply(requestOptions).placeholder(R.color.place).into(holder.image3);
        }
        else if(getItemViewType(position) == VIEW_FOUR){
            Glide.with(context).load(str1).apply(requestOptions).placeholder(R.color.place).into(holder.image4);
        }
        else if(getItemViewType(position) == VIEW_FIVE){
            Glide.with(context).load(str1).apply(requestOptions).placeholder(R.color.place).into(holder.image5);
        }
        else{
            Glide.with(context).load(str1).apply(requestOptions).placeholder(R.color.place).into(holder.image);
       }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(getItemViewType(position) == VIEW_THREE){

                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("contentTwo", hitModel.getLargeImageURL());
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(context,holder.image3,"transition");
                    (context).startActivity(intent,options.toBundle());

                    Toast.makeText(context,"" +hitModel.getId(),Toast.LENGTH_SHORT).show();
               }
               else if(getItemViewType(position) == VIEW_FOUR){

                   Intent intent = new Intent(context, DetailActivity.class);
                   intent.putExtra("contentTwo", hitModel.getLargeImageURL());
                   ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(context,holder.image4,"transition");
                   (context).startActivity(intent,options.toBundle());
               }

               else if(getItemViewType(position) == VIEW_FIVE){

                   Intent intent = new Intent(context, DetailActivity.class);
                   intent.putExtra("contentTwo", hitModel.getLargeImageURL());
                   ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(context,holder.image5,"transition");
                   (context).startActivity(intent,options.toBundle());
               }

               else{

                   Intent intent = new Intent(context, DetailActivity.class);
                   intent.putExtra("contentTwo", hitModel.getLargeImageURL());
                   ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(context,holder.image,"transition");
                   (context).startActivity(intent,options.toBundle());
               }

            }
        });

    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image,image3,image4,image5;
        TextView text;

        public ViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);

           if(viewType == VIEW_THREE){
                image3 = itemView.findViewById(R.id.image3);
            }
            else if(viewType == VIEW_FOUR){
                image4 = itemView.findViewById(R.id.image4);
            }
            else if(viewType == VIEW_FIVE){
                image5 = itemView.findViewById(R.id.image5);
            }
            else{
                image = itemView.findViewById(R.id.image);
                text = itemView.findViewById(R.id.text);
            }
        }
    }
}
