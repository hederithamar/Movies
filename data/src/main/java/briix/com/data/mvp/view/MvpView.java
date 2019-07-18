package briix.com.data.mvp.view;

import briix.com.data.mvp.model.base.Error;

public interface MvpView {

    void showLoading();

    void hideLoading();

    void onServiceError(Error error);

    void onFormatError(String error);

}
