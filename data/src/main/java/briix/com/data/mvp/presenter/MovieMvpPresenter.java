package briix.com.data.mvp.presenter;


import java.util.Map;

import briix.com.data.mvp.model.request.RequestCreateAccessToken;
import briix.com.data.mvp.model.request.RequestToken;
import briix.com.data.mvp.presenter.base.MvpPresenter;
import briix.com.data.mvp.view.MovieView;


public interface MovieMvpPresenter<V extends MovieView> extends MvpPresenter<MovieView> {

    void getToken(RequestToken mRequest);

    void createAccessToken(RequestCreateAccessToken mRequest);

    void getPopularMovies(Map<String, String> mOptions);

    void getTopRatedMovies(Map<String, String> mOptions);

    void getUpcomingMovies(Map<String, String> mOptions);

    void searchMovie(String movie, Map<String, String> mOptions);

    void getMovieDetails(int mId, Map<String, String> mOptions);

}
