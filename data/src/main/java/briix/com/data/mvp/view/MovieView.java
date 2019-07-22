package briix.com.data.mvp.view;


import briix.com.data.mvp.model.response.ResponseCreateAccessToken;
import briix.com.data.mvp.model.response.ResponseMovies;
import briix.com.data.mvp.model.response.ResponseToken;

public interface MovieView extends MvpView {
    String TAG = "MovieView";

    void onSuccessGetToken(ResponseToken response);

    void onSuccessCreateAccessToken(ResponseCreateAccessToken response);

    void onSuccessGetListMovies(ResponseCreateAccessToken response);

    void onSuccessGetPopularMovies(ResponseMovies response);

    void onSuccessGettopRatedMovies(ResponseMovies response);

    void onSuccessGetUpcomingMovies(ResponseMovies response);

    void onSuccessSearchMovie(ResponseMovies response);

    void onSuccessMovieDetails(ResponseMovies response);

}
