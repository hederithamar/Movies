package briix.com.movies.realm;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.ArrayList;

import briix.com.data.mvp.model.response.ResponseMovies;
import briix.com.movies.realm.model.ComingMovieEntity;
import briix.com.movies.realm.model.PopularMovieEntity;
import io.realm.Realm;
import io.realm.RealmQuery;

public class RealmController {
    public static final String TAG = "RealmController";

    private static final String FIELD_ID = "id";
    private static final String FIELD_KEY = "key";
    private static final String FIELD_MOVIE_KEY = "movieKey";

    private static final String ID_ESTABLISHMENTS_TOTAL = "999";
    private static final String DEFAULT_ESTABLISHMENTS_TOTAL = "15880";

    private static RealmController instance;
    private Realm realm;

    private RealmController() {
        this.realm = Realm.getDefaultInstance();
    }


    public static RealmController withInstance() {

        if (instance == null) {
            instance = new RealmController();
        }
        return instance;
    }


    public Realm getRealm() {
        return realm;
    }


    public boolean isDbOutdated() {
        String hashDb = getCatalogHash();
        return TextUtils.isEmpty(hashDb);
    }


    public String getCatalogHash() {
        String hashCatalog = null;
        PopularMovieEntity catalog = realm.where(PopularMovieEntity.class).findFirst();
        if (catalog != null) {
            hashCatalog = catalog.getTitle();
        }
        return hashCatalog;
    }

    public void cleanDB() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                realm.deleteAll();
            }
        });
    }

    public void updateCatalog(ResponseMovies movies, int service) {
        RealmController.withInstance().cleanDB();
        MasterCatalog masterCatalog = new MasterCatalog(movies, service);
        RealmController.withInstance().saveCatalog(masterCatalog);
    }


    public void saveCatalog(final MasterCatalog masterCatalog) {
        try {
            realm = Realm.getDefaultInstance();
            realm.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(@NonNull Realm realm) {
                    realm.insertOrUpdate(masterCatalog);
                }
            });
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }


    public ArrayList<ComingMovieEntity> getPopularMovies() {
        RealmQuery<ComingMovieEntity> query = realm.where(ComingMovieEntity.class);
        return new ArrayList<>(query.findAll());
    }

}
