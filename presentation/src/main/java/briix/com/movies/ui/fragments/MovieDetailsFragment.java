package briix.com.movies.ui.fragments;

import android.content.DialogInterface;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import briix.com.movies.R;
import briix.com.movies.databinding.FragmentMovieDetailsBinding;
import briix.com.movies.model.Movie;

import static briix.com.movies.ui.fragments.HomeMovieFragment.BUNDLE_MOVIE;


public class MovieDetailsFragment extends Fragment {
    public static String TAG = "MovieDetailsFragment";
    private FragmentMovieDetailsBinding mBinding;
    private FragmentActivity mActivity;
    private Bundle mBundle;
    private FragmentManager mFragmentManager;
    private Movie mMovie;



    public MovieDetailsFragment() {
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

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_details, container, false);
        loadArguments();
        mBinding.setMovie(mMovie);
        loadViews();

        return mBinding.getRoot();

    }

    private void loadViews() {
        Glide.with(getContext())
                .load(mMovie.getPosterPath())
                .into(mBinding.imageBack);

        Glide.with(getContext())
                .load(mMovie.getBackdropPath())
                .into(mBinding.image);
    }

    public void initMovies() {

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void loadArguments() {
        mBundle = getArguments();
        if (mBundle != null) {
            mMovie = mBundle.getParcelable(BUNDLE_MOVIE);
        }
    }


    DialogInterface.OnClickListener coexistenceListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        }
    };

}