package briix.com.movies.ui.activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import androidx.navigation.Navigation;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import briix.com.data.mvp.model.base.Error;
import briix.com.data.mvp.model.request.RequestCreateAccessToken;
import briix.com.data.mvp.model.request.RequestToken;
import briix.com.data.mvp.model.response.ResponseCreateAccessToken;
import briix.com.data.mvp.model.response.ResponseMovies;
import briix.com.data.mvp.model.response.ResponseToken;
import briix.com.data.mvp.presenter.MovieMvpPresenter;
import briix.com.data.mvp.view.MovieView;
import briix.com.movies.BaseApp;
import briix.com.movies.R;
import briix.com.movies.data.Preferences;
import briix.com.movies.data.PreferencesImpl;
import briix.com.movies.databinding.ActivitySplashBinding;
import briix.com.movies.realm.RealmController;
import briix.com.movies.ui.base.BaseMvpActivity;
import briix.com.movies.utils.DialogUtils;

import static briix.com.data.MServicesMovie.GET_REQUEST_TOKEN;
import static briix.com.data.MServicesMovie.CREATE_ACCESS_TOKEN;
import static briix.com.data.MServicesMovie.GET_POPULAR_MOVIES;
import static briix.com.data.MServicesMovie.GET_TOP_RATED_MOVIES;
import static briix.com.data.MServicesMovie.GET_UPCOMING_MOVIES;

public class SplashActivity extends BaseMvpActivity implements MovieView {

    private ActivitySplashBinding mBinding;
    private Preferences mPreferences;
    private Map<String, String> mData;
    private String mToken;

    @Inject
    MovieMvpPresenter<MovieView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        mPreferences = PreferencesImpl.getInstance(this);
        BaseApp.getAppComponent().inject(this);
        mPresenter.onAttach(this);
        initData();
        validateService();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }

    private void initData() {
        mData = new HashMap<>();
        mData.put("lenguage", "es-MX");
        mData.put("page", String.valueOf(1));
    }

    private void validateService() {
        boolean isDbOutdated = RealmController.withInstance().isDbOutdated();
        if (isDbOutdated) {
            initRequest();
        } else {
            launchMain();
        }
    }

    private void initRequest() {
        RequestToken requestToken = new RequestToken("http://www.themoviedb.org/");
        mPresenter.getToken(requestToken);
    }

    private void launchMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onSuccessGetToken(ResponseToken response) {
        mToken = response.getRequestToken();
        RequestCreateAccessToken mRequest = new RequestCreateAccessToken(mToken);
        mPresenter.createAccessToken(mRequest);
    }

    @Override
    public void onSuccessCreateAccessToken(ResponseCreateAccessToken response) {
        response.getAccessToken();
        response.getAccountId();

    }

    @Override
    public void onSuccessGetPopularMovies(ResponseMovies response) {
        RealmController.withInstance().updateCatalog(response, GET_POPULAR_MOVIES);
        mPresenter.getTopRatedMovies(mData);
    }

    @Override
    public void onSuccessGettopRatedMovies(ResponseMovies response) {
        RealmController.withInstance().updateCatalog(response, GET_TOP_RATED_MOVIES);
        mPresenter.getUpcomingMovies(mData);
    }

    @Override
    public void onSuccessGetUpcomingMovies(ResponseMovies response) {
        RealmController.withInstance().updateCatalog(response, GET_UPCOMING_MOVIES);
        launchMain();
    }

    @Override
    public void onSuccessSearchMovie(ResponseMovies response) {

    }

    @Override
    public void onSuccessMovieDetails(ResponseMovies response) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onServiceError(Error error) {
        if (isFinishing()) {
            return;
        }

        Dialog.OnClickListener listener = coexistenceListener;

        if (error.getServiceId() == GET_REQUEST_TOKEN)
            listener = getRequestTokenListener;
        else if (error.getServiceId() == CREATE_ACCESS_TOKEN)
            listener = createAccessTokenListener;
        else if (error.getServiceId() == GET_POPULAR_MOVIES)
            listener = getPopularMovies;
        else if (error.getServiceId() == GET_TOP_RATED_MOVIES)
            listener = getTopRatedMovies;
        else if (error.getServiceId() == GET_UPCOMING_MOVIES)
            listener = getUpcomingMovies;


        DialogUtils.showMessageBlurDialogGeneric(this, error.getException(), error.getMessage(),
                getString(R.string.action_accept), getString(R.string.action_cancel), listener);
    }

    DialogInterface.OnClickListener getRequestTokenListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    };

    DialogInterface.OnClickListener createAccessTokenListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    };

    DialogInterface.OnClickListener getPopularMovies = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    };

    DialogInterface.OnClickListener getTopRatedMovies = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    };

    DialogInterface.OnClickListener getUpcomingMovies = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    };

    DialogInterface.OnClickListener coexistenceListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        }
    };

}
