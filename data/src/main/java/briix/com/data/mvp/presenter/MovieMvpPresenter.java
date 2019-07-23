package briix.com.data.mvp.presenter;


import java.util.Map;

import briix.com.data.mvp.model.request.RequestCreateAccessToken;
import briix.com.data.mvp.model.request.RequestToken;
import briix.com.data.mvp.presenter.base.MvpPresenter;
import briix.com.data.mvp.view.MovieView;


public interface MovieMvpPresenter<V extends MovieView> extends MvpPresenter<MovieView> {

    void getToken(String redirectTo);

    void createAccessToken(String requestToken);

    void getListMovies(int mListId, Map<String, String> mOptions);

    void getPopularMovies( Map<String, String> mOptions);

    void getTopRatedMovies(Map<String, String> mOptions);

    void getUpcomingMovies(Map<String, String> mOptions);

    void searchMovie(String movie, Map<String, String> mOptions);

    void getMovieDetails(int mId, Map<String, String> mOptions);

}
