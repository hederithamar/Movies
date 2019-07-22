package briix.com.movies.ui.activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

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
import briix.com.data.preferences.Preferences;
import briix.com.movies.BaseApp;
import briix.com.movies.R;
import briix.com.movies.databinding.ActivitySplashBinding;
import briix.com.movies.realm.RealmController;
import briix.com.movies.ui.base.BaseMvpActivity;
import briix.com.movies.ui.interfaces.OnActionServices;
import briix.com.movies.utils.DialogUtils;

import static briix.com.data.MServicesMovie.CREATE_ACCESS_TOKEN;
import static briix.com.data.MServicesMovie.GET_LIST_MOVIES;
import static briix.com.data.MServicesMovie.GET_POPULAR_MOVIES;
import static briix.com.data.MServicesMovie.GET_REQUEST_TOKEN;
import static briix.com.data.MServicesMovie.GET_TOP_RATED_MOVIES;
import static briix.com.data.MServicesMovie.GET_UPCOMING_MOVIES;

public class SplashActivity extends BaseMvpActivity implements MovieView, OnActionServices.InitAccess {

    private ActivitySplashBinding mBinding;

    private Map<String, String> mData;
    private Bundle mBundle;
    private String mToken;
    public static final String BUNDLE_URL = "BUNDLE_URL";

    @Inject
    MovieMvpPresenter<MovieView> mPresenter;

    @Inject
    Preferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        BaseApp.getAppComponent().inject(this);
        mPresenter.onAttach(this);
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }

    private void initData() {
        mData = new HashMap<>();
        mData.put("lenguage", "es-ES");
        mData.put("page", String.valueOf(1));
    }


    private void launchMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void navigateWebView() {
        mBundle = new Bundle();
        String url = getString(R.string.url_access, mToken);
        mBundle.putString(BUNDLE_URL, url);

        Navigation.findNavController(this, R.id.nav_host_fragment)
                .navigate(R.id.openWebViewFragment, mBundle);
    }

    @Override
    public void onSuccessGetToken(ResponseToken response) {
        mToken = response.getRequestToken();
        navigateWebView();
    }

    @Override
    public void onSuccessCreateAccessToken(ResponseCreateAccessToken response) {
        mToken = response.getAccessToken();
        mPreferences.setAccessToken(response.getAccessToken());
        mPreferences.setAccountId(response.getAccountId());
        getListMovies();
    }

    @Override
    public void onSuccessGetListMovies(ResponseCreateAccessToken response) {
        launchMain();
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
    public void onServiceError(Error error) {
        if (isFinishing()) {
            return;
        }

        Dialog.OnClickListener listener = coexistenceListener;

        if (error.getServiceId() == GET_REQUEST_TOKEN)
            listener = getRequestTokenListener;
        else if (error.getServiceId() == CREATE_ACCESS_TOKEN)
            listener = createAccessTokenListener;
        else if (error.getServiceId() == GET_LIST_MOVIES)
            listener = getListMovies;
        else if (error.getServiceId() == GET_POPULAR_MOVIES)
            listener = getPopularMovies;
        else if (error.getServiceId() == GET_TOP_RATED_MOVIES)
            listener = getTopRatedMovies;
        else if (error.getServiceId() == GET_UPCOMING_MOVIES)
            listener = getUpcomingMovies;


        DialogUtils.showMessageBlurDialogGeneric(this, error.getException(), error.getMessage(),
                getString(R.string.action_retry), null, listener);
    }

    @Override
    public void onGetToken() {
        RequestToken requestToken = new RequestToken("");
        mPresenter.getToken(requestToken);
    }

    @Override
    public void onValidatePassToken() {
        RequestCreateAccessToken mRequest = new RequestCreateAccessToken(mToken);
        mPresenter.createAccessToken(mRequest);
    }

    private void getListMovies(){
        mPresenter.getListMovies(1,  mData);
    }

    DialogInterface.OnClickListener getRequestTokenListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            onBackPressed();
        }
    };

    DialogInterface.OnClickListener createAccessTokenListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            onGetToken();
        }
    };

    DialogInterface.OnClickListener getListMovies= new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            getListMovies();
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
