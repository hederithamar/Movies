package briix.com.data.services;

import java.util.Map;

import briix.com.data.mvp.model.request.RequestCreateAccessToken;
import briix.com.data.mvp.model.request.RequestToken;
import briix.com.data.mvp.model.response.ResponseCreateAccessToken;
import briix.com.data.mvp.model.response.ResponseMovies;
import briix.com.data.mvp.model.response.ResponseToken;
import io.reactivex.Observable;

public class MovieServices {
    MovieApi mMovieApi;

    public MovieServices(MovieApi MovieApi) {
        mMovieApi = MovieApi;
    }

    public Observable<ResponseToken> getToken(RequestToken mRequest) {
        return mMovieApi.getToken(mRequest).toObservable();
    }

    public Observable<ResponseCreateAccessToken> createAccessToken(RequestCreateAccessToken mRequest) {
        return mMovieApi.createAccessToken(mRequest).toObservable();
    }

    public Observable<ResponseCreateAccessToken> getListMovies(int mListId, Map<String, String> mOptions) {
        return mMovieApi.getListMovies(mListId, mOptions).toObservable();
    }

    public Observable<ResponseMovies> getPopularMovies(Map<String, String> mOptions) {
        return mMovieApi.getPopularMovies(mOptions).toObservable();
    }

    public Observable<ResponseMovies> getTopRatedMovies(Map<String, String> mOptions) {
        return mMovieApi.getTopRatedMovies(mOptions).toObservable();
    }

    public Observable<ResponseMovies> getUpcomingMovies(Map<String, String> mOptions) {
        return mMovieApi.getUpcomingMovies(mOptions).toObservable();
    }

    public Observable<ResponseMovies> searchMovie(String movie, Map<String, String> mOptions) {
        return mMovieApi.searchMovie(movie, mOptions).toObservable();
    }

    public Observable<ResponseMovies> getMovieDetails(int id, Map<String, String> mOptions) {
        return mMovieApi.getMovieDetails(id, mOptions).toObservable();
    }


}
