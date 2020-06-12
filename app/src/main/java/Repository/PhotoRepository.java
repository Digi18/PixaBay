package Repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.pixa.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Hit;
import Model.Photos;
import Remote.ApiService;
import Remote.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PhotoRepository {

   List<Hit> hits = new ArrayList<>();
   MutableLiveData<List<Hit>> mutableLiveData = new MutableLiveData<>();
   Application application;

    public PhotoRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Hit>> getMutableLiveData(){

        Retrofit retrofit = RetrofitClient.getInstance();
        ApiService apiService = retrofit.create(ApiService.class);

       Map<String,String> map = new HashMap<>();
       map.put("key", Constant.API_KEY);

       Call<Photos> hitList = apiService.getPhotos(map);

       hitList.enqueue(new Callback<Photos>() {
            @Override
            public void onResponse(Call<Photos> call, Response<Photos> response) {

                Photos photos = (Photos) response.body();

                if(photos != null && photos.getHits() != null){

                    hits = photos.getHits();
                    mutableLiveData.setValue(hits);
                }
            }

            @Override
            public void onFailure(Call<Photos> call, Throwable t) {

                Toast.makeText(application,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        return mutableLiveData;
    }
}
