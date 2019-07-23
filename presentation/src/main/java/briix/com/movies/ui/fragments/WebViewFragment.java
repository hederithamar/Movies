package briix.com.movies.ui.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import briix.com.data.mvp.model.base.Error;
import briix.com.movies.R;
import briix.com.movies.databinding.FragmentWebViewBinding;
import briix.com.movies.ui.base.BaseFragment;
import briix.com.movies.ui.interfaces.OnActionServices;

import static briix.com.movies.ui.activities.SplashActivity.BUNDLE_URL;


public class WebViewFragment extends BaseFragment implements View.OnClickListener {
    public static String TAG = "WebViewFragment";
    private FragmentWebViewBinding mBinding;
    private FragmentActivity mActivity;
    private Bundle mBundle;
    private String webViewUrl;
    private OnActionServices.InitAccess onActionsServices;

    public WebViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle = new Bundle();
        mActivity = getBaseActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_web_view, container, false);
        showLoading();
        loadArguments();
        setUpWebView();
        setListeners();

        return mBinding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnActionServices.InitAccess)
            onActionsServices = (OnActionServices.InitAccess) context;
        else
            throw new RuntimeException(context.toString()
                    + " must implement OnActionServices.InitAccess");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void loadArguments() {
        mBundle = getArguments();
        if (mBundle != null) {
            //
            webViewUrl = mBundle.getString(BUNDLE_URL);
        }
    }

    private void setUpWebView() {
        mBinding.webView.setWebViewClient(new MyWebViewClient());
        mBinding.webView.getSettings().setJavaScriptEnabled(true);
        LoadWebViewUrl(webViewUrl);
    }

    private void setListeners() {
        mBinding.iconClose.setOnClickListener(this);
        mBinding.webView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon_close:
                onActionsServices.onValidatePassToken();
                break;
        }
    }

    @Override
    public void onServiceError(Error error) {

    }


    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            hideLoading();
        }

    }

    // To handle "Back" key press event for WebView to go back to previous screen.
    private void LoadWebViewUrl(String url) {
        if (isInternetConnected())
            mBinding.webView.loadUrl(url);
        else {

        }
    }

    public boolean isInternetConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
        return true;
        else
        return false;

    }

    DialogInterface.OnClickListener coexistenceListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        }
    };

}