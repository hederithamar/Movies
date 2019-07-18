package briix.com.data.mvp.presenter.base;

import android.support.annotation.NonNull;

import java.io.IOException;

import briix.com.data.mvp.view.MvpView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import briix.com.data.mvp.model.base.Error;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private CompositeDisposable compositeSubscription = new CompositeDisposable();

    public void unsubscribeOnDestroy(@NonNull Disposable subscription) {
        compositeSubscription.add(subscription);
    }

    private static final String TAG = "BasePresenter";

    private V mMvpView;


    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        compositeSubscription.clear();

        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    @Override
    public void handleServiceError(Throwable e, int serviceId) {

        getMvpView().hideLoading();

        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            ResponseBody body = httpException.response().errorBody();
            String errorBody = "";
            try {
                if (body != null)
                    errorBody = body.string();
            } catch (IOException ex) {
                errorBody = ex.getMessage();
            }

            getMvpView().onServiceError(new Error(serviceId, httpException.code(),
                    httpException.getMessage(), errorBody, ""));

        } else
            getMvpView().onServiceError(new Error(serviceId, 0,
                    e.getMessage(), e.getMessage(), ""));
    }


    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
