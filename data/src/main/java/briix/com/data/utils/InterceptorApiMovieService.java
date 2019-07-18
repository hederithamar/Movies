package briix.com.data.utils;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class InterceptorApiMovieService implements Interceptor {

    private static final String KEY_API_KEY = "api_key";
    private final String mApiKey;
    private final String mAccessToken;

    public InterceptorApiMovieService(String apiKey, String accessToken) {
        this.mApiKey = apiKey;
        this.mAccessToken = accessToken;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        HttpUrl originalHttpUrl = originalRequest.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter(KEY_API_KEY, mApiKey)
                .build();

        // Request customization: add request headers
        Request.Builder requestBuilder = originalRequest.newBuilder()
                .addHeader("Authorization", "Bearer " + mAccessToken)
                .url(url);

        return chain.proceed(requestBuilder.build());
    }
}

