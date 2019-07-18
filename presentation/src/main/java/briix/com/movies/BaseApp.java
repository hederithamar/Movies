package briix.com.movies;

import android.app.Application;

import briix.com.data.di.ApiMovieModule;
import briix.com.movies.data.Preferences;
import briix.com.movies.data.PreferencesImpl;
import briix.com.movies.di.AppComponent;
import briix.com.movies.di.DaggerAppComponent;
import briix.com.movies.utils.Constants;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import timber.log.Timber;

public class BaseApp extends Application {
    private static BaseApp instance;
    private Preferences mPreferences;

    public static BaseApp getInstance() {
        return instance;
    }

    private static AppComponent sAppComponent;

    private String mURL = "https://api.themoviedb.org/4/";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mPreferences = PreferencesImpl.getInstance(this);
        initLibrary();
        setupRealm();
        configureTimber();

    }

    private void initLibrary() {
        sAppComponent = DaggerAppComponent.builder()
                .apiMovieModule(new ApiMovieModule(mURL, getString(R.string.api_key),
                        getString(R.string.api_key_v4), "1.0"))
                .build();

    }

    private void setupRealm() {
        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .name(Constants.SCHEMA_NAME_BD)
                .schemaVersion(Constants.SCHEMA_VERSION_BD)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfig);
    }

    private void configureTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }
}
