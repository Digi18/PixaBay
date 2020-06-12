package Remote;

import java.util.List;
import java.util.Map;

import Model.Photos;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {

  /*  @GET("api/")
    Call<List<Photos>> getPhotos(@Query("key") String key);

    @GET("api/?key=16983403-ec9e92eb691fcb6038e15f8c2")
    Call<List<Photos>> getPhotos();  */

    @GET("api")
    Call<Photos> getPhotos(@QueryMap Map<String,String> map);
}
