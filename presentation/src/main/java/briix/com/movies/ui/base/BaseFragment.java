package briix.com.movies.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import briix.com.data.mvp.view.MvpView;
import briix.com.movies.R;
import timber.log.Timber;

/**
 * Fragment to manage the mvp pattern.
 *
 * This fragment is used to manage the mvp design pattern.
 *
 * @author Heder Ithamar Romero Romero
 * @version 2019.0721
 * @since 1.0
 */
public abstract class BaseFragment extends Fragment implements MvpView {

    private BaseMvpActivity mActivity;
    private ProgressDialog mProgressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseMvpActivity) {
            BaseMvpActivity activity = (BaseMvpActivity) context;
            this.mActivity = activity;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Timber.d("onPause");

    }

    @Override
    public void showLoading() {

        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mActivity);
            mProgressDialog.setMessage(getString(R.string.message_loading));
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setCancelable(false);
        }
        if (!mProgressDialog.isShowing())
            mProgressDialog.show();

    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }


    @Override
    public void onFormatError(String message) {
        if (mActivity != null) {
            mActivity.onFormatError(message);
        }
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    public BaseMvpActivity getBaseActivity() {
        return mActivity;
    }

}
