package briix.com.data.mvp.presenter;

import java.util.Map;

import javax.inject.Inject;

import briix.com.data.MServicesMovie;
import briix.com.data.mvp.model.request.RequestCreateAccessToken;
import briix.com.data.mvp.model.request.RequestToken;
import briix.com.data.mvp.model.response.ResponseCreateAccessToken;
import briix.com.data.mvp.model.response.ResponseMovies;
import briix.com.data.mvp.model.response.ResponseToken;
import briix.com.data.mvp.presenter.base.BasePresenter;
import briix.com.data.mvp.view.MovieView;
import briix.com.data.services.MovieServices;
import briix.com.data.utils.CommonUtils;
import io.reactivex.Observable;

import briix.com.data.mvp.model.base.Error;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class MoviePresenter<V extends MovieView> extends BasePresenter<MovieView>
        implements MovieMvpPresenter<V> {

    private MovieServices mMovieService;

    @Inject
    public MoviePresenter(MovieServices movieService) {
        this.mMovieService = movieService;
    }

    @Override
    public void getToken(RequestToken mRequest) {
        final int service = MServicesMovie.GET_REQUEST_TOKEN;
        getMvpView().showLoading();

        final Observable<ResponseToken> observable = mMovieService.getToken(mRequest);
        Disposable disposable = observable.compose(CommonUtils.<ResponseToken>applySchedulers())
                .subscribeWith(new DisposableObserver<ResponseToken>() {
                    @Override
                    public void onNext(ResponseToken response) {
                        getMvpView().hideLoading();
                        if (response != null) {
                            getMvpView().onSuccessGetToken(response);
                        } else {
                            getMvpView().onServiceError(new Error(response, service));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        handleServiceError(e, service);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        unsubscribeOnDestroy(disposable);
    }

    @Override
    public void createAccessToken(RequestCreateAccessToken mRequest) {
        final int service = MServicesMovie.CREATE_ACCESS_TOKEN;
        getMvpView().showLoading();
        final Observable<ResponseCreateAccessToken> observable = mMovieService.createAccessToken(mRequest);
        Disposable disposable = observable.compose(CommonUtils.<ResponseCreateAccessToken>applySchedulers())
                .subscribeWith(new DisposableObserver<ResponseCreateAccessToken>() {
                    @Override
                    public void onNext(ResponseCreateAccessToken response) {
                        getMvpView().hideLoading();
                        if (response != null) {
                            getMvpView().onSuccessCreateAccessToken(response);
                        } else {
                            getMvpView().onServiceError(new Error(response, service));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        handleServiceError(e, service);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        unsubscribeOnDestroy(disposable);

    }

    @Override
    public void getListMovies(int mListId, Map<String, String> mOptions) {
        final int service = MServicesMovie.GET_LIST_MOVIES;
        getMvpView().showLoading();
        final Observable<ResponseMovies> observable = mMovieService.getListMovies(mListId, mOptions);
        Disposable disposable = observable.compose(CommonUtils.<ResponseMovies>applySchedulers())
                .subscribeWith(new DisposableObserver<ResponseMovies>() {
                    @Override
                    public void onNext(ResponseMovies response) {
                        getMvpView().hideLoading();
                        if (response != null) {
                            getMvpView().onSuccessGetListMovies(response);
                        } else {
                            getMvpView().onServiceError(new Error(response, service));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        handleServiceError(e, service);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        unsubscribeOnDestroy(disposable);

    }

    @Override
    public void getPopularMovies(Map<String, String> mOptions) {
        final int service = MServicesMovie.GET_POPULAR_MOVIES;
        getMvpView().showLoading();

        final Observable<ResponseMovies> observable = mMovieService.getPopularMovies(mOptions);
        Disposable disposable = observable.compose(CommonUtils.<ResponseMovies>applySchedulers())
                .subscribeWith(new DisposableObserver<ResponseMovies>() {
                    @Override
                    public void onNext(ResponseMovies response) {
                        getMvpView().hideLoading();
                        if (response != null) {
                            getMvpView().onSuccessGetPopularMovies(response);
                        } else {
                            getMvpView().onServiceError(new Error(response, service));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        handleServiceError(e, service);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        unsubscribeOnDestroy(disposable);
    }

    @Override
    public void getTopRatedMovies(Map<String, String> mOptions) {
        final int service = MServicesMovie.GET_TOP_RATED_MOVIES;
        //getMvpView().showLoading();

        final Observable<ResponseMovies> observable = mMovieService.getTopRatedMovies(mOptions);
        Disposable disposable = observable.compose(CommonUtils.<ResponseMovies>applySchedulers())
                .subscribeWith(new DisposableObserver<ResponseMovies>() {
                    @Override
                    public void onNext(ResponseMovies response) {
                        //getMvpView().hideLoading();
                        if (response != null) {
                            getMvpView().onSuccessGettopRatedMovies(response);
                        } else {
                            getMvpView().onServiceError(new Error(response, service));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        handleServiceError(e, service);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        unsubscribeOnDestroy(disposable);
    }

    @Override
    public void getUpcomingMovies(Map<String, String> mOptions) {
        final int service = MServicesMovie.GET_UPCOMING_MOVIES;
        //getMvpView().showLoading();

        final Observable<ResponseMovies> observable = mMovieService.getUpcomingMovies(mOptions);
        Disposable disposable = observable.compose(CommonUtils.<ResponseMovies>applySchedulers())
                .subscribeWith(new DisposableObserver<ResponseMovies>() {
                    @Override
                    public void onNext(ResponseMovies response) {
                        getMvpView().hideLoading();
                        if (response != null) {
                            getMvpView().onSuccessGetUpcomingMovies(response);
                        } else {
                            getMvpView().onServiceError(new Error(response, service));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        handleServiceError(e, service);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        unsubscribeOnDestroy(disposable);
    }


    @Override
    public void getMovieDetails(int mId, Map<String, String> mOptions) {
        final int service = MServicesMovie.GET_MOVIE_DETAILS;
        getMvpView().showLoading();


        final Observable<ResponseMovies> observable = mMovieService.getMovieDetails(mId, mOptions);
        Disposable disposable = observable.compose(CommonUtils.<ResponseMovies>applySchedulers())
                .subscribeWith(new DisposableObserver<ResponseMovies>() {
                    @Override
                    public void onNext(ResponseMovies response) {
                        getMvpView().hideLoading();
                        if (response != null) {
                            getMvpView().onSuccessMovieDetails(response);
                        } else {
                            getMvpView().onServiceError(new Error(response, service));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        handleServiceError(e, service);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        unsubscribeOnDestroy(disposable);
    }

    @Override
    public void searchMovie(String mMovie, Map<String, String> mOptions) {
        final int service = MServicesMovie.SEARCH_MOVIE;
        getMvpView().showLoading();


        final Observable<ResponseMovies> observable = mMovieService.searchMovie(mMovie, mOptions);
        Disposable disposable = observable.compose(CommonUtils.<ResponseMovies>applySchedulers())
                .subscribeWith(new DisposableObserver<ResponseMovies>() {
                    @Override
                    public void onNext(ResponseMovies response) {
                        getMvpView().hideLoading();
                        if (response != null) {
                            getMvpView().onSuccessMovieDetails(response);
                        } else {
                            getMvpView().onServiceError(new Error(response, service));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        handleServiceError(e, service);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        unsubscribeOnDestroy(disposable);
    }
}
