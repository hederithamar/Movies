package briix.com.movies.ui.fragments;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import briix.com.movies.R;
import briix.com.movies.databinding.FragmentSplashBinding;
import briix.com.movies.realm.RealmController;
import briix.com.movies.ui.interfaces.OnActionServices;


public class SplashFragment extends Fragment {
    public static String TAG = "SplashFragment";
    private FragmentSplashBinding mBinding;
    private FragmentActivity mActivity;
    private Bundle mBundle;
    private OnActionServices.InitAccess onActionsServices;

    public SplashFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle = new Bundle();
        mActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false);

        validateService();

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



    private void validateService() {
        boolean isDbOutdated = RealmController.withInstance().isDbOutdated();
        if (isDbOutdated) {
            onActionsServices.onGetToken();
        } else {
            onActionsServices.onGetListMovies();
        }
    }


}