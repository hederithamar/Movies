package briix.com.movies.ui.fragments;

import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import briix.com.movies.R;
import briix.com.movies.adapter.MovieAdapter;
import briix.com.movies.adapter.MovieSmallAdapter;
import briix.com.movies.databinding.FragmentHomeMovieBinding;
import briix.com.movies.databinding.FragmentMovieDetailsBinding;
import briix.com.movies.model.Movie;
import briix.com.movies.realm.RealmController;
import briix.com.movies.realm.model.GeneralMovieEntity;
import briix.com.movies.realm.model.PopularMovieEntity;

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