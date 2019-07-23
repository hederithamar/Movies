package briix.com.data.utils;

import android.support.annotation.NonNull;

import java.io.IOException;

import javax.inject.Inject;

import briix.com.data.preferences.Preferences;
import briix.com.data.preferences.PreferencesImpl;
import briix.com.data.services.MovieServices;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class InterceptorApiMovieService implements Interceptor {

    private static final String KEY_API_KEY = "api_key";
    private final String mApiKey;
    private String mAccessToken;

    public Preferences mPreferences;

    public InterceptorApiMovieService(String apiKey, String accessToken, Preferences mPreferences) {
        this.mApiKey = apiKey;
        this.mAccessToken = accessToken;
        this.mPreferences = mPreferences;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        HttpUrl originalHttpUrl = originalRequest.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter(KEY_API_KEY, mApiKey)
                .build();

        Request.Builder requestBuilder;
        if (originalRequest.header("No-Authentication") == null) {
            requestBuilder = originalRequest.newBuilder()
                    .addHeader("Authorization", "Bearer " + mPreferences.getAccessToken())
                    .url(url);
        } else {
            requestBuilder = originalRequest.newBuilder()
                    .addHeader("Authorization", "Bearer " + mAccessToken)
                    .url(url);
        }


        return chain.proceed(requestBuilder.build());
    }
}

