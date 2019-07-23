package briix.com.data.mvp.view;


import briix.com.domain.entities.auth.TokenEntity;
import briix.com.domain.entities.auth.CreateAccessTokenEntity;
import briix.com.domain.entities.home.MoviesEntity;

public interface MovieView extends MvpView {
    String TAG = "MovieView";

    void onSuccessGetToken(TokenEntity response);

    void onSuccessCreateAccessToken(CreateAccessTokenEntity response);

    void onSuccessGetListMovies(MoviesEntity response);

    void onSuccessGetPopularMovies(MoviesEntity response);

    void onSuccessGettopRatedMovies(MoviesEntity response);

    void onSuccessGetUpcomingMovies(MoviesEntity response);

    void onSuccessSearchMovie(MoviesEntity response);

    void onSuccessMovieDetails(MoviesEntity response);

}
