package briix.com.data.di;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

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

@Module
public class ApiMovieModule {
    private static final int TIMEOUT = 300;

    private String mBaseUrl;
    private String mApiKey;
    private String mAccessToken;
    private String appVersion;
    private boolean isLogEnabled = true;


    public ApiMovieModule(String baseUrl, String apikey, String accessToken, String appVersion) {
        this.mBaseUrl = baseUrl;
        this.mApiKey = apikey;
        this.mAccessToken = accessToken;
        this.appVersion = appVersion;
    }

    @Provides
    @Singleton
    public MovieApi provideMovieApi(@Named("retrofitMovie") Retrofit retrofit) {
        return retrofit.create(MovieApi.class);
    }

    @Provides
    @Singleton
    @Named("retrofitMovie")
    public Retrofit provideRetrofitMovie(@Named("retrofitBuilderMovie") Retrofit.Builder builder) {
        return builder.baseUrl(mBaseUrl).build();
    }

    @Provides
    @Singleton
    @Named("retrofitBuilderMovie")
    public Retrofit.Builder provideRetrofitBuilderMovie(@Named("convertFactoryMovie") Converter.Factory converterFactory) {

        final OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(isLogEnabled ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        OkHttpClient client = builder
                .addInterceptor(interceptor)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new InterceptorApiMovieService(mApiKey, mAccessToken))
                .build();

        return new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(converterFactory);
    }

    @Provides
    @Singleton
    @Named("convertFactoryMovie")
    public Converter.Factory provideConverterFactoryMovie(@Named("gsonMovie") Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
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
