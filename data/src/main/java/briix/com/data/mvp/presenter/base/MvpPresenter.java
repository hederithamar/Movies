package briix.com.data.mvp.presenter.base;


import briix.com.data.mvp.view.MvpView;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleServiceError(Throwable e, int serviceId);

}
