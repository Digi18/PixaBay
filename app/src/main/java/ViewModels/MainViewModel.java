package ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import Model.Hit;
import Repository.PhotoRepository;

public class MainViewModel extends AndroidViewModel {

    PhotoRepository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);

        repository = new PhotoRepository(application);
    }

    public LiveData<List<Hit>> getlAllPhotos(){

        return repository.getMutableLiveData();
    }
}
