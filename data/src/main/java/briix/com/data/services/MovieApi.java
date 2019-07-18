package briix.com.data.services;


import java.util.Map;

import briix.com.data.mvp.model.request.RequestCreateAccessToken;
import briix.com.data.mvp.model.request.RequestToken;
import briix.com.data.mvp.model.response.ResponseCreateAccessToken;
import briix.com.data.mvp.model.response.ResponseMovies;
import briix.com.data.mvp.model.response.ResponseToken;
import briix.com.data.utils.ApiEndPoint;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MovieApi {

    @Headers("Content-Type: application/json")
    @POST(ApiEndPoint.ENDPOINT_REQUEST_TOKEN)
    Single<ResponseToken> getToken(@Body RequestToken mRequest);

    @Headers("Content-Type: application/json")
    @POST(ApiEndPoint.ENDPOINT_CREATE_ACCESS_TOKEN)
    Single<ResponseCreateAccessToken> createAccessToken(@Body RequestCreateAccessToken mRequest);

    @Headers("Content-Type: application/json")
    @POST(ApiEndPoint.ENDPOINT_POPULAR_MOVIES)
    Single<ResponseMovies> getPopularMovies(@QueryMap Map<String, String> options);

    @Headers("Content-Type: application/json")
    @POST(ApiEndPoint.ENDPOINT_TOP_RATED_MOVIES)
    Single<ResponseMovies> getTopRatedMovies(@QueryMap Map<String, String> options);

    @Headers("Content-Type: application/json")
    @POST(ApiEndPoint.ENDPOINT_UPCOMING_MOVIES)
    Single<ResponseMovies> getUpcomingMovies(@QueryMap Map<String, String> options);

    @Headers("Content-Type: application/json")
    @POST(ApiEndPoint.ENDPOINT_SEARCH_MOVIE)
    Single<ResponseMovies> searchMovie(@Query("query") String search, @QueryMap Map<String, String> options);

    @Headers("Content-Type: application/json")
    @POST(ApiEndPoint.ENDPOINT_MOVIE_DEATAILS)
    Single<ResponseMovies> getMovieDetails(@Path("id") int id, @QueryMap Map<String, String> options);


}
