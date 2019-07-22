package briix.com.data.di;

import android.content.Context;
import android.preference.Preference;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;

import briix.com.data.preferences.Preferences;
import briix.com.data.services.MovieApi;
import briix.com.data.utils.InterceptorApiMovieService;
import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {PreferencesModule.class})
public class ApiMovieModule {
    private static final int TIMEOUT = 300;
    private String mBaseUrl;
    private String mApiKey;
    private String mAccessToken;
    private String appVersion;
    private boolean isLogEnabled = true;

    Preference mPreference;

    public ApiMovieModule(String baseUrl, String apikey, String accessToken,
                          String appVersion) {
        this.mBaseUrl = baseUrl;
        this.mApiKey = apikey;
        this.mAccessToken = accessToken;
        this.appVersion = appVersion;
    }

    @Provides
    public MovieApi provideMovieApi(@Named("retrofitMovie") Retrofit retrofit) {
        return retrofit.create(MovieApi.class);
    }

    @Provides
    @Named("retrofitMovie")
    public Retrofit provideRetrofitMovie(@Named("retrofitBuilderMovie") Retrofit.Builder builder) {
        return builder.baseUrl(mBaseUrl).build();
    }

    @Inject
    @Provides
    @Named("retrofitBuilderMovie")
    public Retrofit.Builder provideRetrofitBuilderMovie(@Named("convertFactoryMovie") Converter.Factory converterFactory, Preferences mPreferences) {

        final OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(isLogEnabled ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        OkHttpClient client = builder
                .addInterceptor(interceptor)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new InterceptorApiMovieService(mApiKey, mAccessToken, mPreferences))
                .build();

        return new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(converterFactory);
    }

    @Provides
    @Named("convertFactoryMovie")
    public Converter.Factory provideConverterFactoryMovie(@Named("gsonMovie") Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Named("gsonMovie")
    public Gson provideGsonMovie() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                //.setFieldNamingStrategy(new CustomFieldNamingPolicy())
                .setPrettyPrinting()
                .setLenient()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                //.serializeNulls()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

}
