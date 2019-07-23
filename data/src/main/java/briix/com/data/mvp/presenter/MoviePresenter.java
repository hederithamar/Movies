package briix.com.data.mvp.presenter;

import java.util.Map;

import javax.inject.Inject;

import briix.com.data.MServicesMovie;
import briix.com.data.mvp.presenter.base.BasePresenter;
import briix.com.data.mvp.view.MovieView;
import briix.com.data.utils.CommonUtils;
import briix.com.domain.entities.auth.TokenEntity;
import briix.com.domain.entities.auth.CreateAccessTokenEntity;
import briix.com.domain.entities.home.MoviesEntity;
import briix.com.domain.repositories.AuthRepository;
import briix.com.domain.repositories.HomeRepository;
import io.reactivex.Observable;

import briix.com.data.mvp.model.base.Error;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class MoviePresenter<V extends MovieView> extends BasePresenter<MovieView>
        implements MovieMvpPresenter<V> {

    private HomeRepository mHomeRepository;
    private AuthRepository mAuthRepository;

    @Inject
    public MoviePresenter(HomeRepository homeRepository, AuthRepository authRepository) {
        this.mHomeRepository = homeRepository;
        this.mAuthRepository = authRepository;
    }

    @Override
    public void getToken(String redirectTo) {
        final int service = MServicesMovie.GET_REQUEST_TOKEN;
        getMvpView().showLoading();

        final Observable<TokenEntity> observable = mAuthRepository.getToken(redirectTo);
        Disposable disposable = observable.compose(CommonUtils.<TokenEntity>applySchedulers())
                .subscribeWith(new DisposableObserver<TokenEntity>() {
                    @Override
                    public void onNext(TokenEntity response) {
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
    public void createAccessToken(String requestToken) {
        final int service = MServicesMovie.CREATE_ACCESS_TOKEN;
        getMvpView().showLoading();
        final Observable<CreateAccessTokenEntity> observable = mAuthRepository.createAccessToken(requestToken);
        Disposable disposable = observable.compose(CommonUtils.<CreateAccessTokenEntity>applySchedulers())
                .subscribeWith(new DisposableObserver<CreateAccessTokenEntity>() {
                    @Override
                    public void onNext(CreateAccessTokenEntity response) {
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
        final Observable<MoviesEntity> observable = mHomeRepository.getListMovies(mListId, mOptions);
        Disposable disposable = observable.compose(CommonUtils.<MoviesEntity>applySchedulers())
                .subscribeWith(new DisposableObserver<MoviesEntity>() {
                    @Override
                    public void onNext(MoviesEntity response) {
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

        final Observable<MoviesEntity> observable = mHomeRepository.getPopularMovies(mOptions);
        Disposable disposable = observable.compose(CommonUtils.<MoviesEntity>applySchedulers())
                .subscribeWith(new DisposableObserver<MoviesEntity>() {
                    @Override
                    public void onNext(MoviesEntity response) {
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

        final Observable<MoviesEntity> observable = mHomeRepository.getTopRatedMovies(mOptions);
        Disposable disposable = observable.compose(CommonUtils.<MoviesEntity>applySchedulers())
                .subscribeWith(new DisposableObserver<MoviesEntity>() {
                    @Override
                    public void onNext(MoviesEntity response) {
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

        final Observable<MoviesEntity> observable = mHomeRepository.getUpcomingMovies(mOptions);
        Disposable disposable = observable.compose(CommonUtils.<MoviesEntity>applySchedulers())
                .subscribeWith(new DisposableObserver<MoviesEntity>() {
                    @Override
                    public void onNext(MoviesEntity response) {
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


        final Observable<MoviesEntity> observable = mHomeRepository.getMovieDetails(mId, mOptions);
        Disposable disposable = observable.compose(CommonUtils.<MoviesEntity>applySchedulers())
                .subscribeWith(new DisposableObserver<MoviesEntity>() {
                    @Override
                    public void onNext(MoviesEntity response) {
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


        final Observable<MoviesEntity> observable = mHomeRepository.searchMovie(mMovie, mOptions);
        Disposable disposable = observable.compose(CommonUtils.<MoviesEntity>applySchedulers())
                .subscribeWith(new DisposableObserver<MoviesEntity>() {
                    @Override
                    public void onNext(MoviesEntity response) {
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
