package briix.com.movies.ui.base;

import android.app.ProgressDialog;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Html;

import briix.com.data.mvp.model.base.Error;
import briix.com.data.mvp.view.MvpView;
import briix.com.movies.R;


public class BaseMvpActivity extends AppCompatActivity implements MvpView {
    protected ProgressDialog mProgressDialog;
    protected AlertDialog mDialog;

    @Override
    public void showLoading() {
        if (isFinishing()) return;

        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this, R.style.AppBase_Dialog);
            mProgressDialog.setMessage(Html.fromHtml(getString(R.string.message_loading)));
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setCancelable(false);
        }
        if (!mProgressDialog.isShowing())
            mProgressDialog.show();

    }

    @Override
    public void hideLoading() {
        if (isFinishing()) return;

        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }

    }

    @Override
    public void onServiceError(Error error) {

    }

    @Override
    public void onFormatError(String message) {

    }


    @Override
    protected void onDestroy() {
        hideLoading();
        if (mDialog != null) {
            mDialog.dismiss();
        }
        super.onDestroy();
    }

}
